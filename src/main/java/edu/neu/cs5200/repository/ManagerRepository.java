package edu.neu.cs5200.repository;

import edu.neu.cs5200.entity.Manager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ManagerRepository extends CrudRepository<Manager, Integer> {

    @Query("from Manager c where c.firstName=:firstName and c.lastName=:lastName")
    public Iterable<Manager> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("from Manager c where c.email=:email and c.password=:password")
    public Iterable<Manager> findByCredentials(@Param("email") String email, @Param("password") String password);
}