package iyte.edu.tr.CENG112.HW3;

public class EmptyQueueException extends Exception {

	private static final long serialVersionUID = 1L;


	public EmptyQueueException()
	{
		
		this("Queue is empty");
	} // default constructor
	
	
	public EmptyQueueException(String exceptionMessage)
	{
		// calling the base class constructor
		super(exceptionMessage);
	} // paramaterized constructor
} // end EmptyQueueException
