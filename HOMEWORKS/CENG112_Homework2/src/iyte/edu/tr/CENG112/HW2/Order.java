package iyte.edu.tr.CENG112.HW2;

public class Order {
	
	// data fields 
	private String ID;
	private String date;
	private String[] foodArray;
	private int numberOfEntries;
	
	// default constructor 
	public Order() {
		
		foodArray = new String[3];
		numberOfEntries = 0;
	}
	
	// setters (mutators)
	
	public void setID(String ID) {
		
		this.ID = ID;
	}
	
	public void setOrederDate(String date) {
		
		this.date = date;
	}
	
	public void setFood(String food) {
		
		foodArray[numberOfEntries] = food;
		numberOfEntries++;
	}
	
	// getters (accessors) 
	public String getId() {
		
		return ID;
	}
	
	public String getDate() {
		
		return date;
	}
	
	public String[] getFoodArray() {
		
		return foodArray;
	}
	
	public String toString() {
		
		return "ID: " + ID + " ,Date: " + date + "\t ," + displayFoodArray();
	}
	
	private String displayFoodArray() {
		
		return "[" + foodArray[0] + "," + foodArray[1] + "," + foodArray[2] + "]";
	}
	

} // end Class Order
