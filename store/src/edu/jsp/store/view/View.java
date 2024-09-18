package edu.jsp.store.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.jsp.store.controller.Controller;
import edu.jsp.store.model.Store;
import edu.jsp.store.model.product;

public class View {
//	static: The variable myInput belongs to the class itself, not to any specific instance of the class. This means there is only one copy
//	of this variable shared across all instances of the class.
//	Scanner: This indicates the type of the variable, which is Scanner from the java.util package. Scanner is used for reading input, typically from the console.
//	myInput: This is the name of the variable.
//	new Scanner(System.in): This initializes the myInput variable by creating a new Scanner object that reads from the standard input stream (System.in)
//	, which is typically the keyboard.
	static Scanner myInput = new Scanner(System.in);
//	static: The variable controller belongs to the class itself, not to any specific instance of the class. 
//	This means there is only one copy of this variable shared across all instances of the class.
//	Controller: This indicates the type of the variable, which is Controller, presumably a custom class defined elsewhere in the code.
//	controller: This is the name of the variable.
//	new Controller(): This initializes the controller variable by creating a new Controller object.
	static Controller controller = new Controller();
//	static: The variable store belongs to the class itself, not to any specific instance of the class
//	. This means there is only one copy of this variable shared across all instances of the class.
//	Store: This indicates the type of the variable, which is presumably a custom class named Store.
//	store: This is the name of the variable.
//	controller.getStore(): This calls the getStore method on the controller object. As per the previous explanations, 
//	getStore creates and returns a new Store object, and assigns it to the static variable store.
	static Store store = controller.getStore();
	static {
		System.out.println("********** Enter the details of your store **********");
		System.out.print("Enter id: ");
		store.setId(myInput.nextInt());
		myInput.nextLine();
		System.out.print("Enter Store Name: ");
		store.setName(myInput.nextLine());
		System.out.print("Enter contact: ");
		store.setContact(myInput.nextLong());
		myInput.nextLine();
		System.out.print("Enter address: ");
		store.setAddress(myInput.nextLine());
		System.out.println();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		do {
			System.out.println("select options from below list");
			System.out.println(
					"1.Display store information\n2.Add product\n3.Display all product\n4.Update\n5.Remove Product \n6.Add Products \n0.Exit");
			System.out.println("Enter the digit respective to desire option : ");
			byte userChoice = myInput.nextByte();
			myInput.nextLine();
			switch (userChoice) {
			case 0:
				System.out.println("********** E X I T E D **********");
				System.exit(0);
				break;
			case 1:
				System.out.println(store + "\n");
				break;
			case 2:
				controller.addProduct(getProductDetails());
				System.out.println(store.getProducts());

				break;
			case 3:
				displayAllProducts();
				break;
			case 4:
				displayAllProducts();
				System.out.println("Enter product id to update : ");
				int productIdToUpdate = myInput.nextInt();
				myInput.nextLine();
				System.out.println("1.Name\n2.Price\n3.Quantity\n4.Availability");
				System.out.println("Enter the option : ");
				byte updateOption = myInput.nextByte();
				myInput.nextLine();
				switch (updateOption) {
				case 1:
					System.out.println("Enter the new name of product to update : ");
					String newName = myInput.nextLine();
					controller.updateProductName(productIdToUpdate, newName);
					break;
				case 2:
					System.out.println("Enter the new price of the product: ");
					double newPrice = myInput.nextDouble();
					myInput.nextLine();
					break;
				case 3:
					System.out.println("Enter the new quantity of the product: ");
					int newQuantity = myInput.nextInt();
					myInput.nextLine();
					break;
				case 4:
					System.out.println("Is the product available? true/false: ");
					boolean newAvailability = myInput.nextBoolean();
					myInput.nextLine();
					break;
				default:
					System.out.println("********* INVALID SELECTION *********");
					break;
			}
			break;
			case 5:
				if (displayAllProducts()) {
					boolean flag = true;
					ArrayList<Integer> productIdsToRemove = new ArrayList<Integer>();
					do {
						System.out.print("Enter product id to remove : ");
						int idToRemove = myInput.nextInt();
						myInput.nextLine();
						productIdsToRemove.add(idToRemove);
						System.out.println("Continue adding id to remove? y/n : ");
						if (myInput.next().charAt(0) == 'n') {
							flag = false;
							System.out.println(
									"Your choiced productId is removed from the store... Please check the list of all products ");
						}
					} while (flag);
					controller.removeProducts(productIdsToRemove);
				}
				break;
			case 6:
				controller.addProductS(addProducts());
				System.out.println(store.getProducts());

				break;

			default:
				System.out.println("Invalid Choice");
				break;
			}

		} while (true);

	}

//	public: This method can be called from outside the class.
//	static: This method belongs to the class itself, not to any specific instance of the class.
//	This means it can be called without creating an instance of the class.
//	List<product>: This method returns a List of product objects.
//	addProducts: This is the name of the method.
	public static List<product> addProducts() {

//		This line initializes a new ArrayList to hold product objects. The list is named newProductList.
//		ArrayList<product>: This indicates that newProductList is an ArrayList of product objects.
		ArrayList<product> newProductList = new ArrayList<product>();
//		This line initializes a boolean variable named toContinue and sets it to true. This variable will control the loop that allows users to add multiple products.
		boolean toContinue = true;
//		This line starts a do-while loop. The loop will execute at least once and will continue as long as toContinue is true.
		do {
//			Inside the loop, the method calls getProductDetails() to obtain a new product object
//			(presumably another method that prompts the user for product details and returns a product object).
//			The returned product object is added to newProductList.
			newProductList.add(getProductDetails());
//			The method prints a prompt asking the user whether they want to continue adding products.
//			It reads the next input from the user using myInput.next().charAt(0).
//			myInput is a Scanner object initialized to read from the standard input (typically the keyboard).
//			next() reads the next token (word) from the input.
//			charAt(0) gets the first character of the token.
//			If the first character of the input is 'n', it sets toContinue to false, which will terminate the loop.
			System.out.print("Continue adding products ? y/n : ");
			if (myInput.next().charAt(0) == 'n')
				toContinue = false;
		} while (toContinue);
		return newProductList;
	}

