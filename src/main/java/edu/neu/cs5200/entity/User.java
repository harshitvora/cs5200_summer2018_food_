package edu.neu.cs5200.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class User extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String preferredLocation;
    private String ccNumber;
    private String cvv;
    private int expiryMM;
    private int expiryYY;

    private String role;

    // customer

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Review> reviews;
    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<HuskyOrder> huskyOrders;

    // delivery staff

    @OneToMany(mappedBy = "husky")
    @JsonIgnore
    private List<HuskyOrder> huskyDeliveries;

    // manager

    @OneToMany(mappedBy = "supervisor")
    private List<User> reports;
    @ManyToOne
    private User supervisor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public int getExpiryMM() {
        return expiryMM;
    }

    public void setExpiryMM(int expiryMM) {
        this.expiryMM = expiryMM;
    }

    public int getExpiryYY() {
        return expiryYY;
    }

    public void setExpiryYY(int expiryYY) {
        this.expiryYY = expiryYY;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    // delivery staff

    public List<HuskyOrder> getHuskyDeliveries() {
        return huskyDeliveries;
    }

    public void setHuskyDeliveries(List<HuskyOrder> huskyDeliveries) {
        this.huskyDeliveries = huskyDeliveries;
    }

    // manager

    public List<User> getReports() {
        return reports;
    }

    public void setReports(List<User> reports) {
        this.reports = reports;
    }

    public User getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(User supervisor) {
        this.supervisor = supervisor;
    }

    public void addReview(Review review){
        this.getReviews().add(review);
        if(review.getCustomer() != this){
            review.setCustomer(this);
        }
    }

    public void set(User newUser) {
        setFirstName(newUser.getFirstName());
        setLastName(newUser.getLastName());
        setPassword(newUser.getPassword());
        setEmail(newUser.getEmail());
        setPreferredLocation(newUser.getPreferredLocation());
        setReviews(newUser.getReviews());
        setHuskyOrders(newUser.getHuskyOrders());
    }
}