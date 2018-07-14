package edu.neu.cs5200.model;

public class Phone {
    private String phoneNumber;
    private boolean primary;
    private int personId;

    public Phone(String phoneNumber, boolean primary, int personId) {
        this.phoneNumber = phoneNumber;
        this.primary = primary;
        this.personId = personId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
