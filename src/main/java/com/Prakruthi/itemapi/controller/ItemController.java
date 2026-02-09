package com.Prakruthi.itemapi.controller;

import org.springframework.web.bind.annotation.*;

import com.Prakruthi.itemapi.model.Item;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private List<Item> items = new ArrayList<>();

    // GET - Read all items
    @GetMapping
    public List<Item> getAllItems() {
        return items;
    }

    // POST - Create new item
    @PostMapping
    public String addItem(@RequestBody Item item) {
        items.add(item);
        return "Item added successfully";
    }

    // PUT - Update item
    @PutMapping("/{id}")
    public String updateItem(@PathVariable int id,
                             @RequestBody Item newItem) {

        for (Item item : items) {
            if (item.getId() == id) {
                item.setName(newItem.getName());
                item.setPrice(newItem.getPrice());
                return "Item updated successfully";
            }
        }

        return "Item not found";
    }

    // DELETE - Delete item
    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable int id) {

        for (Item item : items) {
            if (item.getId() == id) {
                items.remove(item);
                return "Item deleted successfully";
            }
        }

        return "Item not found";
    }
}
