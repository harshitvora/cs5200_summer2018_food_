package edu.neu.cs5200.web.service;


import edu.neu.cs5200.dao.MenuDao;
import edu.neu.cs5200.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuService {

        @Autowired
        MenuDao menuDao;

        @GetMapping("/api/restaurant/menu/{restaurantId}")
        public List<Menu> findMenuByRestaurantId(@PathVariable("restaurantId") int id) {
            List<Menu> m = menuDao.findMenuByRestaurantId(id);
            return menuDao.findMenuByRestaurantId(id);
        }

    }
