package edu.neu.cs5200.web.service;


import edu.neu.cs5200.dao.MenuDao;
import edu.neu.cs5200.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuService {

    @Autowired
    MenuDao menuDao;

    @GetMapping("/api/menu/restaurant/{restaurantId}")
    public List<Menu> findMenuByRestaurantId(@PathVariable("restaurantId") int id) {
        return menuDao.findMenuByRestaurantId(id);
    }

    @PostMapping("/api/menu/restaurant/{restaurantId}")
    public Menu createMenuForRestaurant(@RequestBody Menu menu, @PathVariable("restaurantId") int id) {
        return menuDao.createMenu(menu, id);
    }

}
