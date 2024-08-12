package iyte.edu.tr.CENG112.HW3;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileIO 
{

	public LinkedSortedList<Patient> readFile()
	{
		
		Scanner inputStream = null;
        LinkedSortedList<Patient> sortedList = new LinkedSortedList<Patient>();
		
		try 
		{
			
			inputStream = new Scanner(new FileInputStream("records 1.txt"));
		}
		
		catch(FileNotFoundException e) 
		{
			System.out.println("File path not found.");
			System.exit(0);
		}
		
		while (inputStream.hasNextLine()) 
		{
				
		  String line = inputStream.nextLine();
		  StringTokenizer tokenizer = new StringTokenizer(line,",");	
		  
		  
		  // consuming the line number in text file
		  tokenizer.nextToken();
		  
		  // creating patient object
		  Patient anyPatient = new Patient();
		  
		  String nameSurname = tokenizer.nextToken();
		  anyPatient.setName(nameSurname);
		  
          String age = tokenizer.nextToken();  
          anyPatient.setAge(age);
          
          String gender = tokenizer.nextToken();
          anyPatient.setGender(gender);
          
          String pregnancy = tokenizer.nextToken();
          anyPatient.setPregnancy(pregnancy);
          
          String disability = tokenizer.nextToken();
          anyPatient.setDisability(disability);
          
          String date = tokenizer.nextToken();
          anyPatient.setDate(date);
          
          String time = tokenizer.nextToken();
          anyPatient.setTime(time);
          // after forming the patient object we add it to 
          // sortedList
          
          sortedList.add(anyPatient);
		} // end while
		
		return sortedList;
		
	} // end readFile
	
} // end class FileIO
