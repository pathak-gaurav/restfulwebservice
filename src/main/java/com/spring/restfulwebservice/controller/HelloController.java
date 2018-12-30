package com.spring.restfulwebservice.controller;

import com.spring.restfulwebservice.entity.Customer;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private MessageSource messageSource;

    public HelloController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

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

    @GetMapping("/hello-world/I18N")
    public String helloWorldI18N(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("good.morning.message", null, locale);
    }
}
