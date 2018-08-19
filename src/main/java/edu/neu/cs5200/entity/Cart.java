//package edu.neu.cs5200.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@PrimaryKeyJoinColumn(name = "id")
//public class Cart {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "cart")
//    private List<Item> items;
//
//    @OneToOne(mappedBy = "cart")
//    private int customerId;
//
//    @JsonIgnore
//    @OneToOne(mappedBy = "cart")
//    private int restaurantId;
//
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public List<Item> getItems() {
//        if(items == null) {
//            items = new ArrayList<Item>();
//        }
//        return items;
//    }
//
//    public void setItems(List<Item> items) {
//        this.items = items;
//        for(Item item: items) {
//            item.getName();
//            item.getPrice();
//        }
//    }
//
//    public int getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(int customerId) {
//        this.customerId = customerId;
//    }
//
//    public int getRestaurantId() {
//        return restaurantId;
//    }
//
//    public void setRestaurantId(int restaurantId) {
//        this.restaurantId = restaurantId;
//    }
//
//    public void set(Cart newCart) {
//        setId(newCart.getId());
//        setItems(newCart.getItems());
//        setCustomerId(newCart.getCustomerId());
//        setRestaurantId(newCart.getRestaurantId());
//    }
//}
