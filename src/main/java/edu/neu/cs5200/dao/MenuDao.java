package edu.neu.cs5200.dao;

import edu.neu.cs5200.entity.Menu;
import edu.neu.cs5200.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MenuDao {

    @Autowired
    MenuRepository menuRepository;

    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu updateMenu(int id, Menu newMenu) {
        Optional<Menu> optional = menuRepository.findById(id);
        if (optional.isPresent()) {
            Menu menu = optional.get();
            menu.set(newMenu);
            return menuRepository.save(menu);
        }
        return null;
    }

    public void deleteMenu(int id) {
        menuRepository.deleteById(id);
    }

    public void deleteAllMenues() {
        menuRepository.deleteAll();
    }

    public List<Menu> findAllMenus() {
        return (List<Menu>) menuRepository.findAll();
    }

    public Optional<Menu> findMenuById(int id) {
        return menuRepository.findById(id);
    }

    public List<Menu> findMenuByRestaurantId(int restaurantId) {
        return (List<Menu>) menuRepository.findMenuByRestaurantId(restaurantId);
    }
}
