package com.gxw.mymedia.app;


import android.os.Environment;

public class Constants {


    //用户常量
    public final static String PHONE_NUM = "phoneNum";
    public final static String USER_NAME = "userName";
    public final static String USER_PASS = "passWord";
    public final static String USER_TOKEN = "token";
    public final static String USER_ICON = "uIconUrl";
    public final static String USER_ID = "user_id";


    //		返回参数
    public final static String RESULT_CODE = "resultCode";
    public final static String RESULT_INFO = "resultInfo";

    public final static String UPLOAD_IMAGE_NAME = "uploadImg.jpg";//需要上传的图片的名称

    public static String getUploaImgDir() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/CarBuddy/image_from_camera";
    }

}
