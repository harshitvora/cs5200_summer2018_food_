package edu.neu.cs5200.dao;

import edu.neu.cs5200.entity.Restaurant;
import edu.neu.cs5200.entity.User;
import edu.neu.cs5200.repository.RestaurantRepository;
import edu.neu.cs5200.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDao {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(int id, User newUser) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User user = optional.get();
            user.set(newUser);
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> findUserById(int id) {
        return userRepository.findById(id);
    }

    public Optional<User> findUserByFirstNameAndLastName(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public Optional<User> findUserByCredentials(String email, String password) {
        return userRepository.findByCredentials(email, password);

    }

    public User registerManager(User newUser, int id) {
        Optional<Restaurant> optional = restaurantRepository.findById(id);
        if (optional.isPresent()) {
            Restaurant restaurantObject = optional.get();
            newUser.setRestaurant(restaurantObject);
            restaurantObject.setManager(newUser);
            restaurantRepository.save(restaurantObject);
            return userRepository.save(newUser);
        }
        return null;
    }
}