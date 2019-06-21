package com.example.ol.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Column(unique = true)
    private String username;
    private String password;
    //会员到期时间
    private Date vipExpireTime;
    @Transient
    private Boolean vip;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.vipExpireTime = new Date();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getVipExpireTime() {
        return vipExpireTime;
    }

    public void setVipExpireTime(Date vipExpireTime) {
        this.vipExpireTime = vipExpireTime;
    }

    public Boolean getVip() {
        if (this.vipExpireTime.before(new Date())) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", vipExpireTime=" + vipExpireTime +
                ", vip=" + vip +
                '}';
    }
}
