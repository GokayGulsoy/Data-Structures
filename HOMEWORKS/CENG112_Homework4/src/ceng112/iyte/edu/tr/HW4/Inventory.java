package ceng112.iyte.edu.tr.HW4;

import treepackage.BinarySearchTree;

public class Inventory {

	private BinarySearchTree<Product> productInventory;

	public Inventory() {
		productInventory = new BinarySearchTree<Product>();
	}

	// method that adds the product to inventory
	public void addProduct(Product product) {
		// delegates addition to underlying
		// BinarySearchTree object productInventory
		System.out.println("Adding: ");
		System.out.println("		Product: " + product.getName() + ", Category:" + product.getCategory() + ", Price: "
				+ product.getPrice() + "₺");
		productInventory.add(product);
	}

	// method that searches an entry in inventory
	public void searchProduct(Product product) {
		// delegates searching to underlying
		// BinarySearchTree object productInventory
		if (productInventory.contains(product)) {
			Product searchedProduct = productInventory.getEntry(product);
			System.out.println("Searching: ");
			System.out.println("	Found:" + searchedProduct.getName() + "(" + searchedProduct.getCategory() + "):"
					+ searchedProduct.getPrice() + "₺");
		}

		else {
			System.out.println("Searching: ");
			System.out.println("	Not Found:" + product.getName());
		}

	}

	// method that lists all products in inventory
	public void listProducts() {
		// delegates listing to underlying
		// BinarySearchTree object productInventory
		System.out.println("List: ");

		productInventory.inOrderTraverse();
	}

	// method that removes the given product from inventory
	public void removeProduct(Product product) {
		// delegates removal to underlying
		// BinarySearchTree object productInventory
		productInventory.remove(product);
	}

}
