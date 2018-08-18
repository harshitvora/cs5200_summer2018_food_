package edu.neu.cs5200.repository;

import edu.neu.cs5200.entity.Husky;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface HuskyRepository extends CrudRepository<Husky, Integer> {

    @Query("from Husky h where h.firstName=:firstName and h.lastName=:lastName")
    public Iterable<Husky> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("from Husky h where h.email=:email and h.password=:password")
    public Iterable<Husky> findByCredentials(@Param("email") String email, @Param("password") String password);
}