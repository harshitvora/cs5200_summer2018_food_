package edu.neu.cs5200.web.service;

import edu.neu.cs5200.dao.HuskyOrderDao;
import edu.neu.cs5200.entity.HuskyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HuskyOrderService {

    @Autowired
    HuskyOrderDao huskyOrderDao;

    @GetMapping("/api/order")
    public List<HuskyOrder> findAllOrders() {
        return huskyOrderDao.findAllOrders();
    }

    @GetMapping("/api/order/{orderId}")
    public Optional<HuskyOrder> findOrderById(@PathVariable("orderId") int id) {
        return huskyOrderDao.findOrderById(id);
    }

    @GetMapping("/api/order/customer/{customerId}")
    public List<HuskyOrder> findOrdersByCustomerId(@PathVariable("customerId") int customerId) {
        return huskyOrderDao.findOrderByCustomerId(customerId);
    }

    @GetMapping("/api/order/husky/{huskyId}")
    public List<HuskyOrder> findOrdersByHuskyId(@PathVariable("huskyId") int huskyId) {
        return huskyOrderDao.findOrderByHuskyId(huskyId);
    }

    @GetMapping("/api/order/husky/")
    public List<HuskyOrder> findAvailableOrders() {
        return huskyOrderDao.findAvailableOrders();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/api/order/husky/{huskyId}")
    public HuskyOrder acceptOrder(@RequestBody HuskyOrder huskyOrder, @PathVariable("huskyId") int huskyId) {
        return huskyOrderDao.acceptOrder(huskyOrder, huskyId);
    }

    @PostMapping("/api/order")
    public HuskyOrder createOrder(@RequestBody HuskyOrder huskyOrder) {
        return huskyOrderDao.createOrder(huskyOrder);
    }

    @DeleteMapping("/api/order/{orderId}")
    public void deleteOrder(@PathVariable("orderId") int id) {
        huskyOrderDao.deleteOrder(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/api/order/{orderId}")
    public HuskyOrder updateOrder(@PathVariable("orderId") int id, @RequestBody HuskyOrder newHuskyOrder) {
        return huskyOrderDao.updateOrder(id, newHuskyOrder);
    }
}
