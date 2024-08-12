package iyte.edu.tr.CENG112.HW2;

public class Demo {

	 public void simulateFoodStore() {
		 
		 Tuna[] tunaArray = new Tuna[30];
		 Corn[] cornArray = new Corn[30];
		 Pudding[] puddingArray = new Pudding[30];
		 InstantNoodle[] instantNoodleArray = new InstantNoodle[30];
		 
		 // creating arrays for each food category 
		 fillFoodArray(tunaArray ,createItems("Tuna"));
		 fillFoodArray(cornArray,createItems("Corn"));
		 fillFoodArray(puddingArray,createItems("Pudding"));
		 fillFoodArray(instantNoodleArray,createItems("InstantNoodle"));
		 
		 //  creating pile for each food category 
		 PileOfFoods<Tuna> tunaPile = new PileOfFoods<Tuna>();
		 PileOfFoods<Corn> cornPile = new PileOfFoods<Corn>();
		 PileOfFoods<Pudding> puddingPile = new PileOfFoods<Pudding>();
		 PileOfFoods<InstantNoodle> instantNoodlePile = new PileOfFoods<InstantNoodle>();
		 
		 // filling the Piles 
         fillPile(tunaArray,tunaPile);		 
   		 fillPile(cornArray,cornPile);
   		 fillPile(puddingArray,puddingPile);
   		 fillPile(instantNoodleArray,instantNoodlePile);
   		 
   		 // displaying piles before processing the orders
   		 System.out.println("\n-CONTENTS OF THE TUNA PILE BEFORE PROCESSING THE ORDERS-\n");
   		 displayPile(tunaPile);
   		 System.out.println("\n\n-CONTENTS OF THE CORN PILE BEFORE PROCESSING THE ORDERS-\n");
   		 displayPile(cornPile);
   		 System.out.println("\n\n-CONTENTS OF THE PUDDING PILE BEFORE PROCESSING THE ORDERS-\n");
   		 displayPile(puddingPile);
   		 System.out.println("\n\n-CONTENTS OF THE INSTANT NOODLE PILE BEFORE PROCESSING THE ORDERS-\n");
   		 displayPile(instantNoodlePile);
   		 
   		 // re-filling piles again 
   	     fillPile(tunaArray,tunaPile);		 
		 fillPile(cornArray,cornPile);
		 fillPile(puddingArray,puddingPile);
		 fillPile(instantNoodleArray,instantNoodlePile);
   		 	 
         // Creating an instance of FileIO Class
   		 FileIO fileReader = new FileIO();
   		 WaitingLine<Order>  waitingLine = fileReader.createWaitingLine();
   		 
   		 // displaying the waitingLine of orders
   		 System.out.println("\n\n-CONTENTS OF THE WAITING LINE OF ORDERS-\n");
   		 displayWaitingLine(waitingLine);
   		 
   		 // re-filling the waitingLine of orders
   		 waitingLine = fileReader.createWaitingLine();
   		 
   		 // processing the orders and creating cargoList object
   		 CargoList<CargoPacket> cargoList = processOrders(waitingLine,tunaPile,cornPile,puddingPile,instantNoodlePile);
   		 
   		 // displaying piles after processing the orders
   		 System.out.println("\n\n-CONTENTS OF THE TUNA PILE AFTER PROCESSING THE ORDERS-\n");
   		 
   		 if (tunaPile.isEmpty()) {
   			 System.out.println("Tuna Pile is empty after prcocessing the orders.");
   		 }
   		 
   		 else {
   			 
   			displayPile(tunaPile);
   		 }
   		 
   		 System.out.println("\n\n-CONTENTS OF THE CORN PILE AFTER PROCESSING THE ORDERS-\n");
   		 
   		 if (cornPile.isEmpty()) {
   			 System.out.println("Corn Pile is empty after prcocessing the orders.");
   		 }
   		 
   		 else {
   			 
   			displayPile(cornPile);
   		 }
   		 System.out.println("\n\n-CONTENTS OF THE PUDDING PILE AFTER PROCESSING THE ORDERS-\n");
   		 
   		 if (puddingPile.isEmpty()) {
   			 System.out.println("Pudding Pile is empty after prcocessing the orders.");
   		 }
   		 
   		 else {
   			 
   			displayPile(puddingPile);
   		 }
   		 System.out.println("\n\n-CONTENTS OF THE INSTANT NOODLE PILE AFTER PROCESSING THE ORDERS-\n");
   		 
   		 if (instantNoodlePile.isEmpty()) {
   			 System.out.println("InstantNoodle Pile is empty after prcocessing the orders.");
   		 }
   		 
   		 else {
   			 
   			displayPile(instantNoodlePile);
   		 }
   		 
   		 // displaying the contents of cargoList
   		 System.out.println("\n\n-CONTENTS OF THE CARGO LIST-\n");
   		 displayCargoList(cargoList,30);
   		 
   		 // getting the entry with ID 25 from sorted cargoList
   		 CargoPacket entryTwentyFive = cargoList.getEntry(25);
   		 
   		 // printing the expiration dates of the packaged products inside the packet with ID 25
   		 System.out.println("\nEXPIRATION DATES OF PACKAGED PRODUCTS INSIDE THE CARGO PACKET WITH ID 25:\n ");
   		 System.out.println("1.Expiration date: " + entryTwentyFive.getItemArray()[0].getExpirationDate());
   		 System.out.println("2.Expiration date: " + entryTwentyFive.getItemArray()[1].getExpirationDate());
   		 System.out.println("3.Expiration date: " + entryTwentyFive.getItemArray()[2].getExpirationDate());
   		 
   		 // displaying the contents of cargoList after removing the cargoPacket with ID 20
   		 cargoList.remove(20);
   		 System.out.println("\n\n-CONTENTS OF THE CARGO LIST AFTER REMOVING THE CARGO PACKET WITH ID 20-\n");
   		 displayCargoList(cargoList,29);
   		  		 		 
	 } // end simulateFoodStore
	 	 
