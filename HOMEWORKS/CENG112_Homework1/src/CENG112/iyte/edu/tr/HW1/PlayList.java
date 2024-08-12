package CENG112.iyte.edu.tr.HW1;

public class PlayList<T> extends GenreBag<T> implements BagInterface<T> {

    // data fields of the PlayList class
    private int minDuration;
    private int[] suitabilityList; 
    
    
    // parameterized constructor for playList class
    public PlayList(int minDuration,int[] suitabilityList) {
        
   	 // calling the base class' default constructor 
   	 super();
   	 this.minDuration = minDuration;
   	 this.suitabilityList = suitabilityList;
    }
    
    
    // default constructor for PlayList class
    public PlayList() {
   	 
   	 this(0,new int[] {});
   	 
    }
    
    
    // getters(accessors) for PlayList class
    
    public int getMinDuration() {
   	 
   	 return minDuration;
    }

    public int[] getSuitabilityList() {
   	 
   	 return suitabilityList;
    }
    
    
    // setters (mutators) for PlayList class
    public void setMinDuration(int minDuration) {
   	 
   	 this.minDuration = minDuration;
    }
    
    public void setSuitabilityList(int[] suitabilityList) {
   	 
   	 this.suitabilityList = suitabilityList;
    }

}

