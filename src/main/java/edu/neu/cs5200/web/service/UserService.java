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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.cs5200.dao.UserDao;
import edu.neu.cs5200.entity.User;

@RestController
public class UserService {

    @Autowired
    UserDao userDao;

    @GetMapping("/api/user")
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    @GetMapping("/api/user/{userId}")
    public Optional<User> findUserById(@PathVariable("userId") int id) {
        return userDao.findUserById(id);
    }

    @GetMapping("/api/user/login")
    public Optional<User> loginUser(@RequestParam("email") String email, @RequestParam("password") String password) {
        return userDao.findUserByCredentials(email, password);
    }

    @GetMapping("/api/user/{userId}/follow/{followId}")
    public Boolean isFollowed(@PathVariable("userId") int id, @PathVariable("followId") int followId) {
        return userDao.isFollowed(id, followId);
    }

    @GetMapping("/api/user/{userId}/following")
    public List<User> findFollowingForUser(@PathVariable("userId") int id) {
        return userDao.findFollowingForUser(id);
    }

    @PostMapping("/api/user")
    public User createUser(@RequestBody User user) {
        return userDao.createUser(user);
    }

    @CrossOrigin(origins = "https://huskyeats.herokuapp.com/")
    @DeleteMapping("/api/user/{userId}")
    public void deleteUser(@PathVariable("userId") int id) {
        userDao.deleteUser(id);
    }

    @CrossOrigin(origins = "https://huskyeats.herokuapp.com/")
    @PutMapping("/api/user/{userId}")
    public User updateUser(@PathVariable("userId") int id, @RequestBody User newUser) {
        return userDao.updateUser(id, newUser);
    }

    @CrossOrigin(origins = "https://huskyeats.herokuapp.com/")
    @PutMapping("/api/user/restaurant/{restaurantId}")
    public User registerManager(@PathVariable("restaurantId") int id, @RequestBody User newUser) {
        return userDao.registerManager(newUser, id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/api/user/{userId}/follow/{followId}")
    public User followUser(@PathVariable("userId") int id, @PathVariable("followId") int followId) {
        return userDao.followUser(id, followId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/user/{userId}/follow/{followId}")
    public User unfollowUser(@PathVariable("userId") int id, @PathVariable("followId") int followId) {
        return userDao.unfollowUser(id, followId);
    }
}
