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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.user.form.register.exception.NoSuchFormRegisterException;
import com.liferay.user.form.register.model.UserFormRegister;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user form register service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserFormRegisterUtil
 * @generated
 */
@ProviderType
public interface UserFormRegisterPersistence
	extends BasePersistence<UserFormRegister> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserFormRegisterUtil} to access the user form register persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user form registers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user form registers
	 */
	public java.util.List<UserFormRegister> findByUuid(String uuid);

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
	public java.util.List<UserFormRegister> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<UserFormRegister> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserFormRegister>
			orderByComparator);

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
	public java.util.List<UserFormRegister> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserFormRegister>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user form register in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user form register
	 * @throws NoSuchFormRegisterException if a matching user form register could not be found
	 */
	public UserFormRegister findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserFormRegister>
				orderByComparator)
		throws NoSuchFormRegisterException;

	/**
	 * Returns the first user form register in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user form register, or <code>null</code> if a matching user form register could not be found
	 */
	public UserFormRegister fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserFormRegister>
			orderByComparator);

	/**
	 * Returns the last user form register in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user form register
	 * @throws NoSuchFormRegisterException if a matching user form register could not be found
	 */
	public UserFormRegister findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserFormRegister>
				orderByComparator)
		throws NoSuchFormRegisterException;

	/**
	 * Returns the last user form register in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user form register, or <code>null</code> if a matching user form register could not be found
	 */
	public UserFormRegister fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserFormRegister>
			orderByComparator);

	/**
	 * Returns the user form registers before and after the current user form register in the ordered set where uuid = &#63;.
	 *
	 * @param userFormRegisterPK the primary key of the current user form register
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user form register
	 * @throws NoSuchFormRegisterException if a user form register with the primary key could not be found
	 */
	public UserFormRegister[] findByUuid_PrevAndNext(
			UserFormRegisterPK userFormRegisterPK, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserFormRegister>
				orderByComparator)
		throws NoSuchFormRegisterException;

	/**
	 * Removes all the user form registers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of user form registers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user form registers
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the user form register where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFormRegisterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user form register
	 * @throws NoSuchFormRegisterException if a matching user form register could not be found
	 */
	public UserFormRegister findByUUID_G(String uuid, long groupId)
		throws NoSuchFormRegisterException;

	/**
	 * Returns the user form register where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user form register, or <code>null</code> if a matching user form register could not be found
	 */
	public UserFormRegister fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the user form register where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user form register, or <code>null</code> if a matching user form register could not be found
	 */
	public UserFormRegister fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the user form register where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user form register that was removed
	 */
	public UserFormRegister removeByUUID_G(String uuid, long groupId)
		throws NoSuchFormRegisterException;

	/**
	 * Returns the number of user form registers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user form registers
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the user form registers where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching user form registers
	 */
	public java.util.List<UserFormRegister> findByEmailFormRegistered(
		String email);

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
	public java.util.List<UserFormRegister> findByEmailFormRegistered(
		String email, int start, int end);

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
	public java.util.List<UserFormRegister> findByEmailFormRegistered(
		String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserFormRegister>
			orderByComparator);

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
	public java.util.List<UserFormRegister> findByEmailFormRegistered(
		String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserFormRegister>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user form register in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user form register
	 * @throws NoSuchFormRegisterException if a matching user form register could not be found
	 */
	public UserFormRegister findByEmailFormRegistered_First(
			String email,
			com.liferay.portal.kernel.util.OrderByComparator<UserFormRegister>
				orderByComparator)
		throws NoSuchFormRegisterException;

	/**
	 * Returns the first user form register in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user form register, or <code>null</code> if a matching user form register could not be found
	 */
	public UserFormRegister fetchByEmailFormRegistered_First(
		String email,
		com.liferay.portal.kernel.util.OrderByComparator<UserFormRegister>
			orderByComparator);

	/**
	 * Returns the last user form register in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user form register
	 * @throws NoSuchFormRegisterException if a matching user form register could not be found
	 */
	public UserFormRegister findByEmailFormRegistered_Last(
			String email,
			com.liferay.portal.kernel.util.OrderByComparator<UserFormRegister>
				orderByComparator)
		throws NoSuchFormRegisterException;

	/**
	 * Returns the last user form register in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user form register, or <code>null</code> if a matching user form register could not be found
	 */
	public UserFormRegister fetchByEmailFormRegistered_Last(
		String email,
		com.liferay.portal.kernel.util.OrderByComparator<UserFormRegister>
			orderByComparator);

	/**
	 * Returns the user form registers before and after the current user form register in the ordered set where email = &#63;.
	 *
	 * @param userFormRegisterPK the primary key of the current user form register
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user form register
	 * @throws NoSuchFormRegisterException if a user form register with the primary key could not be found
	 */
	public UserFormRegister[] findByEmailFormRegistered_PrevAndNext(
			UserFormRegisterPK userFormRegisterPK, String email,
			com.liferay.portal.kernel.util.OrderByComparator<UserFormRegister>
				orderByComparator)
		throws NoSuchFormRegisterException;

	/**
	 * Removes all the user form registers where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	public void removeByEmailFormRegistered(String email);

	/**
	 * Returns the number of user form registers where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching user form registers
	 */
	public int countByEmailFormRegistered(String email);

	/**
	 * Caches the user form register in the entity cache if it is enabled.
	 *
	 * @param userFormRegister the user form register
	 */
	public void cacheResult(UserFormRegister userFormRegister);

	/**
	 * Caches the user form registers in the entity cache if it is enabled.
	 *
	 * @param userFormRegisters the user form registers
	 */
	public void cacheResult(java.util.List<UserFormRegister> userFormRegisters);

	/**
	 * Creates a new user form register with the primary key. Does not add the user form register to the database.
	 *
	 * @param userFormRegisterPK the primary key for the new user form register
	 * @return the new user form register
	 */
	public UserFormRegister create(UserFormRegisterPK userFormRegisterPK);

	/**
	 * Removes the user form register with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userFormRegisterPK the primary key of the user form register
	 * @return the user form register that was removed
	 * @throws NoSuchFormRegisterException if a user form register with the primary key could not be found
	 */
	public UserFormRegister remove(UserFormRegisterPK userFormRegisterPK)
		throws NoSuchFormRegisterException;

	public UserFormRegister updateImpl(UserFormRegister userFormRegister);

	/**
	 * Returns the user form register with the primary key or throws a <code>NoSuchFormRegisterException</code> if it could not be found.
	 *
	 * @param userFormRegisterPK the primary key of the user form register
	 * @return the user form register
	 * @throws NoSuchFormRegisterException if a user form register with the primary key could not be found
	 */
	public UserFormRegister findByPrimaryKey(
			UserFormRegisterPK userFormRegisterPK)
		throws NoSuchFormRegisterException;

	/**
	 * Returns the user form register with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userFormRegisterPK the primary key of the user form register
	 * @return the user form register, or <code>null</code> if a user form register with the primary key could not be found
	 */
	public UserFormRegister fetchByPrimaryKey(
		UserFormRegisterPK userFormRegisterPK);

	/**
	 * Returns all the user form registers.
	 *
	 * @return the user form registers
	 */
	public java.util.List<UserFormRegister> findAll();

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
	public java.util.List<UserFormRegister> findAll(int start, int end);

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
	public java.util.List<UserFormRegister> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserFormRegister>
			orderByComparator);

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
	public java.util.List<UserFormRegister> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserFormRegister>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user form registers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user form registers.
	 *
	 * @return the number of user form registers
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}