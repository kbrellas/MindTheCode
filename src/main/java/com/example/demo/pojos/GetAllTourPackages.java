package com.example.demo.pojos;

import java.util.List;

public class GetAllTourPackages {
    private List<TourPackageResponse> tourPackageResponses;

    public GetAllTourPackages(List<TourPackageResponse> tourPackageResponses) {
        this.tourPackageResponses = tourPackageResponses;
    }

    public List<TourPackageResponse> getTourPackageResponses() {
        return tourPackageResponses;
    }

    public void setTourPackageResponses(List<TourPackageResponse> tourPackageResponses) {
        this.tourPackageResponses = tourPackageResponses;
    }
}
