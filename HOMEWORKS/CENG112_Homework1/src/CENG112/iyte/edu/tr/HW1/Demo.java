package CENG112.iyte.edu.tr.HW1;

import java.util.Scanner;

public class Demo {
       
	public  void runApplication() {
	   
	   Scanner keyboardInput = new Scanner(System.in);
	   System.out.println("[1] Sleeping");
	   System.out.println("[2] Workout");
	   System.out.println("[3] Dining");
	   System.out.println("[4] Meditation");
	   System.out.println("[5] Road Trip");
	   System.out.print("Enter the type for playlist: ");
	   String type = keyboardInput.nextLine();
	  
	   // parsing String to integer
	   int intType = Integer.parseInt(type);
	   
	   
	   // Until user inputs 0, application will repeat all steps
	   while (intType != 0) { 
		   
		   // creating an object of FileIO class and calling readFile method
		   FileIO fileReader = new FileIO();
		  GenreBag<Track>[] genreArray = fileReader.readFile();

		   // creating an instance of PlayList class
		   PlayList<Track> playList = new PlayList<Track>();
		   
		   switch(intType) {
		   
		        case 1: 
			           
		           playList.setMinDuration(45);
		           playList.setSuitabilityList(new int[] {1,0,4}); // actual list numbers are {2,1,5} 
		           break;                       
		        case 2:
		        	
		           playList.setMinDuration(60);
		           playList.setSuitabilityList(new int[] {3,2,5}); // actual list numbers are {4,3,6}
		           break;
		  
		        case 3:
		        	
		        	playList.setMinDuration(90);
		        	playList.setSuitabilityList(new int[] {4,0,1}); // actual list numbers are {5,1,2}
		            break;
		      
		        case 4:
		        	
		            playList.setMinDuration(120);
		            playList.setSuitabilityList(new int[] {1,0,4}); // actual list numbers are {2,1,5}
		            break;
		            
		        case 5:
		        	
		        	playList.setMinDuration(180);
		        	playList.setSuitabilityList(new int[] {2,5,0}); // actual list numbers are {3,6,1}
		            break;
		   
		   } // end of switch-case statement 
		   
		   
		   int[] suitabilityList = playList.getSuitabilityList();
		   boolean process = true; // controls the outer for loop iteration
		   double duration = 0; // that will keep the duration for playList   
		   
		   for (int i = 0; i < suitabilityList.length && process; i++) {
			      for (int j = 0; j < genreArray.length; j++) {
			    	  
			    	  // if we encounter the suitable genre transfer starts
			    	  if (suitabilityList[i] == j) {
                      
			    		  GenreBag<Track> genre = genreArray[j];
			    		  while (!(genre.isEmpty()) && duration <= playList.getMinDuration()) {
			    			  
			    			  Track mostPopulerTrack = findMostPopuler(genre);
			    			  // transfering track
			    			  genre.remove(mostPopulerTrack);
			    			  playList.add(mostPopulerTrack);
			    			  
			    			  
			    			  // if the duration is exceeded then transfer stops
			    			  if (duration > playList.getMinDuration()) {
			    				  
			    				  process = false;
			    			  }
			    			  
			    			  duration +=   ((double) mostPopulerTrack.getTrackDuration() / 60);
			    			  
			    		  } // end of the while loop
			    		  
			    	  } // end of if statement 
			    	    
			      }	   // end of the inner for loop
			   
		   } // end of the outer for loop
		   
		   // at the end of the outer for loop we will have formed our playList
		   // Displaying information related to playList
		   
		   
		   System.out.println("Total number of tracks in the playList is: " + playList.getCurrentSize());
		   System.out.printf("Total duration for the playList is: %.2f minutes\n",computeTotalDuration(playList));   
		   printGenreDurations(playList);
		   printNumberOfTracks(playList);
		   System.out.printf("Average popularity of the playList is: %.2f\n\n",((double) computeTotalPopularity(playList)/playList.getCurrentSize()));
		   
		   System.out.println("[1] Sleeping");
		   System.out.println("[2] Workout");
		   System.out.println("[3] Dining");
		   System.out.println("[4] Meditation");
		   System.out.println("[5] Road Trip");
		  
		   // until the user enters 0 application will repeat itself
		   System.out.print("Enter the type for playlist: ");
		   type = keyboardInput.nextLine();
	
		   // parsing String to integer
		   intType = Integer.parseInt(type);
		   
	   } // end of the outer while loop
	   
	   keyboardInput.close();
	   
	   // giving an ending message for application
	   System.out.println("\nAPPLICATION HAS ENDED THANKS FOR YOUR USAGE.");
	   
	} // end of the method runApplication
	
	
	
	// helper method that finds most populer track in genre
	private Track findMostPopuler(GenreBag<Track> genre) {
     
		    Track[] tracks = genre.toArray(new Track[6]);   
				      
		    // we perform maximum finder algorithm on tracks array
		    long mostPopuler =   tracks[0].getTrackPopularity();
		    Track mostPopulerTrack = tracks[0];
		    for (int i = 1; i < genre.getCurrentSize(); i++) {
		        
		    	if (mostPopuler < tracks[i].getTrackPopularity()) {
		    		
		    		mostPopuler = tracks[i].getTrackPopularity();
		    		mostPopulerTrack = tracks[i];
		    	}
		    	
		    } // at the end of the for loop we will get the most popular track
		    
		    return mostPopulerTrack;	
	}
	
	
	
