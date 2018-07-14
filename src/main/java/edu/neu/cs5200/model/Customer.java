package edu.neu.cs5200.model;

import java.sql.Date;

public class Customer extends Person {
    private int id;
    private String preferredLocation;
    private String ccNumber;
    private String cvv;
    private int expiryMM;
    private int expiryYY;

    public Customer(int id, String firstName, String lastName, String username, String password, String email, Date dob, String preferredLocation, String ccNumber, String cvv, int expiryMM, int expiryYY, int personId) {
        this.id = id;
        setFirstName(firstName);
        setLastName(lastName);
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setDob(dob);
        setPersonId(personId);
        this.preferredLocation = preferredLocation;
        this.ccNumber = ccNumber;
        this.cvv = cvv;
        this.expiryMM = expiryMM;
        this.expiryYY = expiryYY;
    }

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
}
