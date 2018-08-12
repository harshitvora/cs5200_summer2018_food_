package edu.neu.cs5200.entity;

import javax.persistence.*;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ccNumber;
    private int expiryMM;
    private int expiryDD;
    private String cvv;
    @ManyToOne
    private Person person;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public int getExpiryMM() {
        return expiryMM;
    }

    public void setExpiryMM(int expiryMM) {
        this.expiryMM = expiryMM;
    }

    public int getExpiryDD() {
        return expiryDD;
    }

    public void setExpiryDD(int expiryDD) {
        this.expiryDD = expiryDD;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void set(CreditCard newCreditCard){
        setCcNumber(newCreditCard.getCcNumber());
        setExpiryDD(newCreditCard.getExpiryDD());
        setExpiryMM(newCreditCard.getExpiryMM());
    }
}
