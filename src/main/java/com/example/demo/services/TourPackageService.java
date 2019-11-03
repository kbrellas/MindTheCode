package com.example.demo.services;

import com.example.demo.mappers.TourPackageMapper;
import com.example.demo.pojos.TourPackage;
import com.example.demo.pojos.TourPackageResponse;
import com.example.demo.repositories.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourPackageService {

    @Autowired
    private TourPackageMapper tourPackageMapper;

    @Autowired
    private TourPackageRepository tourPackageRepository;

    public List<TourPackageResponse> getAllTourPackages(){
        Iterable<TourPackage> retrievedTourPackages = tourPackageRepository.findAll();
        return tourPackageMapper.getTourPackageResponses(retrievedTourPackages);
    }
}
