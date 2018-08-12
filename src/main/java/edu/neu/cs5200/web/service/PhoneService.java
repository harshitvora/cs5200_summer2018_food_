package edu.neu.cs5200.web.service;


import edu.neu.cs5200.dao.PhoneDao;
import edu.neu.cs5200.entity.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PhoneService {

    @Autowired
    PhoneDao phoneDao;

    @GetMapping("/api/phone")
    public List<Phone> findAllPhones() {
        return phoneDao.findAllPhones();
    }

    @GetMapping("/api/phone/{phoneId}")
    public Optional<Phone> findPhoneById(@PathVariable("phoneId") int id) {
        return phoneDao.findPhoneById(id);
    }

    @GetMapping("/api/phone/person/{personId}")
    public List<Phone> findPhonesByPersonId(@PathVariable("personId") int personId) {
        return phoneDao.findPhonesByPersonId(personId);
    }

    @PostMapping("/api/phone")
    public Phone createPhone(@RequestBody Phone phone) {
        return phoneDao.createPhone(phone);
    }

    @DeleteMapping("/api/phone/{phoneId}")
    public void deletePhone(@PathVariable("phoneId") int id) {
        phoneDao.deletePhone(id);
    }

    @PutMapping("/api/phone/{phoneId}")
    public Phone updatePhone(@PathVariable("phoneId") int id, @RequestBody Phone newPhone) {
        return phoneDao.updatePhone(id, newPhone);
    }
}
