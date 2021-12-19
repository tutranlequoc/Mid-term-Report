package com.example.models;

import java.time.LocalTime;

public class ThoiGianKham {
    private String buoiKham;
    private LocalTime thoiGianBĐ;
    private LocalTime thoiGianKT;

    public ThoiGianKham(String buoiKham, LocalTime thoiGianBĐ, LocalTime thoiGianKT) {
        this.buoiKham = buoiKham;
        this.thoiGianBĐ = thoiGianBĐ;
        this.thoiGianKT = thoiGianKT;
    }

    public String getBuoiKham() {
        return buoiKham;
    }

    public void setBuoiKham(String buoiKham) {
        this.buoiKham = buoiKham;
    }

    public LocalTime getThoiGianBĐ() {
        return thoiGianBĐ;
    }

    public void setThoiGianBĐ(LocalTime thoiGianBĐ) {
        this.thoiGianBĐ = thoiGianBĐ;
    }

    public LocalTime getThoiGianKT() {
        return thoiGianKT;
    }

    public void setThoiGianKT(LocalTime thoiGianKT) {
        this.thoiGianKT = thoiGianKT;
    }
}
