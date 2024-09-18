package edu.jsp.store.controller;

import java.util.ArrayList;
import java.util.List;

import edu.jsp.store.model.Store;
import edu.jsp.store.model.product;

public class Controller {
//	public: The variable store is accessible from outside the class.
//	static: The variable store belongs to the class itself, not to any specific instance of the class. This means there is only one copy of this variable shared across all instances of the class.
//	Store: This indicates the type of the variable, which is presumably a custom class named Store.
//	store: This is the name of the variable.
//	= null: This initializes the variable store to null, indicating that it does not reference any Store object initially.
	public static Store store = null;

//	public: This method can be called from outside the class.
//	Store: This is the return type of the method, indicating that the method returns an object of type Store.
//	getStore(): This is the name of the method, and it does not take any parameters.

	public Store getStore() {
//		store = new Store(): This creates a new Store object and assigns it to the store variable. 
//				Because store is a static variable, this assignment affects the store variable at the class level.
//				return store: This returns the newly created Store object.
		return store = new Store();
	}
	
	
//	This method is public, meaning it can be called from outside the class.
//	It returns nothing (void).
//	It takes a single argument: a product object named product. This represents the product to be added to the store.

	public void addProduct(product product) {
//		The method first checks if the store's product list is null. This condition will be true if no products have been added to the store yet.
		if (store.getProducts() == null) {
//			If the product list is null, it initializes a new ArrayList to hold product objects. This sets up an empty list to which products can be added.
			store.setProducts(new ArrayList<product>());
//			The newly created list is retrieved using store.getProducts(), and then the product passed to the method is added to this list using the add method.
			List<product> products = store.getProducts();
			products.add(product);
//			If the product list is not null (i.e., it already exists and may contain products), 
//			the method directly adds the new product to the existing list using the add method.
		} else {
			store.getProducts().add(product);
		}

	}

	
//	This method is public, meaning it can be called from outside the class.
//	It returns nothing (void).
//	It takes a single argument: a List of product objects named newProducts. This list contains the products to be added to the store.
	public void addProductS(List<product> newProducts) {
		
//		If the store's product list is null, it iterates over each product in the newProducts list and calls the addProduct method
//		(presumably a separate method in the class) to add each product individually.
//		If the store's product list is not null, it simply adds all products in newProducts to the store's product list at once using the addAll method.
		
		if (store.getProducts() == null)
			for (product product : newProducts) {
				addProduct(product);
			}
		else
			store.getProducts().addAll(newProducts);
	}
	
	
	
//	This method is public, meaning it can be called from outside the class.
//	It returns a List of product objects.
	public List<product> getAllProduct() {
//		The method returns the list of products currently in the store.
		return store.getProducts();

	}

//	This method is public, meaning it can be called from outside the class.
//	It returns nothing (void).
//	It takes a single argument: a List of Integer objects named products. This list contains the IDs of the products to be removed.
	public void removeProducts(List<Integer> products) {
//		The method retrieves the current list of products from the store object and assigns it to the existingProducts variable.
		List<product> existingProducts = store.getProducts();
//		An ArrayList named productToRemove is initialized. This will store the products that need to be removed.
		ArrayList<product> productToRemove = new ArrayList<product>();
		

//		A for-each loop iterates over each Integer in the products list. Each Integer represents the ID of a product that should be removed.
		// to change target
		for (Integer productTarget : products) {
			
//			The current target product ID is assigned to targetId.
//			Another for-each loop iterates over each product in the existingProducts list. Each product is assigned to productEliminator.
//			If the ID of productEliminator matches targetId, then:
//			Instead of directly removing productEliminator from existingProducts (the commented-out line), it is added to the productToRemove list. 
//			This approach avoids ConcurrentModificationException, which can occur when modifying a list while iterating over it.
			// eleminate target
			int targetId = productTarget;
			for (product productEliminator : existingProducts) {
				if (productEliminator.getId() == targetId) {
//					existingProducts.remove(productEliminator);
					productToRemove.add(productEliminator);
				}
			}

		}
		store.getProducts().removeAll(productToRemove);
	}
	
	public void updateProductName(int productIdToUpdate, String newName) {
		product product = getProduct(productIdToUpdate);
		for (product currentProduct : store.getProducts()) {
			if (currentProduct==product) {
				currentProduct.setName(newName);
			}
		}
	}
	
	public product getProduct(int productId) {
		for (product product : store.getProducts()) {
			if (product.getId()==productId) {
				return product;
			
		}
	}
	return null;
}
}
	
