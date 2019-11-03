package com.example.demo.controllers;

import com.example.demo.pojos.GetAllToursResponse;
import com.example.demo.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // auto to kanoume gia na orisoume to default REST template
@RequestMapping("/")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping("allTours")
    public GetAllToursResponse getAllTours() {
        return new GetAllToursResponse(tourService.getAllTours());
    }

    @GetMapping("getToursByPackageId/{id}")
    public GetAllToursResponse getToursByPackageId(@PathVariable Long id){
        return new GetAllToursResponse(tourService.getTourByPackageId(id));
    }

    @GetMapping("getExpensiveTours")
    public GetAllToursResponse getExpensiveTours(){
        return new GetAllToursResponse(tourService.getExpensiveTours());
    }
}
