package com.webstore.domain;

import javax.persistence.*;

/**
 * Created by Blazej on 09.02.2018.
 */
@Entity
@Table(name = "address")
public class Address {

    private long id;
    private String country;
    private String state;
    private String city;
    private String street;
    private int houseNo;
    private String zipCode;
    private User user;

    public Address() {
    }

    public Address(long id, String country, String state, String city, String street, int houseNo, String zipCode, User user) {
        this.id = id;
        this.country = country;
        this.state = state;
        this.city = city;
        this.street = street;
        this.houseNo = houseNo;
        this.zipCode = zipCode;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "address_id",unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "country",nullable = false)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "state",nullable = false)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "city",nullable = false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "street",nullable = false)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "houseNo",nullable = false)
    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    @Column(name = "zipCode",nullable = false)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Column(name = "user_id")
    @OneToOne(mappedBy = "address")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
