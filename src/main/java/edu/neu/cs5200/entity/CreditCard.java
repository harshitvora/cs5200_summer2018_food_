package edu.neu.cs5200.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 16, max = 16)
    private String ccNumber;
    @Size(min = 3, max = 4)
    private String cvv;
    @Size(min = 2, max = 2)
    private String expiryMM;
    @Size(min = 2, max = 2)
    private String expiryYY;
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

    public String getExpiryMM() {
        return expiryMM;
    }

    public void setExpiryMM(String expiryMM) {
        this.expiryMM = expiryMM;
    }

    public String getExpiryYY() {
        return expiryYY;
    }

    public void setExpiryYY(String expiryYY) {
        this.expiryYY = expiryYY;
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
        setExpiryYY(newCreditCard.getExpiryYY());
        setExpiryMM(newCreditCard.getExpiryMM());
    }
}
