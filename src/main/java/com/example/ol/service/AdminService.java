package com.example.ol.service;

import com.example.ol.entity.Admin;
import com.example.ol.entity.User;

import java.util.List;

public interface AdminService {
    Admin findAdminByUsername(String name);

    List<User> findAllUsers();

    boolean buyVipOneMonth(Integer userId);

    boolean buyVipThreeMonth(Integer userId);
}
