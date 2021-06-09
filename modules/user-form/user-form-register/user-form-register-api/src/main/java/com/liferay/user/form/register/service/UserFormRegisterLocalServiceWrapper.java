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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserFormRegisterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserFormRegisterLocalService
 * @generated
 */
public class UserFormRegisterLocalServiceWrapper
	implements ServiceWrapper<UserFormRegisterLocalService>,
			   UserFormRegisterLocalService {

	public UserFormRegisterLocalServiceWrapper(
		UserFormRegisterLocalService userFormRegisterLocalService) {

		_userFormRegisterLocalService = userFormRegisterLocalService;
	}

	@Override
	public com.liferay.user.form.register.model.UserFormRegister
			addUserFormRegister(
				String name, String surname, String email,
				java.util.Date birthday,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.EmailAddressException,
			   com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.UserEmailAddressException.
				   MustNotBeDuplicate {

		return _userFormRegisterLocalService.addUserFormRegister(
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
	@Override
	public com.liferay.user.form.register.model.UserFormRegister
		addUserFormRegister(
			com.liferay.user.form.register.model.UserFormRegister
				userFormRegister) {

		return _userFormRegisterLocalService.addUserFormRegister(
			userFormRegister);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userFormRegisterLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new user form register with the primary key. Does not add the user form register to the database.
	 *
	 * @param userFormRegisterPK the primary key for the new user form register
	 * @return the new user form register
	 */
	@Override
	public com.liferay.user.form.register.model.UserFormRegister
		createUserFormRegister(
			com.liferay.user.form.register.service.persistence.
				UserFormRegisterPK userFormRegisterPK) {

		return _userFormRegisterLocalService.createUserFormRegister(
			userFormRegisterPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userFormRegisterLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public com.liferay.user.form.register.model.UserFormRegister
		deleteUserFormRegister(
			com.liferay.user.form.register.model.UserFormRegister
				userFormRegister) {

		return _userFormRegisterLocalService.deleteUserFormRegister(
			userFormRegister);
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
	@Override
	public com.liferay.user.form.register.model.UserFormRegister
			deleteUserFormRegister(
				com.liferay.user.form.register.service.persistence.
					UserFormRegisterPK userFormRegisterPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userFormRegisterLocalService.deleteUserFormRegister(
			userFormRegisterPK);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _userFormRegisterLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _userFormRegisterLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userFormRegisterLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _userFormRegisterLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _userFormRegisterLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _userFormRegisterLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _userFormRegisterLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _userFormRegisterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.user.form.register.model.UserFormRegister
		fetchUserFormRegister(
			com.liferay.user.form.register.service.persistence.
				UserFormRegisterPK userFormRegisterPK) {

		return _userFormRegisterLocalService.fetchUserFormRegister(
			userFormRegisterPK);
	}

	/**
	 * Returns the user form register matching the UUID and group.
	 *
	 * @param uuid the user form register's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user form register, or <code>null</code> if a matching user form register could not be found
	 */
	@Override
	public com.liferay.user.form.register.model.UserFormRegister
		fetchUserFormRegisterByUuidAndGroupId(String uuid, long groupId) {

		return _userFormRegisterLocalService.
			fetchUserFormRegisterByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userFormRegisterLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userFormRegisterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userFormRegisterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userFormRegisterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user form register with the primary key.
	 *
	 * @param userFormRegisterPK the primary key of the user form register
	 * @return the user form register
	 * @throws PortalException if a user form register with the primary key could not be found
	 */
	@Override
	public com.liferay.user.form.register.model.UserFormRegister
			getUserFormRegister(
				com.liferay.user.form.register.service.persistence.
					UserFormRegisterPK userFormRegisterPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userFormRegisterLocalService.getUserFormRegister(
			userFormRegisterPK);
	}

	/**
	 * Returns the user form register matching the UUID and group.
	 *
	 * @param uuid the user form register's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user form register
	 * @throws PortalException if a matching user form register could not be found
	 */
	@Override
	public com.liferay.user.form.register.model.UserFormRegister
			getUserFormRegisterByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userFormRegisterLocalService.
			getUserFormRegisterByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.liferay.user.form.register.model.UserFormRegister>
		getUserFormRegisters(int start, int end) {

		return _userFormRegisterLocalService.getUserFormRegisters(start, end);
	}

	/**
	 * Returns the number of user form registers.
	 *
	 * @return the number of user form registers
	 */
	@Override
	public int getUserFormRegistersCount() {
		return _userFormRegisterLocalService.getUserFormRegistersCount();
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
	@Override
	public com.liferay.user.form.register.model.UserFormRegister
		updateUserFormRegister(
			com.liferay.user.form.register.model.UserFormRegister
				userFormRegister) {

		return _userFormRegisterLocalService.updateUserFormRegister(
			userFormRegister);
	}

	@Override
	public UserFormRegisterLocalService getWrappedService() {
		return _userFormRegisterLocalService;
	}

	@Override
	public void setWrappedService(
		UserFormRegisterLocalService userFormRegisterLocalService) {

		_userFormRegisterLocalService = userFormRegisterLocalService;
	}

	private UserFormRegisterLocalService _userFormRegisterLocalService;

}