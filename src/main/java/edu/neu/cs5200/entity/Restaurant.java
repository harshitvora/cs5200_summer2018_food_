package edu.neu.cs5200.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Restaurant {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String url;
    private String email;
    @OneToMany(mappedBy = "restaurant")
    private List<Review> reviews;
    @OneToMany(mappedBy = "restaurant")
    @JsonIgnore
    private List<HuskyOrder> huskyOrders;
    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus;
    private Integer avgCostForTwo;
    private Double aggregateRating;
    private Double latitude;
    private Double longitude;
    private String imageUrl;

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

    public Integer getAvgCostForTwo() {
        return avgCostForTwo;
    }

    public void setAvgCostForTwo(Integer avgCostForTwo) {
        this.avgCostForTwo = avgCostForTwo;
    }

    public Double getAggregateRating() {
        return aggregateRating;
    }

    public void setAggregateRating(Double aggregateRating) {
        this.aggregateRating = aggregateRating;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void set(Restaurant newRestaurant){
        setName(newRestaurant.getName());
        setUrl(newRestaurant.getUrl());
        setEmail(newRestaurant.getEmail());
        setReviews(newRestaurant.getReviews());
        setHuskyOrders(newRestaurant.getHuskyOrders());
        setMenus(newRestaurant.getMenus());
        setAvgCostForTwo(newRestaurant.getAvgCostForTwo());
        setAggregateRating(newRestaurant.getAggregateRating());
    }
}
