package edu.neu.cs5200.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Feature;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String password;
    @Column(unique = true)
    private String email;
    private String pictureUrl;

    @OneToMany(mappedBy = "person")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonFormat(with = Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Phone> phones;

    @OneToMany(mappedBy = "person")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonFormat(with = Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Address> addresses;

    @OneToMany(mappedBy = "person")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CreditCard> creditCards;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public List<Phone> getPhones() {
    	if(phones == null) {
    		phones = new ArrayList<Phone>();
		}
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
        for(Phone phone: phones) {
        	phone.getPhoneNumber();
		}
    }

    public List<Address> getAddresses() {
    	if(addresses == null) {
    		addresses = new ArrayList<Address>();
		}
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
        for(Address address: addresses) {
        	address.getStreet1();
        	address.getStreet2();
        	address.getCity();
        	address.getState();
        	address.getZip();
		}
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
}
