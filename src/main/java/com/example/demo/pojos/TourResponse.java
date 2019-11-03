package com.example.demo.pojos;

//h klash auth einai gia na kaneis model to response pou 8a dwseis
public class TourResponse {

    private long id;

    private int price;
    private int discount;
    private int finalPrice;

    private  String title;
    private String shortDesc;
    private String longDesc;

    private String tourPackageTitle;

    public TourResponse() {
    }

    public TourResponse(long id, int price, int discount, int finalPrice, String title, String shortDesc, String longDesc, String tourPackageTitle) {
        this.id = id;
        this.price = price;
        this.discount = discount;
        this.finalPrice = finalPrice;
        this.title = title;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.tourPackageTitle = tourPackageTitle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getTourPackageTitle() {
        return tourPackageTitle;
    }

    public void setTourPackageTitle(String tourPackageTitle) {
        this.tourPackageTitle = tourPackageTitle;
    }
}
