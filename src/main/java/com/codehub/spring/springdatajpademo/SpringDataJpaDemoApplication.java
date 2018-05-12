package com.codehub.spring.springdatajpademo;

import com.codehub.spring.springdatajpademo.domain.City;
import com.codehub.spring.springdatajpademo.domain.Hotel;
import com.codehub.spring.springdatajpademo.service.CityService;
import com.codehub.spring.springdatajpademo.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication

public class SpringDataJpaDemoApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CityService cityService;

    @Autowired
    private HotelService hotelService;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("=============================");
        logger.info("====Finding Montreal====");
        logger.info(cityService.getCityByName("Montreal").getName());
        logger.info("=============================");
        logger.info("=============================");


        logger.info("=============================");
        logger.info("====Finding Melbourne====");
        logger.info(cityService.getCityByNameAndCountry("Melbourne", "Australia").getName());
        logger.info("=============================");
        logger.info("=============================");


        logger.info("=============================");
        logger.info("====Finding All Usa Countries====");
        for (City city : cityService.getByCountry("USA")) {
            logger.info(city.toString());
        }
        logger.info("=============================");
        logger.info("=============================");

        logger.info("=============================");
        logger.info("====Finding Bath's Hotels====");
        for (Hotel hotel : hotelService.getHotelsByCity(new City("Bath", "UK"))) {
            logger.info(hotel.toString());
        }
        logger.info("=============================");
        logger.info("=============================");


        logger.info("=============================");
        logger.info("====Finding Bath's Hotels Summary====");
        logger.info(hotelService.getHotelsSummary(new City("Bath", "UK"),
                new PageRequest(0,5)).getContent().toString());

        logger.info("=============================");
        logger.info("=============================");
    }
}
