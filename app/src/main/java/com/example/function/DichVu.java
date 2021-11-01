package com.example.function;

public class DichVu {
    private String tenDichVu;
    private String thoiGian;
    private double giaDichVu;

    public DichVu(String tenDichVu, String thoiGian, double giaDichVu) {
        this.tenDichVu = tenDichVu;
        this.thoiGian = thoiGian;
        this.giaDichVu = giaDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public double getGiaDichVu() {
        return giaDichVu;
    }

    public void setGiaDichVu(double giaDichVu) {
        this.giaDichVu = giaDichVu;
    }
}
