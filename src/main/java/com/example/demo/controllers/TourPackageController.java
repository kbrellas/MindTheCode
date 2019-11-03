package com.example.demo.controllers;

import com.example.demo.pojos.GetAllTourPackages;
import com.example.demo.services.TourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TourPackageController {

    @Autowired
    private TourPackageService tourPackageService;

    @GetMapping("allTourPackages")
    public GetAllTourPackages getAllTourPackages(){
        return new GetAllTourPackages(tourPackageService.getAllTourPackages());
    }

}
