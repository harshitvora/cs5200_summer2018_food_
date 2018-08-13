package edu.neu.cs5200.dao;

import edu.neu.cs5200.entity.Phone;
import edu.neu.cs5200.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PhoneDao {

    @Autowired
    PhoneRepository phoneRepository;

    public Phone createPhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    public Phone updatePhone(int id, Phone newPhone) {
        Optional<Phone> optional = phoneRepository.findById(id);
        if (optional.isPresent()) {
            Phone phone = optional.get();
            phone.set(newPhone);
            return phoneRepository.save(phone);
        }
        return null;
    }

    public void deletePhone(int id) {
        phoneRepository.deleteById(id);
    }

    public void deleteAllPhonees() {
        phoneRepository.deleteAll();
    }

    public List<Phone> findAllPhones() {
        return (List<Phone>) phoneRepository.findAll();
    }

    public Optional<Phone> findPhoneById(int id) {
        return phoneRepository.findById(id);
    }

    public List<Phone> findPhonesByPersonId(int personId) {
        return (List<Phone>) phoneRepository.findByPersonId(personId);
    }
}
