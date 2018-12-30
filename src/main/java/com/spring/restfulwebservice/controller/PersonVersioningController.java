package com.spring.restfulwebservice.controller;

import com.spring.restfulwebservice.entity.Name;
import com.spring.restfulwebservice.entity.PersonV1;
import com.spring.restfulwebservice.entity.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("/personv1")
    public PersonV1 personV1() {
        return new PersonV1("Zack Anderson");
    }

    @GetMapping("/personv2")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Theresa", "May"));
    }

    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 paramPersonV1() {
        return new PersonV1("Zack Anderson");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramPersonV2() {
        return new PersonV2(new Name("Theresa", "May"));
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headersPersonV1() {
        return new PersonV1("Zack Anderson");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headersPersonV2() {
        return new PersonV2(new Name("Theresa", "May"));
    }


    @GetMapping(value = "/person/produces", produces = "application/app-v1+json")
    public PersonV1 PersonV1produces() {
        return new PersonV1("Zack Anderson");
    }

    @GetMapping(value = "/person/produces", produces = "application/app-v2+json")
    public PersonV2 PersonV2produces() {
        return new PersonV2(new Name("Theresa", "May"));
    }

}
