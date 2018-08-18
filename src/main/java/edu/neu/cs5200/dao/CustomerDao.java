package edu.neu.cs5200.dao;

import edu.neu.cs5200.entity.Customer;
import edu.neu.cs5200.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerDao {

    @Autowired
    CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(int id, Customer newCustomer) {
        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isPresent()) {
            Customer customer = optional.get();
            customer.set(newCustomer);
            return customerRepository.save(customer);
        }
        return null;
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }

    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }

    public List<Customer> findAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Optional<Customer> findCustomerById(int id) {
        return customerRepository.findById(id);
    }

    public List<Customer> findCustomerByFirstNameAndLastName(String firstName, String lastName) {
        return (List<Customer>) customerRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public Optional<Customer> findCustomerByCredentials(String email, String password) {
        List<Customer> customers = (List<Customer>) customerRepository.findByCredentials(email, password);
        Optional<Customer> customer;
        if (customers.isEmpty()) {
            customer = Optional.empty();
        } else {
            customer = Optional.of(customers.get(0));
        }
        return customer;

    }
};