package com.example.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BenhVienSQLiteHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "BENHVIEN.sqlite";

    public static final String TBL_NAME_HOSODATKHAM = "HOSODATKHAM";
    public static final String COL_CODE = "CODE";
    public static final String COL_FULLNAME = "FULLNAME";
    public static final String COL_DATEOFBIRTH = "DATEOFBIRTH";
    public static final String COL_GENDER = "GENDER";
    public static final String COL_IDENTITY = "IDENTITY";
    public static final String COL_INSURRANCE = "INSURRANCE";
    public static final String COL_ETHNIC = "ETHNIC";
    public static final String COL_JOB = "JOB";
    public static final String COL_PHONE = "PHONE_BOOKING";
    public static final String COL_EMAIL = "EMAIL";
    public static final String COL_COUNTRY = "COUNTRY";
    public static final String COL_ADDRESS = "ADDRESS";

    public static final String TBL_NAME_USER = "USER";
    public static final String COL_USER_PHONE = "PHONE";
    public static final String COL_USERNAME = "NAME";
    public static final String COL_PASSWORD = "PASSWORD";

    public static final String TBL_NAME_PHIEUKHAM = "PHIEUKHAM";
    //mã bệnh nhân khóa ngoại
    public static final String COL_CODE_MEDICAL_TEST = "CODE_TEST";
    public static final String COL_DATE = "DATE";
    public static final String COL_FORM = "FORM";
    public static final String COL_MONEY = "MONEY";
    public static final String COL_TIME = "TIME";

    public BenhVienSQLiteHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlUSER = "CREATE TABLE IF NOT EXISTS " + TBL_NAME_USER + "(" + COL_USER_PHONE + " VARCHAR(30) PRIMARY KEY, " +
                COL_USERNAME + " VARCHAR(100), " + COL_PASSWORD + " VARCHAR(100))";
        String sqlHOSODK = "CREATE TABLE IF NOT EXISTS " + TBL_NAME_HOSODATKHAM + "(" + COL_CODE + " VARCHAR(30) PRIMARY KEY, " + COL_FULLNAME + " VARCHAR(100), "
                + COL_DATEOFBIRTH + " VARCHAR(50), " + COL_GENDER + " VARCHAR(20), " + COL_IDENTITY + " VARCHAR(50), " + COL_INSURRANCE + " VARCHAR(50), " +
                COL_ETHNIC + " VARCHAR(30), " + COL_JOB + " VARCHAR(50), " + COL_PHONE + " VARCHAR(30), " + COL_EMAIL + " VARCHAR(50), " + COL_COUNTRY + " VARCHAR(100), " +
                COL_ADDRESS + " VARCHAR(200), " + COL_USER_PHONE + " VARCHAR(100), " + "CONSTRAINT fk_userphone FOREIGN KEY " + "(" + COL_USER_PHONE + ")" + " REFERENCES " +
                TBL_NAME_USER + " (" + COL_USER_PHONE + "))";
        String sqlPhieuKham = "CREATE TABLE IF NOT EXISTS " + TBL_NAME_PHIEUKHAM + "(" + COL_CODE_MEDICAL_TEST + " VARCHAR(30) PRIMARY KEY, " + COL_CODE + " VARCHAR(30), " +
                COL_DATE + " VARCHAR(50), " + COL_FORM + " VARCHAR(100), " + COL_MONEY + " REAL, " + COL_TIME + " VARCHAR(50), " + "CONSTRAINT fk_patient_code FOREIGN KEY " +
                "(" + COL_CODE + ")" + " REFERENCES " + TBL_NAME_HOSODATKHAM + " (" + COL_CODE + "))";
        try{
            sqLiteDatabase.execSQL(sqlUSER);
            sqLiteDatabase.execSQL(sqlHOSODK);
            sqLiteDatabase.execSQL(sqlPhieuKham);
        }catch (Exception e){
            Log.e("Error:", e.toString());
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
