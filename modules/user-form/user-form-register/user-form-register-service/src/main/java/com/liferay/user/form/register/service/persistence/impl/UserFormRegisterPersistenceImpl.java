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

package com.liferay.user.form.register.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.user.form.register.exception.NoSuchFormRegisterException;
import com.liferay.user.form.register.model.UserFormRegister;
import com.liferay.user.form.register.model.UserFormRegisterTable;
import com.liferay.user.form.register.model.impl.UserFormRegisterImpl;
import com.liferay.user.form.register.model.impl.UserFormRegisterModelImpl;
import com.liferay.user.form.register.service.persistence.UserFormRegisterPK;
import com.liferay.user.form.register.service.persistence.UserFormRegisterPersistence;
import com.liferay.user.form.register.service.persistence.impl.constants.UserPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the user form register service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {UserFormRegisterPersistence.class, BasePersistence.class})
public class UserFormRegisterPersistenceImpl
	extends BasePersistenceImpl<UserFormRegister>
	implements UserFormRegisterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserFormRegisterUtil</code> to access the user form register persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserFormRegisterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the user form registers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user form registers
	 */
	@Override
	public List<UserFormRegister> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserFormRegister> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<UserFormRegister> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserFormRegister> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<UserFormRegister> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserFormRegister> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<UserFormRegister> list = null;

		if (useFinderCache) {
			list = (List<UserFormRegister>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (UserFormRegister userFormRegister : list) {
					if (!uuid.equals(userFormRegister.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_USERFORMREGISTER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserFormRegisterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<UserFormRegister>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user form register in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user form register
	 * @throws NoSuchFormRegisterException if a matching user form register could not be found
	 */
	@Override
	public UserFormRegister findByUuid_First(
			String uuid, OrderByComparator<UserFormRegister> orderByComparator)
		throws NoSuchFormRegisterException {

		UserFormRegister userFormRegister = fetchByUuid_First(
			uuid, orderByComparator);

		if (userFormRegister != null) {
			return userFormRegister;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFormRegisterException(sb.toString());
	}

	/**
	 * Returns the first user form register in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user form register, or <code>null</code> if a matching user form register could not be found
	 */
	@Override
	public UserFormRegister fetchByUuid_First(
		String uuid, OrderByComparator<UserFormRegister> orderByComparator) {

		List<UserFormRegister> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user form register in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user form register
	 * @throws NoSuchFormRegisterException if a matching user form register could not be found
	 */
	@Override
	public UserFormRegister findByUuid_Last(
			String uuid, OrderByComparator<UserFormRegister> orderByComparator)
		throws NoSuchFormRegisterException {

		UserFormRegister userFormRegister = fetchByUuid_Last(
			uuid, orderByComparator);

		if (userFormRegister != null) {
			return userFormRegister;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFormRegisterException(sb.toString());
	}

	/**
	 * Returns the last user form register in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user form register, or <code>null</code> if a matching user form register could not be found
	 */
	@Override
	public UserFormRegister fetchByUuid_Last(
		String uuid, OrderByComparator<UserFormRegister> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserFormRegister> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserFormRegister[] findByUuid_PrevAndNext(
			UserFormRegisterPK userFormRegisterPK, String uuid,
			OrderByComparator<UserFormRegister> orderByComparator)
		throws NoSuchFormRegisterException {

		uuid = Objects.toString(uuid, "");

		UserFormRegister userFormRegister = findByPrimaryKey(
			userFormRegisterPK);

		Session session = null;

		try {
			session = openSession();

			UserFormRegister[] array = new UserFormRegisterImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, userFormRegister, uuid, orderByComparator, true);

			array[1] = userFormRegister;

			array[2] = getByUuid_PrevAndNext(
				session, userFormRegister, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserFormRegister getByUuid_PrevAndNext(
		Session session, UserFormRegister userFormRegister, String uuid,
		OrderByComparator<UserFormRegister> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_USERFORMREGISTER_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(UserFormRegisterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						userFormRegister)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserFormRegister> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user form registers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UserFormRegister userFormRegister :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userFormRegister);
		}
	}

	/**
	 * Returns the number of user form registers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user form registers
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERFORMREGISTER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"userFormRegister.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(userFormRegister.uuid IS NULL OR userFormRegister.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the user form register where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFormRegisterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user form register
	 * @throws NoSuchFormRegisterException if a matching user form register could not be found
	 */
	@Override
	public UserFormRegister findByUUID_G(String uuid, long groupId)
		throws NoSuchFormRegisterException {

		UserFormRegister userFormRegister = fetchByUUID_G(uuid, groupId);

		if (userFormRegister == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFormRegisterException(sb.toString());
		}

		return userFormRegister;
	}

	/**
	 * Returns the user form register where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user form register, or <code>null</code> if a matching user form register could not be found
	 */
	@Override
	public UserFormRegister fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the user form register where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user form register, or <code>null</code> if a matching user form register could not be found
	 */
	@Override
	public UserFormRegister fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof UserFormRegister) {
			UserFormRegister userFormRegister = (UserFormRegister)result;

			if (!Objects.equals(uuid, userFormRegister.getUuid()) ||
				(groupId != userFormRegister.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_USERFORMREGISTER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<UserFormRegister> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					UserFormRegister userFormRegister = list.get(0);

					result = userFormRegister;

					cacheResult(userFormRegister);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (UserFormRegister)result;
		}
	}

	/**
	 * Removes the user form register where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user form register that was removed
	 */
	@Override
	public UserFormRegister removeByUUID_G(String uuid, long groupId)
		throws NoSuchFormRegisterException {

		UserFormRegister userFormRegister = findByUUID_G(uuid, groupId);

		return remove(userFormRegister);
	}

	/**
	 * Returns the number of user form registers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user form registers
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_USERFORMREGISTER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"userFormRegister.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(userFormRegister.uuid IS NULL OR userFormRegister.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"userFormRegister.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByEmailFormRegistered;
	private FinderPath _finderPathWithoutPaginationFindByEmailFormRegistered;
	private FinderPath _finderPathCountByEmailFormRegistered;

	/**
	 * Returns all the user form registers where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching user form registers
	 */
	@Override
	public List<UserFormRegister> findByEmailFormRegistered(String email) {
		return findByEmailFormRegistered(
			email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserFormRegister> findByEmailFormRegistered(
		String email, int start, int end) {

		return findByEmailFormRegistered(email, start, end, null);
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
	@Override
	public List<UserFormRegister> findByEmailFormRegistered(
		String email, int start, int end,
		OrderByComparator<UserFormRegister> orderByComparator) {

		return findByEmailFormRegistered(
			email, start, end, orderByComparator, true);
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
	@Override
	public List<UserFormRegister> findByEmailFormRegistered(
		String email, int start, int end,
		OrderByComparator<UserFormRegister> orderByComparator,
		boolean useFinderCache) {

		email = Objects.toString(email, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByEmailFormRegistered;
				finderArgs = new Object[] {email};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmailFormRegistered;
			finderArgs = new Object[] {email, start, end, orderByComparator};
		}

		List<UserFormRegister> list = null;

		if (useFinderCache) {
			list = (List<UserFormRegister>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (UserFormRegister userFormRegister : list) {
					if (!email.equals(userFormRegister.getEmail())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_USERFORMREGISTER_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAILFORMREGISTERED_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAILFORMREGISTERED_EMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserFormRegisterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmail) {
					queryPos.add(email);
				}

				list = (List<UserFormRegister>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user form register in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user form register
	 * @throws NoSuchFormRegisterException if a matching user form register could not be found
	 */
	@Override
	public UserFormRegister findByEmailFormRegistered_First(
			String email, OrderByComparator<UserFormRegister> orderByComparator)
		throws NoSuchFormRegisterException {

		UserFormRegister userFormRegister = fetchByEmailFormRegistered_First(
			email, orderByComparator);

		if (userFormRegister != null) {
			return userFormRegister;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("email=");
		sb.append(email);

		sb.append("}");

		throw new NoSuchFormRegisterException(sb.toString());
	}

	/**
	 * Returns the first user form register in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user form register, or <code>null</code> if a matching user form register could not be found
	 */
	@Override
	public UserFormRegister fetchByEmailFormRegistered_First(
		String email, OrderByComparator<UserFormRegister> orderByComparator) {

		List<UserFormRegister> list = findByEmailFormRegistered(
			email, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user form register in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user form register
	 * @throws NoSuchFormRegisterException if a matching user form register could not be found
	 */
	@Override
	public UserFormRegister findByEmailFormRegistered_Last(
			String email, OrderByComparator<UserFormRegister> orderByComparator)
		throws NoSuchFormRegisterException {

		UserFormRegister userFormRegister = fetchByEmailFormRegistered_Last(
			email, orderByComparator);

		if (userFormRegister != null) {
			return userFormRegister;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("email=");
		sb.append(email);

		sb.append("}");

		throw new NoSuchFormRegisterException(sb.toString());
	}

	/**
	 * Returns the last user form register in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user form register, or <code>null</code> if a matching user form register could not be found
	 */
	@Override
	public UserFormRegister fetchByEmailFormRegistered_Last(
		String email, OrderByComparator<UserFormRegister> orderByComparator) {

		int count = countByEmailFormRegistered(email);

		if (count == 0) {
			return null;
		}

		List<UserFormRegister> list = findByEmailFormRegistered(
			email, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserFormRegister[] findByEmailFormRegistered_PrevAndNext(
			UserFormRegisterPK userFormRegisterPK, String email,
			OrderByComparator<UserFormRegister> orderByComparator)
		throws NoSuchFormRegisterException {

		email = Objects.toString(email, "");

		UserFormRegister userFormRegister = findByPrimaryKey(
			userFormRegisterPK);

		Session session = null;

		try {
			session = openSession();

			UserFormRegister[] array = new UserFormRegisterImpl[3];

			array[0] = getByEmailFormRegistered_PrevAndNext(
				session, userFormRegister, email, orderByComparator, true);

			array[1] = userFormRegister;

			array[2] = getByEmailFormRegistered_PrevAndNext(
				session, userFormRegister, email, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserFormRegister getByEmailFormRegistered_PrevAndNext(
		Session session, UserFormRegister userFormRegister, String email,
		OrderByComparator<UserFormRegister> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_USERFORMREGISTER_WHERE);

		boolean bindEmail = false;

		if (email.isEmpty()) {
			sb.append(_FINDER_COLUMN_EMAILFORMREGISTERED_EMAIL_3);
		}
		else {
			bindEmail = true;

			sb.append(_FINDER_COLUMN_EMAILFORMREGISTERED_EMAIL_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(UserFormRegisterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEmail) {
			queryPos.add(email);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						userFormRegister)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserFormRegister> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user form registers where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	@Override
	public void removeByEmailFormRegistered(String email) {
		for (UserFormRegister userFormRegister :
				findByEmailFormRegistered(
					email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userFormRegister);
		}
	}

	/**
	 * Returns the number of user form registers where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching user form registers
	 */
	@Override
	public int countByEmailFormRegistered(String email) {
		email = Objects.toString(email, "");

		FinderPath finderPath = _finderPathCountByEmailFormRegistered;

		Object[] finderArgs = new Object[] {email};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERFORMREGISTER_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMAILFORMREGISTERED_EMAIL_3);
			}
			else {
				bindEmail = true;

				sb.append(_FINDER_COLUMN_EMAILFORMREGISTERED_EMAIL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmail) {
					queryPos.add(email);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMAILFORMREGISTERED_EMAIL_2 =
		"userFormRegister.id.email = ?";

	private static final String _FINDER_COLUMN_EMAILFORMREGISTERED_EMAIL_3 =
		"(userFormRegister.id.email IS NULL OR userFormRegister.id.email = '')";

	public UserFormRegisterPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(UserFormRegister.class);

		setModelImplClass(UserFormRegisterImpl.class);
		setModelPKClass(UserFormRegisterPK.class);

		setTable(UserFormRegisterTable.INSTANCE);
	}

	/**
	 * Caches the user form register in the entity cache if it is enabled.
	 *
	 * @param userFormRegister the user form register
	 */
	@Override
	public void cacheResult(UserFormRegister userFormRegister) {
		entityCache.putResult(
			UserFormRegisterImpl.class, userFormRegister.getPrimaryKey(),
			userFormRegister);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				userFormRegister.getUuid(), userFormRegister.getGroupId()
			},
			userFormRegister);
	}

	/**
	 * Caches the user form registers in the entity cache if it is enabled.
	 *
	 * @param userFormRegisters the user form registers
	 */
	@Override
	public void cacheResult(List<UserFormRegister> userFormRegisters) {
		for (UserFormRegister userFormRegister : userFormRegisters) {
			if (entityCache.getResult(
					UserFormRegisterImpl.class,
					userFormRegister.getPrimaryKey()) == null) {

				cacheResult(userFormRegister);
			}
		}
	}

	/**
	 * Clears the cache for all user form registers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserFormRegisterImpl.class);

		finderCache.clearCache(UserFormRegisterImpl.class);
	}

	/**
	 * Clears the cache for the user form register.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserFormRegister userFormRegister) {
		entityCache.removeResult(UserFormRegisterImpl.class, userFormRegister);
	}

	@Override
	public void clearCache(List<UserFormRegister> userFormRegisters) {
		for (UserFormRegister userFormRegister : userFormRegisters) {
			entityCache.removeResult(
				UserFormRegisterImpl.class, userFormRegister);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(UserFormRegisterImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(UserFormRegisterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		UserFormRegisterModelImpl userFormRegisterModelImpl) {

		Object[] args = new Object[] {
			userFormRegisterModelImpl.getUuid(),
			userFormRegisterModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, userFormRegisterModelImpl);
	}

	/**
	 * Creates a new user form register with the primary key. Does not add the user form register to the database.
	 *
	 * @param userFormRegisterPK the primary key for the new user form register
	 * @return the new user form register
	 */
	@Override
	public UserFormRegister create(UserFormRegisterPK userFormRegisterPK) {
		UserFormRegister userFormRegister = new UserFormRegisterImpl();

		userFormRegister.setNew(true);
		userFormRegister.setPrimaryKey(userFormRegisterPK);

		String uuid = PortalUUIDUtil.generate();

		userFormRegister.setUuid(uuid);

		return userFormRegister;
	}

	/**
	 * Removes the user form register with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userFormRegisterPK the primary key of the user form register
	 * @return the user form register that was removed
	 * @throws NoSuchFormRegisterException if a user form register with the primary key could not be found
	 */
	@Override
	public UserFormRegister remove(UserFormRegisterPK userFormRegisterPK)
		throws NoSuchFormRegisterException {

		return remove((Serializable)userFormRegisterPK);
	}

	/**
	 * Removes the user form register with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user form register
	 * @return the user form register that was removed
	 * @throws NoSuchFormRegisterException if a user form register with the primary key could not be found
	 */
	@Override
	public UserFormRegister remove(Serializable primaryKey)
		throws NoSuchFormRegisterException {

		Session session = null;

		try {
			session = openSession();

			UserFormRegister userFormRegister = (UserFormRegister)session.get(
				UserFormRegisterImpl.class, primaryKey);

			if (userFormRegister == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFormRegisterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userFormRegister);
		}
		catch (NoSuchFormRegisterException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected UserFormRegister removeImpl(UserFormRegister userFormRegister) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userFormRegister)) {
				userFormRegister = (UserFormRegister)session.get(
					UserFormRegisterImpl.class,
					userFormRegister.getPrimaryKeyObj());
			}

			if (userFormRegister != null) {
				session.delete(userFormRegister);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userFormRegister != null) {
			clearCache(userFormRegister);
		}

		return userFormRegister;
	}

	@Override
	public UserFormRegister updateImpl(UserFormRegister userFormRegister) {
		boolean isNew = userFormRegister.isNew();

		if (!(userFormRegister instanceof UserFormRegisterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userFormRegister.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					userFormRegister);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userFormRegister proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserFormRegister implementation " +
					userFormRegister.getClass());
		}

		UserFormRegisterModelImpl userFormRegisterModelImpl =
			(UserFormRegisterModelImpl)userFormRegister;

		if (Validator.isNull(userFormRegister.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			userFormRegister.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (userFormRegister.getCreateDate() == null)) {
			if (serviceContext == null) {
				userFormRegister.setCreateDate(date);
			}
			else {
				userFormRegister.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(userFormRegister);
			}
			else {
				userFormRegister = (UserFormRegister)session.merge(
					userFormRegister);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			UserFormRegisterImpl.class, userFormRegisterModelImpl, false, true);

		cacheUniqueFindersCache(userFormRegisterModelImpl);

		if (isNew) {
			userFormRegister.setNew(false);
		}

		userFormRegister.resetOriginalValues();

		return userFormRegister;
	}

	/**
	 * Returns the user form register with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user form register
	 * @return the user form register
	 * @throws NoSuchFormRegisterException if a user form register with the primary key could not be found
	 */
	@Override
	public UserFormRegister findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFormRegisterException {

		UserFormRegister userFormRegister = fetchByPrimaryKey(primaryKey);

		if (userFormRegister == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFormRegisterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userFormRegister;
	}

	/**
	 * Returns the user form register with the primary key or throws a <code>NoSuchFormRegisterException</code> if it could not be found.
	 *
	 * @param userFormRegisterPK the primary key of the user form register
	 * @return the user form register
	 * @throws NoSuchFormRegisterException if a user form register with the primary key could not be found
	 */
	@Override
	public UserFormRegister findByPrimaryKey(
			UserFormRegisterPK userFormRegisterPK)
		throws NoSuchFormRegisterException {

		return findByPrimaryKey((Serializable)userFormRegisterPK);
	}

	/**
	 * Returns the user form register with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userFormRegisterPK the primary key of the user form register
	 * @return the user form register, or <code>null</code> if a user form register with the primary key could not be found
	 */
	@Override
	public UserFormRegister fetchByPrimaryKey(
		UserFormRegisterPK userFormRegisterPK) {

		return fetchByPrimaryKey((Serializable)userFormRegisterPK);
	}

	/**
	 * Returns all the user form registers.
	 *
	 * @return the user form registers
	 */
	@Override
	public List<UserFormRegister> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserFormRegister> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<UserFormRegister> findAll(
		int start, int end,
		OrderByComparator<UserFormRegister> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<UserFormRegister> findAll(
		int start, int end,
		OrderByComparator<UserFormRegister> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<UserFormRegister> list = null;

		if (useFinderCache) {
			list = (List<UserFormRegister>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_USERFORMREGISTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_USERFORMREGISTER;

				sql = sql.concat(UserFormRegisterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UserFormRegister>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the user form registers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserFormRegister userFormRegister : findAll()) {
			remove(userFormRegister);
		}
	}

	/**
	 * Returns the number of user form registers.
	 *
	 * @return the number of user form registers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_USERFORMREGISTER);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "userFormRegisterPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERFORMREGISTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserFormRegisterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user form register persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new UserFormRegisterModelArgumentsResolver(),
			new HashMapDictionary<>());

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByEmailFormRegistered = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmailFormRegistered",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"email"}, true);

		_finderPathWithoutPaginationFindByEmailFormRegistered = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEmailFormRegistered", new String[] {String.class.getName()},
			new String[] {"email"}, true);

		_finderPathCountByEmailFormRegistered = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmailFormRegistered", new String[] {String.class.getName()},
			new String[] {"email"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(UserFormRegisterImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();
	}

	@Override
	@Reference(
		target = UserPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = UserPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = UserPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_USERFORMREGISTER =
		"SELECT userFormRegister FROM UserFormRegister userFormRegister";

	private static final String _SQL_SELECT_USERFORMREGISTER_WHERE =
		"SELECT userFormRegister FROM UserFormRegister userFormRegister WHERE ";

	private static final String _SQL_COUNT_USERFORMREGISTER =
		"SELECT COUNT(userFormRegister) FROM UserFormRegister userFormRegister";

	private static final String _SQL_COUNT_USERFORMREGISTER_WHERE =
		"SELECT COUNT(userFormRegister) FROM UserFormRegister userFormRegister WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userFormRegister.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserFormRegister exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserFormRegister exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserFormRegisterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"userFormRegisterId", "email"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class UserFormRegisterModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			UserFormRegisterModelImpl userFormRegisterModelImpl =
				(UserFormRegisterModelImpl)baseModel;

			long columnBitmask = userFormRegisterModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					userFormRegisterModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						userFormRegisterModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					userFormRegisterModelImpl, columnNames, original);
			}

			return null;
		}

		@Override
		public String getClassName() {
			return UserFormRegisterImpl.class.getName();
		}

		@Override
		public String getTableName() {
			return UserFormRegisterTable.INSTANCE.getTableName();
		}

		private static Object[] _getValue(
			UserFormRegisterModelImpl userFormRegisterModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						userFormRegisterModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = userFormRegisterModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			orderByColumnsBitmask |= UserFormRegisterModelImpl.getColumnBitmask(
				"createDate");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}