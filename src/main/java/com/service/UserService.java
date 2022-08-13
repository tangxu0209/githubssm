package com.service;

import com.pojo.Users;

import java.util.List;

public interface UserService {
    List<Users> getUsers();
    int updateUserStatus(Users user);
    Users getUserById(String usersid);
    int deleteUserById(String usersid);
    List<Users> queryUsersByCond(String cond,String name);
}
