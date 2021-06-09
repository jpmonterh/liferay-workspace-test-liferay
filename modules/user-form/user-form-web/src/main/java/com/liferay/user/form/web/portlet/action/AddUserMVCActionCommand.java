package com.liferay.user.form.web.portlet.action;

import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.SendFailedException;
import javax.mail.internet.InternetAddress;
import javax.naming.NameNotFoundException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.exception.ContactBirthdayException;
import com.liferay.portal.kernel.exception.EmailAddressException;
import com.liferay.portal.kernel.exception.UserEmailAddressException.MustNotBeDuplicate;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.user.form.register.model.UserFormRegister;
import com.liferay.user.form.register.service.UserFormRegisterLocalService;
import com.liferay.user.form.web.constants.UserFormWebPortletKeys;
import com.liferay.user.form.web.portlet.util.UserFormWebPortletUtil;

/**
 * @author Juan Pablo Montero
 */
@Component(
		property = {
			"javax.portlet.name=" + UserFormWebPortletKeys.USERFORMWEB,
			"mvc.command.name=" + UserFormWebPortletKeys.USERFORMACTION
		},
		service = MVCActionCommand.class
		
		)
public class AddUserMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try{
			
			String userName = ParamUtil.getString(actionRequest,"name");
			
			if(Validator.isNull(userName)) {
				throw new NameNotFoundException();
			}
			
			String userSurname = ParamUtil.getString(actionRequest,"surname");
			if(Validator.isNull(userSurname)) {
				throw new NameNotFoundException();
			}
			
			String userEmail = ParamUtil.getString(actionRequest, "email");
			String userEmailRepeated = ParamUtil.getString(actionRequest, "emailConfirmed");
			
			if(Validator.isNull(userEmail) || Validator.isNull(userEmailRepeated) ||!userEmail.equalsIgnoreCase(userEmailRepeated)) {
				throw new EmailAddressException();
			}
			
			String userBirthdayText= ParamUtil.getString(actionRequest, "birthday");
			Date userBirthday = sdf.parse(userBirthdayText);
			
			if (!UserFormWebPortletUtil.isValidDate(userBirthday)) {
				throw new ContactBirthdayException();
			}
			
            CaptchaUtil.check(actionRequest);  
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(this.getClass().getName(),actionRequest);
			serviceContext.setScopeGroupId(themeDisplay.getSiteGroupId());
			UserFormRegister userFormResgister = _userRegisterLocalService.addUserFormRegister(userName, userSurname, userEmail, userBirthday, serviceContext );
			if(Validator.isNotNull(userFormResgister)) {
				sendEmail(userFormResgister, actionRequest);
			}

			SessionMessages.add(actionRequest, "thanks.for.your.registration");
			
		 }catch(Exception exception) {
	            if(exception instanceof CaptchaTextException) {
	                SessionErrors.add(actionRequest, exception.getClass(), exception);
	                _log.error(UserFormWebPortletKeys.CAPTCHAERRORLOG);
	            }else if(exception instanceof MustNotBeDuplicate || exception instanceof EmailAddressException) {
	            	SessionErrors.add(actionRequest, exception.getClass(), exception);
	                _log.error(UserFormWebPortletKeys.INVALIDEMAIL);
	            }else {
	            	SessionErrors.add(actionRequest, exception.getClass(), exception);
	            }
	           
		    }

		
	}
	public void sendEmail(UserFormRegister userFormResgister, ActionRequest actionRequest) throws SendFailedException {
		
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(actionRequest);
		String subject = LanguageUtil.get(httpServletRequest, "email.template.subject");
		String body = LanguageUtil.get(httpServletRequest, "email.template.body");

		try {
			InternetAddress from = new InternetAddress("contact@liferay.com","contact");
			InternetAddress to = new InternetAddress(userFormResgister.getEmail(),userFormResgister.getName());
			MailMessage mailMessage = new MailMessage(from, to, subject, MessageFormat.format(body, userFormResgister.getName()), true);
			MailServiceUtil.sendEmail(mailMessage);
			
		} catch (IOException e) {
			throw new SendFailedException();
		}
		
	}

	private Log _log = LogFactoryUtil.getLog(this.getClass().getName());
	
	@Reference
	private UserFormRegisterLocalService _userRegisterLocalService;
	
}
