package com.webstore.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Blazej on 09.02.2018.
 */
@Entity
@Table(name = "roles")
public class Role {

    private Long id;
    private String name;
    private Set<User> users = new HashSet<>();

    public Role() {
    }

    public Role(String name, Set<User> users) {
        this.name = name;
        this.users = users;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "role_id",unique = true,nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "role_name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "user_id")
    @ManyToMany(mappedBy = "role")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


}
