package com.example.demo.pojos;

import java.util.List;

public class MainPageResponse {
    private int numberOfTours;
    private int numberOfUsers;
    private List<TourResponse> tourResponses;
    private List<UserResponse> userResponses;

    public MainPageResponse(int numberOfTours, int numberOfUsers, List<TourResponse> tourResponses, List<UserResponse> userResponses) {
        this.numberOfTours = numberOfTours;
        this.numberOfUsers = numberOfUsers;
        this.tourResponses = tourResponses;
        this.userResponses = userResponses;
    }

    public int getNumberOfTours() {
        return numberOfTours;
    }

    public void setNumberOfTours(int numberOfTours) {
        this.numberOfTours = numberOfTours;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public List<TourResponse> getTourResponses() {
        return tourResponses;
    }

    public void setTourResponses(List<TourResponse> tourResponses) {
        this.tourResponses = tourResponses;
    }

    public List<UserResponse> getUserResponses() {
        return userResponses;
    }

    public void setUserResponses(List<UserResponse> userResponses) {
        this.userResponses = userResponses;
    }
}
