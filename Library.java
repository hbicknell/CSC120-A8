import java.util.Hashtable;
/* This is a stub for the Library class */
public class Library extends Building implements LibraryRequirements {
  /* Attributes */
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

  /*Overloaed constructor */
  public Library(String name, String address) {
      int nFloors = 2;
      super(name, address, nFloors);
      System.out.println("You have built a library: 📖");
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = true;
    }
  
    /*overloaded constructor but has floors */
  public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      System.out.println("You have built a library: 📖");
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = true;
    }

    /* normal constructor */
    public Library(String name, String address, int nFloors, boolean hasElevator_) {
      super(name, address, nFloors);
      System.out.println("You have built a library: 📖");
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = hasElevator_;
    }

    /**
     * add a title to the library's collection 
     * @param title
     */
    public void addTitle(String title){
      this.collection.put(title, true);
    }

    /**
     * remove a title from the library's collection 
     * @param title 
     * @return title
     */
    public String removeTitle(String title){
      this.collection.remove(title);
      return title;
    }
    
    /**
     * if the title is in the library's collection
     * @param title 
     * @return boolean
     */
    public boolean containsTitle(String title){
      if (this.collection.contains(title)){
      return true;
    } else{
      return false;
      }
    }

    /**
     * allows someone to check out the title in the library, says it's false in collection 
     * @param title 
     */
  public void checkOut(String title){
    if (containsTitle(title)){
      this.collection.replace(title, false);
    } else{
      throw new RuntimeException("This library does not own this title.");
      }
  }

  /**
   * allows someone to return the book, says it's true in the list
   * @param title
   */
  public void returnBook(String title){
    if (containsTitle(title)){
      this.collection.replace(title, true);
    } else{
      throw new RuntimeException("This library does not own this title.");
    }
  }

  /**
   * tells what the status either true or false of the title in the library's collection 
   * @param title 
   * @return boolean
   */
  public boolean isAvailable(String title){
    if (this.collection.getOrDefault(title, false)==false){
      System.out.println("This title is not available at this library.");
      return false;
    }else{
      System.out.println("This title is available.");
      return true;
    }
  }

  /**
   * prints collection in string 
   */
  public void printCollection(){
    System.out.println(this.collection.toString());
  }

  public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        if (floorNum < this.activeFloor - 1 || floorNum > this.activeFloor + 1 ) {
            if (this.hasElevator == false){
              throw new RuntimeException("There's no elevator here silly! You have to go up floor by floor");
            }
          System.out.println("You are now on floor #" + floorNum + " of " + this.name);
          this.activeFloor = floorNum; 
        } else {
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
      }
    }
  
  public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n + addTitle \n + removeTitle \n + containsTitle \n + checkOut \n + returnBook \n + isAvailable \n + printCollection ");
    }
    public static void main(String[] args) {
      Library Hilyer = new Library("Hilyer","1 Chapin Way",4,false);
      Hilyer.showOptions();
      Hilyer.enter();
      Hilyer.goToFloor(3);
    }

  
  }
