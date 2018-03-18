package com.webstore.services.Implementation;

import com.webstore.dao.UserRepository;
import com.webstore.domain.Role;
import com.webstore.domain.User;
import com.webstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Blazej on 13.03.2018.
 */
@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("USER"));
        if(user.getLogin().equalsIgnoreCase("admin")){
            roles.add(new Role("ADMIN"));
        }
        roles.add(new Role("USER"));
        user.setRole(roles);
        return userRepository.save(user);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    //@Transactional
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
