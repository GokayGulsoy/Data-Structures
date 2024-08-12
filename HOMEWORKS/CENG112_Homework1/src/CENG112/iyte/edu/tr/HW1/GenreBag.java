package CENG112.iyte.edu.tr.HW1;

import java.util.Arrays;

public class GenreBag<T> implements BagInterface<T> {

	// data fields of genreBag class
	private T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 25;
	private boolean initialized = false;
	
	
	// paramaterized constructor for genreBag class
	public GenreBag(int capacity) {
		
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[])new Object[DEFAULT_CAPACITY];
		bag = tempBag;
		numberOfEntries = 0;
		initialized = true;
	}
	
	// no-argument (default) constructor for genreBag class
	public GenreBag() {
		
		// default constructor of class calls the paramaterized constructor 
		this(DEFAULT_CAPACITY);
	}
	
	
	@Override
	public int getCurrentSize() {
		
		return numberOfEntries;
	}
	
	
	public boolean isEmpty() {
		
		return numberOfEntries == 0;
	}
		
	public boolean add(T anEntry) {
		  
	    checkInitialized();
	 
	    if (isArrayFull()) {
			doubleTheSize();
				
		}
			
		bag[numberOfEntries] = anEntry;
		numberOfEntries++;	
			
		return true;	    
	}
	
	public T remove() {
		
		T result = null;
		if(!isEmpty()) {
			 
		   result = bag[numberOfEntries-1];   	
		   bag[numberOfEntries-1] = null;			
		   numberOfEntries--;
		}
		
		return result;
		
	}
	
	public boolean remove(T anEntry) {
		
		checkInitialized();
		int index = getIndexOf(anEntry);
		T result = removeEntry(index);
		return result.equals(anEntry);
	}
    
	
	public void clear() {
		
		while(!isEmpty()) {
			
			remove();
		}
	}
	
	
   public int getFrequencyOf(T anEntry) {
		
		checkInitialized();
		int counter = 0;
		
		for (int index = 0; index < numberOfEntries; index++) {
			
			if (anEntry.equals(bag[index])) {
				
				counter++;
			}
		}
		
		return counter;
	}
	
	
   public boolean contains(T anEntry) {
	   
	   checkInitialized();
	   return getIndexOf(anEntry) > -1;
   }
   
   
   @SuppressWarnings("unchecked")
public T[] toArray(T[] a) {
	   
	   if (a.length < numberOfEntries) {
		    // Making an array of a's runtime type 
		    return (T[]) Arrays.copyOf(bag,numberOfEntries,a.getClass());
		   
	   }
	      
	   System.arraycopy(bag,0,a,0,numberOfEntries);
	   
	   if (a.length > numberOfEntries) {
		   
		   a[numberOfEntries] = null;
	   }
	   
	   return a;
   
   }	
	
	// helper methods that are called inside other public methods
	
	/* 
	  checks whether the genreBag is full, returns true if it is full,
	  and returns false otherwise
	*/
	private boolean isArrayFull() {
		
		return numberOfEntries >= bag.length;		
	}
	
	
	// checks whether the arrayBag is initialized properly
	private void checkInitialized() {
		
		if (!initialized) {
			 
			throw new SecurityException("genreBag was not initialized properly");
		}
		
	}
	
	// returns the index of the given entry (first occurence)
	private int getIndexOf(T anEntry) {
		
		int where = -1;
		boolean found = false;
		int index = 0;
		while ((!found) && (index < numberOfEntries)) {
			
			if (anEntry.equals(bag[index])) {
				
				found = true;
				where = index;
			}
			

			index++;			
		}
		
		/* if where > -1 then entry if found in genreBag and it is
		   equal to bag[where], otherwise entry was not found.
		*/
		return where; 
	}
	
	
	/*removes the entry at the given index and returns it,
	  if the entry doesn't exist or genreBag is empty returns null
	*/
	private T removeEntry(int index) {
		
		  T result = null;
		  
		  if (!isEmpty() && (index >= 0)) {
			  
			  result = bag[index];
			  bag[index] = bag[numberOfEntries-1];
			  bag[numberOfEntries-1] = null;
			  numberOfEntries--;
		  }
		
		  return result;
	}
	
	
	/* method doubles the size of genreBag
	   if the genreBag is full
	*/
	 private void doubleTheSize() {
		 
		 int newLength = 2*bag.length;
		 bag = Arrays.copyOf(bag,newLength);
	 }
		
}
