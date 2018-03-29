package com.webstore.services;

import com.webstore.domain.User;

import java.util.List;

/**
 * Created by Blazej on 13.03.2018.
 */
public interface UserService {

    User save(User user);
    User findByLogin(String login);
    void deleteUser(User user);
    List<String> findLogins();
}
