package com.example.demo.pojos;

public class UserResponse {

    private  long id;
    private String name;
    private int numberOfBookings;
    private String status;

    public UserResponse() {
    }

    public UserResponse(long id, String name, int numberOfBookings, String status) {
        this.id = id;
        this.name = name;
        this.numberOfBookings = numberOfBookings;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBookings() {
        return numberOfBookings;
    }

    public void setNumberOfBookings(int numberOfBookings) {
        this.numberOfBookings = numberOfBookings;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
