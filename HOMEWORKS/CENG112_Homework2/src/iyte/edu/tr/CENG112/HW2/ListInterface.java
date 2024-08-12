package iyte.edu.tr.CENG112.HW2;

public interface ListInterface<T> {

	/**
	   Adds a new entry to the end of this list 
	   The list size is increased by 1
	   @param newEntry the object to be added as a new Entry
	*/
	 
	 public void add(T newEntry);
	 
	 /**
	   Adds a new entry at a specified position within this list
	   The list size is increased by 1
	   @param new Position an integer that specifies the desired position
	   @param newEntry The object to be added as a newEntry
	   @throws IndexOutOfBoundsException if either the 
	           newPosition < 1 or newPosition > getLength().	   
	 */
	 
	 public void add (int givenPosition,T newEntry);
	 
	 /**
	   Removes the entry at a given position from the list
	   list's size is decreased by 1
	   @param givenPosition an integer that indicates the position of the 
	                        entry to be removed
	   @return A reference to the removed entry.
	   @throws IndexOutOfBoundsException if either 
	           givenPosition < 1 or givenPosition > getLength().                  
	 */
	 
	  public T remove(int givenPosition);
	  
	 /** Removes all entries from this list. */
	 
	  public void clear();
	  
	  /**
	   Replaces the entry at a given position in the list
	   @param givenPosition an integer that indicates the position
	                        of the entry to be removed 
	   @param newEntry The object that will replace the entry at the
	                   givenPosition
	   @return the original  entry that was replaced                      
	   @throws IndexOutOfBoundsException  if either 
	           givenPosition < 1 or givenPosition > getLength().
	  */
	   
	  public T replace(int givenPosition,T newEntry);
	  
	  /**
	    Retrieves the entry at a given location in the list
	    @param givenPosition An integer that indicates the position of the 
	           entry to be retrieved
	    @return A reference to the indicated entry        
	    @throws IndexOutOfBoundsException if either 
	            givenPosition < 1 or givenPosition > getLength().
	  */
	  
	  public T getEntry(int givenPosition);
	   
	  /**
	    Retrieves all the entries in the list in the order in which they occur
	    in the list.
	    @return A newly allocated array of all the entries in the list
	            if the list is empty, returned array is empty.
	  */
	
	   public T[] toArray();
	   
	   /**
	     Checks whether the list contains a given entry
	     @param anEentry The Object to be checked   
	     @return True if the list contains anEntry,or false if not
	   */
	    
	   public boolean contains(T anEntry);
	   
	   /**
	     Gets the length of the list
	     @return The number of entries currently in the list
	   */
       
	   public int getLength();
	   
	   /**
	     Checks whether the list is empt.
	     @return True if the list is empty, or false if not
	   */
	  
        public boolean isEmpty();
	
} // end ListInterface
