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

package com.liferay.user.form.register.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.user.form.register.model.UserFormRegister;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for UserFormRegister. This utility wraps
 * <code>com.liferay.user.form.register.service.impl.UserFormRegisterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserFormRegisterLocalService
 * @generated
 */
public class UserFormRegisterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.user.form.register.service.impl.UserFormRegisterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static UserFormRegister addUserFormRegister(
			String name, String surname, String email, java.util.Date birthday,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.EmailAddressException,
			   com.liferay.portal.kernel.exception.UserEmailAddressException.
				   MustNotBeDuplicate,
			   PortalException {

		return getService().addUserFormRegister(
			name, surname, email, birthday, serviceContext);
	}

	/**
	 * Adds the user form register to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserFormRegisterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userFormRegister the user form register
	 * @return the user form register that was added
	 */
	public static UserFormRegister addUserFormRegister(
		UserFormRegister userFormRegister) {

		return getService().addUserFormRegister(userFormRegister);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new user form register with the primary key. Does not add the user form register to the database.
	 *
	 * @param userFormRegisterPK the primary key for the new user form register
	 * @return the new user form register
	 */
	public static UserFormRegister createUserFormRegister(
		com.liferay.user.form.register.service.persistence.UserFormRegisterPK
			userFormRegisterPK) {

		return getService().createUserFormRegister(userFormRegisterPK);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the user form register from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserFormRegisterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userFormRegister the user form register
	 * @return the user form register that was removed
	 */
	public static UserFormRegister deleteUserFormRegister(
		UserFormRegister userFormRegister) {

		return getService().deleteUserFormRegister(userFormRegister);
	}

	/**
	 * Deletes the user form register with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserFormRegisterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userFormRegisterPK the primary key of the user form register
	 * @return the user form register that was removed
	 * @throws PortalException if a user form register with the primary key could not be found
	 */
	public static UserFormRegister deleteUserFormRegister(
			com.liferay.user.form.register.service.persistence.
				UserFormRegisterPK userFormRegisterPK)
		throws PortalException {

		return getService().deleteUserFormRegister(userFormRegisterPK);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.user.form.register.model.impl.UserFormRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.user.form.register.model.impl.UserFormRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static UserFormRegister fetchUserFormRegister(
		com.liferay.user.form.register.service.persistence.UserFormRegisterPK
			userFormRegisterPK) {

		return getService().fetchUserFormRegister(userFormRegisterPK);
	}

	/**
	 * Returns the user form register matching the UUID and group.
	 *
	 * @param uuid the user form register's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user form register, or <code>null</code> if a matching user form register could not be found
	 */
	public static UserFormRegister fetchUserFormRegisterByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchUserFormRegisterByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user form register with the primary key.
	 *
	 * @param userFormRegisterPK the primary key of the user form register
	 * @return the user form register
	 * @throws PortalException if a user form register with the primary key could not be found
	 */
	public static UserFormRegister getUserFormRegister(
			com.liferay.user.form.register.service.persistence.
				UserFormRegisterPK userFormRegisterPK)
		throws PortalException {

		return getService().getUserFormRegister(userFormRegisterPK);
	}

	/**
	 * Returns the user form register matching the UUID and group.
	 *
	 * @param uuid the user form register's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user form register
	 * @throws PortalException if a matching user form register could not be found
	 */
	public static UserFormRegister getUserFormRegisterByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getUserFormRegisterByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the user form registers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.user.form.register.model.impl.UserFormRegisterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user form registers
	 * @param end the upper bound of the range of user form registers (not inclusive)
	 * @return the range of user form registers
	 */
	public static List<UserFormRegister> getUserFormRegisters(
		int start, int end) {

		return getService().getUserFormRegisters(start, end);
	}

	/**
	 * Returns the number of user form registers.
	 *
	 * @return the number of user form registers
	 */
	public static int getUserFormRegistersCount() {
		return getService().getUserFormRegistersCount();
	}

	/**
	 * Updates the user form register in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserFormRegisterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userFormRegister the user form register
	 * @return the user form register that was updated
	 */
	public static UserFormRegister updateUserFormRegister(
		UserFormRegister userFormRegister) {

		return getService().updateUserFormRegister(userFormRegister);
	}

	public static UserFormRegisterLocalService getService() {
		return _service;
	}

	private static volatile UserFormRegisterLocalService _service;

}