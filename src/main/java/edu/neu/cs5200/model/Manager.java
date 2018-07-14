package edu.neu.cs5200.model;

import java.sql.Date;

public class Manager extends Person {
    private int id;

    public Manager(int id, String firstName, String lastName, String username, String password, String email, Date dob, int personId) {
        this.id = id;
        setFirstName(firstName);
        setLastName(lastName);
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setDob(dob);
        setPersonId(personId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
