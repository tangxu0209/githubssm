package com.service;

import com.pojo.Admin;

import java.util.List;

public interface AdminService {
    Admin LoginAdmin(Admin admin);
    Admin getAdminByName(Admin admin);
    int AddAdmin(Admin admin);
    List<Admin> getAdminList();
    Admin getAdminById(String id);
    int deleteAdminById(String id);
    int updateAdminById(Admin admin);
    List<Admin> getAdminCondition(String cond,String name);
}
