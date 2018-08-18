package edu.neu.cs5200.web.service;

import edu.neu.cs5200.dao.ItemDao;
import edu.neu.cs5200.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemService {

    @Autowired
    ItemDao itemDao;

    @GetMapping("/api/item")
    public List<Item> findAllItems() {
        return itemDao.findAllItems();
    }

    @GetMapping("/api/item/{itemId}")
    public Optional<Item> findItemById(@PathVariable("itemId") int itemId) {
        return itemDao.findItemById(itemId);
    }

    @GetMapping("/api/item/{itemName}")
    public List<Item> findAllItemsByName(@PathVariable("itemName") String itemName) {
        return itemDao.findAllItemsByName(itemName);
    }

    @PostMapping("/api/item")
    public Item createItem(@RequestBody Item item) {
        return itemDao.createItem(item);
    }

    @DeleteMapping("/api/item/{itemId}")
    public void deleteItem(@PathVariable("itemid") int itemId) {
        itemDao.deleteItem(itemId);
    }

    @PutMapping("/api/item/{itemId}")
    public Item updateItem(@PathVariable("itemId") int itemId, @RequestBody Item newItem) {
        return itemDao.updateItem(itemId, newItem);
    }
}
