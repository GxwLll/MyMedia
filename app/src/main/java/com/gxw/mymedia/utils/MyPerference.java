package com.gxw.mymedia.utils;

import android.content.Context;
import android.content.SharedPreferences;


import com.gxw.mymedia.app.Constants;

import org.json.JSONArray;

import java.util.Arrays;


public class MyPerference {

private static final String FILE_NAME = "app_mydedia_preferences";
	
private static String user_id = "";
	private static String userToken = "";
	private static String userName = "";
	private static String phone_num = "";
	private static String iconUrl = "";
	private static String passWord = "";


	public static String getUser_id() {
		return user_id;
	}
	public static void setUser_id(String user_id) {
		MyPerference.user_id = user_id;
	}
	public static String getPhone_num() {
		return phone_num;
	}
	public static void setPhone_num(String phone_num) {
		MyPerference.phone_num = phone_num;
	}

	public static String getUserToken() {
		return userToken;
	}
	public static void setUserToken(String userToken) {
		MyPerference.userToken = userToken;
	}
	public static String getUserName() {
		return userName;
	}
	public static void setUserName(String userName) {
		MyPerference.userName = userName;
	}
	public static String getIconUrl() {
		return iconUrl;
	}
	public static void setIconUrl(String iconUrl) {
		MyPerference.iconUrl = iconUrl;
	}
	public static String getPassWord() {
		return passWord;
	}
	public static void setPassWord(String passWord) {
		MyPerference.passWord = passWord;
	}

	public static void setUserInfo(MyPerference mp) {
			setUser_id(mp.getString(Constants.USER_ID, null));
			setUserToken(mp.getString(Constants.USER_TOKEN, null));
			setIconUrl(mp.getString(Constants.USER_ICON, null));
			setUserName(mp.getString(Constants.USER_NAME, null));
			setPhone_num(mp.getString(Constants.PHONE_NUM, null));
			setPassWord(mp.getString(Constants.USER_PASS, null));

	}
	
	
	protected SharedPreferences settings;
	protected SharedPreferences.Editor editor;
	public MyPerference(Context context) {
		context = context.getApplicationContext();
		settings = context
				.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
		editor = settings.edit();
	}
//	保存数组
	public void saveArray(String key, int [] value){
		editor.putString(key, value.toString());
		editor.commit();
	}
	
//	获取数组
	public int[] getArray(String key, int arrayLength)
	  {
	    int[] resArray=new int[arrayLength];
	    Arrays.fill(resArray,-1);
	    try {
	        JSONArray jsonArray = new JSONArray(settings.getString(key, "[]"));
	        for (int i = 0; i < jsonArray.length(); i++) {
	        	resArray[i] = jsonArray.getInt(i);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    	return resArray;
	  }
	
	
	public void saveBoolean(String key, boolean value) {
		editor.putBoolean(key, value);
		editor.commit();
	}

	public void saveFloat(String key, float value) {
		editor.putFloat(key, value);
		editor.commit();
	}

	public void saveInt(String key, int value) {
		editor.putInt(key, value);
		editor.commit();
	}

	public void saveLong(String key, long value) {
		editor.putLong(key, value);
		editor.commit();
	}

	public void saveString(String key, String value) {
		editor.putString(key, value);
		editor.commit();
	}

	public void clear(String key) {
		editor.remove(key);
		editor.commit();
	}

	public void clear() {
		editor.clear();
		editor.commit();
	}

	public boolean getBoolean(String key, boolean defValue) {
		return settings.getBoolean(key, defValue);
	}

	public float getFloat(String key, float defValue) {
		return settings.getFloat(key, defValue);
	}

	public  int getInt(String key, int defValue) {
		return settings.getInt(key, defValue);
	}

	public  long getLong(String key, long defValue) {
		return settings.getLong(key, defValue);
	}

	public String getString(String key, String defValue) {
		return settings.getString(key, defValue);
	}


}
