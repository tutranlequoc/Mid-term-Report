package com.example.models;

public class ThongBao {
    private String maPhieuHuy,ngayKhamHuy,ngayThongBaoHuy;

    public ThongBao(String maPhieuHuy, String ngayKhamHuy, String ngayThongBaoHuy) {
        this.maPhieuHuy = maPhieuHuy;
        this.ngayKhamHuy = ngayKhamHuy;
        this.ngayThongBaoHuy = ngayThongBaoHuy;
    }

    public String getMaPhieuHuy() {
        return maPhieuHuy;
    }

    public void setMaPhieuHuy(String maPhieuHuy) {
        this.maPhieuHuy = maPhieuHuy;
    }

    public String getNgayKhamHuy() {
        return ngayKhamHuy;
    }

    public void setNgayKhamHuy(String ngayKhamHuy) {
        this.ngayKhamHuy = ngayKhamHuy;
    }

    public String getNgayThongBaoHuy() {
        return ngayThongBaoHuy;
    }

    public void setNgayThongBaoHuy(String ngayThongBaoHuy) {
        this.ngayThongBaoHuy = ngayThongBaoHuy;
    }
}
