package iyte.edu.tr.CENG112.HW2;

public class WaitingLine<T> implements QueueInterface<T> {

	  // data fields 
	  private T[] queue; // circular array that will hold the queue entries with one unused location
	  private int frontIndex;
	  private int backIndex;
	  private boolean initialized = false;
	  private static final int DEFAULT_CAPACITY = 50;
	  private static final int MAX_CAPACITY = 10000;
	  
	  public WaitingLine() { 
		  
		  this(DEFAULT_CAPACITY);
	  } // end default constructor
	  
	  public WaitingLine(int initialCapacity) {
		  
		  checkCapacity(initialCapacity);
	     
		  // the cast is safe because new array contains null entries
		  @SuppressWarnings("unchecked")
		  T[] tempQueue = (T[]) new Object[initialCapacity+1];
		  queue = tempQueue;
		  frontIndex = 0;
		  backIndex = initialCapacity;
		  initialized = true;
	  }   // end paramaterized constructor
	  
	   
	  public void enqueue(T newEntry) {
		  
		  checkInitialization();
		  ensureCapacity();
		  
		  backIndex = (backIndex+1) % queue.length;
		  queue[backIndex] = newEntry;		  
	  } // end enqueue
	  
	  
	  public T getFront() throws EmptyQueueException {
		  
		  checkInitialization();
		  
		  if (isEmpty()) {
			  
			  throw new EmptyQueueException();
		  }
		  
		  else {
		  
		      return queue[frontIndex];
		  }	  
	  } // end getFront
	  
	  
	  public T dequeue() throws EmptyQueueException {
		  
		  checkInitialization();
		  
		  if (isEmpty()) {
			  
			  throw new EmptyQueueException();
		  }
		  
		  else {
			  
			  T front = queue[frontIndex];
			  queue[frontIndex] = null;
			  frontIndex = (frontIndex+1) % queue.length;
			  return front;			  
		  }		  
	  } // end dequeue
	  

	  public boolean isEmpty() {
		  
		 return frontIndex == (backIndex+1) % queue.length;		  
	  } // end isEmpty
	  
	  
	  
	  public void clear() throws EmptyQueueException {
		  
		  while (!isEmpty()) {
			  
			  dequeue();
		  }	  
	  } // end clear
	  
	  
	  private void checkInitialization() {
		  
		  if (!initialized) {
			  
		       throw new SecurityException("Queue is not initialized properly");	  
		  }
	  } // end checkInitialized 
	  
	  
	  
	  
	  private void checkCapacity(int capacity) {
		  
		  if (capacity > MAX_CAPACITY) {
			  
			  throw new IllegalStateException("Given capacity exceeds allowed capacity");
		  }	  
	  }
	  
	  private void ensureCapacity() {
		  
		  if (frontIndex == (backIndex+2) % queue.length) { // if the queue is full
			  
			  T[] oldQueue = queue;
			  int oldSize = oldQueue.length;
			  int newSize = 2*oldSize;
			  
			  checkCapacity(newSize);
			  // doubling the size of array
			  // the cast is safe because array entries are null
			  @SuppressWarnings("unchecked")
			  T[] tempQueue = (T[]) new Object[newSize];
			  queue = tempQueue;
			  
			  // copying the entries of the old queue
			  for (int index = 0; index <  oldSize-1; index++) {
				  
				  queue[index] = oldQueue[frontIndex];
				  frontIndex = (frontIndex+1) % oldSize;
			  } // end copying entries
			  
			  frontIndex = 0;
			  backIndex = oldSize-2;  
		  }   
	  } // end ensureCapacity
	  
} // end WaitingLine
