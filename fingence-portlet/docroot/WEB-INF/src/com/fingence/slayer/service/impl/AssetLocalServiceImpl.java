/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.fingence.slayer.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fingence.slayer.NoSuchAssetException;
import com.fingence.slayer.NoSuchBondException;
import com.fingence.slayer.NoSuchEquityException;
import com.fingence.slayer.NoSuchMutualFundException;
import com.fingence.slayer.model.Asset;
import com.fingence.slayer.model.Bond;
import com.fingence.slayer.model.Equity;
import com.fingence.slayer.model.MutualFund;
import com.fingence.slayer.service.base.AssetLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.CompanyThreadLocal;

/**
 * The implementation of the asset local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.fingence.slayer.service.AssetLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Ahmed Hasan
 * @see com.fingence.slayer.service.base.AssetLocalServiceBaseImpl
 * @see com.fingence.slayer.service.AssetLocalServiceUtil
 */
public class AssetLocalServiceImpl extends AssetLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.fingence.slayer.service.AssetLocalServiceUtil} to access the asset
	 * local service.
	 */

	public void importFromExcel(long userId, File excel) {

		InputStream is = AssetLocalServiceImpl.class.getClassLoader()
				.getResourceAsStream("data/fingence-data-sample.xlsx");

		if (Validator.isNull(is)) return;

		// Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (Validator.isNull(workbook)) return;

		// Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);

		// Iterate through each rows one by one
		Iterator<Row> rowIterator = sheet.iterator();

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			if (row.getRowNum() == 0) continue;

			String id_isin = getString(row.getCell(2));
			
			Asset asset = getAsset(userId, id_isin);
			
			asset.setSecurity_ticker(getString(row.getCell(0)));
			asset.setId_cusip(getString(row.getCell(1)));
			asset.setId_bb_global(getString(row.getCell(3)));
			asset.setId_bb_sec_num_src(getLong(row.getCell(4)));
			asset.setName(getString(row.getCell(13)));
			asset.setChg_pct_mtd(getDouble(row.getCell(15)));
			asset.setChg_pct_5d(getDouble(row.getCell(16)));
			asset.setChg_pct_1m(getDouble(row.getCell(17)));
			asset.setChg_pct_3m(getDouble(row.getCell(18)));
			asset.setChg_pct_6m(getDouble(row.getCell(19)));
			asset.setChg_pct_ytd(getDouble(row.getCell(20)));
			asset.setBid_price(getDouble(row.getCell(32)));
			asset.setAsk_price(getDouble(row.getCell(33)));
			asset.setChg_pct_high_52week(getDouble(row.getCell(48)));
			asset.setChg_pct_low_52week(getDouble(row.getCell(49)));
			asset.setSecurity_des(getString(row.getCell(55)));
			asset.setSecurity_typ(getString(row.getCell(56)));
			asset.setSecurity_typ2(getString(row.getCell(57)));
			asset.setParent_comp_name(getString(row.getCell(63)));
			asset.setSecurity_class(getString(row.getCell(67)));
			asset.setVolatility_30d(getDouble(row.getCell(81)));
			asset.setVolatility_90d(getDouble(row.getCell(82)));
			asset.setVolatility_180d(getDouble(row.getCell(83)));
			asset.setVolatility_360d(getDouble(row.getCell(84)));	
			
			try {
				updateAsset(asset);
			} catch (SystemException e) {
				e.printStackTrace();
			}
			
			String assetType = getString(row.getCell(67));
			
			long assetId = asset.getAssetId();
			
			if (assetType.equalsIgnoreCase("FixedIncome")) {
				Bond bond = getBond(assetId);
				
             	bond.setIssuer_bulk(getString(row.getCell(27)));
             	bond.setCpn(getDouble(row.getCell(29)));
             	bond.setCpn_typ(getString(row.getCell(30)));
             	bond.setMty_typ(getString(row.getCell(34)));
             	bond.setMty_years_tdy(getDouble(row.getCell(35)));
             	bond.setYld_ytm_ask(getDouble(row.getCell(36)));
             	bond.setYld_ytm_bid(getDouble(row.getCell(37)));
             	bond.setYld_cur_mid(getDouble(row.getCell(38)));
             	bond.setBb_composite(getString(row.getCell(40)));
            	bond.setRtg_sp(getString(row.getCell(42)));
            	bond.setRtg_moody(getString(row.getCell(43)));
            	bond.setCpn_freq(getDouble(row.getCell(44)));
            	bond.setFive_y_bid_cds_spread(getDouble(row.getCell(45)));
            	bond.setDur_mid(getDouble(row.getCell(46)));
             	bond.setPrice_to_cash_flow(getDouble(row.getCell(77)));
             	
             	try {
					bondLocalService.updateBond(bond);
				} catch (SystemException e) {
					e.printStackTrace();
				}
				
			} else if (assetType.equalsIgnoreCase("Fund")) {
				MutualFund mutualFund = getMutualFund(assetId);
				
             	mutualFund.setFund_total_assets(getDouble(row.getCell(26)));
             	mutualFund.setFund_asset_class_focus(getString(row.getCell(53)));
             	mutualFund.setFund_geo_focus(getString(row.getCell(54)));
             	
             	try {
					mutualFundLocalService.updateMutualFund(mutualFund);
				} catch (SystemException e) {
					e.printStackTrace();
				}
				
			} else if (assetType.equalsIgnoreCase("Equity")) {
				Equity equity = getEquity(assetId);
				
             	equity.setEqy_alpha(getDouble(row.getCell(24)));
             	equity.setDividend_yield(getDouble(row.getCell(70)));
             	equity.setEqy_dvd_yld_12m(getDouble(row.getCell(71)));
             	equity.setEqy_dvd_yld_es(getDouble(row.getCell(72)));
             	equity.setDvd_payout_ratio(getDouble(row.getCell(73)));
             	equity.setPe_ratio(getDouble(row.getCell(74)));
             	equity.setTot_debt_to_com_eqy(getDouble(row.getCell(75)));
             	equity.setEbitda_to_revenue(getDouble(row.getCell(76)));
             	equity.setTrail_12m_prof_margin(getDouble(row.getCell(78)));
             	equity.setBest_current_ev_best_opp(getDouble(row.getCell(79)));
             	equity.setEqy_beta(getDouble(row.getCell(81)));
              	equity.setReturn_sharpe_ratio(getDouble(row.getCell(86)));
             	equity.setEqy_sharpe_ratio_1yr(getDouble(row.getCell(87)));
             	equity.setEqy_sharpe_ratio_3yr(getDouble(row.getCell(88)));
             	equity.setEqy_sharpe_ratio_5yr(getDouble(row.getCell(89)));
             	
             	try {
					equityLocalService.updateEquity(equity);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private Equity getEquity(long assetId) {
		Equity equity = null;
		try {
			equity = equityPersistence.findByPrimaryKey(assetId);
		} catch (NoSuchEquityException e) {
			equity = equityLocalService.createEquity(assetId);
			try {
				equity = equityLocalService.addEquity(equity);
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return equity;
	}

	private MutualFund getMutualFund(long assetId) {
		MutualFund mutualFund = null;
		try {
			mutualFund = mutualFundPersistence.findByPrimaryKey(assetId);
		} catch (NoSuchMutualFundException e) {
			mutualFund = mutualFundLocalService.createMutualFund(assetId);
			try {
				mutualFund = mutualFundLocalService.addMutualFund(mutualFund);
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return mutualFund;
	}

	private Bond getBond(long assetId) {
		
		Bond bond = null;
		try {
			bond = bondPersistence.findByPrimaryKey(assetId);
		} catch (NoSuchBondException e) {
			bond = bondLocalService.createBond(assetId);
			try {
				bond = bondLocalService.addBond(bond);
			} catch (SystemException e1) {
				e1.printStackTrace();
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return bond;
	}

	private Asset getAsset(long userId, String id_isin) {
		
		long companyId = CompanyThreadLocal.getCompanyId();
		
		Asset asset = null;
		
		long assetId = getAssetId(id_isin);
		
		if (assetId > 0l) {
			try {
				asset = fetchAsset(assetId);
				asset.setModifiedDate(new java.util.Date());
			} catch (SystemException e) {
				e.printStackTrace();
			}
		} else {
			try {
				assetId = counterLocalService.increment(Asset.class.getName());
				asset = createAsset(assetId);
				asset.setCompanyId(companyId);
				asset.setUserId(userId);
				asset.setCreateDate(new java.util.Date());
				addAsset(asset);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		asset.setId_isin(id_isin);
		
		return asset;
	}

	private long getAssetId(String id_isin) {
		
		long assetId = 0l;
		
		try {
			Asset asset = assetPersistence.findByIdISIN(id_isin);
			
			if (Validator.isNotNull(asset)){
				assetId = asset.getAssetId();
			}
		} catch (NoSuchAssetException e) {
			System.out.println(e.getMessage());
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return assetId;
		
	}

	private long getLong(Cell cell) {
		
		long value = 0l;
		
		String cellValue = cell.toString();
		
		if (Validator.isNotNull(cellValue) && !cellValue.trim().equalsIgnoreCase(StringPool.DASH)) {
			try {
				value = Long.parseLong(cellValue.trim());
			} catch (NumberFormatException nfe) {
				System.out.println("Unable to convert to Long ==> " + cellValue);
			}
		}
		
		return value;
	}

	private double getDouble(Cell cell) {

		double value = 0;
		
		String cellValue = cell.toString();
		
		if (Validator.isNotNull(cellValue) && !cellValue.trim().equalsIgnoreCase(StringPool.DASH)) {
			try {
				value = Double.parseDouble(cellValue.trim());
			} catch (NumberFormatException nfe) {
				System.out.println("Unable to convert to double ==> " + cellValue);
			}
		}
		
		return value;

	}
	
	private String getString(Cell cell) {
		
		String value = StringPool.BLANK;
		
		String cellValue = cell.toString();
		
		if (Validator.isNotNull(cellValue) && !cellValue.trim().equalsIgnoreCase(StringPool.DASH)) {
			value = cellValue;
		}
		
		return value;
	}
}