	public static product getProductDetails() {
		System.out.print("Enter id : ");
		int productId = myInput.nextInt();
		myInput.nextLine();
		System.out.print("Enter name : ");
		String productName = myInput.nextLine();
		System.out.print("Enter price : ");
		double productPrice = myInput.nextDouble();
		myInput.nextLine();
		System.out.print("Enter quantity : ");
		int productQuantity = myInput.nextInt();
		myInput.nextLine();
		boolean productAvailabilty = true;
		if (productQuantity <= 0) {
			productAvailabilty = false;
		}
		return new product(productId, productName, productPrice, productQuantity, productAvailabilty);

	}

//	public: This method can be called from outside the class.
//	static: This method belongs to the class itself, not to any specific instance of the class. 
//	This means it can be called without creating an instance of the class.
//	boolean: This method returns a boolean value (true or false).
//	displayAllProducts: This is the name of the method.
	public static boolean displayAllProducts() {
		// table header
//		The method retrieves the list of all products from the controller object by calling its getAllProduct method.
//		List<product>: This indicates that allProducts is a list of product objects.
		List<product> allProducts = controller.getAllProduct();

//		The method checks if the allProducts list is null.
//		If allProducts is null, it prints "No products to display" and returns false.
		if (allProducts == null) {
			System.out.println("No products to display\n");
			return false;
//			
//			If allProducts is not null, the method proceeds to print the table header.
//			System.out.printf is used to format the header line with column names: ID, NAME, PRICE, QUANTITY, and AVAILABILITY.
//			%-5s, %-15s, %-11s, %-10s, %-12s are format specifiers to align the text within the table columns.
		} else {
			System.out.printf("|%-5s|%-15s|%-11s|%-10s|%-12s|", "ID", "NAME", "PRICE", "QUANTITY", "AVAILABILITY");
			System.out.println();

//			The method iterates over each product in the allProducts list.
//			For each product, it prints its details using System.out.printf:
//			product.getId() for the product ID.
//			product.getName() for the product name.
//			product.getPrice() for the product price.
//			product.getQuantity() for the product quantity.
//			product.isAvailability() for the product availability.
//			The same format specifiers are used to align the data within the table columns.
			for (product product : allProducts) {
				System.out.printf("|%-5d|", product.getId());
				System.out.printf("%-15s|", product.getName());
				System.out.printf("%-11f|", product.getPrice());
				System.out.printf("%-10d|", product.getQuantity());
				System.out.printf("%-12b|", product.isAvailability());
				System.out.println();
			}
			return true;
		}

	}

}