	// defining a generic method for creating Tuna,Corn,Pudding,Instant Noodle items 
   	private Item[] createItems(String item) {
		   
		   // first 6 creations are fixed in 2022
		   // creating an array of T type
   		
		   Item[] itemArray = new Item[30];
	   
		   // initializing counter to keep track of array entries
		   int counter = 0;
		   for (int monthNo = 19; monthNo <= 24; monthNo++) {
			      
			    String year = "-22";
			    String month = determineMonth(monthNo);
			     
			    if (item.equals("Tuna")) {
			         	
			    	  Tuna anyItem = new Tuna(); 
					  String expirationDate = month + year;
					  anyItem.setExpirationDate(expirationDate);
					   
				      itemArray[counter] = anyItem;
				      counter++;
			    }
			    
			    else if (item.equals("Corn")) {
			    	
			    	   Corn anyItem = new Corn();
					   String expirationDate = month + year;
					   anyItem.setExpirationDate(expirationDate);
					   
					   itemArray[counter] = anyItem;
					   counter++;
			    }
			    
			    else if (item.equals("Pudding")) {
				  
			    	  Pudding anyItem = new Pudding();
			          String expirationDate = month + year;
				      anyItem.setExpirationDate(expirationDate);
				   
				      itemArray[counter] = anyItem;
				      counter++;
			 
			    }
			    
			    else {
			    	
			    	  InstantNoodle anyItem = new InstantNoodle();
					  String expirationDate = month + year;
				      anyItem.setExpirationDate(expirationDate);
					   
				      itemArray[counter] = anyItem;
				      counter++;
			    }
			    
			   
		   } // end for 
		   
		   int year = 2023;
		   for (int monthNo = 13; monthNo <= 36; monthNo++) {
			  
			   
			   if (monthNo == 25) {
				
				   year = 2024;
			   }
			   
			   String stringYear = year + ""; // converting year to String by concatenation
			   stringYear = "-" + stringYear.substring(2,4);
			   String month = determineMonth(monthNo);
			   
			    if (item.equals("Tuna")) {
			         	
			    	  Tuna anyItem = new Tuna(); 
					  String expirationDate = month + stringYear;
					  anyItem.setExpirationDate(expirationDate);
					   
				      itemArray[counter] = anyItem;
				      counter++;
			    }
			    
			    else if (item.equals("Corn")) {
			    	
			    	   Corn anyItem = new Corn();
					   String expirationDate = month + stringYear;
					   anyItem.setExpirationDate(expirationDate);
					   
					   itemArray[counter] = anyItem;
					   counter++;
			    }
			    
			    else if (item.equals("Pudding")) {
				  
			    	  Pudding anyItem = new Pudding();
			          String expirationDate = month + stringYear;
				      anyItem.setExpirationDate(expirationDate);
				   
				      itemArray[counter] = anyItem;
				      counter++;
			 
			    }
			    
			    else {
			    	
			    	  InstantNoodle anyItem = new InstantNoodle();
					  String expirationDate = month + stringYear;
				      anyItem.setExpirationDate(expirationDate);
					   
				      itemArray[counter] = anyItem;
				      counter++;
			    }
			   
			   
		   } // end for
			   
		   // returning the itemArray which is ordered from earliest expirationDate to latest 
		   return itemArray;
		   
	 } // end createItems	 
		   
	 private String determineMonth(int month) {
		 
		  int monthNo = month % 12; 
		 // switch-case statement 
		 switch (monthNo) {
		 
			 case  1:
				 return "Jan";
		     
			 case 2:
				 return "Feb";
			 case 3: 
				 return "Mar";
			 case 4: 
				 return "Apr";
			 case 5:
				 return "May";
			 case 6: 
				 return "Jun";
			 case 7: 
				 return "Jul";
			 case 8:
				 return "Aug";
			 case 9:
				 return "Sep";
			 case 10:
				 return "Oct";
			 case 11:
				 return "Nov";
			 case 0:
				 return "Dec";
		    // default block will be never used
			// it is placed just to keep compiler satisfied
			default: 
				return null; 			 
				 
	  }// end switch case
		 
	 } // end determineMonth 
	
	 
	 // method that fills each food array
	 @SuppressWarnings("unchecked")
	private <T extends Item> void fillFoodArray(T[] foodArray,Item[] itemArray) {
		 
	                	 
		 // copying entries of itemArray to foodArray
         for (int index = 0; index <= 29; index++) {
        	 
        	 
        	 foodArray[index] = (T) itemArray[index];
         } 
	 }  // end fillFoodArray
	 
