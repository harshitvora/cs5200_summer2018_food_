package edu.neu.cs5200.repository;

import edu.neu.cs5200.entity.HuskyOrder;
import org.springframework.data.repository.CrudRepository;

public interface HuskyOrderRepository extends CrudRepository<HuskyOrder, Integer> {
}
