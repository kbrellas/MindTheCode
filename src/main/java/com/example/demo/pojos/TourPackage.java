package com.example.demo.pojos;

import javax.persistence.*;


@Entity(name = "TourPack") //etsi dhlwnete table se vash, columns oi metavlhtes
public class TourPackage { //to onoma tou table ths vashs 8a einai idio me ths klashs

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//me auto to susthma vazei timh mono tou
    private long id;
    @Column (name="description") //etsi dhlwneis diaforetiko onoma ths sthlhs ths vashs apo auto pou exeis sthn metavlhth
    private String desc;
    private int price;
    private String dest;

    public TourPackage(long id, String desc, int price, String dest) {
        this.id = id;
        this.desc = desc;
        this.price = price;
        this.dest = dest;
    }

    public TourPackage(String desc, int price, String dest) {
        this.desc = desc;
        this.price = price;
        this.dest = dest;
    }

    public TourPackage() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }
}
