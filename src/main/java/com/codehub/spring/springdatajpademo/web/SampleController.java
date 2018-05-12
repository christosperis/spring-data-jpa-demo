package com.codehub.spring.springdatajpademo.web;

import com.codehub.spring.springdatajpademo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class SampleController {

    @Autowired
    private CityService cityService;

    @RequestMapping("/")
    @ResponseBody
    @Transactional(readOnly = true)
    public String helloWorld() {
        return "helloWorld";
    }


}
