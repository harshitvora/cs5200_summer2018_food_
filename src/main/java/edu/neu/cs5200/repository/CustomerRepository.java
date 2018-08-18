package edu.neu.cs5200.repository;

import edu.neu.cs5200.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query("from Customer c where c.firstName=:firstName and c.lastName=:lastName")
    public Optional<Customer> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("from Customer c where c.email=:email and c.password=:password")
    public Optional<Customer> findByCredentials(@Param("email") String email, @Param("password") String password);
}
