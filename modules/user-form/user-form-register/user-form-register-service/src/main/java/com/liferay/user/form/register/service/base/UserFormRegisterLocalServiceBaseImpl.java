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

package com.liferay.user.form.register.service.base;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.user.form.register.model.UserFormRegister;
import com.liferay.user.form.register.service.UserFormRegisterLocalService;
import com.liferay.user.form.register.service.UserFormRegisterLocalServiceUtil;
import com.liferay.user.form.register.service.persistence.UserFormRegisterPK;
import com.liferay.user.form.register.service.persistence.UserFormRegisterPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the user form register local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.user.form.register.service.impl.UserFormRegisterLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.user.form.register.service.impl.UserFormRegisterLocalServiceImpl
 * @generated
 */
public abstract class UserFormRegisterLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   UserFormRegisterLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>UserFormRegisterLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>UserFormRegisterLocalServiceUtil</code>.
	 */

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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public UserFormRegister addUserFormRegister(
		UserFormRegister userFormRegister) {

		userFormRegister.setNew(true);

		return userFormRegisterPersistence.update(userFormRegister);
	}

	/**
	 * Creates a new user form register with the primary key. Does not add the user form register to the database.
	 *
	 * @param userFormRegisterPK the primary key for the new user form register
	 * @return the new user form register
	 */
	@Override
	@Transactional(enabled = false)
	public UserFormRegister createUserFormRegister(
		UserFormRegisterPK userFormRegisterPK) {

		return userFormRegisterPersistence.create(userFormRegisterPK);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public UserFormRegister deleteUserFormRegister(
			UserFormRegisterPK userFormRegisterPK)
		throws PortalException {

		return userFormRegisterPersistence.remove(userFormRegisterPK);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public UserFormRegister deleteUserFormRegister(
		UserFormRegister userFormRegister) {

		return userFormRegisterPersistence.remove(userFormRegister);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return userFormRegisterPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			UserFormRegister.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return userFormRegisterPersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return userFormRegisterPersistence.findWithDynamicQuery(
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return userFormRegisterPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return userFormRegisterPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return userFormRegisterPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public UserFormRegister fetchUserFormRegister(
		UserFormRegisterPK userFormRegisterPK) {

		return userFormRegisterPersistence.fetchByPrimaryKey(
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
	public UserFormRegister fetchUserFormRegisterByUuidAndGroupId(
		String uuid, long groupId) {

		return userFormRegisterPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the user form register with the primary key.
	 *
	 * @param userFormRegisterPK the primary key of the user form register
	 * @return the user form register
	 * @throws PortalException if a user form register with the primary key could not be found
	 */
	@Override
	public UserFormRegister getUserFormRegister(
			UserFormRegisterPK userFormRegisterPK)
		throws PortalException {

		return userFormRegisterPersistence.findByPrimaryKey(userFormRegisterPK);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			userFormRegisterLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(UserFormRegister.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.userFormRegisterId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			userFormRegisterLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(UserFormRegister.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.userFormRegisterId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			userFormRegisterLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(UserFormRegister.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.userFormRegisterId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return userFormRegisterPersistence.create(
			(UserFormRegisterPK)primaryKeyObj);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return userFormRegisterLocalService.deleteUserFormRegister(
			(UserFormRegister)persistedModel);
	}

	@Override
	public BasePersistence<UserFormRegister> getBasePersistence() {
		return userFormRegisterPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return userFormRegisterPersistence.findByPrimaryKey(primaryKeyObj);
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
	public UserFormRegister getUserFormRegisterByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return userFormRegisterPersistence.findByUUID_G(uuid, groupId);
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
	public List<UserFormRegister> getUserFormRegisters(int start, int end) {
		return userFormRegisterPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of user form registers.
	 *
	 * @return the number of user form registers
	 */
	@Override
	public int getUserFormRegistersCount() {
		return userFormRegisterPersistence.countAll();
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public UserFormRegister updateUserFormRegister(
		UserFormRegister userFormRegister) {

		return userFormRegisterPersistence.update(userFormRegister);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			UserFormRegisterLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		userFormRegisterLocalService = (UserFormRegisterLocalService)aopProxy;

		_setLocalServiceUtilService(userFormRegisterLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return UserFormRegisterLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return UserFormRegister.class;
	}

	protected String getModelClassName() {
		return UserFormRegister.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = userFormRegisterPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		UserFormRegisterLocalService userFormRegisterLocalService) {

		try {
			Field field =
				UserFormRegisterLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, userFormRegisterLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected UserFormRegisterLocalService userFormRegisterLocalService;

	@Reference
	protected UserFormRegisterPersistence userFormRegisterPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

}