package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

public interface Users {
    User findByUsername(String username);

    User findByEmail(String email);

    Long insert(User user);
    int updatePassword(User user);
    int updateContact(String email, String firstName, String lastName, String phone, String username);
}