	 // method that fills the piles for a given food category
	 private <T> void fillPile(T[] itemArray,PileOfFoods<T> itemPile) {
		 
		 for (int index = 29; index >= 0; index--) {
			 
	           itemPile.push(itemArray[index]);    		 
		 } // end for
	 
	 } // end fillPile 
	 
	 private <T> void displayPile(PileOfFoods<T> anyPile) {
		 
	
		    while (!anyPile.isEmpty()) {
		    	
		    	try {
		    		
		    		System.out.println(anyPile.pop());
		    	}
		    	
		    	catch (EmptyStackException e) {
		    		
		    		System.out.println("Trying to remove from an empty stack.");
		    		System.exit(0);		    		
		    	}
		    } // end while
	
	 } // end displayPile 
	 
	 
	 private void displayWaitingLine(WaitingLine<Order> waitingLine) {
		    

		    while (!waitingLine.isEmpty()) {
		    	
		    	try {
		    		
		    		System.out.println(waitingLine.dequeue());
		    	}
		    	
		    	catch (EmptyQueueException e) {
		    		
		    		System.out.println("Trying to remove from an empty queue.");
		    		System.exit(0);		    		
		    	}
		    } // end while
		    
	 } // end displayWaitingLine
	 
	 
	 private CargoList<CargoPacket> processOrders(WaitingLine<Order> waitingLine,PileOfFoods<Tuna> tunaPile,PileOfFoods<Corn> cornPile,PileOfFoods<Pudding> puddingPile,PileOfFoods<InstantNoodle> noodlePile) {
		 
		 // creating CargoList object
		 CargoList<CargoPacket> cargoList = new CargoList<CargoPacket>();
		 
		 // processing orders
		 while (!(waitingLine.isEmpty())) {
			 
			 CargoPacket cargoPacket = new CargoPacket();
			 
			 try {
				Order anyOrder = waitingLine.dequeue();
				
				// setting ID and processDate of cargoPacket object
				cargoPacket.setID(anyOrder.getId());
				cargoPacket.setProcessDate(anyOrder.getDate());
			    
				String[] foodArray = anyOrder.getFoodArray();
				for (String food: foodArray) {
			          
					  if (food.equals("tuna")) {
						  
						  Tuna tunaItem = tunaPile.pop();
						  cargoPacket.setItem(tunaItem);
					  }
					
					  else if (food.equals("corn")) {
						  
						  Corn cornItem = cornPile.pop();
						  cargoPacket.setItem(cornItem);
					  }
					  
					  else if (food.equals("pudding")) {
						  
						  Pudding puddingItem = puddingPile.pop();
						  cargoPacket.setItem(puddingItem);
					  }
					
					  else if (food.equals("noodle")) { // food is the noodle case
						  
						  InstantNoodle noodleItem = noodlePile.pop();
						  cargoPacket.setItem(noodleItem);
					  }
		 			
				} // end for
		
				cargoList.add(cargoPacket);
				
			}  // end try
			 
			catch (EmptyQueueException | EmptyStackException e) {
				
				e.printStackTrace();
			}
						 
		 } // end while
		 
		 // at the end of the while loop we will have formed our cargoList, but 
		 // it is not sorted according to IDs
		 
		 sortCargoList(cargoList);
		 
		 return cargoList;
	 } // end processOrders
	 
	 private void sortCargoList(CargoList<CargoPacket> cargoList) {
		 
		 // we will use Insertion Sort algorithm to sort 
		 // the list according to IDs
         
		 CargoPacket key; 
		 for (int i = 2; i <= cargoList.getLength();i++) {
			   
			 
			 key = cargoList.getEntry(i);
			 int keyId = Integer.parseInt(key.getID());
			 // inserting key to correct location in the list
			 
			 int j = i - 1;
			 int previousId = Integer.parseInt(cargoList.getEntry(j).getID());
			 
			 while ((j >= 1) && (previousId > keyId)) {
				 
			    
				cargoList.replace(j+1,cargoList.getEntry(j));
				j = j - 1;
				
				// update the with the Id otf the new entry to be compared
				if (j != 0) {
								
				previousId = Integer.parseInt(cargoList.getEntry(j).getID());
				}
				
			 } 
			 
			 cargoList.replace(j+1,key);
		 } 
		     
	 } // end sortCargoList
	 
	 private void displayCargoList(CargoList<CargoPacket> cargoList,int numberOfEntries) {
		  
              for (int i = 1; i <= numberOfEntries; i++) {
              			 
              			 
              	CargoPacket cargoPacket = cargoList.getEntry(i);
              	System.out.println(cargoPacket);
              }
	 } // end displayCargoList
	
	 
} // end Demo
