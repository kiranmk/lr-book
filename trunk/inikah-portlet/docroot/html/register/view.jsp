<%@ include file="/html/init.jsp" %>

<% 
	PortletURL createAccountURL = PortletURLFactoryUtil.create(request, "58", plid, PortletRequest.ACTION_PHASE);
	createAccountURL.setWindowState(WindowState.NORMAL);
	createAccountURL.setPortletMode(PortletMode.VIEW);
	createAccountURL.setParameter("saveLastPath", "0");
	createAccountURL.setParameter("struts_action", "/login/create_account");
	
	String PORTLET_NSPACE = "_58_";
%>

<aui:form portletNamespace="<%= PORTLET_NSPACE %>" action="<%= createAccountURL.toString() %>">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
	
	<!-- birth day -->
	<aui:input name="birthdayDay" type="hidden" value="1" />
	<aui:input name="firstName" type="hidden" value="Not Specified" />
	<aui:input name="customRegistration" type="hidden" value="<%= true %>"/>
	
	<aui:input name="profileName" label="profile-name" helpMessage="help-msg-profile-name" required="<%= true %>" />
	
	<aui:input name="emailAddress" required="<%= true %>" helpMessage="help-msg-email-address">
		<aui:validator name="email"/>
	</aui:input>
	
	<aui:select name="bride" label="profile-type" helpMessage="help-msg-profile-type"
			showEmptyOption="<%= true %>" required="<%= true %>" showRequiredLabel="<%= true %>" >
		<aui:option value="1" label="bride"/>
		<aui:option value="0" label="groom"/>
	</aui:select>
	
	<aui:input name="" type="checkbox" required="<%= true %>" label="i-agree-to-terms-and-conditions" showRequiredLabel="<%= false %>"/>
	
	<aui:button type="submit" value="Register" />
</aui:form>

<aui:script>
	Liferay.Util.focusFormField(
		document.<%= PORTLET_NSPACE %>fm.<%= PORTLET_NSPACE %>profileName);
</aui:script>