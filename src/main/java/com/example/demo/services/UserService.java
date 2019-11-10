package com.example.demo.services;

import com.example.demo.mappers.UserMapper;
import com.example.demo.pojos.Error;
import com.example.demo.pojos.GenericResponse;
import com.example.demo.pojos.User;
import com.example.demo.pojos.UserResponse;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepo;

    public List<UserResponse> getAllUsers() {

        return userMapper.mapUsers(userRepo.findAll());
    }

    public GenericResponse<List<UserResponse>> getUserStatus(String status) {
        if(userMapper.checkStatus(status)) {
            return new GenericResponse(userMapper.mapUsersStatus(userRepo.findAll(), status));
        }
        else{
            return new GenericResponse(new Error(0,"status error","thers is no status type of :"+status));
        }
    }
}
