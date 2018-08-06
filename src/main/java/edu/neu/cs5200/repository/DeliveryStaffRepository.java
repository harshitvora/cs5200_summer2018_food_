package edu.neu.cs5200.repository;

import edu.neu.cs5200.entity.DeliveryStaff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DeliveryStaffRepository extends CrudRepository<DeliveryStaff, Integer> {

    @Query("from DeliveryStaff c where c.firstName=:firstName and c.lastName=:lastName")
    public Iterable<DeliveryStaff> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("from DeliveryStaff c where c.username=:username and c.password=:password")
    public Iterable<DeliveryStaff> findByCredentials(@Param("username") String username, @Param("password") String password);
}