package iyte.edu.tr.CENG112.HW3;

public class LinkedPriorityQueue<T> implements QueueInterface<T> 
{
    
	// data fields 
	private Node firstNode;
	private Node lastNode;
	
	
	public LinkedPriorityQueue()
	{
		firstNode = null;
		lastNode = null;
	} // end default constructor
	 
	
	public void enqueue(T newEntry)
	{
		
		Node newNode = new Node(newEntry,null);
		if (isEmpty())
		{
			
			firstNode = newNode;
		}
		
		else
		{
		
			lastNode.setNextNode(newNode);
		}
		
		lastNode = newNode;
	} // end enqueue
	
	
	public T getFront()
	{
		
		if (isEmpty())
		{	
			try 
			{
			   throw new EmptyQueueException("Exception queue is empty");
			}
			
			catch(EmptyQueueException e)
			{
				e.getMessage();
				System.exit(0);
			}	
		}
		
	    return firstNode.getData();
	} // end getFront
	
	public T dequeue()
	{
		
		T front = getFront(); // Might throw EmptyQueueException
		assert firstNode != null;
		firstNode.setData(null);
		firstNode = firstNode.getNextNode();
		
		if (firstNode == null)
		{
			
			lastNode = null;
		}
		
		return front;
	} // end dequeue
	
	public boolean isEmpty()
	{
		
		return (firstNode == null) && (lastNode == null);
	} // end isEmpty
	
	public void clear()
	{
		
		firstNode = null;
		lastNode = null;
	} // end clear
	
	
	public void assignPriorities(LinkedSortedList<Patient> sortedList)
	{
		
		// assigning priorities to patients
		for (int i = 1; i < sortedList.getLength(); i++)
		{
				
			Patient anyPatient = sortedList.getEntry(i);
			
			// parsing age to integer
			String age = anyPatient.getAge();
			if (age.charAt(0) == '0')
			{
				age = age.substring(1);
			}
			
			int numeric_age = Integer.parseInt(age);
			
			
			if (anyPatient.getDisability().equals("disabled"))
			{
				anyPatient.setPriority(5);
			}
					
			else if (numeric_age > 65)
			{
				anyPatient.setPriority(4);
			}
			
			else if (anyPatient.getPregnancy().equals("preg"))
			{
				anyPatient.setPriority(3);
			}
			
			else if (numeric_age < 18)
			{
				anyPatient.setPriority(2);
			}
			
			// otherwise patient is regular
		}
	} // end assignPriorities
	
		
	// Node Inner class
	private class Node 
	{
		
		private T data; // Entry in queue
		private Node next; // Link to next node
		
		private Node(T newEntry)
		{
			
			this(newEntry,null);
		} // end constructor
		
		
		private Node(T newEntry,Node nextNode)
		{
			
			data = newEntry;
			next = nextNode;
 		} // end constructor
		
		
		// getters (accessors)
		private T getData()
		{
			
			return data;
		}
		
		private Node getNextNode()
		{
			
			return next;
		}
		
		// setters (mutators)
		private void setData(T newData)
		{
			
			data = newData;
		}
		
		private void setNextNode(Node nextNode)
		{
			
			next = nextNode;
		}		
	} // end class Node
	
} // end LinkedPriorityQueue
