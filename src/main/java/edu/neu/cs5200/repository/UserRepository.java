package edu.neu.cs5200.repository;

import edu.neu.cs5200.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("from User u where u.firstName=:firstName and u.lastName=:lastName")
    public Optional<User> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("from User u where u.email=:email and u.password=:password")
    public Optional<User> findByCredentials(@Param("email") String email, @Param("password") String password);
}
