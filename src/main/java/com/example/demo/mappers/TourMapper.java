package com.example.demo.mappers;

import com.example.demo.pojos.Tour;
import com.example.demo.pojos.TourResponse;
import org.springframework.stereotype.Component;

//auth h klashh einai antistoixh me tis ServiceImpl klaseis
@Component
public class TourMapper {
    public TourResponse mapTourResponseFromTour(Tour tour) {
        return new TourResponse(
                tour.getId(),
                tour.getPrice(),
                tour.getDiscount(),
                mapFinalPrice(tour),
                tour.getTitle(),
                tour.getShortDesc(),
                tour.getLongDesc(),
                getTitleFromTourPackage(tour));
    }

    private String getTitleFromTourPackage(Tour tour) {
        return tour.getTourPackage().getDesc();
    }

    private int mapFinalPrice(Tour tour) {
        return tour.getPrice()-tour.getDiscount();
    }
}
