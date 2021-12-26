package com.example.ultis;

import com.example.adapter.Bank;
import com.example.database.BenhVienSQLiteHelper;
import com.example.function.HoSoDK;
import com.example.models.BookingInfor;
import com.example.models.Danhsachphieukham;
import com.example.models.Document;
import com.example.models.User;

import java.security.PublicKey;
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
    public static final String DATABASE_NAME_ADMINISTRATIVE_UNITS = "dvhcvn.db";
    public static final String DB_PATH_SUFFIX = "/databases/";
    public static final String TBL_NAME_PROVINCE = "province";
    public static final String PROVINCE_ID = "id";
    public static final String PROVINCE_NAME = "name";
    public static final String TBL_NAME_DISTRICT = "district";
    public static final String DISTRICT_ID = "id";
    public static final String DISTRICT_NAME = "name";
    public static final String DISTRICT_PROVINCE_ID = "province_id";
    public static final String TBL_NAME_WARD = "ward";
    public static final String WARD_NAME = "name";
    public static final String WARE_DISTRICT_ID = "district_id";
    public static BookingInfor bookingInfor;
    public static Bank bank;
    public static Danhsachphieukham danhsachphieukham;
    public static String code_medical_test;
    public static final String VERIFYID = "verifyId";
}
