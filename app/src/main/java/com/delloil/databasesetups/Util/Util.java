package com.delloil.databasesetups.Util;

public class Util {

	//Database related items
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "contact_db";
	public static final String TABLE_NAME = "contacts";

	//Contacts table columns names
	public static final String KEY_ID = "id";
	public static final String KEY_NAME = "name";
	public static final String KEY_PHONE_NUMBER = "phone_number";


	// Upgrade and drop
	public static final String db_drop="DROP TABLE IF EXISTS";


	//Tags
	public static final String TAG ="DbTest";
}
