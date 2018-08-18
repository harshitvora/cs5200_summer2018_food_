package edu.neu.cs5200.repository;

import edu.neu.cs5200.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query("from Customer c where c.firstName=:firstName and c.lastName=:lastName")
    public Iterable<Customer> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("from Customer c where c.email=:email and c.password=:password")
    public Iterable<Customer> findByCredentials(@Param("email") String email, @Param("password") String password);
}
