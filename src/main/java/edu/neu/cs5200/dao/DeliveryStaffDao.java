package edu.neu.cs5200.dao;

import edu.neu.cs5200.entity.DeliveryStaff;
import edu.neu.cs5200.repository.DeliveryStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DeliveryStaffDao {

    @Autowired
    DeliveryStaffRepository deliveryStaffRepository;

    public DeliveryStaff createDeliveryStaff(DeliveryStaff deliveryStaff) {
        return deliveryStaffRepository.save(deliveryStaff);
    }

    public DeliveryStaff updateDeliveryStaff(int id, DeliveryStaff newDeliveryStaff) {
        Optional<DeliveryStaff> optional = deliveryStaffRepository.findById(id);
        if (optional.isPresent()) {
            DeliveryStaff deliveryStaff = optional.get();
            deliveryStaff.set(newDeliveryStaff);
            return deliveryStaffRepository.save(deliveryStaff);
        }
        return null;
    }

    public void deleteDeliveryStaff(int id) {
        deliveryStaffRepository.deleteById(id);
    }

    public void deleteAllDeliveryStaffs() {
        deliveryStaffRepository.deleteAll();
    }

    public List<DeliveryStaff> findAllDeliveryStaffs() {
        return (List<DeliveryStaff>) deliveryStaffRepository.findAll();
    }

    public Optional<DeliveryStaff> findDeliveryStaffById(int id) {
        return deliveryStaffRepository.findById(id);
    }

    public List<DeliveryStaff> findDeliveryStaffByFirstNameAndLastName(String firstName, String lastName) {
        return (List<DeliveryStaff>) deliveryStaffRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<DeliveryStaff> findDeliveryStaffByCredentials(String username, String password) {
        return (List<DeliveryStaff>) deliveryStaffRepository.findByCredentials(username, password);
    }
}
