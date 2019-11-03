package com.example.demo.repositories;
//dhlwneis repo gia na epikoinwnei me thn vash

import com.example.demo.pojos.TourPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface TourPackageRepository extends CrudRepository<TourPackage, Long> {

    @Override
    @RestResource(exported=false) //auto to grafeis gia na mhn xrhsimopoioun tis me8odous sou
    void delete(TourPackage entity);

    @Override
    @RestResource(exported=false) //mporeis na to kaneis se oles tis me8odous
    void deleteAll();
}
