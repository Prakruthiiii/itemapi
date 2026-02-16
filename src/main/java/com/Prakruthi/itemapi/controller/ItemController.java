package com.Prakruthi.itemapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Prakruthi.itemapi.model.Item;

@RestController
@RequestMapping("/items")
public class ItemController {

    private List<Item> items = new ArrayList<>();


    // ✅ GET ALL ITEMS
    @GetMapping
    public List<Item> getAllItems() {
        return items;
    }


    // ✅ GET ITEM BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(@PathVariable int id) {

        for (Item item : items) {
            if (item.getId() == id) {
                return ResponseEntity.ok(item);
            }
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Item not found");
    }


    // ✅ ADD ITEM (POST)
    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody Item item) {

        // Validation
        if (item.getName() == null || item.getName().isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body("Name is required");
        }

        if (item.getPrice() <= 0) {
            return ResponseEntity
                    .badRequest()
                    .body("Price must be greater than 0");
        }

        items.add(item);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Item added successfully");
    }


    // ✅ UPDATE ITEM
    @PutMapping("/{id}")
    public ResponseEntity<?> updateItem(@PathVariable int id,
                                        @RequestBody Item newItem) {

        for (Item item : items) {

            if (item.getId() == id) {

                if (newItem.getName() != null && !newItem.getName().isEmpty()) {
                    item.setName(newItem.getName());
                }

                if (newItem.getDescription() != null) {
                    item.setDescription(newItem.getDescription());
                }

                if (newItem.getPrice() > 0) {
                    item.setPrice(newItem.getPrice());
                }

                return ResponseEntity.ok("Item updated successfully");
            }
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Item not found");
    }


    // ✅ DELETE ITEM
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable int id) {

        for (Item item : items) {

            if (item.getId() == id) {
                items.remove(item);

                return ResponseEntity.ok("Item deleted successfully");
            }
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Item not found");
    }
}
