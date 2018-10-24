package com.glovoapp.backender.controller;

import com.glovoapp.backender.domain.maker.CourierMaker;
import com.glovoapp.backender.domain.viewer.CourierVM;
import com.glovoapp.backender.repositories.CourierRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = { "couriersController" })
@RestController
public class CouriersController {

    @Autowired
    private CourierRepository courierRepository;

    @GetMapping("/couriers")
    @ResponseBody
    public List<CourierVM> couriers() {
        return courierRepository.findAll()
                .stream()
                .map(CourierMaker::toCourierVM)
                .collect(Collectors.toList());
    }

}
