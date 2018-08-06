package edu.neu.cs5200.web.service;


import edu.neu.cs5200.dao.DeliveryStaffDao;
import edu.neu.cs5200.entity.DeliveryStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DeliveryStaffService {

    @Autowired
    DeliveryStaffDao deliveryStaffDao;

    @GetMapping("/api/deliveryStaff")
    public List<DeliveryStaff> findAllDeliveryStaffs() {
        return deliveryStaffDao.findAllDeliveryStaffs();
    }

    @GetMapping("/api/deliveryStaff/{deliveryStaffId}")
    public Optional<DeliveryStaff> findDeliveryStaffById(@PathVariable("deliveryStaffId") int id) {
        return deliveryStaffDao.findDeliveryStaffById(id);
    }

//    @GetMapping("/api/deliveryStaff/{deliveryStaffId}/movie")
//    public List<Movie> findMoviesByDeliveryStaffId(@PathVariable("deliveryStaffId") int id) {
//        List<Movie> movies = new ArrayList<>();
//        Optional<DeliveryStaff> optional = deliveryStaffDao.findDeliveryStaffById(id);
//        if (optional.isPresent()) {
//            DeliveryStaff deliveryStaff = optional.get();
//            movies.addAll(deliveryStaff.getMoviesActed());
//        }
//        return movies;
//    }

    @PostMapping("/api/deliveryStaff")
    public DeliveryStaff createDeliveryStaff(@RequestBody DeliveryStaff deliveryStaff) {
        return deliveryStaffDao.createDeliveryStaff(deliveryStaff);
    }

    @DeleteMapping("/api/deliveryStaff/{deliveryStaffId}")
    public void deleteDeliveryStaff(@PathVariable("deliveryStaffId") int id) {
        deliveryStaffDao.deleteDeliveryStaff(id);
    }

    @PutMapping("/api/deliveryStaff/{deliveryStaffId}")
    public DeliveryStaff updateDeliveryStaff(@PathVariable("deliveryStaffId") int id, @RequestBody DeliveryStaff newDeliveryStaff) {
        return deliveryStaffDao.updateDeliveryStaff(id, newDeliveryStaff);
    }
}
