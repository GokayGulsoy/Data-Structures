package iyte.edu.tr.CENG112.HW2;
public class EmptyStackException extends Exception {
     
	private static final long serialVersionUID = 1L;
	private String message = "Stack is empty";
	   
	   // default constructor
	   public EmptyStackException() {
		    
		   super("Stack is empty");
	   }
	   
	   
	   public EmptyStackException(String message) {
		   
		     super(message);
	   }
	   
	   // getter (accessor)
	   public String getMessage() {
		   
		   return message;
	   }
	   
	   
	   // setter (mutator)
	   public void setMessage(String message) {
		   
		   this.message = message;
	   }
	   	
} // end EmptyStackException 
