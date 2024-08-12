package iyte.edu.tr.CENG112.HW2;
import java.util.Arrays;

public class PileOfFoods<T> implements StackInterface<T> {

	  //  data fields (attributes)
	  private T[] stack; // array of stack entries
	  private int topIndex; // Index of the top entry
	  private boolean initialized = false;
	  private static final int DEFAULT_CAPACITY = 50;
	  private static final int MAX_CAPACITY = 1000;
	  
	  // default constructor
	  public PileOfFoods() {
		  
		  this(DEFAULT_CAPACITY);
	  } // end default (no-argument) constructor
	  
	  
	  // paramaterized constructor 
	  public PileOfFoods(int initialCapacity) {
		  
		  checkCapacity(initialCapacity);
		  
		  // The cast is safe because the array entries are null
		  @SuppressWarnings("unchecked")
		  T[] tempStack = (T[]) new Object[initialCapacity];
		  
		  stack = tempStack;
		  topIndex = -1;
		  initialized = true;
	  } // end paramaterized constructor	  
    
	 public void push(T newEntry) {
		 
		 checkInitialization();
		 ensureCapacity();
		 
		 stack[topIndex+1] = newEntry;
		 topIndex++;	 
	 } // end push 
	 
	 
	 public T peek() throws EmptyStackException {
		 
		 checkInitialization();
		  
		  if (isEmpty()) {
			  
			  throw new EmptyStackException();
		  }
		  
		  else {
			  
			  return stack[topIndex];
		  }
	 } // end peek 
	 
	 
	 public T pop() throws EmptyStackException {
		 
		 if (isEmpty()) {
			 
			 throw new EmptyStackException();
		 }
		 
		 else {
			 
			 T top = stack[topIndex];
			 stack[topIndex] = null;
			 topIndex--;
			 
			 return top;
		 }
	 } // end pop 
	 
	 
	 public boolean isEmpty() {
		 
		 return topIndex < 0;
	 } // end isEmpty
	 
     
	 public void clear() throws EmptyStackException {
		 
		 while(!isEmpty()) {
	        		 
			pop(); 
		 }
	 }
	  
	 private void checkInitialization() {
		 
		 if (!initialized) {
			 
			 throw new SecurityException("Stack is not initialized properly");
		 }
	 } // end checkInitialization 
	
   
	 private void checkCapacity(int capacity) {
		 
		 if (capacity > MAX_CAPACITY) {
			 
			 throw new IllegalStateException("Attempt to create a Stack whose capacity exceeds allowed capacity.");
		 }
	 } // end checkCapacity
	
	 
	 private void ensureCapacity() {
		 
		 if (topIndex == stack.length-1) {
			 
			 int newLength = 2*stack.length;
			 checkCapacity(newLength);
			 stack = Arrays.copyOf(stack,newLength);
		 }
	 }  // end ensureCapacity
	 
	 
} // end PileOfFoods
