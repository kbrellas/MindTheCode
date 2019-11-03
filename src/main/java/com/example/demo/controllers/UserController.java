package com.example.demo.controllers;

import com.example.demo.pojos.GetAllUsersResponse;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("users")
    public GetAllUsersResponse getAllUsers(){
        return new GetAllUsersResponse(userService.getAllUsers());
    }

    @GetMapping("users/{status}")
    public GetAllUsersResponse getUsersStatus(@PathVariable String status){
        return new GetAllUsersResponse(userService.getUserStatus(status));
    }
}
