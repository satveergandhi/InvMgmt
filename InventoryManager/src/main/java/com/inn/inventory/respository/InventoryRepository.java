package com.inn.inventory.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inn.inventory.model.InventoryItems;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItems, Long> {

	public int countByCategory(String category);
}
