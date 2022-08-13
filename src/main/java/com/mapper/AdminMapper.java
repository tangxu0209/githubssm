package com.mapper;

import com.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface AdminMapper {
    Admin LoginAdmin(Admin admin);
    Admin getAdminByName(Admin admin);
    int AddAdmin(Admin admin);
    List<Admin> getAdminList();
    Admin getAdminById(String id);
    int deleteAdminById(String id);
    int updateAdminById(Admin admin);
    List<Admin> getAdminCondition(@Param("cond") String cond,@Param("name") String name);
}
