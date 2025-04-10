package com.example.myrecyclerview;

public class ItemModel {
    private String namaMakanan;
    private String hargaMakanan;
    private int imageResId;
    private String desc;

    public ItemModel(String namaMakanan,int imageResId, String hargaMakanan, String desc){
        this.namaMakanan = namaMakanan;
        this.hargaMakanan = hargaMakanan;
        this.imageResId = imageResId;
        this.desc = desc;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public String getHargaMakanan() {
        return hargaMakanan;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getDesc() {
        return desc;
    }
}
