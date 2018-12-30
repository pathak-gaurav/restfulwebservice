package com.spring.restfulwebservice.controller;

import com.spring.restfulwebservice.entity.SomeBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @GetMapping(path = "/filtering")
    public SomeBean filteringBean(){
        return new SomeBean("A","B","C");
    }



}
