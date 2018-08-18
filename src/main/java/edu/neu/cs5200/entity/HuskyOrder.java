package edu.neu.cs5200.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class HuskyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float amount;
    private String status;
    @ManyToOne
    private User customer;
    @ManyToOne
    @JsonIgnore
    private User husky;
    @ManyToOne
    private Restaurant restaurant;
    @ManyToMany
    @JoinTable(name = "HuskyOrderItems",
            joinColumns = @JoinColumn(name = "orderId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "itemId", referencedColumnName = "id"))
    private List<Item> items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getHusky() {
        return husky;
    }

    public void setHusky(User husky) {
        this.husky = husky;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void set(HuskyOrder newHuskyOrder){
        setAmount(newHuskyOrder.getAmount());
        setStatus(newHuskyOrder.getStatus());
        setCustomer(newHuskyOrder.getCustomer());
        setHusky(newHuskyOrder.getHusky());
        setRestaurant(newHuskyOrder.getRestaurant());
        setItems(newHuskyOrder.getItems());
    }
}
