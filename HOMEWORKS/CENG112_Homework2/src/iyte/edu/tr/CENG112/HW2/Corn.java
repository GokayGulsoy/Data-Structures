package iyte.edu.tr.CENG112.HW2;

public class Corn extends Item {
  
	 // data fields 
	private String drainedWeight;
	private String productionCountry;
	
	// default constructor
	public Corn() {
		
		setNetWeight("220 GR"); 
		drainedWeight = "132 GR";
		productionCountry = "Turkey";
	}

	// getters (accessors)
	public String getDrainedWeight() {
		
		return drainedWeight;
	}
	
	public String getProductionCountry() {
		
		return productionCountry;
	} 
	
	public String toString() {
		 
		
		return "Net Weight: " + getNetWeight() + ", Drained Weight: " + drainedWeight + ", Production Country: " + productionCountry + ", Expiration Date: " + getExpirationDate();
	}

} // end Class Corn
