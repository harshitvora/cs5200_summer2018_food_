package edu.neu.cs5200.repository;

import edu.neu.cs5200.entity.CreditCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CreditCardRepository extends CrudRepository<CreditCard, Integer> {

    @Query("from CreditCard c where c.person.id=:personId")
    public Iterable<CreditCard> findByPersonId(@Param("personId") int personId);
}
