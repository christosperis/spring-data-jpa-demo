package com.codehub.spring.springdatajpademo.service;

import com.codehub.spring.springdatajpademo.domain.City;
import com.codehub.spring.springdatajpademo.domain.Hotel;
import com.codehub.spring.springdatajpademo.transfer.HotelSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HotelService {

    Page<HotelSummary> getHotelsSummary(City city, Pageable pageable);

    List<Hotel> getHotelsByCity(City city);

}
