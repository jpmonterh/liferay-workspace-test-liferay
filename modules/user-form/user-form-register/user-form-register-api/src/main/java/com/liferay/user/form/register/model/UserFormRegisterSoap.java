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

import com.liferay.user.form.register.service.persistence.UserFormRegisterPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.user.form.register.service.http.UserFormRegisterServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class UserFormRegisterSoap implements Serializable {

	public static UserFormRegisterSoap toSoapModel(UserFormRegister model) {
		UserFormRegisterSoap soapModel = new UserFormRegisterSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setUserFormRegisterId(model.getUserFormRegisterId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setName(model.getName());
		soapModel.setSurname(model.getSurname());
		soapModel.setEmail(model.getEmail());
		soapModel.setBirthday(model.getBirthday());

		return soapModel;
	}

	public static UserFormRegisterSoap[] toSoapModels(
		UserFormRegister[] models) {

		UserFormRegisterSoap[] soapModels =
			new UserFormRegisterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserFormRegisterSoap[][] toSoapModels(
		UserFormRegister[][] models) {

		UserFormRegisterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new UserFormRegisterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserFormRegisterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserFormRegisterSoap[] toSoapModels(
		List<UserFormRegister> models) {

		List<UserFormRegisterSoap> soapModels =
			new ArrayList<UserFormRegisterSoap>(models.size());

		for (UserFormRegister model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserFormRegisterSoap[soapModels.size()]);
	}

	public UserFormRegisterSoap() {
	}

	public UserFormRegisterPK getPrimaryKey() {
		return new UserFormRegisterPK(_userFormRegisterId, _email);
	}

	public void setPrimaryKey(UserFormRegisterPK pk) {
		setUserFormRegisterId(pk.userFormRegisterId);
		setEmail(pk.email);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getUserFormRegisterId() {
		return _userFormRegisterId;
	}

	public void setUserFormRegisterId(long userFormRegisterId) {
		_userFormRegisterId = userFormRegisterId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getSurname() {
		return _surname;
	}

	public void setSurname(String surname) {
		_surname = surname;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public Date getBirthday() {
		return _birthday;
	}

	public void setBirthday(Date birthday) {
		_birthday = birthday;
	}

	private String _uuid;
	private long _userFormRegisterId;
	private long _groupId;
	private Date _createDate;
	private String _name;
	private String _surname;
	private String _email;
	private Date _birthday;

}