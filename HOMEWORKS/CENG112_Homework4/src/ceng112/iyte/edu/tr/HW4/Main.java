package ceng112.iyte.edu.tr.HW4;

public class Main {

	public static void main(String[] args) {

		// creating an object of Inventory class
		Inventory productInventory = new Inventory();

		// creating an object of FileIO class
		FileIO csvReader = new FileIO();

		// running the app via passing productInventory
		// object to readProductsAndCommandsFromCSVfile
		// method of FileIO class object
		csvReader.readProductsAndCommandsFromCSVfile(productInventory);
	}

}
