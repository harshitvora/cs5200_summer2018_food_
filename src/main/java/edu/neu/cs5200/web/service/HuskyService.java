package edu.neu.cs5200.web.service;


import edu.neu.cs5200.dao.HuskyDao;
import edu.neu.cs5200.entity.Husky;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HuskyService {

    @Autowired
    HuskyDao huskyDao;

    @GetMapping("/api/husky")
    public List<Husky> findAllHuskys() {
        return huskyDao.findAllHuskys();
    }

    @GetMapping("/api/husky/{huskyId}")
    public Optional<Husky> findHuskyById(@PathVariable("huskyId") int id) {
        return huskyDao.findHuskyById(id);
    }

//    @GetMapping("/api/husky/{huskyId}/movie")
//    public List<Movie> findMoviesByHuskyId(@PathVariable("huskyId") int id) {
//        List<Movie> movies = new ArrayList<>();
//        Optional<Husky> optional = huskyDao.findHuskyById(id);
//        if (optional.isPresent()) {
//            Husky husky = optional.get();
//            movies.addAll(husky.getMoviesActed());
//        }
//        return movies;
//    }

    @PostMapping("/api/husky")
    public Husky createHusky(@RequestBody Husky husky) {
        return huskyDao.createHusky(husky);
    }

    @DeleteMapping("/api/husky/{huskyId}")
    public void deleteHusky(@PathVariable("huskyId") int id) {
        huskyDao.deleteHusky(id);
    }

    @PutMapping("/api/husky/{huskyId}")
    public Husky updateHusky(@PathVariable("huskyId") int id, @RequestBody Husky newHusky) {
        return huskyDao.updateHusky(id, newHusky);
    }
}
