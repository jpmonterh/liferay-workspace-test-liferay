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

package com.liferay.user.form.register.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserFormRegisterPK
	implements Comparable<UserFormRegisterPK>, Serializable {

	public long userFormRegisterId;
	public String email;

	public UserFormRegisterPK() {
	}

	public UserFormRegisterPK(long userFormRegisterId, String email) {
		this.userFormRegisterId = userFormRegisterId;
		this.email = email;
	}

	public long getUserFormRegisterId() {
		return userFormRegisterId;
	}

	public void setUserFormRegisterId(long userFormRegisterId) {
		this.userFormRegisterId = userFormRegisterId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(UserFormRegisterPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (userFormRegisterId < pk.userFormRegisterId) {
			value = -1;
		}
		else if (userFormRegisterId > pk.userFormRegisterId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = email.compareTo(pk.email);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserFormRegisterPK)) {
			return false;
		}

		UserFormRegisterPK pk = (UserFormRegisterPK)object;

		if ((userFormRegisterId == pk.userFormRegisterId) &&
			email.equals(pk.email)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, userFormRegisterId);
		hashCode = HashUtil.hash(hashCode, email);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("userFormRegisterId=");

		sb.append(userFormRegisterId);
		sb.append(", email=");

		sb.append(email);

		sb.append("}");

		return sb.toString();
	}

}