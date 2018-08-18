package edu.neu.cs5200.repository;

import edu.neu.cs5200.entity.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends CrudRepository<Item, Integer> {
    @Query("from Item i where i.name=:name")
    public Iterable<Item> findItemsByName(@Param("name") String name);
}
