package com.boris.springbootunittests.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public String getUser() {
        return "Boris";
    }
}
