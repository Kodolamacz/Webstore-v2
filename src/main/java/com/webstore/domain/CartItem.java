package com.webstore.domain;

import javax.persistence.*;

/**
 * Created by Blazej on 17.02.2018.
 */
@Entity
@Table(name = "cart_items")
public class CartItem {

    private Long id;
    private Product product;
    private int quantity;
    private double totalPrice;
    private Cart cart;

    public CartItem() {
    }

    public CartItem( Product product, int quantity, double totalPrice, Cart cart) {
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.cart = cart;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cart_item_id",unique = true,nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name = "quantity",nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "total_price",nullable = false)
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @ManyToOne
    @JoinColumn(name = "cart_id")
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
