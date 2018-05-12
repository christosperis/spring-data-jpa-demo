package com.codehub.spring.springdatajpademo.service;


import com.codehub.spring.springdatajpademo.domain.City;

import java.util.List;

public interface CityService {


	City getCityByName(String name);

	List<City> getByCountry(String country);

	City getCityByNameAndCountry(String name, String country);
}
