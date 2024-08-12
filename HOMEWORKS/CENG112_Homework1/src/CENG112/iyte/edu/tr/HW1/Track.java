package CENG112.iyte.edu.tr.HW1;

public class Track {
	 
	 // data fields for Track class
	 private int genreId;
	 private int trackId;
	 private int trackDuration;
	 private long trackPopularity;
	 
	 // constructor for Track class
	 public Track(int genreId,int trackId,int trackDuration,long trackPopularity) {
		 
		 this.genreId = genreId;
		 this.trackId = trackId;
		 this.trackDuration = trackDuration;
		 this.trackPopularity = trackPopularity;
	 }
	 
	 // accessors (getters) for Track class
	 public int getGenreId() {
		 
		 return genreId;
	 }
	
	 public int getTrackId() {
		 
		 return trackId;
	 }
	
	 public int getTrackDuration() {
		 
		return trackDuration;
	 }
	
	 
	 public long getTrackPopularity() {
		 
		 return trackPopularity;
	 }
	 
	 
	 /* we don't need setters for Track class as we are not going to change 
	    the data fields.  
	 */
	 
	// defining equals method for Track class
	public boolean equals(Track anotherTrack) {
		
	      if(anotherTrack == null) {
	    	  
	    	  return false;
	      }
	
	      else if (getClass() != anotherTrack.getClass()) {
	    	  
	    	  return false;
	      }
		
	      else {
	    	  
	    	  return (genreId == anotherTrack.getGenreId()) && (trackId == anotherTrack.getTrackId()) &&
	    			  (trackDuration == anotherTrack.getTrackDuration()) && (trackPopularity == anotherTrack.getTrackPopularity());
	      }
	}
		
}
