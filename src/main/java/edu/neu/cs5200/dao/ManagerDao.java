package edu.neu.cs5200.dao;

import edu.neu.cs5200.entity.Manager;
import edu.neu.cs5200.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ManagerDao {

    @Autowired
    ManagerRepository managerRepository;

    public Manager createManager(Manager manager) {
        return managerRepository.save(manager);
    }

    public Manager updateManager(int id, Manager newManager) {
        Optional<Manager> optional = managerRepository.findById(id);
        if (optional.isPresent()) {
            Manager manager = optional.get();
            manager.set(newManager);
            return managerRepository.save(manager);
        }
        return null;
    }

    public void deleteManager(int id) {
        managerRepository.deleteById(id);
    }

    public void deleteAllManagers() {
        managerRepository.deleteAll();
    }

    public List<Manager> findAllManagers() {
        return (List<Manager>) managerRepository.findAll();
    }

    public Optional<Manager> findManagerById(int id) {
        return managerRepository.findById(id);
    }

    public List<Manager> findManagerByFirstNameAndLastName(String firstName, String lastName) {
        return (List<Manager>) managerRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<Manager> findManagerByCredentials(String username, String password) {
        return (List<Manager>) managerRepository.findByCredentials(username, password);
    }
}
