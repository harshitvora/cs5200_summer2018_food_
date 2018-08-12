package edu.neu.cs5200.dao;

import edu.neu.cs5200.entity.Husky;
import edu.neu.cs5200.repository.HuskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class HuskyDao {

    @Autowired
    HuskyRepository huskyRepository;

    public Husky createHusky(Husky husky) {
        return huskyRepository.save(husky);
    }

    public Husky updateHusky(int id, Husky newHusky) {
        Optional<Husky> optional = huskyRepository.findById(id);
        if (optional.isPresent()) {
            Husky husky = optional.get();
            husky.set(newHusky);
            return huskyRepository.save(husky);
        }
        return null;
    }

    public void deleteHusky(int id) {
        huskyRepository.deleteById(id);
    }

    public void deleteAllHuskys() {
        huskyRepository.deleteAll();
    }

    public List<Husky> findAllHuskys() {
        return (List<Husky>) huskyRepository.findAll();
    }

    public Optional<Husky> findHuskyById(int id) {
        return huskyRepository.findById(id);
    }

    public List<Husky> findHuskyByFirstNameAndLastName(String firstName, String lastName) {
        return (List<Husky>) huskyRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<Husky> findHuskyByCredentials(String username, String password) {
        return (List<Husky>) huskyRepository.findByCredentials(username, password);
    }
}
