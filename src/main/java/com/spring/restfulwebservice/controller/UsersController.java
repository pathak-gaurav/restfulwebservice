package com.spring.restfulwebservice.controller;

import com.spring.restfulwebservice.dao.UsersDAO;
import com.spring.restfulwebservice.entity.Users;
import com.spring.restfulwebservice.exception.UserNotFoundException;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
@RequestMapping("/api")
public class UsersController {

    private UsersDAO dao;

    public UsersController(UsersDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/users")
    public List<Users> getUsers() {
        return dao.getUsers();
    }

    @GetMapping(value = "/users/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Users> getSingleUser(@PathVariable Long userId) {
        Users user = dao.getUser(userId);
        if (user == null) {
            throw new UserNotFoundException("User Not Found -" + userId);
        }
        Resource<Users> resource = new Resource<>(user);
        ControllerLinkBuilder controllerLinkBuilder = linkTo(methodOn(this.getClass()).getUsers());
        resource.add(controllerLinkBuilder.withRel("all-users"));
        return resource;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        Users user = dao.getUser(userId);
        if (user == null) {
            throw new UserNotFoundException("User Not Found -" + userId);
        }
        dao.deleteUser(user);
        return "User Deleted -" + userId;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> saveUser(@Valid @RequestBody Users users) {
        users.setUserId(0L);
        dao.saveUser(users);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(users.getUserId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/users")
    public Users updateUsers(@Valid @RequestBody Users users) {
        Users user = dao.getUser(users.getUserId());
        if (user == null) {
            throw new UserNotFoundException("User Not Found -" + users.getUserId());
        }
        dao.updateUsers(user);
        return user;
    }
}
