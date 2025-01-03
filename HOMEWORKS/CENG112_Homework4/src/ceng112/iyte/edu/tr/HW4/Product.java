package ceng112.iyte.edu.tr.HW4;

public class Product implements Comparable<Product> {

	private String name;
	private String category;
	private int price;

	public Product(String name, String category, int price) {
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public int getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int compareTo(Product otherProduct) {

		// compare by category first
		int comparisonByCategory;

		if (category == null) {
			comparisonByCategory = 0;
		}

		else {
			comparisonByCategory = category.compareTo(otherProduct.getCategory());
		}

		// if categories are same, then compare by name
		if (comparisonByCategory == 0) {

			int comparisonByName = name.compareTo(otherProduct.getName());

			// case if names are equal
			if (comparisonByName == 0) {
				return 0;
			}

			else if (comparisonByName < 0) {
				return -1;
			}

			else { // comparisonByName
				return 1;
			}
		}

		else if (comparisonByCategory < 0) {
			return -1;
		}

		else { // comparisonByCategory > 0
			return 1;
		}

	}

	@Override
	public boolean equals(Object object) {

		Product otherProduct = (Product) object;
		// two Product objects are considered equal
		// iff they have same category and name
		boolean equalityByCategory = (category == null) || (category.equals(otherProduct.getCategory()));
		boolean equalityByName = name.equals(otherProduct.getName());

		if (equalityByCategory && equalityByName) {
			return true;
		}

		else {
			return false;
		}

	}

	@Override
	public String toString() {
		return name + "(" + category + "):" + price + "₺";
	}

}
