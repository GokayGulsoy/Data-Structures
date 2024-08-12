package iyte.edu.tr.CENG112.HW2;
public interface StackInterface<T> {

	/**
	    Adds a new entry at the top of the stack
	    @param newEntry to be added to top of the stack 
	*/
	 
	public void push(T newEntry);
	
	/**
	  Removes and returns the top entry of the stack 
	  @return object at the top of the stack 
	  @throws EmptyStackException if the stack is empty 
	*/
	
	public T pop() throws EmptyStackException;
	
	/**
	 Retrieves the stacks top entry 
	 @return Object at the top of the stack
	 @throws EmptyStackException if the stack is empty  
	*/
	
	public T peek() throws EmptyStackException;
	
	/**
	  Checks whether the stack is empty  
	  @return true if the stack is empty
	*/
	 
	public boolean isEmpty();
	
	/**
	 Removes all entries from the stack   
	 * @throws EmptyStackException 
	*/
	 
	public void clear() throws EmptyStackException;

	
} // end StackInterface
