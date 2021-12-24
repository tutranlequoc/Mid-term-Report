package com.example.ultis;

import com.example.database.BenhVienSQLiteHelper;
import com.example.function.HoSoDK;
import com.example.models.Document;
import com.example.models.User;

import java.time.LocalDate;
import java.time.LocalTime;

public class Constant {
    public static final String SELECTED_DATE = "selected_date";
    public static final String FUNCTION = "function";
    public static final String THONGTIN = "thongtin";
    public static final String DICHVU = "dichvu";
    public static final String HOSODATKHAM = "hosodatkham";
    public static final String PTTT = "PTTT";
    public static final String INDEX_THONGTIN = "Index";
    public static final String CHUYENKHOA = "chuyenkhoa";
    public static final String REQUEST_TAG = "REQUEST";
    public static final int REQUEST_CODE = 9;
    public static final String BUOI_SANG = "Buổi sáng";
    public static final String BUOI_TOI = "Buổi tối";
    public static final String DICH_VU = "KHÁM DỊCH VỤ";
    public static final String VIP = "KHÁM VIP";
    public static BenhVienSQLiteHelper database;
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String HO_SO = "Hồ sơ";
    public static final String PHIEU_KHAM = "Phiếu khám";
    public static final String KIEM_TRA = "Kiểm tra";
    public static User user;
    public static int REQUEST_CODE_FOR_LOGIN = 8;
    public static int REQUEST_CODE_FOR_DOCUMENT_FROM_MAIN = 10;
    public static HoSoDK doc;
    public static Document document;
}
