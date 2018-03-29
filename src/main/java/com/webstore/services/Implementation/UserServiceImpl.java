package com.webstore.services.Implementation;

import com.webstore.dao.UserRepository;
import com.webstore.domain.Role;
import com.webstore.domain.User;
import com.webstore.services.UserService;
import org.apache.log4j.Logger;
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

    private static final Logger log = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User save(User user) {

        log.debug("Rozpoczynam dodawanie nowego użytkownika");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);

        Set<Role> roles = new HashSet<>();
        roles.add(new Role("USER"));

        if(user.getLogin().equalsIgnoreCase("admin")){
            roles.add(new Role("ADMIN"));
        }

        user.setRole(roles);
        log.debug("###### Użytkownik dodany!!!!");
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

    @Override
    public List<String> findLogins() {
        return userRepository.findLogins();
    }
}
