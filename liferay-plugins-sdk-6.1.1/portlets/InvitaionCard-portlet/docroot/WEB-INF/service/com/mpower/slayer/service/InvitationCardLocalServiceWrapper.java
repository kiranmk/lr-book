/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.mpower.slayer.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link InvitationCardLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       InvitationCardLocalService
 * @generated
 */
public class InvitationCardLocalServiceWrapper
	implements InvitationCardLocalService,
		ServiceWrapper<InvitationCardLocalService> {
	public InvitationCardLocalServiceWrapper(
		InvitationCardLocalService invitationCardLocalService) {
		_invitationCardLocalService = invitationCardLocalService;
	}

	/**
	* Adds the invitation card to the database. Also notifies the appropriate model listeners.
	*
	* @param invitationCard the invitation card
	* @return the invitation card that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.slayer.model.InvitationCard addInvitationCard(
		com.mpower.slayer.model.InvitationCard invitationCard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationCardLocalService.addInvitationCard(invitationCard);
	}

	/**
	* Creates a new invitation card with the primary key. Does not add the invitation card to the database.
	*
	* @param invitationId the primary key for the new invitation card
	* @return the new invitation card
	*/
	public com.mpower.slayer.model.InvitationCard createInvitationCard(
		long invitationId) {
		return _invitationCardLocalService.createInvitationCard(invitationId);
	}

	/**
	* Deletes the invitation card with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param invitationId the primary key of the invitation card
	* @return the invitation card that was removed
	* @throws PortalException if a invitation card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.slayer.model.InvitationCard deleteInvitationCard(
		long invitationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _invitationCardLocalService.deleteInvitationCard(invitationId);
	}

	/**
	* Deletes the invitation card from the database. Also notifies the appropriate model listeners.
	*
	* @param invitationCard the invitation card
	* @return the invitation card that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.slayer.model.InvitationCard deleteInvitationCard(
		com.mpower.slayer.model.InvitationCard invitationCard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationCardLocalService.deleteInvitationCard(invitationCard);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _invitationCardLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationCardLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationCardLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationCardLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationCardLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.mpower.slayer.model.InvitationCard fetchInvitationCard(
		long invitationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationCardLocalService.fetchInvitationCard(invitationId);
	}

	/**
	* Returns the invitation card with the primary key.
	*
	* @param invitationId the primary key of the invitation card
	* @return the invitation card
	* @throws PortalException if a invitation card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.slayer.model.InvitationCard getInvitationCard(
		long invitationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _invitationCardLocalService.getInvitationCard(invitationId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _invitationCardLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the invitation cards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of invitation cards
	* @param end the upper bound of the range of invitation cards (not inclusive)
	* @return the range of invitation cards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.mpower.slayer.model.InvitationCard> getInvitationCards(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationCardLocalService.getInvitationCards(start, end);
	}

	/**
	* Returns the number of invitation cards.
	*
	* @return the number of invitation cards
	* @throws SystemException if a system exception occurred
	*/
	public int getInvitationCardsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationCardLocalService.getInvitationCardsCount();
	}

	/**
	* Updates the invitation card in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param invitationCard the invitation card
	* @return the invitation card that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.slayer.model.InvitationCard updateInvitationCard(
		com.mpower.slayer.model.InvitationCard invitationCard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationCardLocalService.updateInvitationCard(invitationCard);
	}

	/**
	* Updates the invitation card in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param invitationCard the invitation card
	* @param merge whether to merge the invitation card with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the invitation card that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.mpower.slayer.model.InvitationCard updateInvitationCard(
		com.mpower.slayer.model.InvitationCard invitationCard, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationCardLocalService.updateInvitationCard(invitationCard,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _invitationCardLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_invitationCardLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _invitationCardLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public boolean notAnExistingUser(java.lang.String emailAdress,
		javax.portlet.ActionRequest actionrequest) {
		return _invitationCardLocalService.notAnExistingUser(emailAdress,
			actionrequest);
	}

	public boolean notAlreadyInvited(java.lang.String emailAdress,
		javax.portlet.ActionRequest actionrequest) {
		return _invitationCardLocalService.notAlreadyInvited(emailAdress,
			actionrequest);
	}

	public com.mpower.slayer.model.InvitationCard findByUserIdAndInviteeEmail(
		long userId, java.lang.String inviteeEmail)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.slayer.NoSuchInvitationCardException {
		return _invitationCardLocalService.findByUserIdAndInviteeEmail(userId,
			inviteeEmail);
	}

	public java.util.List<com.mpower.slayer.model.InvitationCard> findbystatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationCardLocalService.findbystatus(status);
	}

	public java.util.List<com.mpower.slayer.model.InvitationCard> findByUserIdSatus(
		long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationCardLocalService.findByUserIdSatus(userId, status);
	}

	public java.util.List<com.mpower.slayer.model.UserRank> findByCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationCardLocalService.findByCount();
	}

	public com.mpower.slayer.model.InvitationCard userId(long userId,
		java.lang.String inviteeEmail)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.mpower.slayer.NoSuchInvitationCardException {
		return _invitationCardLocalService.userId(userId, inviteeEmail);
	}

	public com.mpower.slayer.model.InvitationCard invitationAccepted(
		long inviteeId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationCardLocalService.invitationAccepted(inviteeId,
			emailAddress);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public InvitationCardLocalService getWrappedInvitationCardLocalService() {
		return _invitationCardLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedInvitationCardLocalService(
		InvitationCardLocalService invitationCardLocalService) {
		_invitationCardLocalService = invitationCardLocalService;
	}

	public InvitationCardLocalService getWrappedService() {
		return _invitationCardLocalService;
	}

	public void setWrappedService(
		InvitationCardLocalService invitationCardLocalService) {
		_invitationCardLocalService = invitationCardLocalService;
	}

	private InvitationCardLocalService _invitationCardLocalService;
}