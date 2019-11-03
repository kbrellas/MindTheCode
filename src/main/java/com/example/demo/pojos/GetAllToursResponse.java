package com.example.demo.pojos;

import java.util.List;

//auth h klash xrhimopoieitai gia na epistrefeis object anti gia lista (allazei thn morfh tou json)
public class GetAllToursResponse {
    private List<TourResponse> tourResponses;

    public GetAllToursResponse(List<TourResponse> tourResponses) {
        this.tourResponses = tourResponses;
    }

    public List<TourResponse> getTourResponses() {
        return tourResponses;
    }

    public void setTourResponses(List<TourResponse> tourResponses) {
        this.tourResponses = tourResponses;
    }
}
