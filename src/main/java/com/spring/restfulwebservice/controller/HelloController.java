package com.spring.restfulwebservice.controller;

import com.spring.restfulwebservice.entity.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/customer")
    public Customer customer() {
        return new Customer("Zack", "Anderson");
    }

    @GetMapping("/customer/{addressing}")
    public Customer Customer(@PathVariable String addressing) {
        return new Customer(addressing + " Barack", "Obama");
    }
}
