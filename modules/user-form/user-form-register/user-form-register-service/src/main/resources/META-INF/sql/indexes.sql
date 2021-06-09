create index IX_99E0A2A0 on User_UserFormRegister (email[$COLUMN_LENGTH:75$]);
create unique index IX_3674BCA2 on User_UserFormRegister (uuid_[$COLUMN_LENGTH:75$], groupId);