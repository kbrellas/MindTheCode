package com.example.demo.mappers;

import com.example.demo.pojos.User;
import com.example.demo.pojos.UserResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    public List<UserResponse> mapUsers(Iterable<User> all) {
        List<UserResponse> userResponses = new ArrayList<>();
        for(User user : all){
            userResponses.add(new UserResponse(user.getId(),
                    user.getFirstName()+" "+user.getLastName(),
                    user.getNumberOfBookings(),
                    mapStatus(user.getStatus())));
        }
        return userResponses;
    }

    private String mapStatus(User.Status status) {
        return String.valueOf(status).toLowerCase();
    }


    public List<UserResponse> mapUsersStatus(Iterable<User> all, String status) {
        List<UserResponse> userResponses = new ArrayList<>();
        for(User user : all){
            if(user.getStatus().toString().equalsIgnoreCase(status)){
                userResponses.add(new UserResponse(user.getId(),
                        user.getFirstName()+" "+user.getLastName(),
                        user.getNumberOfBookings(),
                        mapStatus(user.getStatus())));
            }
        }
        return  userResponses;
    }

    public boolean checkStatus(String status) {
        if(status.equalsIgnoreCase("new") ||
                status.equalsIgnoreCase("loyal") ||
                status.equalsIgnoreCase("gold") ||
                status.equalsIgnoreCase("platinum")
        )
            return true;
        else
            return false;
    }
}
