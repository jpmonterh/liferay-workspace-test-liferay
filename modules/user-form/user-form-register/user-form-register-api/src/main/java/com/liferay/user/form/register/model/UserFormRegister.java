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

package com.liferay.user.form.register.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the UserFormRegister service. Represents a row in the &quot;User_UserFormRegister&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see UserFormRegisterModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.user.form.register.model.impl.UserFormRegisterImpl"
)
@ProviderType
public interface UserFormRegister
	extends PersistedModel, UserFormRegisterModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.user.form.register.model.impl.UserFormRegisterImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UserFormRegister, Long>
		USER_FORM_REGISTER_ID_ACCESSOR =
			new Accessor<UserFormRegister, Long>() {

				@Override
				public Long get(UserFormRegister userFormRegister) {
					return userFormRegister.getUserFormRegisterId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<UserFormRegister> getTypeClass() {
					return UserFormRegister.class;
				}

			};
	public static final Accessor<UserFormRegister, String> EMAIL_ACCESSOR =
		new Accessor<UserFormRegister, String>() {

			@Override
			public String get(UserFormRegister userFormRegister) {
				return userFormRegister.getEmail();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<UserFormRegister> getTypeClass() {
				return UserFormRegister.class;
			}

		};

}