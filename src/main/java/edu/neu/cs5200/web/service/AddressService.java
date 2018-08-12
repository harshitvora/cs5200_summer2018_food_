package edu.neu.cs5200.web.service;

import edu.neu.cs5200.dao.AddressDao;
import edu.neu.cs5200.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/api/address")
    public Address createAddress(@RequestBody Address address) {
        return addressDao.createAddress(address);
    }

    @DeleteMapping("/api/address/{addressId}")
    public void deleteAddress(@PathVariable("addressId") int id) {
        addressDao.deleteAddress(id);
    }

    @PutMapping("/api/address/{addressId}")
    public Address updateAddress(@PathVariable("addressId") int id, @RequestBody Address newAddress) {
        return addressDao.updateAddress(id, newAddress);
    }
}