package edu.neu.cs5200.web.service;


import edu.neu.cs5200.dao.ManagerDao;
import edu.neu.cs5200.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ManagerService {

    @Autowired
    ManagerDao managerDao;

    @GetMapping("/api/manager")
    public List<Manager> findAllManagers() {
        return managerDao.findAllManagers();
    }

    @GetMapping("/api/manager/{managerId}")
    public Optional<Manager> findManagerById(@PathVariable("managerId") int id) {
        return managerDao.findManagerById(id);
    }

//    @GetMapping("/api/manager/{managerId}/movie")
//    public List<Movie> findMoviesByManagerId(@PathVariable("managerId") int id) {
//        List<Movie> movies = new ArrayList<>();
//        Optional<Manager> optional = managerDao.findManagerById(id);
//        if (optional.isPresent()) {
//            Manager manager = optional.get();
//            movies.addAll(manager.getMoviesActed());
//        }
//        return movies;
//    }

    @PostMapping("/api/manager")
    public Manager createManager(@RequestBody Manager manager) {
        return managerDao.createManager(manager);
    }

    @DeleteMapping("/api/manager/{managerId}")
    public void deleteManager(@PathVariable("managerId") int id) {
        managerDao.deleteManager(id);
    }

    @PutMapping("/api/manager/{managerId}")
    public Manager updateManager(@PathVariable("managerId") int id, @RequestBody Manager newManager) {
        return managerDao.updateManager(id, newManager);
    }
}
