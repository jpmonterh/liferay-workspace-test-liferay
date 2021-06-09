create table User_UserFormRegister (
	uuid_ VARCHAR(75) null,
	userFormRegisterId LONG not null,
	groupId LONG,
	createDate DATE null,
	name VARCHAR(75) null,
	surname VARCHAR(75) null,
	email VARCHAR(75) not null,
	birthday DATE null,
	primary key (userFormRegisterId, email)
);