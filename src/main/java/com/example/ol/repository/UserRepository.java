package com.example.ol.repository;

import com.example.ol.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);

    User findUserByUserId(Integer id);
}
