package CENG112.iyte.edu.tr.HW1;

public interface BagInterface<T> {
	
	/** counts the total number of entries in array bag and returns it
    @return total number of filled entries in the arrayBag
   */

	public int getCurrentSize(); 
	
	/**
	   checks whether the arrayBag is empty
	   @return true if the arrayBag is empty, and false otherwise
	*/
	
	 public boolean isEmpty();
	 
	 /** 
	   adds a new entry to arrayBag, if the arrayBag is full 
	   calls the method doubleTheSize ,and then adds the new entry 
	   @param new entry to be added
	   @return returns true in any case if nothing exceptional occurs
	 */
	 
	 public boolean add(T newEntry); 
	
	/**
	  removes an unspecified entry from arrayBag
	  @return entry that was removed
	*/
	
	public T remove(); 
	
	/**
	  removes an specified entry from the arrayBag   
	  @param an entry to be removed
	  @return true if the entry was removed successfully,and false otherwise
	*/
	
	public boolean remove(T anEntry);
	
	/**
	  removes all elements from arrayBag  
	*/
	
	public void clear();
	
	/**
	  counts how many times a given entry occures in the arrayBag
	  @param entry that will be counted 
	  @return occurence amount of a given entry
	*/
	 
	public int getFrequencyOf(T anEntry);
	
	/**
	  checks whether the given entry exists in the arrayBag
	  @param entry to be located 
	  @return true if an entry is in the arrayBag,and false otherwise 
	*/
	
	public boolean contains(T anEntry);
	
	/**
	  copies the entries of arrayBag to new array and returns it
	  @param another generic array
	*/
	
	public T[] toArray(T[] anArray);
		

}
