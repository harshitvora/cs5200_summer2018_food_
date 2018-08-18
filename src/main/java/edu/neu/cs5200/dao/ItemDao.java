package edu.neu.cs5200.dao;

import edu.neu.cs5200.entity.Item;
import edu.neu.cs5200.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ItemDao {

    @Autowired
    ItemRepository itemRepository;

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(int id, Item newItem) {
        Optional<Item> optional = itemRepository.findById(id);
        if (optional.isPresent()) {
            Item item = optional.get();
            item.set(newItem);
            return itemRepository.save(item);
        }
        return null;
    }

    public void deleteItem(int id) {
        itemRepository.deleteById(id);
    }

    public void deleteAllItems(int menuId) {
        itemRepository.deleteById(menuId);
    }

    public List<Item> findAllItems() {
        return (List<Item>) itemRepository.findAll();
    }

    public List<Item> findAllItemsByName(String itemName) {
        return (List<Item>) itemRepository.findItemsByName(itemName);
    }

    // TODO find items for a given menuId

    public Optional<Item> findItemById(int id) {
        return itemRepository.findById(id);
    }
}
