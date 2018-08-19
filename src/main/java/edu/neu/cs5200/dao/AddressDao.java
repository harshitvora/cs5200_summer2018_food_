package edu.neu.cs5200.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.neu.cs5200.entity.Address;
import edu.neu.cs5200.entity.User;
import edu.neu.cs5200.repository.AddressRepository;
import edu.neu.cs5200.repository.UserRepository;

@Component
public class AddressDao {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserRepository userRepository;

    public Address createAddress(Address address, int userId) {
		Optional<User> optional = userRepository.findById(userId);
        if (optional.isPresent()) {
            User user = optional.get();
            List<Address> addresses = user.getAddresses();
            addresses.add(address);
            user.setAddresses(addresses);
            userRepository.save(user);
            return addressRepository.save(address);
        }
    	return null;
    }

    public Address updateAddress(int id, Address newAddress) {
        Optional<Address> optional = addressRepository.findById(id);
        if (optional.isPresent()) {
            Address address = optional.get();
            address.set(newAddress);
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
