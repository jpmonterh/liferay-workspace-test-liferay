<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha" %>

<%@page import="com.liferay.user.form.web.constants.UserFormWebPortletKeys"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@ page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>
<%@ page import="javax.naming.NameNotFoundException"%>
<%@ page import="com.liferay.portal.kernel.exception.ContactBirthdayException"%>
<%@page import="java.text.ParseException"%>
<%@ page import="com.liferay.portal.kernel.exception.EmailAddressException"%>
<%@ page import="com.liferay.portal.kernel.exception.UserEmailAddressException"%>



<liferay-theme:defineObjects />

<portlet:defineObjects />