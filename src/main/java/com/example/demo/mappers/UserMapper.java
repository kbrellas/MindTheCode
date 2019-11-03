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
}
