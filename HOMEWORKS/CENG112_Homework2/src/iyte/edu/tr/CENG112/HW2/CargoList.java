package iyte.edu.tr.CENG112.HW2;
import java.util.Arrays;

public class CargoList<T> implements ListInterface<T>  {
           
	   // data fields 
	   private T[] list; // Array of list entries we ignore list[0]
	   private int numberOfEntries;
	   private boolean initialized = false;
	   private static final int DEFAULT_CAPACITY = 25;
	   private static final int MAX_CAPACITY = 10000;
	   
	   public CargoList() {
		   
		   
		   this(DEFAULT_CAPACITY); // call to paramaterized constructor
	   } // end default constructor 
	  
	   
	   public CargoList(int initialCapacity) {
		   
		   // if the initialCapacity is too small
		   if (initialCapacity < DEFAULT_CAPACITY) {
			   
			   initialCapacity = DEFAULT_CAPACITY;
		   }
		   
		   else {
			   
			   checkCapacity(initialCapacity);
			   // The cast is safe because array contains null entries
			   @SuppressWarnings("unchecked")
			   T[] tempList = (T[]) new Object[initialCapacity+1];
			   list = tempList;
			   numberOfEntries = 0;
			   initialized = true;
		   }
	   } // end paramaterized constructor 
	   
	   
	   public void add(T newEntry) {
		   
		   checkInitialization();
		   ensureCapacity();
		   list[numberOfEntries+1] = newEntry;
		   numberOfEntries++;
	   } // end add
	   
	   public T[] toArray() {
		   
		    checkInitialization();
		    
		    // The cast is safe because array contains null entries 
		    @SuppressWarnings("unchecked")
			T[] result = (T[]) new Object[numberOfEntries];
		    
		    for (int index = 0; index < numberOfEntries; index++) {
		    	 
		    	
		    	result[index] = list[index+1];
		    } 
		    
		    return result;
	   } // end toArray
	   
	   
	   public void add(int newPosition,T newEntry) {
		   
		   checkInitialization();
		   ensureCapacity();
		   
		   if ((newPosition >= 1) && (newPosition <= numberOfEntries+1)) {
			   
			   if (newPosition <= numberOfEntries) {
				 
				   makeRoom(newPosition);
			   }
			   
			   
			   list[newPosition] = newEntry;
			   numberOfEntries++;
 		   }
		   
		   else {
			   
			   throw new IndexOutOfBoundsException("Given position is out of bounds for list.");
		   }	   
	   } // end add
	   
	  
	   public int getLength() {
		   
		   return numberOfEntries;
	   } //  end getLength
	   
	   
	   public boolean isEmpty() {
		   
		   return numberOfEntries == 0;
	   } // end isEmpty
	   
	   
	   public T remove(int givenPosition) {
		    
		   checkInitialization();
		   
		   if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			   
			   assert (!isEmpty());

			   T result = list[givenPosition]; // get entry to be removed 
			   // move subsequent entries toward the entry to be removed
			   // unless it is th last in the list
			   if (givenPosition < numberOfEntries) {
				   
				   removeGap(givenPosition);
			   }

			   numberOfEntries--;
			   return result; 
		   }
		   
		   else {
			   
			   throw new IndexOutOfBoundsException("Illegal position is given to remove operation");
		   }  
	   } // end remove
	   
	   
	   public T replace(int givenPosition,T newEntry) {
		   
		     checkInitialization();
		     
		     if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
		    	 
		    	 assert (!isEmpty());
		    	 
		    	 T originalEntry = list[givenPosition]; 
		    	 list[givenPosition] = newEntry;
		    	 return originalEntry;
		     }
		   
		     else {
		    	 
		    	 throw new IndexOutOfBoundsException("Illegal position given to replace operation");
		     }
	   } // end replace
	 
	   
	   public T getEntry(int  givenPosition) {
		   
		     checkInitialization();
		          
		   if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			   
			   assert (!isEmpty());
			   return list[givenPosition];
		   } 
		   
		   else {
			   
			   throw new IndexOutOfBoundsException("Illegal position given to getEntry operation");
		   }		   
	   } // end getEntry
	   
	   
	   public boolean contains(T anEntry) {
		   
		   checkInitialization();
		   
		   boolean found = false;
		   int index = 1;
		    
		   while (!found && (index <= numberOfEntries)) {
			   
			   if (anEntry.equals(list[index])) {
				   
				   found = true;
			   }
			   
			   index++;
		   }
		   
		   return found;
	   } // end contains
	   
	   
	   
		public void clear() {
			
			 while(!isEmpty()) {
				 
				 remove(numberOfEntries);
			 }
		} // end clear 
	   
	   
	   private void checkInitialization() {
		   
		  if (!initialized) {
			  
			  throw new SecurityException("List is not initialized properly");
		  }
	   } //  end checkInitialization
	
	   
	   private void checkCapacity(int capacity) {
		   
		   if (capacity > MAX_CAPACITY) {
			   
			    throw new IllegalStateException("Given capacity exceeds allowed capacity");
		   }
	   }  // end checkCapacity
	   
	   private void makeRoom(int newPosition) {
		    
		   assert (newPosition >= 1 && newPosition <= numberOfEntries+1);
		   
		   int newIndex = newPosition;
		   int lastIndex = numberOfEntries;
		   
		   // moving each entry to next higher entry starting at the end
		   // of the list and continuing until the entry at newIndex is moved
		   for (int index = lastIndex; index >= newIndex; index--) {
			    
			   list[index+1] = list[index];
		   }   
	   } // end make room 
	   
	   
	   private void ensureCapacity() {
		   
		   int capacity = list.length-1;
		   if (numberOfEntries >=  capacity) {
			   
			   int newCapacity = 2 * capacity;
			   checkCapacity(newCapacity); // if the capacity is not too big
			   list = Arrays.copyOf(list,newCapacity+1); 
		   }
	   } // end ensureCapacity
	   
	   private void removeGap(int givenPosition) {
		   
		   
		 assert (givenPosition >= 1) && (givenPosition < numberOfEntries); 
		 
		 int removedIndex = givenPosition;
		 int lastIndex = numberOfEntries;
		 
		 for (int index = removedIndex; index < lastIndex; index++) {
			 
			 
			 list[index] = list[index+1];
		 } 
	   } // removeGap 
	   
} // end CargoList
