package edu.neu.cs5200.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.cs5200.dao.HuskyOrderDao;
import edu.neu.cs5200.entity.HuskyOrder;
import edu.neu.cs5200.entity.Item;

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

    @PostMapping("/api/order/restaurant/{restaurantId}/user/{userId}")
    public HuskyOrder createOrder(@RequestBody List<Item> items, @PathVariable("restaurantId") int restaurantId, @PathVariable("userId") int userId) {
        return huskyOrderDao.createNewOrder(items, restaurantId, userId);
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
