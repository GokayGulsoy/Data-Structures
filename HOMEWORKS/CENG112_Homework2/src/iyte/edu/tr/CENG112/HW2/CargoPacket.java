package iyte.edu.tr.CENG112.HW2;

public class CargoPacket {

	// data fields 
	private String ID; 
	private String processDate;
	private Item[] itemArray;
	private int numberOfEntries;
	
	// default constructor 
	public CargoPacket() {
		
		
		itemArray = new Item[3];
		numberOfEntries = 0;
	}
	
	// setters (mutators)
	public void setID(String ID) { 
		
		this.ID = ID;
	}
	
	public void setProcessDate(String processDate) {
		
		this.processDate = processDate;
	}
	
	public void setItem(Item anyItem) {
		
		itemArray[numberOfEntries] = anyItem;
		numberOfEntries++;
	}
	
	
   // getters (accessors)
   public String getID() {
	   
	   return ID;
   }
   	
   public String getProcessDate() {
	   
	   return processDate;
   }
   
   
   public Item[] getItemArray() {
	   
	   return itemArray;
   }
   
   public String toString() {
	   
	   return "Packet ID: " + ID + " ,Process Date: " + processDate + " ,Information of foods in packet: \n" + displayFoodArray();
 	   
   }
   
   // method that displays the contents of the foodArray
   private String displayFoodArray() {
	   
	   return "\n1." + itemArray[0].toString() + "\n2." + itemArray[1].toString() + "\n3." + itemArray[2].toString() + "\n";
   }
   
} // end Class CargoPacket
