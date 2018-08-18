package edu.neu.cs5200.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Husky extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @OneToMany(mappedBy = "husky")
//    private List<HuskyOrder> huskyOrders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public List<HuskyOrder> getHuskyOrders() {
//        return huskyOrders;
//    }
//
//    public void setHuskyOrders(List<HuskyOrder> huskyOrders) {
//        this.huskyOrders = huskyOrders;
//    }

    public void set(Husky newHusky){
        setFirstName(newHusky.getFirstName());
        setLastName(newHusky.getLastName());
        setPassword(newHusky.getPassword());
        setEmail(newHusky.getEmail());
//        setHuskyOrders(newHusky.getHuskyOrders());
    }
}
