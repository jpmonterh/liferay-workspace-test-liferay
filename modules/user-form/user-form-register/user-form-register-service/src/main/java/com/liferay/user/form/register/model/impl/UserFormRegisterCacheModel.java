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

package com.liferay.user.form.register.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.user.form.register.model.UserFormRegister;
import com.liferay.user.form.register.service.persistence.UserFormRegisterPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserFormRegister in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserFormRegisterCacheModel
	implements CacheModel<UserFormRegister>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserFormRegisterCacheModel)) {
			return false;
		}

		UserFormRegisterCacheModel userFormRegisterCacheModel =
			(UserFormRegisterCacheModel)object;

		if (userFormRegisterPK.equals(
				userFormRegisterCacheModel.userFormRegisterPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userFormRegisterPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", userFormRegisterId=");
		sb.append(userFormRegisterId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", surname=");
		sb.append(surname);
		sb.append(", email=");
		sb.append(email);
		sb.append(", birthday=");
		sb.append(birthday);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserFormRegister toEntityModel() {
		UserFormRegisterImpl userFormRegisterImpl = new UserFormRegisterImpl();

		if (uuid == null) {
			userFormRegisterImpl.setUuid("");
		}
		else {
			userFormRegisterImpl.setUuid(uuid);
		}

		userFormRegisterImpl.setUserFormRegisterId(userFormRegisterId);
		userFormRegisterImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			userFormRegisterImpl.setCreateDate(null);
		}
		else {
			userFormRegisterImpl.setCreateDate(new Date(createDate));
		}

		if (name == null) {
			userFormRegisterImpl.setName("");
		}
		else {
			userFormRegisterImpl.setName(name);
		}

		if (surname == null) {
			userFormRegisterImpl.setSurname("");
		}
		else {
			userFormRegisterImpl.setSurname(surname);
		}

		if (email == null) {
			userFormRegisterImpl.setEmail("");
		}
		else {
			userFormRegisterImpl.setEmail(email);
		}

		if (birthday == Long.MIN_VALUE) {
			userFormRegisterImpl.setBirthday(null);
		}
		else {
			userFormRegisterImpl.setBirthday(new Date(birthday));
		}

		userFormRegisterImpl.resetOriginalValues();

		return userFormRegisterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		userFormRegisterId = objectInput.readLong();

		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		name = objectInput.readUTF();
		surname = objectInput.readUTF();
		email = objectInput.readUTF();
		birthday = objectInput.readLong();

		userFormRegisterPK = new UserFormRegisterPK(userFormRegisterId, email);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(userFormRegisterId);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (surname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(surname);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(birthday);
	}

	public String uuid;
	public long userFormRegisterId;
	public long groupId;
	public long createDate;
	public String name;
	public String surname;
	public String email;
	public long birthday;
	public transient UserFormRegisterPK userFormRegisterPK;

}