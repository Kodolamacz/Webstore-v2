package com.webstore.dao;

import com.webstore.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by Blazej on 04.03.2018.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String name);
    Set<Role> findByUsers_Login(String login);
}
