package edu.neu.cs5200.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zip;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean primaryAddress;

    @ManyToOne
    private Person person;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public boolean isPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(boolean primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void set(Address newAddress){
        setStreet1(newAddress.getStreet1());
        setStreet2(newAddress.getStreet2());
        setCity(newAddress.getCity());
        setState(newAddress.getState());
        setZip(newAddress.getZip());
        setPrimaryAddress(newAddress.isPrimaryAddress());
    }
}
