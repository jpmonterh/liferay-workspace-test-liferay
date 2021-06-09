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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.user.form.register.model.UserFormRegister;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the user form register service. This utility wraps <code>com.liferay.user.form.register.service.persistence.impl.UserFormRegisterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserFormRegisterPersistence
 * @generated
 */
public class UserFormRegisterUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(UserFormRegister userFormRegister) {
		getPersistence().clearCache(userFormRegister);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, UserFormRegister> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserFormRegister> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserFormRegister> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserFormRegister> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserFormRegister> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserFormRegister update(UserFormRegister userFormRegister) {
		return getPersistence().update(userFormRegister);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserFormRegister update(
		UserFormRegister userFormRegister, ServiceContext serviceContext) {

		return getPersistence().update(userFormRegister, serviceContext);
	}

	/**
	 * Returns all the user form registers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user form registers
	 */
	public static List<UserFormRegister> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the user form registers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserFormRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user form registers
	 * @param end the upper bound of the range of user form registers (not inclusive)
	 * @return the range of matching user form registers
	 */
	public static List<UserFormRegister> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the user form registers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserFormRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user form registers
	 * @param end the upper bound of the range of user form registers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user form registers
	 */
	public static List<UserFormRegister> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserFormRegister> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user form registers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserFormRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user form registers
	 * @param end the upper bound of the range of user form registers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user form registers
	 */
	public static List<UserFormRegister> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserFormRegister> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user form register in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user form register
	 * @throws NoSuchFormRegisterException if a matching user form register could not be found
	 */
	public static UserFormRegister findByUuid_First(
			String uuid, OrderByComparator<UserFormRegister> orderByComparator)
		throws com.liferay.user.form.register.exception.
			NoSuchFormRegisterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first user form register in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user form register, or <code>null</code> if a matching user form register could not be found
	 */
	public static UserFormRegister fetchByUuid_First(
		String uuid, OrderByComparator<UserFormRegister> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last user form register in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user form register
	 * @throws NoSuchFormRegisterException if a matching user form register could not be found
	 */
	public static UserFormRegister findByUuid_Last(
			String uuid, OrderByComparator<UserFormRegister> orderByComparator)
		throws com.liferay.user.form.register.exception.
			NoSuchFormRegisterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last user form register in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user form register, or <code>null</code> if a matching user form register could not be found
	 */
	public static UserFormRegister fetchByUuid_Last(
		String uuid, OrderByComparator<UserFormRegister> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the user form registers before and after the current user form register in the ordered set where uuid = &#63;.
	 *
	 * @param userFormRegisterPK the primary key of the current user form register
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user form register
	 * @throws NoSuchFormRegisterException if a user form register with the primary key could not be found
	 */
	public static UserFormRegister[] findByUuid_PrevAndNext(
			UserFormRegisterPK userFormRegisterPK, String uuid,
			OrderByComparator<UserFormRegister> orderByComparator)
		throws com.liferay.user.form.register.exception.
			NoSuchFormRegisterException {

		return getPersistence().findByUuid_PrevAndNext(
			userFormRegisterPK, uuid, orderByComparator);
	}

	/**
	 * Removes all the user form registers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of user form registers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user form registers
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the user form register where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFormRegisterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user form register
	 * @throws NoSuchFormRegisterException if a matching user form register could not be found
	 */
	public static UserFormRegister findByUUID_G(String uuid, long groupId)
		throws com.liferay.user.form.register.exception.
			NoSuchFormRegisterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the user form register where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user form register, or <code>null</code> if a matching user form register could not be found
	 */
	public static UserFormRegister fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the user form register where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user form register, or <code>null</code> if a matching user form register could not be found
	 */
	public static UserFormRegister fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the user form register where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user form register that was removed
	 */
	public static UserFormRegister removeByUUID_G(String uuid, long groupId)
		throws com.liferay.user.form.register.exception.
			NoSuchFormRegisterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of user form registers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user form registers
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the user form registers where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching user form registers
	 */
	public static List<UserFormRegister> findByEmailFormRegistered(
		String email) {

		return getPersistence().findByEmailFormRegistered(email);
	}

	/**
	 * Returns a range of all the user form registers where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserFormRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of user form registers
	 * @param end the upper bound of the range of user form registers (not inclusive)
	 * @return the range of matching user form registers
	 */
	public static List<UserFormRegister> findByEmailFormRegistered(
		String email, int start, int end) {

		return getPersistence().findByEmailFormRegistered(email, start, end);
	}

	/**
	 * Returns an ordered range of all the user form registers where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserFormRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of user form registers
	 * @param end the upper bound of the range of user form registers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user form registers
	 */
	public static List<UserFormRegister> findByEmailFormRegistered(
		String email, int start, int end,
		OrderByComparator<UserFormRegister> orderByComparator) {

		return getPersistence().findByEmailFormRegistered(
			email, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user form registers where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserFormRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of user form registers
	 * @param end the upper bound of the range of user form registers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user form registers
	 */
	public static List<UserFormRegister> findByEmailFormRegistered(
		String email, int start, int end,
		OrderByComparator<UserFormRegister> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmailFormRegistered(
			email, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user form register in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user form register
	 * @throws NoSuchFormRegisterException if a matching user form register could not be found
	 */
	public static UserFormRegister findByEmailFormRegistered_First(
			String email, OrderByComparator<UserFormRegister> orderByComparator)
		throws com.liferay.user.form.register.exception.
			NoSuchFormRegisterException {

		return getPersistence().findByEmailFormRegistered_First(
			email, orderByComparator);
	}

	/**
	 * Returns the first user form register in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user form register, or <code>null</code> if a matching user form register could not be found
	 */
	public static UserFormRegister fetchByEmailFormRegistered_First(
		String email, OrderByComparator<UserFormRegister> orderByComparator) {

		return getPersistence().fetchByEmailFormRegistered_First(
			email, orderByComparator);
	}

	/**
	 * Returns the last user form register in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user form register
	 * @throws NoSuchFormRegisterException if a matching user form register could not be found
	 */
	public static UserFormRegister findByEmailFormRegistered_Last(
			String email, OrderByComparator<UserFormRegister> orderByComparator)
		throws com.liferay.user.form.register.exception.
			NoSuchFormRegisterException {

		return getPersistence().findByEmailFormRegistered_Last(
			email, orderByComparator);
	}

	/**
	 * Returns the last user form register in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user form register, or <code>null</code> if a matching user form register could not be found
	 */
	public static UserFormRegister fetchByEmailFormRegistered_Last(
		String email, OrderByComparator<UserFormRegister> orderByComparator) {

		return getPersistence().fetchByEmailFormRegistered_Last(
			email, orderByComparator);
	}

	/**
	 * Returns the user form registers before and after the current user form register in the ordered set where email = &#63;.
	 *
	 * @param userFormRegisterPK the primary key of the current user form register
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user form register
	 * @throws NoSuchFormRegisterException if a user form register with the primary key could not be found
	 */
	public static UserFormRegister[] findByEmailFormRegistered_PrevAndNext(
			UserFormRegisterPK userFormRegisterPK, String email,
			OrderByComparator<UserFormRegister> orderByComparator)
		throws com.liferay.user.form.register.exception.
			NoSuchFormRegisterException {

		return getPersistence().findByEmailFormRegistered_PrevAndNext(
			userFormRegisterPK, email, orderByComparator);
	}

	/**
	 * Removes all the user form registers where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	public static void removeByEmailFormRegistered(String email) {
		getPersistence().removeByEmailFormRegistered(email);
	}

	/**
	 * Returns the number of user form registers where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching user form registers
	 */
	public static int countByEmailFormRegistered(String email) {
		return getPersistence().countByEmailFormRegistered(email);
	}

	/**
	 * Caches the user form register in the entity cache if it is enabled.
	 *
	 * @param userFormRegister the user form register
	 */
	public static void cacheResult(UserFormRegister userFormRegister) {
		getPersistence().cacheResult(userFormRegister);
	}

	/**
	 * Caches the user form registers in the entity cache if it is enabled.
	 *
	 * @param userFormRegisters the user form registers
	 */
	public static void cacheResult(List<UserFormRegister> userFormRegisters) {
		getPersistence().cacheResult(userFormRegisters);
	}

	/**
	 * Creates a new user form register with the primary key. Does not add the user form register to the database.
	 *
	 * @param userFormRegisterPK the primary key for the new user form register
	 * @return the new user form register
	 */
	public static UserFormRegister create(
		UserFormRegisterPK userFormRegisterPK) {

		return getPersistence().create(userFormRegisterPK);
	}

	/**
	 * Removes the user form register with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userFormRegisterPK the primary key of the user form register
	 * @return the user form register that was removed
	 * @throws NoSuchFormRegisterException if a user form register with the primary key could not be found
	 */
	public static UserFormRegister remove(UserFormRegisterPK userFormRegisterPK)
		throws com.liferay.user.form.register.exception.
			NoSuchFormRegisterException {

		return getPersistence().remove(userFormRegisterPK);
	}

	public static UserFormRegister updateImpl(
		UserFormRegister userFormRegister) {

		return getPersistence().updateImpl(userFormRegister);
	}

	/**
	 * Returns the user form register with the primary key or throws a <code>NoSuchFormRegisterException</code> if it could not be found.
	 *
	 * @param userFormRegisterPK the primary key of the user form register
	 * @return the user form register
	 * @throws NoSuchFormRegisterException if a user form register with the primary key could not be found
	 */
	public static UserFormRegister findByPrimaryKey(
			UserFormRegisterPK userFormRegisterPK)
		throws com.liferay.user.form.register.exception.
			NoSuchFormRegisterException {

		return getPersistence().findByPrimaryKey(userFormRegisterPK);
	}

	/**
	 * Returns the user form register with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userFormRegisterPK the primary key of the user form register
	 * @return the user form register, or <code>null</code> if a user form register with the primary key could not be found
	 */
	public static UserFormRegister fetchByPrimaryKey(
		UserFormRegisterPK userFormRegisterPK) {

		return getPersistence().fetchByPrimaryKey(userFormRegisterPK);
	}

	/**
	 * Returns all the user form registers.
	 *
	 * @return the user form registers
	 */
	public static List<UserFormRegister> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user form registers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserFormRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user form registers
	 * @param end the upper bound of the range of user form registers (not inclusive)
	 * @return the range of user form registers
	 */
	public static List<UserFormRegister> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user form registers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserFormRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user form registers
	 * @param end the upper bound of the range of user form registers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user form registers
	 */
	public static List<UserFormRegister> findAll(
		int start, int end,
		OrderByComparator<UserFormRegister> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user form registers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserFormRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user form registers
	 * @param end the upper bound of the range of user form registers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user form registers
	 */
	public static List<UserFormRegister> findAll(
		int start, int end,
		OrderByComparator<UserFormRegister> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user form registers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user form registers.
	 *
	 * @return the number of user form registers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static UserFormRegisterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<UserFormRegisterPersistence, UserFormRegisterPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			UserFormRegisterPersistence.class);

		ServiceTracker<UserFormRegisterPersistence, UserFormRegisterPersistence>
			serviceTracker =
				new ServiceTracker
					<UserFormRegisterPersistence, UserFormRegisterPersistence>(
						bundle.getBundleContext(),
						UserFormRegisterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}