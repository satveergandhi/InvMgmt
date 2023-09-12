package com.inn.inventory.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inn.inventory.model.InventoryItems;
import com.inn.inventory.service.InventoryService;

@RestController
public class InventoryRestController {
	
	@Autowired
	private InventoryService inventoryService;

	@PostMapping("/inventory/add")
	public ResponseEntity<InventoryItems> addItem(@RequestBody InventoryItems item) {		
		try {
			InventoryItems savedItems = inventoryService.addItem(item);
			if(savedItems!=null) {
				return ResponseEntity.ok(savedItems);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping("/inventory/update/{id}")
	public ResponseEntity<InventoryItems> updateItemStatus(@PathVariable Long id, @RequestBody String status){
		try {
			InventoryItems updatedItem = inventoryService.updateItemStatus(id, status);
			if(updatedItem!=null) {
				return ResponseEntity.ok(updatedItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/inventory/getAll")
	public List<InventoryItems> getAllItems(){
		return inventoryService.getAllItems();
	}
	
	@GetMapping("/inventory/getById/{id}")
	public InventoryItems getItemById(@PathVariable Long id){
		try {
			return inventoryService.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@DeleteMapping("/inventory/remove/{id}")
	public void removeItem(@PathVariable Long id){
		try {
			inventoryService.removeItem(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/inventory/stock")
	public Map<String, Integer> getInventoryStock(){
		try {
			Map<String, Integer> itemStockCount = inventoryService.getInventoryStock();
			return itemStockCount;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
