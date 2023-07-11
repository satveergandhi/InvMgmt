package com.inn.inventory.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inn.inventory.model.InventoryItems;
import com.inn.inventory.respository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	public InventoryItems addItem(InventoryItems item) {		
		return inventoryRepository.save(item);
	}
	
	public InventoryItems updateItemStatus(Long id, String status){
		try {
			Optional<InventoryItems> optionalItems = inventoryRepository.findById(id);
			if(optionalItems.isPresent()) {
				InventoryItems items = optionalItems.get();
				items.setStatus(status);
				return inventoryRepository.save(items);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<InventoryItems> getAllItems(){
		return inventoryRepository.findAll();
	}

	public void removeItem(Long id){
		try {
			inventoryRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public InventoryItems getById(Long id){
		try {
			return inventoryRepository.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Map<String, Integer> getInventoryStock(){
		List<InventoryItems> items = getAllItems();
		Map<String, Integer> stock = new HashMap<>();
		try {
			for(InventoryItems item : items) {
				String category = item.getCategory();
				int count = stock.getOrDefault(category, 0);
				stock.put(category, count+1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stock;
	}
}
