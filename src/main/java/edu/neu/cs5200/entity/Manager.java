package edu.neu.cs5200.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Manager extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "supervisor")
    private List<Manager> reports;
    @ManyToOne
    private Manager supervisor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Manager> getReports() {
        return reports;
    }

    public void setReports(List<Manager> reports) {
        this.reports = reports;
    }

    public Manager getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Manager supervisor) {
        this.supervisor = supervisor;
    }

    public void set(Manager newManager){
        setFirstName(newManager.getFirstName());
        setLastName(newManager.getLastName());
        setUsername(newManager.getUsername());
        setPassword(newManager.getPassword());
        setEmail(newManager.getEmail());
        setDob(newManager.getDob());
        setReports(newManager.getReports());
        setSupervisor(newManager.getSupervisor());
    }
}
