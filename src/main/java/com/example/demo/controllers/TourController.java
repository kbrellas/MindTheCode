package com.example.demo.controllers;

import com.example.demo.pojos.Error;
import com.example.demo.pojos.GenericResponse;
import com.example.demo.pojos.GetAllToursResponse;
import com.example.demo.pojos.TourPackageResponse;
import com.example.demo.pojos.TourResponse;
import com.example.demo.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/getToursByCriteria/{criteria}/{id}")
    public ResponseEntity getToursByCriteria(@PathVariable String criteria, @PathVariable long id) {

        if(!criteria.equals("tourPackage")){
            return new ResponseEntity(new Error(0,"wrong criteria","The criteria should be tourPackage"),null,HttpStatus.BAD_REQUEST);
        }

        GenericResponse<List<TourResponse>> response = tourService.getToursByCriteria(criteria,id);
        if(response.getError()!=null)
            return new ResponseEntity(response.getError(),null, HttpStatus.OK);

        return new ResponseEntity(new GetAllToursResponse(response.getData()),null, HttpStatus.OK);
    }
}
