package com.example.demo.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    public enum Status{NEW,LOYAL,GOLD,PLATINUM};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private int numberOfBookings;
    private Status status;

    public User() {
    }

    public User(String firstName, String lastName, int numberOfBookings, Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfBookings = numberOfBookings;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getNumberOfBookings() {
        return numberOfBookings;
    }

    public void setNumberOfBookings(int numberOfBookings) {
        this.numberOfBookings = numberOfBookings;
    }
}
