package edu.neu.cs5200.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String phoneNumber;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean primaryPhone;
    @ManyToOne
    private Person person;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(boolean primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void set(Phone newPhone){
        setPhoneNumber(newPhone.getPhoneNumber());
        setPrimaryPhone(newPhone.isPrimaryPhone());
    }
}
