package iyte.edu.tr.CENG112.HW2;

public class Tuna extends Item {

	// data fields 
	private String drainedWeight;
	private String ingredients; 
	
	// default constructor
	public Tuna() {
		
		setNetWeight("75 GR");
		drainedWeight = "50 GR";
		ingredients = "tuna,sunflower oil,salt";
	} 
	
	
	// getters (accessors)
	public String getDrainedWeight() {
		
		return drainedWeight;
	}
	
	public String getIngredients() {
		
		return ingredients;
	}
	
	public String toString() {
			
		return "Net Weight: " + getNetWeight() + ", Drained weight: " + drainedWeight + ", Ingredients: " + ingredients + ", Expiration Date: " + getExpirationDate();
	}	
	
} // end Class Tuna
