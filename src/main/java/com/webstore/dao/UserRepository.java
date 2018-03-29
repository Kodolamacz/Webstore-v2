package com.webstore.dao;

import com.webstore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Blazej on 27.02.2018.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

   Optional<User> findById(Long id);
   List<User> findByFirstNameOrLastName(String firstName, String lastName);
   User save(User user);
   User findByLogin(String login);
   void deleteById(Long id);
   void deleteByLogin(String login);
  // List<User> findByIsActiveTrue();
   List<User> findByRole_Name(String roleName);

   @Query(value="select login from User u",nativeQuery = true)
   List<String> findLogins();


}
