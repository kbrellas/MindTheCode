package com.example.demo.controllers;

import com.example.demo.pojos.Error;
import com.example.demo.pojos.GenericResponse;
import com.example.demo.pojos.MainPageResponse;
import com.example.demo.services.HomeInteractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tour-office/")
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

    @GetMapping("main/{userStatus}")
    public ResponseEntity getMainPageByUserStatus(@PathVariable String userStatus){
        try {
            GenericResponse<MainPageResponse> genericResponse =homeInteractor.getMainPageByUserStatus(userStatus);
            ResponseEntity response;
            if(genericResponse.getError()==null)
                response = new ResponseEntity(genericResponse.getData(), null, HttpStatus.OK);
            else
                response = new ResponseEntity(genericResponse.getError(), null, HttpStatus.OK);
            return response;
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(new Error(0,"Problemo","Something went really wrong"), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
