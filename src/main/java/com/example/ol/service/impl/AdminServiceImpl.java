package com.example.ol.service.impl;

import com.example.ol.entity.Admin;
import com.example.ol.entity.User;
import com.example.ol.repository.AdminRepository;
import com.example.ol.repository.UserRepository;
import com.example.ol.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Admin findAdminByUsername(String name) {
        return adminRepository.findAdminByUsername(name);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean buyVipOneMonth(Integer userId) {
        User user = userRepository.findUserByUserId(userId);

        Calendar calendar = new GregorianCalendar();
        if (user.getVip()) {
            calendar.setTime(user.getVipExpireTime());
        } else {
            calendar.setTime(new Date());
        }
        calendar.add(Calendar.DATE, 30);
        user.setVipExpireTime(calendar.getTime());
        System.out.println(user);
        try {
            userRepository.save(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean buyVipThreeMonth(Integer userId) {
        User user = userRepository.findUserByUserId(userId);
        Calendar calendar = new GregorianCalendar();
        if (user.getVip()) {
            calendar.setTime(user.getVipExpireTime());
        } else {
            calendar.setTime(new Date());
        }
        calendar.add(Calendar.DATE, 90);
        user.setVipExpireTime(calendar.getTime());
        try {
            userRepository.save(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
