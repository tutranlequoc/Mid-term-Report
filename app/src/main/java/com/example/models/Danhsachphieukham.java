package com.example.models;

import android.graphics.drawable.Drawable;

public class Danhsachphieukham {

    private String maPhieu,Ten,ngayKham,GioKhamDuKien,tenTrangThai;
    private int trangThai;




    public Danhsachphieukham(String maPhieu, String ten, String ngayKham, String gioKhamDuKien, int trangThai, String tenTrangThai) {
        this.maPhieu = maPhieu;
        Ten = ten;
        this.ngayKham = ngayKham;
        GioKhamDuKien = gioKhamDuKien;
        this.trangThai = trangThai;
        this.tenTrangThai = tenTrangThai;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(String ngayKham) {
        this.ngayKham = ngayKham;
    }

    public String getGioKhamDuKien() {
        return GioKhamDuKien;
    }

    public void setGioKhamDuKien(String gioKhamDuKien) {
        GioKhamDuKien = gioKhamDuKien;
    }

    public int getTrangThai() {
        return trangThai;
    }



    public String getTenTrangThai() {
        return tenTrangThai;
    }

    public void setTenTrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }
}
