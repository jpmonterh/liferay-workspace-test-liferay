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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;User_UserFormRegister&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see UserFormRegister
 * @generated
 */
public class UserFormRegisterTable extends BaseTable<UserFormRegisterTable> {

	public static final UserFormRegisterTable INSTANCE =
		new UserFormRegisterTable();

	public final Column<UserFormRegisterTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserFormRegisterTable, Long> userFormRegisterId =
		createColumn(
			"userFormRegisterId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<UserFormRegisterTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserFormRegisterTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<UserFormRegisterTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserFormRegisterTable, String> surname = createColumn(
		"surname", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserFormRegisterTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<UserFormRegisterTable, Date> birthday = createColumn(
		"birthday", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private UserFormRegisterTable() {
		super("User_UserFormRegister", UserFormRegisterTable::new);
	}

}