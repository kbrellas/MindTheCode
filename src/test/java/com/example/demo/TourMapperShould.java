package com.example.demo;

import com.example.demo.pojos.Tour;
import com.example.demo.pojos.TourPackage;
import com.example.demo.pojos.TourResponse;
import org.junit.*;
import com.example.demo.mappers.TourMapper;

public class TourMapperShould {

    private TourMapper mapper;

    private Tour tourInput;
    private TourPackage packageInput;
    private TourResponse output;

    @Before
    public void setup(){
        mapper = new TourMapper();
        tourInput = new Tour(1000,400,"Da best Tour","shorty","longy");
        tourInput.setId(100);
        packageInput = new TourPackage("package desc da best",3000,"Ionia");
        packageInput.setId(200);
        tourInput.setTourPackage(packageInput);
        output = mapper.mapTourResponseFromTour(tourInput);
    }

    @Test
    public void keepSameId(){
        Assert.assertEquals((long)100,output.getId());
    }

    @Test
    public void keepSamePrice(){
        Assert.assertEquals(1000,output.getPrice());
    }

    @Test
    public void keepSameDiscount(){
        Assert.assertEquals(400,output.getDiscount());
    }

    @Test
    public void calculateFinalPriceByPriceAndDiscount(){
        Assert.assertEquals(600,output.getFinalPrice());
    }

    @Test
    public void keepSameTitle(){
        Assert.assertEquals(tourInput.getTitle(),output.getTitle());
    }

    @Test
    public void keepSameShortDescription(){
        Assert.assertEquals(tourInput.getShortDesc(),output.getShortDesc());
    }

    @Test
    public void keepSameLongDescription(){
        Assert.assertEquals(tourInput.getLongDesc(),output.getLongDesc());
    }

    @Test
    public void setTitleFromTourPackage(){
        Assert.assertEquals(tourInput.getTourPackage().getDesc(),output.getTourPackageTitle());
    }
}
