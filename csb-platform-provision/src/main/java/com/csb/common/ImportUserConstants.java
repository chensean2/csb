package com.csb.common;


public class ImportUserConstants {
	public static final String HEAD_USERNAME = "Primary email";
	public static final String HEAD_EMAIL = "Email";
	public static final String HEAD_DISPLAYNAME = "Display name";
	public static final String HEAD_FIRSTNAME = "First name (do not remove this row)";
	public static final String HEAD_LASTNAME = "Last name";
	public static final String HEAD_ALTERNATE_EMAIL = "Alternate email";
	public static final String HEAD_JOBTITLE = "Job title";
	public static final String HEAD_DEPARTMENT = "Department";
	public static final String HEAD_PHONE_MOBILE = "Mobile (optional)";
	public static final String HEAD_PHONE_LANDLINE = "Landline (optional)";
	public static final String HEAD_OFFICEAPP_ROLE = "Role (optional)";
	
	public static final String PROPERTY_FILENAME = "bulkuser";
	
	public static final String ROLE_ADMIN = getPorpertyAsString("bulkimport.user.role.admin","Admin");
	public static final String ROLE_NORMALUSER = getPorpertyAsString("bulkimport.user.role.normaluser","Normal User");
	
	public static final String ERR_MSG_MAXLENGTH = getPorpertyAsString("msg.error.maxlength","");
	public static final String ERR_MSG_EXIST = getPorpertyAsString("msg.error.exist","");
	public static final String ERR_MSG_EMPTY = getPorpertyAsString("msg.error.empty","");
	public static final String ERR_MSG_EMAIL = getPorpertyAsString("msg.error.format.email","");
	public static final String ERR_MSG_NUMBER = getPorpertyAsString("msg.error.format.number","");
	public static final String ERR_MSG_ROLE = getPorpertyAsString("msg.error.role","");
	
	public static final int MAX_LENGTH_USERNAME = getPorpertyAsInt("maxlength.userName", 80);
	public static final int MAX_LENGTH_EMAIL = getPorpertyAsInt("maxlength.email", 80);
	public static final int MAX_LENGTH_DISPLAYNAME = getPorpertyAsInt("maxlength.displayName", 100);
	public static final int MAX_LENGTH_FIRSTNAME = getPorpertyAsInt("maxlength.firstName", 50);
	public static final int MAX_LENGTH_LASTTNAME = getPorpertyAsInt("maxlength.lastName", 50);
	public static final int MAX_LENGTH_ALTERNATEEMAIL = getPorpertyAsInt("maxlength.alternateEmail", 50);
	public static final int MAX_LENGTH_JOBTITLE = getPorpertyAsInt("maxlength.jobTitle", 50);
	public static final int MAX_LENGTH_DEPARTMENT = getPorpertyAsInt("maxlength.department", 50);
	public static final int MAX_LENGTH_PHONEMOBILE = getPorpertyAsInt("maxlength.phoneM", 15);
	public static final int MAX_LENGTH_PHONELANDLINE = getPorpertyAsInt("maxlength.phoneL", 15);
	
	public static final String REGEXP_EMAIL = getPorpertyAsString("validate.regexp.email","");
	
	public static final String REGEXP_NUMBER = getPorpertyAsString("validate.regexp.number","");
	
	
	
	public static final long COMPANYID = (long)getPorpertyAsInt("liferay.companyId", 1);
	
	public static final String CACHE_PREFIX_ORGANIZATION = COMPANYID + "_CACHE_SAAS_EDUPLUS_ORGANIZATION_";
	public static final String CACHE_PREFIX_ROLE = COMPANYID + "_CACHE_SAAS_EDUPLUS_ROLE_";
	
	

	public static final String LIFERAY_WS_POINT = getPorpertyAsString("liferay.ws.point","http://@localhost:8080/tunnel-web/secure/axis/");
	public static final String LIFERAY_ADMIN_NAME = getPorpertyAsString("liferay.ws.adminname","test@liferay.com");
	public static final String LIFERAY_ADMIN_PASSWORD = getPorpertyAsString("liferay.ws.adminpassword","test");
	
	public static final String EXPORT_CSV_PATH = getPorpertyAsString("export.csv.path","/saas/csv");
	
	public static int getPorpertyAsInt(String key, int intDefault){
//		return ConfigProperties.getInstance().getPropertyAsInt(PROPERTY_FILENAME, key, intDefault);
		return 0;
	}
	
	public static String getPorpertyAsString(String key, String stringDefault){
//		return ConfigProperties.getInstance().getPropertyAsString(PROPERTY_FILENAME, key, stringDefault);
		return "";
	}

}
