package com.service;

import com.mapper.UserMapper;
import com.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<Users> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public int updateUserStatus(Users user) {
        return userMapper.updateUserStatus(user);
    }

    @Override
    public Users getUserById(String usersid) {
        return userMapper.getUserById(usersid);
    }

    @Override
    public int deleteUserById(String usersid) {
        return userMapper.deleteUserById(usersid);
    }

    @Override
    public List<Users> queryUsersByCond(String cond, String name) {
        return userMapper.queryUsersByCond(cond, name);
    }

}
