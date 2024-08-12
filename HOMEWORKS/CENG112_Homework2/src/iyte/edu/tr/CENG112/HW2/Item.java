package iyte.edu.tr.CENG112.HW2;

public abstract class Item {

	  // data fields 
	  private String expirationDate;
	  private String netWeight;
	   
	
	 // setter for expirationDate
   	 public void setExpirationDate(String expirationDate) {
			
	    	this.expirationDate = expirationDate;
	 } 
   	 
   	 public void setNetWeight(String netWeight) {
   		 
   		 this.netWeight = netWeight;
   	 }
   	 
	  
	// getters (accessors) 
   	public String getExpirationDate() { 
			
    		return expirationDate;
	}
   	
   	public String getNetWeight() {
			
			return netWeight;
	} 
   	
	    
} // end Abstract Class Item