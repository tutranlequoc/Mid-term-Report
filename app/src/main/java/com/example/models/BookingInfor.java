package com.example.models;

public class BookingInfor {
    private String chuyenKhoa;
    private String dichVu;
    private String ngayKham;
    private String gioKham;
    private String tienKham;

    public BookingInfor(){

    }

    public BookingInfor(String chuyenKhoa, String dichVu, String ngayKham, String gioKham, String tienKham) {
        this.chuyenKhoa = chuyenKhoa;
        this.dichVu = dichVu;
        this.ngayKham = ngayKham;
        this.gioKham = gioKham;
        this.tienKham = tienKham;
    }

    public String getChuyenKhoa() {
        return chuyenKhoa;
    }

    public void setChuyenKhoa(String chuyenKhoa) {
        this.chuyenKhoa = chuyenKhoa;
    }

    public String getDichVu() {
        return dichVu;
    }

    public void setDichVu(String dichVu) {
        this.dichVu = dichVu;
    }

    public String getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(String ngayKham) {
        this.ngayKham = ngayKham;
    }

    public String getGioKham() {
        return gioKham;
    }

    public void setGioKham(String gioKham) {
        this.gioKham = gioKham;
    }

    public String getTienKham() {
        return tienKham;
    }

    public void setTienKham(String tienKham) {
        this.tienKham = tienKham;
    }
}
