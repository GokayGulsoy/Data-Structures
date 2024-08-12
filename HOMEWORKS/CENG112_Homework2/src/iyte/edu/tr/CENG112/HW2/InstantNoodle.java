package iyte.edu.tr.CENG112.HW2;

public class InstantNoodle extends Item {
 
	// data fields 
	private String simmerDuration;
	
	// default constructor 
	public InstantNoodle() {
		
		setNetWeight("120 GR");
		simmerDuration = "3 min";
	}
	
	// getters (accessors)
	public String getSimmerDuration() {
		
		return simmerDuration;
	}
	
	public String toString() {
		
		return "Net weight: " + getNetWeight() + ", Simmer Duration: " + simmerDuration + " , Expiration Date: " + getExpirationDate();
	}
	
} // end Class InstantNoodle
