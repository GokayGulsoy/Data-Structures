package ceng112.iyte.edu.tr.HW4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileIO {

	public void readProductsAndCommandsFromCSVfile(Inventory productInventory) {

		try {

			File csvFile = new File("hw3_example_inputs.csv");
			Scanner fileReader = new Scanner(csvFile);

			while (fileReader.hasNextLine()) {

				String line = fileReader.nextLine();
				StringTokenizer tokenizer = new StringTokenizer(line, ",");

				// add command
				if (tokenizer.countTokens() == 4) {
					tokenizer.nextToken(); // first token is the `add` command itself
					String category = tokenizer.nextToken().strip();
					String name = tokenizer.nextToken().strip();
					int price = Integer.parseInt(tokenizer.nextToken());

					Product product = new Product(name, category, price);
					productInventory.addProduct(product);
				}

				// search command
				else if (tokenizer.countTokens() == 2) {
					tokenizer.nextToken(); // first token is the command `search` itself
					String nameString = tokenizer.nextToken().strip();

					// creating product object for searching
					Product product = new Product(nameString, null, 0);
					productInventory.searchProduct(product);
				}

				// list command
				else {
					tokenizer.nextToken(); // first token is the command `list` itself
					productInventory.listProducts();
				}

			}

			fileReader.close();

		}

		catch (FileNotFoundException e) {
			System.out.println("File for reading products and commands does not exist");
			System.exit(0);
		}

	}

}
