package com.spring.restfulwebservice.controller;

import com.spring.restfulwebservice.dao.UsersDAO;
import com.spring.restfulwebservice.entity.Users;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/users/{userId}")
    public Users getSingleUser(@PathVariable Long userId) {
        return dao.getUser(userId);
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        Users user = dao.getUser(userId);
        if (user == null) {
            throw new NullPointerException("User Not Found -" + userId);
        }
        dao.deleteUser(user);
        return "User Deleted -" + userId;
    }

    @PostMapping("/users")
    public Users saveUser(@RequestBody Users users) {
        users.setUserId(0L);
        dao.saveUser(users);
        return users;
    }

    @PutMapping("/users")
    public Users updateUsers(@RequestBody Users users) {
        Users user = dao.getUser(users.getUserId());
        if (user == null) {
            throw new NullPointerException("User Not Found for update -" + users.getUserId());
        }
        dao.updateUsers(user);
        return users;
    }

}
