package iyte.edu.tr.CENG112.HW3;

public class ManagementSystem {
   public void simulatePatientManagementSystem()
   {
	
		FileIO fileReader = new FileIO();
		LinkedSortedList<Patient> sortedList = fileReader.readFile();
		
		// printing patient list
		System.out.println("\n----------------");
		System.out.println("-LIST OF PATIENTS-");
	    displayPatientList(sortedList);
	    
	    // creeating an instance of LinkedPriorityQueue
	    LinkedPriorityQueue<Patient> priorityQueue = new LinkedPriorityQueue<Patient>();
	    priorityQueue.assignPriorities(sortedList);
	    
	    // creating a new LinkedSortedList that contain patients according to their
	    // appointments and priority conditions
	    LinkedSortedList<Patient> priorityList = new LinkedSortedList<Patient>();
	    
	    for (int i = 1; i <= sortedList.getLength();i++)
	    {
	    	priorityList.add(sortedList.getEntry(i));
	    }
	    
	    // Adding patients to priorityQueue according to priorities and appointment date ,and time
	    fillPriorityQueue(priorityList,priorityQueue);
	    
	    // Displaying the entries of priorityQueue
	    System.out.println("\n---------------------------");
	    System.out.println("-PRIORITY QUEUE OF PATIENTS-");
	    while (!priorityQueue.isEmpty())
	    {
	      
	    	System.out.println(priorityQueue.dequeue());
	    }
	    
	     // filling the priorityQueue again
	    fillPriorityQueue(priorityList,priorityQueue);
	    
	    // printing the remaining patients after every 5 treatments
	    int treatmentNo = 0;
	    while (!priorityQueue.isEmpty())
	    {
	    	
	    	if (treatmentNo != 0 && treatmentNo % 5 == 0)
	    	{
	           
	    		System.out.println("\n------------------------------------------");
	     		System.out.println("-LIST OF PATIENTS AFTER THE " + treatmentNo + "th TREATMENT-");
	    		displayPatientList(sortedList);
	    	}
	    	    	
	    	Patient anyPatient = priorityQueue.dequeue();
	    	
	    	if (treatmentNo == 19)
	    	{
	    		
	    		System.out.println("\n------------------------------------------");
	    		System.out.println("-FINAL PATIENT THAT RECEIVED THE TREATMENT-");
	            System.out.println(anyPatient);
	    	}
	    	
	    	int positionToRemove = searchPatient(anyPatient,sortedList);
	    	sortedList.remove(positionToRemove);
	    	treatmentNo++;
	    }
  } // end SimulatePatientManagementSystem
   
  // helper method that prints the patients in the list
  private void displayPatientList(LinkedSortedList<Patient> sortedList)
  {
	  
	  for (int i = 1; i <= sortedList.getLength();i++) {
	    	
	    	Patient anyPatient = sortedList.getEntry(i);
	    	System.out.println(anyPatient);
	    }	  
  } // end displayPatientList
  
  
  // helper method that fills the priorityQueue
  private void fillPriorityQueue(LinkedSortedList<Patient> priorityList,LinkedPriorityQueue<Patient> priorityQueue)
  {
	  
	  for (int i = 1; i <= priorityList.getLength();i++)
	    {
	    	priorityQueue.enqueue(priorityList.getEntry(i));
	    }	  
  } // end fillPriorityQueue
  
  // helper method that searches for the specific patient
  private int searchPatient(Patient anyPatient,LinkedSortedList<Patient> sortedList)
  {
	  
	  int position = 1;
	  for (int i = 1; i <= sortedList.getLength();i++)
	  {
		  
		  if (anyPatient.getNameSurname().equals(sortedList.getEntry(position).getNameSurname()))
		  {
			  break;
		  }
		  
		  position++;
	  }
	  
	  return position;  
  } // end searchPatient
    
} // end class ManagementSystem
