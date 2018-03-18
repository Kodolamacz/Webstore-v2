package com.webstore.services.Implementation;

import com.webstore.dao.RoleRepository;
import com.webstore.dao.UserRepository;
import com.webstore.domain.Role;
import com.webstore.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Blazej on 11.03.2018.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByLogin(username);
      //  System.out.println(user.getLogin() + " " );

        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);

        } else {
            Set<Role> roles = roleRepository.findByUsers_Login(user.getLogin());
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

            for (Role role : roles) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            }

            System.out.println(user.getLogin() + " " + grantedAuthorities + " " + user.getPassword());
            return new UserDetails() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    return grantedAuthorities;
                }

                @Override
                public String getPassword() {
                    return user.getPassword();
                }

                @Override
                public String getUsername() {
                    return user.getLogin();
                }

                @Override
                public boolean isAccountNonExpired() {
                    return true;
                }

                @Override
                public boolean isAccountNonLocked() {return true; }

                @Override
                public boolean isCredentialsNonExpired() {
                    return true;
                }

                @Override
                public boolean isEnabled() {
                    return user.isActive();
                }
            };
        }


    }
}
