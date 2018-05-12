package com.codehub.spring.springdatajpademo.service;

import com.codehub.spring.springdatajpademo.domain.City;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("cityService")
@Transactional
class CityServiceImpl implements CityService {
	


	@Override
	public City getCity(String name, String country) {
		return new City("Athens", "Greece");
	}

}
