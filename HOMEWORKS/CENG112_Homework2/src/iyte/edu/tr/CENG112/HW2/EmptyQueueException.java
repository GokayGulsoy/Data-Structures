package iyte.edu.tr.CENG112.HW2;
public class EmptyQueueException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;
	
	  public EmptyQueueException() {
		  
		  super("Queue is empty");
	  } // end default constructor 
	  
	  
	  public EmptyQueueException(String newMessage) {
		  
		  super(newMessage);
	  } // end paramaterized constructor
	  
	  
	  // setter (mutator)
	  public void setMessage(String message) {
		  
		  this.message = message;
	  }
	  
	  // getter (accessor)
	  public String getMessage() {
		  
	     return message;
	  }
	 	
} // end EmptyQueueException
