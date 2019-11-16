package com.example.demo.controllers;

import com.example.demo.pojos.GenericResponse;
import com.example.demo.pojos.GetAllUsersResponse;
import com.example.demo.pojos.UserResponse;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tour-office/")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("users")
    public GetAllUsersResponse getAllUsers(){
        return new GetAllUsersResponse(userService.getAllUsers());
    }

    @GetMapping("users/{status}")
    public ResponseEntity getUsersStatus(@PathVariable String status){
        GenericResponse<List<UserResponse>> response = userService.getUserStatus(status);
        if(response.getError()!=null)
            return new ResponseEntity(response.getError(),null, HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity(response.getData(),null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
