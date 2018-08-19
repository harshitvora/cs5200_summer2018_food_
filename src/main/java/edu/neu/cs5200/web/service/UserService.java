package edu.neu.cs5200.web.service;


import edu.neu.cs5200.dao.UserDao;
import edu.neu.cs5200.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    //    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/user/login")
    public Optional<User> loginUser(@RequestParam("email") String email, @RequestParam("password") String password) {
        return userDao.findUserByCredentials(email, password);
    }

//    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/user/{userId}/follow/{followId}")
    public Boolean isFollowed(@PathVariable("userId") int id, @PathVariable("followId") int followId) {
        return userDao.isFollowed(id, followId);
    }

    @GetMapping("/api/user/{userId}/following")
    public List<User> findFollowingForUser(@PathVariable("userId") int id) {
        return userDao.findFollowingForUser(id);
    }

//    @GetMapping("/api/user/{userId}/movie")
//    public List<Movie> findMoviesByUserId(@PathVariable("userId") int id) {
//        List<Movie> movies = new ArrayList<>();
//        Optional<User> optional = userDao.findUserById(id);
//        if (optional.isPresent()) {
//            User user = optional.get();
//            movies.addAll(user.getMoviesActed());
//        }
//        return movies;
//    }

    //    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/user")
    public User createUser(@RequestBody User user) {
        return userDao.createUser(user);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/api/user/{userId}")
    public void deleteUser(@PathVariable("userId") int id) {
        userDao.deleteUser(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/api/user/{userId}")
    public User updateUser(@PathVariable("userId") int id, @RequestBody User newUser) {
        return userDao.updateUser(id, newUser);
    }

    @CrossOrigin(origins = "http://localhost:3000")
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
