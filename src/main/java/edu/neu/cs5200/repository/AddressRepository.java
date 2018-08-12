package edu.neu.cs5200.repository;

import edu.neu.cs5200.entity.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends CrudRepository<Address, Integer> {

    @Query("from Address a where a.person.id=:personId")
    public Iterable<Address> findByPersonId(@Param("personId") int personId);
}
