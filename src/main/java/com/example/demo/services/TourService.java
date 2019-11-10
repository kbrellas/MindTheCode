package com.example.demo.services;

import com.example.demo.mappers.TourMapper;
import com.example.demo.pojos.*;
import com.example.demo.pojos.Error;
import com.example.demo.repositories.TourPackageRepository;
import com.example.demo.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourService {

    @Autowired
    private TourMapper tourMapper;

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    TourPackageRepository tourPackageRepository;

    public List<TourResponse> getAllTours(){
        Iterable<Tour> retrievedTours = tourRepository.findAll();
        List<TourResponse> tours = new ArrayList<>();

        for(Tour tour : retrievedTours){
            tours.add(tourMapper.mapTourResponseFromTour(tour));
        }

        /*retrievedTours.forEach(tour -> {

        });*/

        return tours;
    }

    public List<TourResponse> getTourByPackageId(Long id) {
        //Iterable<Tour> retrievedTours = tourRepository.findById(id);
        Iterable<Tour> retrievedTours = tourRepository.findAll();
        List<TourResponse> tours = new ArrayList<>();
        for(Tour tour : retrievedTours){
            if(tour.getTourPackage()!=null && tour.getTourPackage().getId()==id)
                tours.add(tourMapper.mapTourResponseFromTour(tour));
        }
        return tours;
    }


    public List<TourResponse> getExpensiveTours() {
        List<TourResponse> tours = getAllTours();
        List<TourResponse> expensiveTours = new ArrayList<>();

        for(TourResponse tourResponse : tours){
            if(tourResponse.getFinalPrice()>50)
                expensiveTours.add(tourResponse);
        }
        return  expensiveTours;
    }

    public GenericResponse<List<TourResponse>> getToursByCriteria(String criteria, long id) {
        Iterable<Tour> tours = tourRepository.findAll();
        List<TourResponse> tourResponses = new ArrayList<>();
//        boolean tourPackageFound = false;
        if(criteria.equals("tourPackage")){
            if(!tourPackageRepository.findById(id).isPresent())
                return new GenericResponse<>(new Error(0,"wrong input", "TourPackage with id "+id+" does not exist"));

            for (Tour tour : tours){
               if (tour.getTourPackage().getId()==id){
//                    tourPackageFound = true;
                    tourResponses.add(tourMapper.mapTourResponseFromTour(tour));
                }
            }
        }
        /*if(!tourPackageFound)
            return new GenericResponse<>(new Error(0,"wrong input", "TourPackage with id "+id+" does not exist"));
        else*/
            return new GenericResponse<>(tourResponses);
    }
}
