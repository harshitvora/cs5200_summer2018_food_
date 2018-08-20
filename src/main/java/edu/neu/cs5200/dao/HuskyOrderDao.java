package edu.neu.cs5200.dao;

import edu.neu.cs5200.entity.HuskyOrder;
import edu.neu.cs5200.entity.Item;
import edu.neu.cs5200.entity.Restaurant;
import edu.neu.cs5200.entity.User;
import edu.neu.cs5200.repository.HuskyOrderRepository;
import edu.neu.cs5200.repository.RestaurantRepository;
import edu.neu.cs5200.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class HuskyOrderDao {

    @Autowired
    HuskyOrderRepository huskyOrderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    public HuskyOrder createOrder(HuskyOrder huskyOrder) {
        return huskyOrderRepository.save(huskyOrder);
    }

    public HuskyOrder createNewOrder(List<Item> items, int restaurantId, int userId) {
        HuskyOrder order = new HuskyOrder();
        Optional<User> user = userRepository.findById(userId);
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        float amount = 0;
        if(user.isPresent() && restaurant.isPresent()){
            order.setCustomer(user.get());
            order.setRestaurant(restaurant.get());
            order.setItems(items);
            for(Item item : items){
                amount = amount + item.getPrice();
            }
            order.setStatus("PENDING");
            order.setAmount(amount);
            return huskyOrderRepository.save(order);
        }

        return null;
    }

    public HuskyOrder updateOrder(int id, HuskyOrder newHuskyOrder) {
        Optional<HuskyOrder> optional = huskyOrderRepository.findById(id);
        if (optional.isPresent()) {
            HuskyOrder huskyOrder = optional.get();
            huskyOrder.set(newHuskyOrder);
            return huskyOrderRepository.save(huskyOrder);
        }
        return null;
    }


    public HuskyOrder acceptOrder(HuskyOrder huskyOrder, int huskyId) {
        Optional<User> husky = userRepository.findById(huskyId);
        if(husky.isPresent()){
            huskyOrder.setStatus("ACCEPTED");
            User huskyObject = husky.get();
            huskyOrder.setHusky(huskyObject);
            huskyObject.addOrder(huskyOrder);
            userRepository.save(huskyObject);
            return huskyOrderRepository.save(huskyOrder);
        }
        return null;
    }

    public void deleteOrder(int id) {
        huskyOrderRepository.deleteById(id);
    }

    public void deleteAllOrderes() {
        huskyOrderRepository.deleteAll();
    }

    public List<HuskyOrder> findAllOrders() {
        return (List<HuskyOrder>) huskyOrderRepository.findAll();
    }

    public Optional<HuskyOrder> findOrderById(int id) {
        return huskyOrderRepository.findById(id);
    }

    public List<HuskyOrder> findOrderByCustomerId(int customerId) {
        return (List<HuskyOrder>) huskyOrderRepository.findByCustomerId(customerId);
    }

    public List<HuskyOrder> findOrderByHuskyId(int huskyId) {
        return (List<HuskyOrder>) huskyOrderRepository.findByHuskyId(huskyId);
    }

    public List<HuskyOrder> findAvailableOrders() {
        return (List<HuskyOrder>) huskyOrderRepository.findAvailable();
    }
}
