package iyte.edu.tr.CENG112.HW3;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

public class Patient implements Comparable<Patient> {
    
	// data fields
	private String nameSurname;
	private String age;
	private String gender;
	private String pregnancy;
	private String disability;
	private String date;
	private String time;
	private int priority;
	
   
	// default constructor
	public Patient()
	{
	  nameSurname = null;
	  age = null;
	  gender = null;
	  pregnancy = null;
	  disability = null;
	  date = null;
	  time = null;
	  priority = 1; // initially priority is regular
	}
	
	
	// paramaterized constructor 
	public Patient(String nameSurname,String age,String gender,String pregnancy,String disability,String date,String time) 
	{
		
		this.nameSurname = nameSurname;
		this.age = age;
		this.gender = gender;
		this.pregnancy = pregnancy;
		this.disability = disability;
		this.date = date;
		this.time = time;
	}
	
	
	// setters (mutators)
	public void setName(String nameSurname) 
	{
	
		 this.nameSurname = nameSurname;
	}
	
	
	public void setAge(String age)
	{
	
	   this.age = age;	 
	}
	
	
	public void setGender(String gender) 
	{
		
		this.gender = gender;
	}
	
	
	public void setPregnancy(String pregnancy) 
	{
		
		this.pregnancy = pregnancy;
	}
    
	public void setDisability(String disability) 
	{
		
		this.disability = disability;
	}
	
	public void setDate(String date)
	{
		
		this.date = date;
	}
	
	public void setTime(String time)
	{
		
		this.time = time;
	}
	
	public void setPriority(int priority)
	{
		this.priority = priority;
	}
	
	// getters (accessors) 
	public String getNameSurname()
	{
		
		return nameSurname;
	}
	
	public String getAge()
	{
		
		return age;
	}
	
	public String getGender()
	{
		
		return gender;
	}
    
	public String getPregnancy()
	{
		
		return pregnancy;
	}
	
	public String getDisability()
	{
		
		return disability;
	}
	
	public String getDate()
	{
		
		return date;
	}
	
	public String getTime()
	{
		
		return time;
	}
	
	public int getPriority()
	{
		
		return priority;
	}
	
    @Override
	public String toString()
	{
		
		return "\nName and Surname: " + nameSurname + " ,Age: " + age + " ,Gender: " + gender + " ,Pregnancy: " + pregnancy + 
			   " ,Disability: " + disability + " ,Appointment Date: " + date + " ,Appointment time: " + time + "\n";
	}
		
    // makes comparsion both with respect to date and priority conditions
	@Override
    public int compareTo(Patient anotherPatient)
    {
		LocalDateTime originalTime,otherTime;
		String originalDate = getDate();
		StringTokenizer dateTokenizer = new StringTokenizer(originalDate,"/");
		
		// tokenizing the date to day,month,and year 
		String day = dateTokenizer.nextToken();
		
		if (day.charAt(0) == '0') 
		{
			// if day starts with 0 we remove it	
			day = day.substring(1);
		}
		
		String month = dateTokenizer.nextToken();
		
		if (month.charAt(0) == '0')
		{
			// if month starts with 0 we remove it
			month = month.substring(1);
		}
		
		
		String year = dateTokenizer.nextToken();
		// parsing String values to integers
		int originalNumericDay = Integer.parseInt(day);
		int originalNumericMonth = Integer.parseInt(month);
		int originalNumericYear = Integer.parseInt(year);
        
		String otherDate = anotherPatient.getDate();
		StringTokenizer dateTokenizer2 = new StringTokenizer(otherDate,"/");
		
		day = dateTokenizer2.nextToken();
		
		if (day.charAt(0) == '0') 
		{
				
			day = day.substring(1);
		}
		
	    month = dateTokenizer2.nextToken();
		
		if (month.charAt(0) == '0')
		{
			
			month = month.substring(1);
		}
		
		year = dateTokenizer2.nextToken();
		
		int otherNumericDay = Integer.parseInt(day);
		int otherNumericMonth = Integer.parseInt(month);
		int otherNumericYear = Integer.parseInt(year);
		
		
		// tokenizing time data field
		String originalTimeField = getTime();
		StringTokenizer timeTokenizer = new StringTokenizer(originalTimeField,":");
		
		String originalHour = timeTokenizer.nextToken();
		
		if (originalHour.charAt(0) == '0')
		{
			// if hour starts with 0 we remove 0
			originalHour = originalHour.substring(1);
		}
		
		String originalMinutes = timeTokenizer.nextToken();
		
		int originalNumericHour = Integer.parseInt(originalHour);
		int originalNumericMinutes = Integer.parseInt(originalMinutes);
	
		
		String otherTimeField = anotherPatient.getTime();
		StringTokenizer timeTokenizer2 = new StringTokenizer(otherTimeField,":");
		
		String otherHour = timeTokenizer2.nextToken();
		
		if (otherHour.charAt(0) == '0')
		{
			// if hour starts with 0 we remove 0
			otherHour = otherHour.substring(1);
		}
		
		String otherMinutes = timeTokenizer2.nextToken();
		
		int otherNumericHour = Integer.parseInt(otherHour);
		int otherNumericMinutes = Integer.parseInt(otherMinutes);
		
		
		originalTime = LocalDateTime.of(originalNumericYear, originalNumericMonth, originalNumericDay,0,0);
		otherTime = LocalDateTime.of(otherNumericYear, otherNumericMonth,otherNumericDay,0,0);
			
		// comparing two LocalDateTime objects
		if (originalTime.compareTo(otherTime) > 0)
		{
			// originalTime comes after otherTime
			return 1;
		}
		
		else 
		{
			
			// in case originalTime.compareTo(otherTime) <= 0
			if (originalTime.compareTo(otherTime) == 0)
			{
				// comparing priorities
				if (getPriority() > anotherPatient.getPriority())
				{
					
					return -1; // patient has higher priority than anotherPatient
				}
				
				else if (getPriority() < anotherPatient.getPriority())
				{
					
					return 1; // patient has lower priority than anotherPatient
				}
				
				else  
				{
					// if both patients has the same priority we check appointment times
					originalTime = LocalDateTime.of(originalNumericYear,originalNumericMonth,originalNumericDay,originalNumericHour,originalNumericMinutes);
					otherTime = LocalDateTime.of(otherNumericYear,otherNumericMonth,otherNumericDay,otherNumericHour,otherNumericMinutes);
					
					if (originalTime.compareTo(otherTime) > 0)
					{	
						return 1;
					}
					
					else
					{
					   return -1;	
					}		
				}		
			}
			
			else { // in case originalTime.compareTo(otherTime) < 0
				return -1;
			}
		}
    } // end compareTo
	
} // end class Patient
