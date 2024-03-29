package com.example.demo.pojos;

public class TourPackageResponse {

    private long id;
    private String title;
    private int price;

    public TourPackageResponse(long id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public TourPackageResponse() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
