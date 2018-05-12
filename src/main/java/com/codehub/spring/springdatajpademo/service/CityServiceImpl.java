package com.codehub.spring.springdatajpademo.service;

import com.codehub.spring.springdatajpademo.domain.City;
import com.codehub.spring.springdatajpademo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("cityService")
@Transactional
class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;


	@Override
	public City getCityByName(String name) {
		return cityRepository.findByName(name);
	}

	@Override
	public List<City> getByCountry(String country) {
		return cityRepository.findAllByCountry(country);
	}

	@Override
	public City getCityByNameAndCountry(String name, String country) {
		return cityRepository.findByNameAndAndCountry(name, country);
	}

}
