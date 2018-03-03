package com.webstore.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Blazej on 16.02.2018.
 */
@Entity
@Table(name = "carts")
public class Cart {

    private Long id;
    private double totalOrderValue;
    private Set<CartItem> items = new HashSet<>();
    private User user;

    public Cart( double totalOrderValue, Set<CartItem> items, User user) {
        this.totalOrderValue = totalOrderValue;
        this.items = items;
        this.user = user;
    }

    public Cart() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cart_id",unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "total_order_value")
    public double getTotalOrderValue() {
        return totalOrderValue;
    }

    public void setTotalOrderValue(double totalOrderValue) {
        this.totalOrderValue = totalOrderValue;
    }

    @OneToMany(mappedBy = "cart")
    public Set<CartItem> getItems() {
        return items;
    }

    public void setItems(Set<CartItem> items) {
        this.items = items;
    }


    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
