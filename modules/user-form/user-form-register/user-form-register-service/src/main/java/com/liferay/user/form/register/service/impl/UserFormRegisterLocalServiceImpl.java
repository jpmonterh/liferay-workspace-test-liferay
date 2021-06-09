/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.user.form.register.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.EmailAddressException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserEmailAddressException.MustNotBeDuplicate;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.user.form.register.model.UserFormRegister;
import com.liferay.user.form.register.service.base.UserFormRegisterLocalServiceBaseImpl;
import com.liferay.user.form.register.service.persistence.UserFormRegisterPK;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the user form register local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.user.form.register.service.UserFormRegisterLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserFormRegisterLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.user.form.register.model.UserFormRegister",
	service = AopService.class
)
public class UserFormRegisterLocalServiceImpl
	extends UserFormRegisterLocalServiceBaseImpl {
	
	@Indexable(type = IndexableType.REINDEX)
	public UserFormRegister addUserFormRegister(String name, String surname, String email,Date birthday, ServiceContext serviceContext) throws EmailAddressException, MustNotBeDuplicate, PortalException {
		
		if (Validator.isNull(email) || !Validator.isEmailAddress(email)) {
			throw new EmailAddressException();
		}
		
		UserFormRegisterPK userFormRegisterPK = new UserFormRegisterPK();
		userFormRegisterPK.setUserFormRegisterId(counterLocalService.increment(UserFormRegisterPK.class.getName()));
		UserFormRegister userFormRegister = userFormRegisterPersistence.fetchByEmailFormRegistered_First(email, null);
		
		if (Validator.isNotNull(userFormRegister)) {
			throw new UserEmailAddressException.MustNotBeDuplicate(serviceContext.getCompanyId(), email);
		}
		
		try {
		
			userFormRegister = createUserFormRegister(userFormRegisterPK);
			userFormRegister.setBirthday(birthday);
			userFormRegister.setEmail(email);
			userFormRegister.setName(name);
			userFormRegister.setSurname(surname);
			userFormRegister.setGroupId(serviceContext.getScopeGroupId());
			userFormRegister.setCreateDate(new Date());
			userFormRegister = super.addUserFormRegister(userFormRegister);
		}catch(Exception e) {
			_log.error(this.getClass().getName());
			throw new PortalException(e);
			
		}
		return userFormRegister;
	}

	private Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}