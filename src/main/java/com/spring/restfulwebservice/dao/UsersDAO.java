package com.spring.restfulwebservice.dao;

import com.spring.restfulwebservice.entity.Users;

import java.util.List;

public interface UsersDAO {

    List<Users> getUsers();

    Users getUser(Long userId);

    void deleteUser(Users user);

    void saveUser(Users users);

    void updateUsers(Users users);
}
