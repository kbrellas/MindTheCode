package com.example.demo.repositories;

import com.example.demo.pojos.Tour;
import org.springframework.data.repository.CrudRepository;

public interface TourRepository extends CrudRepository<Tour, Long> {
}
