package edu.neu.cs5200.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.neu.cs5200.dao.AddressDao;
import edu.neu.cs5200.entity.Address;

@RestController
public class AddressService {

    @Autowired
    AddressDao addressDao;

    @GetMapping("/api/address")
    public List<Address> findAllAddresss() {
        return addressDao.findAllAddresses();
    }

    @GetMapping("/api/address/{addressId}")
    public Optional<Address> findAddressById(@PathVariable("addressId") int id) {
        return addressDao.findAddressById(id);
    }

    @GetMapping("/api/address/person/{personId}")
    public List<Address> findAddresssByPersonId(@PathVariable("personId") int personId) {
        return addressDao.findAddressesByPersonId(personId);
    }
    
    @PostMapping("/api/address/{personId}")
    public Address createAddress(@RequestBody Address address, @PathVariable("personId") int personId) {
        return addressDao.createAddress(address, personId);
    }

    @CrossOrigin(origins = "https://huskyeats.herokuapp.com/")
    @DeleteMapping("/api/address/{addressId}")
    public void deleteAddress(@PathVariable("addressId") int id) {
        addressDao.deleteAddress(id);
    }

    @CrossOrigin(origins = "https://huskyeats.herokuapp.com/")
    @PutMapping("/api/address/{addressId}")
    public Address updateAddress(@PathVariable("addressId") int id, @RequestBody Address newAddress) {
        return addressDao.updateAddress(id, newAddress);
    }
}