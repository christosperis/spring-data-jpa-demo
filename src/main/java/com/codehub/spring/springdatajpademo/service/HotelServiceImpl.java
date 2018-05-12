package com.codehub.spring.springdatajpademo.service;

import com.codehub.spring.springdatajpademo.domain.City;
import com.codehub.spring.springdatajpademo.domain.Hotel;
import com.codehub.spring.springdatajpademo.repository.HotelRepository;
import com.codehub.spring.springdatajpademo.transfer.HotelSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigInteger;
import java.util.List;

@Component("hotelService")
@Transactional
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private CityService cityService;

    @Override
    public Page<HotelSummary> getHotelsSummary(City city, Pageable pageable) {
        Assert.notNull(city, "City must not be null");
        City resolvedCity = cityService.getCityByName(city.getName());
        Page<HotelSummary> hotelSummaries = hotelRepository.findHotelSummaryByCity(resolvedCity, pageable);
        hotelSummaries.getTotalElements();
        return hotelSummaries;
    }

    @Override
    public List<Hotel> getHotelsByCity(City city) {
        Assert.notNull(city, "City must not be null");
        City resolvedCity = cityService.getCityByName(city.getName());
        List<Hotel> hotels = hotelRepository.findHotelsByCity(BigInteger.valueOf(resolvedCity.getId()));
        hotels.size();
        return hotels;
    }
}
