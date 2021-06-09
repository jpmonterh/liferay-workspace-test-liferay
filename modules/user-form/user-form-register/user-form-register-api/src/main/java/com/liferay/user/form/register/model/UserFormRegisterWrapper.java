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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserFormRegister}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserFormRegister
 * @generated
 */
public class UserFormRegisterWrapper
	extends BaseModelWrapper<UserFormRegister>
	implements ModelWrapper<UserFormRegister>, UserFormRegister {

	public UserFormRegisterWrapper(UserFormRegister userFormRegister) {
		super(userFormRegister);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("userFormRegisterId", getUserFormRegisterId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("name", getName());
		attributes.put("surname", getSurname());
		attributes.put("email", getEmail());
		attributes.put("birthday", getBirthday());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long userFormRegisterId = (Long)attributes.get("userFormRegisterId");

		if (userFormRegisterId != null) {
			setUserFormRegisterId(userFormRegisterId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String surname = (String)attributes.get("surname");

		if (surname != null) {
			setSurname(surname);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Date birthday = (Date)attributes.get("birthday");

		if (birthday != null) {
			setBirthday(birthday);
		}
	}

	/**
	 * Returns the birthday of this user form register.
	 *
	 * @return the birthday of this user form register
	 */
	@Override
	public Date getBirthday() {
		return model.getBirthday();
	}

	/**
	 * Returns the create date of this user form register.
	 *
	 * @return the create date of this user form register
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email of this user form register.
	 *
	 * @return the email of this user form register
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the group ID of this user form register.
	 *
	 * @return the group ID of this user form register
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the name of this user form register.
	 *
	 * @return the name of this user form register
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this user form register.
	 *
	 * @return the primary key of this user form register
	 */
	@Override
	public com.liferay.user.form.register.service.persistence.UserFormRegisterPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the surname of this user form register.
	 *
	 * @return the surname of this user form register
	 */
	@Override
	public String getSurname() {
		return model.getSurname();
	}

	/**
	 * Returns the user form register ID of this user form register.
	 *
	 * @return the user form register ID of this user form register
	 */
	@Override
	public long getUserFormRegisterId() {
		return model.getUserFormRegisterId();
	}

	/**
	 * Returns the uuid of this user form register.
	 *
	 * @return the uuid of this user form register
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the birthday of this user form register.
	 *
	 * @param birthday the birthday of this user form register
	 */
	@Override
	public void setBirthday(Date birthday) {
		model.setBirthday(birthday);
	}

	/**
	 * Sets the create date of this user form register.
	 *
	 * @param createDate the create date of this user form register
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email of this user form register.
	 *
	 * @param email the email of this user form register
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the group ID of this user form register.
	 *
	 * @param groupId the group ID of this user form register
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the name of this user form register.
	 *
	 * @param name the name of this user form register
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this user form register.
	 *
	 * @param primaryKey the primary key of this user form register
	 */
	@Override
	public void setPrimaryKey(
		com.liferay.user.form.register.service.persistence.UserFormRegisterPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the surname of this user form register.
	 *
	 * @param surname the surname of this user form register
	 */
	@Override
	public void setSurname(String surname) {
		model.setSurname(surname);
	}

	/**
	 * Sets the user form register ID of this user form register.
	 *
	 * @param userFormRegisterId the user form register ID of this user form register
	 */
	@Override
	public void setUserFormRegisterId(long userFormRegisterId) {
		model.setUserFormRegisterId(userFormRegisterId);
	}

	/**
	 * Sets the uuid of this user form register.
	 *
	 * @param uuid the uuid of this user form register
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected UserFormRegisterWrapper wrap(UserFormRegister userFormRegister) {
		return new UserFormRegisterWrapper(userFormRegister);
	}

}