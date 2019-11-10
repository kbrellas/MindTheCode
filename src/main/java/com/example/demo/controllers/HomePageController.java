package com.example.demo.controllers;

import com.example.demo.services.HomeInteractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomePageController {

    @Autowired
    HomeInteractor homeInteractor;

    @GetMapping("home")
    public ResponseEntity getHomePage(){
        ResponseEntity response=new ResponseEntity(homeInteractor.getHomePage(),null, HttpStatus.OK);
        return response;
    }
    @GetMapping("main")
    public ResponseEntity getMainPage(){
        ResponseEntity response=new ResponseEntity(homeInteractor.getMainPage(),null, HttpStatus.OK);
        return response;
    }


}
