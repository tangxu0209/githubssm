package com.mapper;

import com.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<Users> getUsers();
    int updateUserStatus(Users user);
    Users getUserById(String usersid);
    int deleteUserById(String usersid);
    List<Users> queryUsersByCond(@Param("cond") String cond, @Param("name") String name);
}
