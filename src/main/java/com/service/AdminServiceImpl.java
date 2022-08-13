package com.service;

import com.mapper.AdminMapper;
import com.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminMapper adminMapper;

    public Admin LoginAdmin(Admin admin) {
        return adminMapper.LoginAdmin(admin);
    }

    public Admin getAdminByName(Admin admin) {
        return adminMapper.getAdminByName(admin);
    }

    @Override
    public int AddAdmin(Admin admin) {
        return adminMapper.AddAdmin(admin);
    }

    @Override
    public List<Admin> getAdminList() {
        return adminMapper.getAdminList();
    }

    @Override
    public Admin getAdminById(String id) {
        return adminMapper.getAdminById(id);
    }

    @Override
    public int deleteAdminById(String id) {
        return adminMapper.deleteAdminById(id);
    }

    @Override
    public int updateAdminById(Admin admin) {
        return adminMapper.updateAdminById(admin);
    }

    @Override
    public List<Admin> getAdminCondition(String cond,String name) {
        return adminMapper.getAdminCondition(cond,name);
    }
}
