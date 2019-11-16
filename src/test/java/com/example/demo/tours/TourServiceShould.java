package com.example.demo.tours;

import com.example.demo.mappers.TourMapper;
import com.example.demo.pojos.Tour;
import com.example.demo.pojos.TourPackage;
import com.example.demo.pojos.TourResponse;
import com.example.demo.repositories.TourPackageRepository;
import com.example.demo.repositories.TourRepository;
import com.example.demo.services.TourService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class TourServiceShould {

    private TourService service;
    @Mock
    private TourRepository tourRepository;
    @Mock
    private TourPackageRepository tourPackageRepository;
    @Mock
    private TourMapper mapper;

    private Iterable<Tour> mockedTours = new ArrayList<Tour>(){
        {
            add(new Tour(1,10, 5, "sightseeing", "kallithea sites", "manhattan of athens", new TourPackage("best one", 10000, "Mykonos")));
            add(new Tour(2,10, 5, "sightseeing", "kallithea sites", "manhattan of athens", new TourPackage("best one", 10000, "Mykonos")));
        }
    };

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this); //auto kanei initialization sta @Mock
        when(tourRepository.findAll()).thenReturn(mockedTours); //kaneis mock return gia to repo
        when(mapper.mapTourResponseFromTour(ArgumentMatchers.any())).thenReturn(new TourResponse(1,500,400,600,"title","short","long","package"));
        service = new TourService(mapper,tourRepository,tourPackageRepository);

    }
    @Test //se auth thn klash testaroume an h me8odos tou service pairnei ta dedomena ths apo to repo
    public void retrieveToursFromRepository(){
        service.getAllTours();
        Mockito.verify(tourRepository).findAll(); //test gia to an kalesthke to repo
    }

    @Test
    public void useTourMapper(){
        service.getAllTours();
        // ArgumentMatchers.any() gia na elenxo an kalesthke me opoiadhpote sunarthsh
        Mockito.verify(mapper,times(2)).mapTourResponseFromTour(ArgumentMatchers.any());
    }

    @Test
    public void returnListOfTourResponse(){
        List<TourResponse> output = service.getAllTours();
        Assert.assertEquals(2,output.size());
        List<TourResponse> expextedList=new ArrayList<>();
        expextedList.add(new TourResponse(1,500,400,600,"title","short","long","package"));
        expextedList.add(new TourResponse(1,500,400,600,"title","short","long","package"));
        Assert.assertThat(expextedList, Matchers.samePropertyValuesAs(output)); //auto to kanoume otan exoume complex methods
    }
}
