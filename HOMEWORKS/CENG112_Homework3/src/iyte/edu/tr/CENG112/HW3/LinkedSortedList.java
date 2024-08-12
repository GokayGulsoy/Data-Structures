package iyte.edu.tr.CENG112.HW3;

public class LinkedSortedList<T extends Comparable<? super T>> implements SortedListInterface<T> 
{

	 // data fields
	 private Node firstNode; // Reference to first node of chain
	 private int numberOfEntries;
	
	 public LinkedSortedList() {
		 
		 firstNode = null;
		 numberOfEntries = 0;
	 } // end default constructor
	 
	 public void add(T newEntry) {
	     
		 Node newNode = new Node(newEntry);
		 Node nodeBefore = getNodeBefore(newEntry);
		 
		 if (isEmpty() ||nodeBefore == null) {
			 
			 
			 newNode.setNextNode(firstNode);
			 firstNode = newNode;
		 }
		 
		 else {
			 
			 // add after nodeBefore
			 Node nodeAfter = nodeBefore.getNextNode();
			 newNode.setNextNode(nodeAfter);
			 nodeBefore.setNextNode(newNode);
		 } 
		 
		 numberOfEntries++;
	 } // end add
	 
	
	 public int getPosition(T anEntry) {
		 
		 int position = 1;
		 int length = getLength();
		 
		 // Find position of anEntry
		 while ((position <= length) && (anEntry.compareTo(getEntry(position)) > 0))  {
			 
			 position++;
		 } // end while
		 
		 // See whether anEntry is in the sortedList
		 if ((position > length) || (anEntry.compareTo(getEntry(position)) != 0 )) {
			 
			 position = -position; // anEntry is not in the sortedList
		 }
		 
		 return position;
	 } // end getPosition
	
 	 
	 public boolean remove(int givenPosition) {
		 
		 boolean result = false;
		 
		 if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
              			 
			 assert !isEmpty();
			 if (givenPosition == 1) { // Case 1: Remove first entry
				 
				 result = true;
				 firstNode = firstNode.getNextNode();
			 }
			 
			 else { // Case 2: Not first entry
				 
				 Node nodeBefore = getNodeAt(givenPosition-1);
				 Node nodeToRemove = nodeBefore.getNextNode();
				 Node nodeAfter = nodeToRemove.getNextNode();
				 nodeBefore.setNextNode(nodeAfter);
				 nodeToRemove = null;
				 result = true;
			 }
			 
			 numberOfEntries--;
			 return result;
		 }
		 
		 else {
			 
		    throw new IndexOutOfBoundsException("Illegal position given to remove operation");
		 } 
	 } // end remove
	 
	 
	 public T getEntry(int givenPosition) {
		 
		 if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			 
			 assert !isEmpty();
			 return getNodeAt(givenPosition).getData();
		 }
		 
		 else {
			 
			 throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
		 }
	 } // end getEntry
	 
	 
	 public boolean isEmpty() {
		 
		 boolean result;
		 if (numberOfEntries == 0) {
			 
			 assert firstNode == null;
			 result = true;
		 }
		 
		 else {
			 
			 assert firstNode != null;
			 result = false;
		 }
		 
		 return result;
	 } // end isEmpty
	 
	 public boolean contains(T anEntry) {
		 
		 boolean found = false;
		 Node currentNode = firstNode;
		 
		 while (!found && currentNode != null) {
			 
			 
			 if (anEntry.equals(currentNode.getData())) {
				 
				 found = true;
			 }
			 
			 else {
				 
				 currentNode = currentNode.getNextNode();
			 }
		 } // end while
		 
		 return found;
	 } // end contains
	 
	 public T[] toArray(T[] anyArray) {
		 
		 // The cast is safe because the newly allocated array 
		 // contains null entries
		 
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		 
		 int index = 0;
		 Node currentNode = firstNode;
		 while (index < numberOfEntries && currentNode != null) {
			 
			 result[index] = currentNode.getData();
			 currentNode = currentNode.getNextNode();
			 index++;
		 } // end while
		 
		 return result; 
	 } // end toArray
	 
	 public void clear() {
		 
		 firstNode = null;
		 numberOfEntries = 0;
	 } // end clear
	 
	 
	 private Node getNodeAt(int givenPosition) {
		 
		 assert (firstNode != null) && (givenPosition <= 1 && givenPosition <= numberOfEntries); 
		 
		 Node currentNode = firstNode;
		 
		 // Traverse the chain to locate the desired node
		 // (skipped if givenPosition is 1)
		 for (int counter = 1; counter < givenPosition; counter++) {
			 
			 currentNode = currentNode.getNextNode();
		 }
		 
		 assert currentNode != null;
		 
		 return currentNode;
	 } // end getNodeAt
	 
	 
	 private Node getNodeBefore(T anEntry) {
		 
		 Node currentNode = firstNode;
		 Node nodeBefore = null;
		 
		 while ((currentNode != null) && (anEntry.compareTo(currentNode.getData()) > 0)) { 
			 
			 
			 nodeBefore = currentNode;
			 currentNode = currentNode.getNextNode();
		 } // end while
		 
		 return nodeBefore;		 
	 } // end getNodeBefore
	
	 
	 public int getLength() {
		 
		 return numberOfEntries;
	 } //end getLength
	 
	  
	 // private Inner class Node 
	 private class Node {
		 
		 private T data;
		 private Node next;
		 
		 private Node(T dataPortion) 
		 {
			 
			 this(dataPortion,null);
		 } // end contructor
		
		 private Node(T dataPortion,Node nextNode) 
		 {
			 data = dataPortion;
			 next = nextNode;
		 } // end constructor
		 
		 private T getData() {
			 
			 return data;
		 } // end getData
		 
		 private void setData(T newData) {
			 
			 data = newData;
		 } // end setData
	     
		 private Node getNextNode() {
			 
			 return next;
		 } // end getNextNode
		 
		 private void setNextNode(Node nextNode) {
			 
			 next = nextNode;
		 } // end setNextNode
		 	 
	 } // end Node Inner class
	 	
} // end class LinkedSortedList
