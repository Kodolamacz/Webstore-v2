package com.webstore.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Blazej on 09.02.2018.
 */
@Entity
@Table(name = "products")
public class Product {

    private Long id;
    private double price;
    private int unitsInStock;
    private int getUnitsInOrder;
    private String name;
    private String category;
    private String description;
    private String manufacturer;
    private String condition;
    private Set<CartItem> cartItem = new HashSet<>();

    public Product() {
    }

    public Product(Long id, double price, int unitsInStock, int getUnitsInOrder, String name, String category, String description, String manufacturer, String condition, Set<CartItem> cartItem) {
        this.id = id;
        this.price = price;
        this.unitsInStock = unitsInStock;
        this.getUnitsInOrder = getUnitsInOrder;
        this.name = name;
        this.category = category;
        this.description = description;
        this.manufacturer = manufacturer;
        this.condition = condition;
        this.cartItem = cartItem;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "product_id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "price",nullable = false)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "units_in_stock",nullable = false)
    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    @Column(name = "units_in_order")
    public int getGetUnitsInOrder() {
        return getUnitsInOrder;
    }

    public void setGetUnitsInOrder(int getUnitsInOrder) {
        this.getUnitsInOrder = getUnitsInOrder;
    }

    @Column(name = "name",nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "category",nullable = false)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Column(name = "description",nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "manufacturer",nullable = false)
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Column(name = "condition",nullable = false)
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @OneToMany(mappedBy = "product")
    public Set<CartItem> getCartItem() {
        return cartItem;
    }

    public void setCartItem(Set<CartItem> cartItem) {
        this.cartItem = cartItem;
    }
}
