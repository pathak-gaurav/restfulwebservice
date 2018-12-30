package com.spring.restfulwebservice.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.spring.restfulwebservice.entity.SomeBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping(path = "/filtering")
    public SomeBean filteringBean(){
        return new SomeBean("A","B","C");
    }


    @GetMapping(path = "/dynamic-filtering")
    public MappingJacksonValue dynamicFiltering(){
        SomeBean someBean = new SomeBean("A", "B", "C");
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("first");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("some-filter", simpleBeanPropertyFilter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }

    @GetMapping(path = "/dynamic-filtering-list")
    public MappingJacksonValue dynamicFilteringList(){
        List<SomeBean> list = Arrays.asList(new SomeBean("C","D","E"),
                new SomeBean("F","G","H"));
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("third");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("some-filter",simpleBeanPropertyFilter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }

}
