package com.example.demo.mappers;

import com.example.demo.pojos.TourPackage;
import com.example.demo.pojos.TourPackageResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TourPackageMapper {
    public List<TourPackageResponse> getTourPackageResponses(Iterable<TourPackage> retrievedTourPackages){
        List<TourPackageResponse> tourPackages = new ArrayList<>();
        for(TourPackage tp : retrievedTourPackages){
            tourPackages.add(new TourPackageResponse(tp.getId(),tp.getDest()+": "+tp.getDesc(),tp.getPrice()));
        }
        return tourPackages;
    }
}
