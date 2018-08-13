package edu.neu.cs5200.repository;

import edu.neu.cs5200.entity.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Integer> {
}
