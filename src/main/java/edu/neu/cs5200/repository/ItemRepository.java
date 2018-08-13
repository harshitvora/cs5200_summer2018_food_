package edu.neu.cs5200.repository;

import edu.neu.cs5200.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}
