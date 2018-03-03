package com.webstore.domain.dao;

import com.webstore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Blazej on 27.02.2018.
 */
public interface UserRepository extends JpaRepository<User,Long> {

   Optional<User> findById(Long id);
   List<User> findByFirstnameOrLastname(String firstname, String lastname);
   User save(User user);
   void deleteById(Long id);
   void deleteByLogin(String login);

}
