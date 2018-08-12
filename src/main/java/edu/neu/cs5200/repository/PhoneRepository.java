package edu.neu.cs5200.repository;

import edu.neu.cs5200.entity.Phone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PhoneRepository extends CrudRepository<Phone, Integer> {

    @Query("from Phone p where p.person.id=:personId")
    public Iterable<Phone> findByPersonId(@Param("personId") int personId);
}
