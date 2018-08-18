package edu.neu.cs5200.web.service;


import edu.neu.cs5200.dao.CustomerDao;
import edu.neu.cs5200.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    @GetMapping("/api/customer")
    public List<Customer> findAllCustomers() {
        return customerDao.findAllCustomers();
    }

    @GetMapping("/api/customer/{customerId}")
    public Optional<Customer> findCustomerById(@PathVariable("customerId") int id) {
        return customerDao.findCustomerById(id);
    }

//    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/customer/login")
    public Optional<Customer> loginCustomer(@RequestParam("email") String email, @RequestParam("password") String password) {
        return customerDao.findCustomerByCredentials(email, password);
    }

//    @GetMapping("/api/customer/{customerId}/movie")
//    public List<Movie> findMoviesByCustomerId(@PathVariable("customerId") int id) {
//        List<Movie> movies = new ArrayList<>();
//        Optional<Customer> optional = customerDao.findCustomerById(id);
//        if (optional.isPresent()) {
//            Customer customer = optional.get();
//            movies.addAll(customer.getMoviesActed());
//        }
//        return movies;
//    }

//    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerDao.createCustomer(customer);
    }

    @DeleteMapping("/api/customer/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int id) {
        customerDao.deleteCustomer(id);
    }

    @PutMapping("/api/customer/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int id, @RequestBody Customer newCustomer) {
        return customerDao.updateCustomer(id, newCustomer);
    }
}
