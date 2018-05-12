package com.codehub.spring.springdatajpademo.repository;

import com.codehub.spring.springdatajpademo.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findByName(String name);

    List<City> findAllByCountry(String country);

    City findByNameAndAndCountry(String name, String country);


}