	// helper method that computes the total duration for tracks inside the playList
	private double computeTotalDuration(PlayList<Track> playList) {
		
		double totalDuration = 0;
		int counter = 0;
    	Track[] tracks = new Track[playList.getCurrentSize()];
		
		while (!(playList.isEmpty())) {
			
			Track anyTrack = playList.remove();
			tracks[counter] = anyTrack;
   		    counter++;
			totalDuration +=  ((double) anyTrack.getTrackDuration()/60);
		}
		
		// filling the playList again for later computations
        fillPlayList(tracks,playList);
		
		// at the end of the while loop we will get the totalDuration of playList
		return totalDuration;
	}
	
	
	// helper method prints the total duration for each genre in the playList
    private void printGenreDurations(PlayList<Track> playList) {
    	
    	 // declaring durations as 0 initially 
    	 double acousticDuration = 0;
    	 double instrumentalDuration = 0;
    	 double rockDuration = 0;
    	 double rapDuration = 0;
    	 double jazzDuration = 0; 
    	 double popDuration = 0;
    	
    	 int counter = 0;
    	 Track[] tracks = new Track[playList.getCurrentSize()];
    	 while (!(playList.isEmpty())) {
   
    		 Track anyTrack = playList.remove();
    		 tracks[counter] = anyTrack;
    		 counter++;
    		 int genreId = anyTrack.getGenreId();
    		 
    		 if (genreId == 1) {
    			 
    			 acousticDuration += ((double) anyTrack.getTrackDuration()/60);
    		 }
    		 
    		 else if (genreId == 2) {
    			 
    			 instrumentalDuration += ((double) anyTrack.getTrackDuration()/60);
    		 }
    		 
    		 else if (genreId == 3) {
    			 
    			 rockDuration += ((double) anyTrack.getTrackDuration()/60);
    		 }
    		 
    		 else if (genreId == 4) {
    			 
    			 rapDuration += ((double) anyTrack.getTrackDuration()/60);
    		 }
    		 
    		 else if (genreId == 5) {
    			 
    			 jazzDuration += ((double) anyTrack.getTrackDuration()/60);
    		 }
    		 
    		 else { // if genre is Pop
    			 
    			 popDuration += ((double) anyTrack.getTrackDuration()/60);
    		 }
    		 
    	 } /* at the end of the while loop we will have computed all
    	     genre durations existing in the playlist */
    	    	 
    	// filling the playList again for later computations
    	fillPlayList(tracks,playList); 
    	 
    	// prnting durations of genres in terms of minutes
    	System.out.printf("Total duration for Acoustic genre is: %.2f minutes\n",acousticDuration);
		System.out.printf("Total duration for Instrumental genre is: %.2f minutes\n",instrumentalDuration);
		System.out.printf("Total duration for Rock genre is: %.2f minutes\n",rockDuration);
		System.out.printf("Total duration for Rap genre is: %.2f minutes\n",rapDuration);	
		System.out.printf("Total duration for Jazz genre is: %.2f minutes\n",jazzDuration);
		System.out.printf("Total duration for Pop genre is: %.2f minutes\n\n",popDuration);
   	
    }
		
    // helper method that will compute the total number of plays for tracks in the playlist
	private long computeTotalPopularity(PlayList<Track> playList) {
		
		long totalPopularity = 0;
		int counter = 0;
    	Track[] tracks = new Track[playList.getCurrentSize()];
		
		
		while(!(playList.isEmpty())) {
			
			 Track anyTrack = playList.remove();
			 tracks[counter] = anyTrack;
			 counter++;
			 totalPopularity += anyTrack.getTrackPopularity();		
		}
		
		// filling the playList for later computations
		fillPlayList(tracks,playList);
 	 
		// at the end of the while loop we will have computed total track popularity
		return totalPopularity;
			
	}
	
	
	// helper method that fills the playlist
	private void fillPlayList(Track[] tracks,PlayList<Track> playList) {
		
		   for (Track anyTrack: tracks) {
	    		 
	    		 playList.add(anyTrack); 
		   }	
	}
	
	// helper method that prints the number of tracks in each genre for playList
	private void printNumberOfTracks(PlayList<Track> playList) {
	
	 int acousticGenre = 0;
	 int instrumentalGenre = 0;
	 int rockGenre = 0;
	 int rapGenre = 0;
	 int jazzGenre = 0;
	 int popGenre = 0;
	 
	int counter = 0;
 	Track[] tracks = new Track[playList.getCurrentSize()];
	 
	 while (!(playList.isEmpty())) {
		 
		 Track anyTrack = playList.remove();
		 int genreId = anyTrack.getGenreId();
		 tracks[counter] = anyTrack;
		 counter++;
		 
		 
		 if (genreId == 1) {
			 
			 acousticGenre += 1;
 		 }
		 
		 else if (genreId == 2) {
			 
			 instrumentalGenre += 1;
		 }
		 
		 else if (genreId == 3) {
			 
			 rockGenre += 1;
		 }
		 
		 else if (genreId == 4) {
			 
			 rapGenre += 1;
		 }
		 
		 else if (genreId == 5) {
			 
			 jazzGenre += 1;
		 }
		 
		 else { // if genre is Pop
			 
			 popGenre += 1;
		 }
		 	 
	 } 
	 
	 // filling the playList again for later computations
	 fillPlayList(tracks,playList);
	 
	 // at the end of the while loop printing total number of tracks for rach genre
	 System.out.println("Total number of tracks in Acoustic genre in playlist is: " + acousticGenre);
	 System.out.println("Total number of tracks in Instrumental genre in playlist is: " + instrumentalGenre);
	 System.out.println("Total number of tracks in Rock genre in playlist is: " + rockGenre);
	 System.out.println("Total number of tracks in Rap genre in playlist is: " + rapGenre);
	 System.out.println("Total number of tracks in Jazz genre in playlist is: " + jazzGenre);
	 System.out.println("Total number of tracks in Pop genre in playlist is: " + popGenre);
			
	}
	
}
