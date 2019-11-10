package com.example.demo.services;

import com.example.demo.pojos.*;
import com.example.demo.pojos.Error;
import com.example.demo.services.TourPackageService;
import com.example.demo.services.TourService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeInteractor {

    @Autowired
    UserService userService;

    @Autowired
    TourPackageService tourPackageService;

    @Autowired
    TourService tourService;

    public HomePageResponse getHomePage(){
        List<TourPackageResponse> tourPackages=tourPackageService.getAllTourPackages();
        List<UserResponse> users =userService.getAllUsers();
        int numberOfTourPackages = tourPackages.size();
        int numberOfUsers =users.size();
        String title="Home Page";

        HomePageResponse homePageResponse= new HomePageResponse(title,numberOfTourPackages,numberOfUsers,tourPackages,users);
        return homePageResponse;
    }

    public MainPageResponse getMainPage(){
        List<TourResponse> tours=tourService.getAllTours();
        List<UserResponse> users =userService.getAllUsers();
        int numberOfTours = tours.size();
        int numberOfUsers =users.size();
        String title="Home Page";

        MainPageResponse mainPageResponse= new MainPageResponse(numberOfTours,numberOfUsers,tours,users);
        return mainPageResponse;
    }

    public GenericResponse<MainPageResponse> getMainPageByUserStatus(String userStatus) {
        List<TourResponse> tours=tourService.getAllTours();
        GenericResponse<List<UserResponse>> userGeneric = userService.getUserStatus(userStatus);
        List<UserResponse> userResponses;
        int numberOfTours = tours.size();
        int numberOfUsers;
        MainPageResponse mainPageResponse= new MainPageResponse();

        if(userGeneric.getError()==null){
            userResponses=userGeneric.getData();
            numberOfUsers=userResponses.size();
            mainPageResponse= new MainPageResponse(numberOfTours,numberOfUsers,tours,userResponses);
            return new GenericResponse<MainPageResponse>(mainPageResponse);
        }
        else
            return new GenericResponse<>(userGeneric.getError());

    }
}
