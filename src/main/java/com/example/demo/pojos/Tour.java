package com.example.demo.pojos;

import javax.persistence.*;

@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//me auto to susthma vazei timh mono tou
    private long id;

    private int price;

    private int discount;

    private  String title;
    @Column(name="shortDescription")
    private String shortDesc;
    @Column(name="longDescription")
    private String longDesc;

    @ManyToOne //gia na to sunduasei polla tour se ena tour package - epishs einai ena tour mporei na anhkei mono se ena package
    private TourPackage tourPackage;

    public Tour() {
    }

    public Tour(int price, int discount, String title, String shortDesc, String longDesc) {
        this.price = price;
        this.discount = discount;
        this.title = title;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
    }

    public Tour(long id, int price, int discount, String title, String shortDesc, String longDesc, TourPackage tourPackage) {
        this.id = id;
        this.price = price;
        this.discount = discount;
        this.title = title;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.tourPackage = tourPackage;
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

    public TourPackage getTourPackage() {
        return tourPackage;
    }

    public void setTourPackage(TourPackage tourPackage) {
        this.tourPackage = tourPackage;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
