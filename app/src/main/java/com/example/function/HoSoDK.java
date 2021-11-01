package com.example.function;

public class HoSoDK {
    private String ten;
    private String thoiGian;
    private String maSo;
    private String diaChi;
    private String sDT;

    public HoSoDK(String ten, String thoiGian, String maSo, String diaChi, String sDT) {
        this.ten = ten;
        this.thoiGian = thoiGian;
        this.maSo = maSo;
        this.diaChi = diaChi;
        this.sDT = sDT;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }
}
