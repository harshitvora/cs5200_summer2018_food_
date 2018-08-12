package edu.neu.cs5200.entity;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Manager extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void set(Manager newManager){
        setFirstName(newManager.getFirstName());
        setLastName(newManager.getLastName());
        setUsername(newManager.getUsername());
        setPassword(newManager.getPassword());
        setEmail(newManager.getEmail());
        setDob(newManager.getDob());
    }
}
