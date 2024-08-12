package CENG112.iyte.edu.tr.HW1;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class FileIO {
   
	  public GenreBag<Track>[] readFile() {
		  
		  // creating Scanner object for reading the tracks.txt file
		  Scanner inputStream = null;
		  
		  try {
			  
			  inputStream = new Scanner(new FileInputStream("tracks.txt"));
		  }
		  
		  catch (FileNotFoundException e) {
			  
			  System.out.println("File was not found."); 
			  System.exit(0);
		  }
		  
		  
		  // creating genres
		  GenreBag<Track> acousticGenre = new GenreBag<Track>();
		  GenreBag<Track> instrumentalGenre = new GenreBag<Track>();
		  GenreBag<Track> rockGenre = new GenreBag<Track>();
		  GenreBag<Track> rapGenre = new GenreBag<Track>();
		  GenreBag<Track> jazzGenre = new GenreBag<Track>();
		  GenreBag<Track> popGenre = new GenreBag<Track>();
		  
		  // reading tracks.txt line by line
		  while (inputStream.hasNextLine()) {
			  
			  String line = inputStream.nextLine();
			  
			  // creating an instance of StringTokenizer
			  StringTokenizer tokenizer = new StringTokenizer(line,",");
			  
			  int genreId = Integer.parseInt(tokenizer.nextToken());
			  int trackId = Integer.parseInt(tokenizer.nextToken());
			  int trackDuration = Integer.parseInt(tokenizer.nextToken());
			  long trackPopularity = Long.parseLong(tokenizer.nextToken());
			  
			  // creating an track object
			  Track anyTrack = new Track(genreId,trackId,trackDuration,trackPopularity);
			 
			  // adding tracks to corresponding genreBag
			  
			  if (anyTrack.getGenreId() == 1) {
				  
				  acousticGenre.add(anyTrack);
			  }
			  
			  else if (anyTrack.getGenreId() == 2) {
				  
				  instrumentalGenre.add(anyTrack);
			  }
			  
			  else if (anyTrack.getGenreId() == 3) {
				  
				  rockGenre.add(anyTrack);
			  }
			  
			  else if (anyTrack.getGenreId() == 4) {
				  
				  rapGenre.add(anyTrack);
			  }
			  
			  else if (anyTrack.getGenreId() == 5) {
				  
				  jazzGenre.add(anyTrack);
			  }
			  
			  else {
				  popGenre.add(anyTrack);
				  
			  }
			  
		  } // end of while loop
		  
		  //  printing total number of tracks in each genre
		  System.out.println("\nTotal number of tracks in Acoustic genre is: " + acousticGenre.getCurrentSize());
		  System.out.println("Total number of tracks in Instrumental genre is: " + instrumentalGenre.getCurrentSize());
		  System.out.println("Total number of tracks in Rock genre is: " + rockGenre.getCurrentSize());
		  System.out.println("Total number of tracks in Rap genre is: " + rapGenre.getCurrentSize());
		  System.out.println("Total number of tracks in Jazz genre is: " + jazzGenre.getCurrentSize());
		  System.out.println("Total number of tracks in Pop genre is: " + popGenre.getCurrentSize() + "\n");
		  
		  // printing total duration for each genre
		  System.out.printf("Total duration for Acoustic genre is: %.2f minutes\n",computeTotalDuration(acousticGenre));
		  System.out.printf("Total duration for Instrumental genre is: %.2f minutes\n",computeTotalDuration(instrumentalGenre));
		  System.out.printf("Total duration for Rock genre is: %.2f minutes\n",computeTotalDuration(rockGenre));
		  System.out.printf("Total duration for Rap genre is: %.2f minutes\n" ,computeTotalDuration(rapGenre));
		  System.out.printf("Total duration for Jazz genre is: %.2f minutes\n",computeTotalDuration(jazzGenre));
		  System.out.printf("Total duration for Pop genre is: %.2f minutes\n\n",computeTotalDuration(popGenre));
		  
		  
		  // creating an array for holding genres
		@SuppressWarnings("unchecked")
		GenreBag<Track>[] genreArray = new GenreBag[6];		
	  
		 genreArray[0] = acousticGenre;
		 genreArray[1] = instrumentalGenre;
		 genreArray[2] = rockGenre;
		 genreArray[3] = rapGenre;
		 genreArray[4] = jazzGenre;
		 genreArray[5] = popGenre;
		  
		  // returning an array of genres
		  return genreArray;
		  
	  }
	  
	  // helper method that computes total duration for genre
	  private double computeTotalDuration(GenreBag<Track> genre) {
		  
		  Track[] removedTracks = new Track[genre.getCurrentSize()];
		  double totalDuration = 0;
		  int counter = 0;
		  
		  while (!(genre.isEmpty())) {
			  
			  
			  Track anyTrack = genre.remove();
			  removedTracks[counter] = anyTrack;
			  counter++;
			  totalDuration += ((double)anyTrack.getTrackDuration()/60);
		  }  
		  
		  // at the end of the while loop we will fill the genre again for later computations
		  fillGenre(genre,removedTracks);
		  
		  return totalDuration;
		  
		  
	  }
	  
	  // helper method for filling the genre again
	  private void fillGenre(GenreBag<Track> genre,Track[] removedTracks) {
		  
		  // adding each removed track to genre again
		  for (Track track: removedTracks) {
			  
			  genre.add(track);
		  }	  
	  }
	  
	  
	  
		
}
