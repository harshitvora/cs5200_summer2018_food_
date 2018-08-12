package edu.neu.cs5200.dao;

import edu.neu.cs5200.entity.Address;
import edu.neu.cs5200.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AddressDao {

    @Autowired
    AddressRepository addressRepository;

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(int id, Address newAdress) {
        Optional<Address> optional = addressRepository.findById(id);
        if (optional.isPresent()) {
            Address address = optional.get();
            address.set(newAdress);
            return addressRepository.save(address);
        }
        return null;
    }

    public void deleteAddress(int id) {
        addressRepository.deleteById(id);
    }

    public void deleteAllAddresses() {
        addressRepository.deleteAll();
    }

    public List<Address> findAllAddresses() {
        return (List<Address>) addressRepository.findAll();
    }

    public Optional<Address> findAddressById(int id) {
        return addressRepository.findById(id);
    }

    public List<Address> findAddressesByPersonId(int personId) {
        return (List<Address>) addressRepository.findByPersonId(personId);
    }
}
