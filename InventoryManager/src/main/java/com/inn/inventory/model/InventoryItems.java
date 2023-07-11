package com.inn.inventory.model;

/*Create a spring boot project which can do the following:
A rest API that accepts an image file and stores in the memory DB.
A get API which prints the same image on the browser.
An API to perform inventory management
We have to create an inventory for the shop where the user has a different category of the item which he /she have to manage and track record of it.
Design database accordingly.
Create an API to create the item in inventory.
Create an API to update the status of the item in inventory.
Create an API to fetch all the information on the inventory.
Create an API to remove the item from inventory.
Create an API to get the stock of the inventory.*/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*Create a spring boot project which can do the following:
A rest API that accepts an image file and stores in the memory DB.
A get API which prints the same image on the browser.
An API to perform inventory management
We have to create an inventory for the shop where the user has a different category of the item which he /she have to manage and track record of it.
Design database accordingly.
Create an API to create the item in inventory.
Create an API to update the status of the item in inventory.
Create an API to fetch all the information on the inventory.
Create an API to remove the item from inventory.
Create an API to get the stock of the inventory.*/

import lombok.Data;

@Data
@Entity
public class InventoryItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String category;
	private String status;
}
