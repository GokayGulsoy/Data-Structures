package iyte.edu.tr.CENG112.HW3;

public interface SortedListInterface<T extends Comparable<? super T>> 
{
	/**
	   Adds a new entry to this list in its proper order 
	   list's size is increased by 1
	   @param newEntry The object to be added as a new entry
	*/
	 
	public void add(T newEntry);
	
	/**
	  Removes the first or only occurence of a specified entry
	  from this list 
	  @param The position of the object to be removed.
	  @return True if anEntry was located and removed
	          otherwise returns false.
	*/
	 
	public boolean remove(int givenPosition);
	
	/**
	  Gets the position of an entry in this sorted list.
	  @param anEntry  The object to be found.
	  @return The position o the first or only occurence of anEntry
	          if it occurs in the list;otherwise returns the position
	          where anEntry would occur in the list, but as a negative
	          integer.
	*/
	
    public int getPosition(T anEntry); 	
	
	/**
	  Removes all entries from the list  
	*/
	 
    public void clear();
    
    /**
     Retrieves the entry at a given position in the list.
     @param givenPosition An integer that indicates the position of
            the desired entry.
     @return A reference to the indicated entry.       
     @throws IndexOutOfBoundsException if either 
             givenPosition < 1 or givenPosition > getLength()
    */
     
    public T getEntry(int givenPosition);
	
    /**
      Retrives all entries that are in this list in order in which 
      they occur in the list.
      @return A newly allocated array of all entries in the list.
      if the list is empty,the returned array is empty.
    */
     
    public T[] toArray(T[] anyArray);
    
    /**
      Sees whether this list contains a givenEntry.
      @param anEntry The object that is the desired entry.
      @return True if list contains anEntry,or false if not.
    */
    
    public boolean contains(T anEntry);
    
    /**
      Gets the length of this list
      @return The integer number of entries currently in the list. 
    */
    
    public int getLength();
    
    /**
      Sees whether this list is empty.
      @return True if the list is empty,or false if not.
    */
    
    public boolean isEmpty();
       
} // end SortedListInterface
