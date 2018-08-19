package edu.neu.cs5200.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.neu.cs5200.entity.Phone;
import edu.neu.cs5200.entity.User;
import edu.neu.cs5200.repository.PhoneRepository;
import edu.neu.cs5200.repository.UserRepository;

@Component
public class PhoneDao {

    @Autowired
    PhoneRepository phoneRepository;
    @Autowired
    UserRepository userRepository;

    public Phone createPhone(Phone phone, int userId) {
    	Optional<User> optional = userRepository.findById(userId);
        if (optional.isPresent()) {
            User user = optional.get();
            List<Phone> phones = user.getPhones();
            phones.add(phone);
            user.setPhones(phones);
            userRepository.save(user);
            return phoneRepository.save(phone);
        }
    	return null;
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
