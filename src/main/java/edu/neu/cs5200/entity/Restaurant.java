package edu.neu.cs5200.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String url;
    private String email;
    @OneToMany(mappedBy = "restaurant")
    private List<Review> reviews;
    @OneToMany(mappedBy = "restaurant")
    private List<HuskyOrder> huskyOrders;
    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<HuskyOrder> getHuskyOrders() {
        return huskyOrders;
    }

    public void setHuskyOrders(List<HuskyOrder> huskyOrders) {
        this.huskyOrders = huskyOrders;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public void set(Restaurant newRestaurant){
        setName(newRestaurant.getName());
        setUrl(newRestaurant.getUrl());
        setEmail(newRestaurant.getEmail());
        setReviews(newRestaurant.getReviews());
        setHuskyOrders(newRestaurant.getHuskyOrders());
        setMenus(newRestaurant.getMenus());
    }
}
