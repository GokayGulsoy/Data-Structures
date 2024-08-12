package iyte.edu.tr.CENG112.HW2;

public interface QueueInterface<T> {

	/**
	   Adds a new entry to the back of this queue
	   @param newEntry An object to be added.
	*/
	
	public void enqueue(T newEntry);
	
	/**
	  Removes and returns the entry at the front of this queue  
	  @return the Object at the front of the queue
	  @throws EmptyQueueException if the queue is empty
	*/
	
	 public T dequeue() throws EmptyQueueException;
	 
	 /**
	   Retrieves the entry at the front of this queue 
	   @return The object at the front of the queue
	   @throws EmptyQueueException if the queue is empty
	 */
	 
	 public T getFront() throws EmptyQueueException;
	 
	 /**
	    Checks whether the queue is empty 
	    @return true if the queue is empty, or false otherwise
	 */
	 
	 public boolean isEmpty();
	 
	 /**
	   Removes all entries from the queue
	 * @throws EmptyQueueException 
	 */
	 
	 public void clear() throws EmptyQueueException;
	 
} // end QueueInterface
