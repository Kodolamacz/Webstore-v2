package com.webstore.services.Implementation;

import com.webstore.dao.RoleRepository;
import com.webstore.domain.Role;
import com.webstore.domain.User;
import com.webstore.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Blazej on 11.03.2018.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger log = Logger.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.debug("######## Zaczynam ładować userów!!!!!!!!!!!!! "+ username);

        User user = userService.findByLogin(username);

        if (user == null) {
            log.info("######## BRAK użytkownika");
            throw new UsernameNotFoundException("User not found: " + username);
           // log.info("######## BRAK?");

        } else {
            Set<Role> roles = roleRepository.findByUsers_Login(user.getLogin());
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

            for (Role role : roles) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            }

            log.debug("#######  Znalezniono i wczytano" );
            return new org.springframework.security.core.userdetails.User(username,user.getPassword(),grantedAuthorities);
        }


    }
}
