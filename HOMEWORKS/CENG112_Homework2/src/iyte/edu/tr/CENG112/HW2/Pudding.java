package iyte.edu.tr.CENG112.HW2;

public class Pudding extends Item {

	// data fields 
	private String flavor;
	
	// default contructor 
	public Pudding() {
		
		setNetWeight("120 GR");
		flavor = "banana";
	}
	
	// getters (accessors) 
	
	public String getFlavor() {
		
		return flavor;
	}
	
	public String toString() {
		
		return "Net Weight: " + getNetWeight() + ", Flavor: " + flavor +  " , Expiration Date: " + getExpirationDate();
	}

} // end Class Pudding 
