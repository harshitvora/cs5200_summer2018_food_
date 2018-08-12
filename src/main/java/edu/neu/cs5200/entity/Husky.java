package edu.neu.cs5200.entity;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Husky extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void set(Husky newHusky){
        setFirstName(newHusky.getFirstName());
        setLastName(newHusky.getLastName());
        setUsername(newHusky.getUsername());
        setPassword(newHusky.getPassword());
        setEmail(newHusky.getEmail());
        setDob(newHusky.getDob());
    }
}
