package com.spring.restfulwebservice.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({"first","second"})
@JsonFilter("some-filter")
public class SomeBean {

    private String first;
    private String second;
    private String third;

    public SomeBean(String first, String second, String third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public SomeBean() {
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    @Override
    public String toString() {
        return "SomeBean{" +
                "first='" + first + '\'' +
                ", second='" + second + '\'' +
                ", third='" + third + '\'' +
                '}';
    }
}
