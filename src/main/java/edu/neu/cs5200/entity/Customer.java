package edu.neu.cs5200.entity;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Customer extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String preferredLocation;
    private String ccNumber;
    private String cvv;
    private int expiryMM;
    private int expiryYY;

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

    public void set(Customer newCustomer){

    }
}
