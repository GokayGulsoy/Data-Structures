package iyte.edu.tr.CENG112.HW2;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileIO {
     
	public WaitingLine<Order> createWaitingLine() {
		
		 // creating WaitingLine object
		 WaitingLine<Order> waitingLine = new WaitingLine<Order>();
		
		 // filling order array   
		 Order[] orderArray = createOrderObjects();
		 
		 for (int index = 0; index <= 29; index++) {
			  
			 waitingLine.enqueue(orderArray[index]);
		 } // end for
		 
		 return waitingLine;
	} // end createWaitingLine
		
	private Order[] createOrderObjects() {
		
		// creating Order array 
		Order[] orderArray = new Order[30];
		
		// creating Scanner Class object for reading csv file
		Scanner inputStream = null; 
		
		try {
			
			inputStream  = new Scanner(new FileInputStream("orders.csv"));
		}
		
		catch (FileNotFoundException e) {
			
			System.out.println("File path was not found.");
			System.exit(0);
			
		}
		
		// variable to keep track of orderArray's entries
		int numberOfEntries = 0;
		
		while (inputStream.hasNextLine()) {
			
			
			String line = inputStream.nextLine();
			// creating StringTokenizer Object
			StringTokenizer tokenizer = new StringTokenizer(line,",");
			// creating Order object
			Order anyOrder = new Order();
			
			String ID = tokenizer.nextToken();
			String date = tokenizer.nextToken();
			String food1 = tokenizer.nextToken().trim();
			String food2 = tokenizer.nextToken().trim();
			String food3 = tokenizer.nextToken().trim();
			
			// setting the data fields of the anyOrder object 
			anyOrder.setID(ID);
			anyOrder.setOrederDate(date);
			anyOrder.setFood(food1);
			anyOrder.setFood(food2);
			anyOrder.setFood(food3);
			
			orderArray[numberOfEntries] = anyOrder;
			numberOfEntries++;
			
		} // end while
		
		// At the end of the while loop array of order objects will have formed
		// from earliest order date to latest order date
		
		return orderArray;
	} // end createOrderObjects

} // end FileIO
 