package com.webstore.domain;


import com.webstore.validators.interfaces.IEmailValidator;
import com.webstore.validators.interfaces.MatchingPassword;
import com.webstore.validators.interfaces.UserExists;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Blazej on 05.02.2018.
 */
@Entity
@Table(name = "users")
@UserExists
@MatchingPassword
public class User {

    private long id;

    @NotEmpty(message = "{notnull.field}")
    private String login;

    @NotEmpty(message = "{notnull.field}")
    private String password;

    @NotEmpty(message = "{notnull.field}")
    private String matchingPassword;

    @NotEmpty(message = "{notnull.field}")
    private String firstName;

    @NotEmpty(message = "{notnull.field}")
    private String lastName;

    @IEmailValidator
    @NotEmpty(message = "{notnull.field}")
    private String email;

    private Address address;
    private Set<Role> role = new HashSet<>();
    private boolean isActive;
    private Set<Cart> userCarts = new HashSet<>();

    public User() {
    }

    public User(String login, String password, String firstName, String lastName, Address address, Set<Role> role,
                boolean isActive, Set<Cart> userCarts, String email) {

        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.role = role;
        this.isActive = isActive;
        this.userCarts = userCarts;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "login",unique = true,nullable = false)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password",nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //@Column(name = "address_id")
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Column(name = "role_id")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = {@JoinColumn(name = "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id")})
    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    @Column(name = "is_active",nullable = false)
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @OneToMany(mappedBy = "user")
    public Set<Cart> getUserCarts() {
        return userCarts;
    }

    public void setUserCarts(Set<Cart> userCarts) {
        this.userCarts = userCarts;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Transient
    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

//    @Transient
//    public String getMatchingPassword() {
//        return matchingPassword;
//    }
//
//    public void setMatchingPassword(String matchingPassword) {
//        this.matchingPassword = matchingPassword;
//    }
}
