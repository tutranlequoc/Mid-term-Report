package com.example.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appbenhvienlocal.R;
import com.example.function.HoSoDK;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public static final String COL_CITY = "CITY";
    public static final String COL_DISTRICT = "DISTRICT";
    public static final String COL_WARD = "WARD";
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
                COL_CITY + " VARCHAR(50), "+ COL_DISTRICT + " VARCHAR(50), " + COL_WARD + " VARCHAR(50), " + COL_ADDRESS + " VARCHAR(200), " + COL_USER_PHONE + " VARCHAR(100), " +
                "CONSTRAINT fk_userphone FOREIGN KEY " + "(" + COL_USER_PHONE + ")" + " REFERENCES " +
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
        try{
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME_PHIEUKHAM);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME_HOSODATKHAM);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TBL_NAME_USER);
        }catch (Exception e){
            Log.e("Error:", e.toString());
        }
        onCreate(sqLiteDatabase);
    }

    public void queryExec(String sql){
        SQLiteDatabase db = getWritableDatabase();
        try{
            db.execSQL(sql);
        }catch (Exception e){
            Log.e("Error:", e.toString());
        }

    }

    public Cursor getData(String sql){
        SQLiteDatabase db = getReadableDatabase();
        try{
            return db.rawQuery(sql, null);
        }catch (Exception e){
            Log.e("Error:", e.toString());
            return null;
        }
    }

    public int checkUserPhone(String phone){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor =  db.rawQuery("SELECT * FROM " + TBL_NAME_USER + " WHERE " + COL_USER_PHONE + " =?", new String[]{phone});
        return cursor.getCount();
    }

    public String getUserName(String phone){
        SQLiteDatabase db  = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TBL_NAME_USER + " WHERE " + COL_USER_PHONE + " =?", new String[]{phone});
        cursor.moveToFirst();
        return cursor.getString(1);
    }

    public int checkUserPhoneAndPass(String phone, String password){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TBL_NAME_USER + " WHERE " + COL_USER_PHONE + " =?" + " AND " + COL_PASSWORD + " =?", new String[]{phone,password});
        return cursor.getCount();
    }

    public int getCount(String tableName){
        int count;
        Cursor cursor = getData("SELECT * FROM " + tableName);
        count = cursor.getCount();
        cursor.close();
        return count;
    }

    public ArrayList<HoSoDK> getInForFromDocument(String phoneNumber){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TBL_NAME_HOSODATKHAM + " WHERE " + COL_USER_PHONE + " =?", new String[]{phoneNumber});
        ArrayList<HoSoDK> documents = new ArrayList<>();
        while (cursor.moveToNext()){
            documents.add(new HoSoDK(cursor.getString(1), cursor.getString(2), cursor.getString(0), cursor.getString(14), cursor.getString(8)));
        }
        return documents;
    }

    public int checkExistDocument(String phoneNumber){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TBL_NAME_HOSODATKHAM + " WHERE " + COL_USER_PHONE + " =?", new String[]{phoneNumber});
        return cursor.getCount();
    }

    public void createDefaultUser(){
        if(getCount(TBL_NAME_USER) == 0){
            insertDataForUser("0963075062", "Lê Hoàng Giáp", "123456");
            insertDataForUser("0326213055", "Nguyễn Đăng Bắc", "123456");
        }
    }

    public void createDefaultDoc(){
        if(getCount(TBL_NAME_HOSODATKHAM) == 0){

        }
    }

    public boolean insertDataForDocuments(String code, String fullName, String dateOfBirth, String gender, String identity,
                                          String insurrance, String ethnic, String job, String phone_booking, String email, String country,
                                          String city, String district, String ward, String address, String user_phone){
        try{
            SQLiteDatabase db = getWritableDatabase();
            String sql = "INSERT INTO " + TBL_NAME_HOSODATKHAM + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, code);
            statement.bindString(2, fullName);
            statement.bindString(3, dateOfBirth);
            statement.bindString(4, gender);
            statement.bindString(5, identity);
            statement.bindString(6, insurrance);
            statement.bindString(7, ethnic);
            statement.bindString(8, job);
            statement.bindString(9, phone_booking);
            statement.bindString(10, email);
            statement.bindString(11, country);
            statement.bindString(12, city);
            statement.bindString(13, district);
            statement.bindString(14, ward);
            statement.bindString(15, address);
            statement.bindString(16, user_phone);
            statement.executeInsert();
            return true;
        }catch (Exception e){
            Log.e("Error:", e.toString());
            return false;
        }
    }


    public boolean insertDataForUser(String phone, String userName, String password){
        try{
            SQLiteDatabase db = getWritableDatabase();
            String sql = "INSERT INTO " + TBL_NAME_USER + " VALUES(?,?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, phone);
            statement.bindString(2, userName);
            statement.bindString(3, password);
            statement.executeInsert();
            return true;
        }catch (Exception e){
            Log.e("Error:", e.toString());
            return false;
        }
    }


}
