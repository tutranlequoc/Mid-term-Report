package com.example.adapter;

public class Bank {
    public String bankName;
    public int bankThumb;

    public Bank(String bankName, int bankThumb) {
        this.bankName = bankName;
        this.bankThumb = bankThumb;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getBankThumb() {
        return bankThumb;
    }

    public void setBankThumb(int bankThumb) {
        this.bankThumb = bankThumb;
    }
}
