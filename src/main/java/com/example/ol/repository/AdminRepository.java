package com.example.ol.repository;

import com.example.ol.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
    Admin findAdminByUsername(String name);
}
