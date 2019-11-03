package com.example.demo.pojos;

import java.util.List;

public class GetAllUsersResponse {
    private List<UserResponse> userResponses;

    public GetAllUsersResponse(List<UserResponse> userResponses) {
        this.userResponses = userResponses;
    }

    public List<UserResponse> getUserResponses() {
        return userResponses;
    }

    public void setUserResponses(List<UserResponse> userResponses) {
        this.userResponses = userResponses;
    }
}
