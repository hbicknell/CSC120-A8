import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building implements HouseRequirements{
  /* Attributes */
  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;
  
  /* overloaded constructor */
  public House(String name, String address, int nFloors) {
  super(name,address,nFloors);
  System.out.println("You have built a house: 🏠");
  this.residents = new ArrayList<Student>();
  this.hasDiningRoom = false;
  this.hasElevator = false;
  }

  /*normal constructor */
  public House(String name, String address, int nFloors, boolean hasDiningRoom_, boolean hasElevator_) {
  super(name,address,nFloors);
  System.out.println("You have built a house: 🏠");
  this.residents = new ArrayList<Student>();
  this.hasDiningRoom = hasDiningRoom_;
  this.hasElevator = hasElevator_;
  }
  
  /* Accessors */
  
   /**
     * whether has a dining hall or not
     * @return dining room
     */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * the number of residents
   * @return residents size
   */
  public int nResidents(){
    return this.residents.size();
  }

  /* Manipulators */

  /**
   * add a student to the house
   * @param student
   */
  public void moveIn(Student s){
    this.residents.add(s);
  }
  
  /**
   * remove a student from house 
   * @param student
   */
  public Student moveOut(Student s){
    this.residents.remove(s);
    return s;
} 

/* Boolean */

/**
 * whether or not a student lives in the house 
 * @param Student
 * @return boolean
 */
public boolean isResident(Student s){
  if (this.residents.contains(s)){
    return true;
  } else{
    return false;
  }
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

/*normal method for show options */
public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n + hasDiningRoom() \n + nResidents() \n + isResident() \n + movein() \n + moveout()");
    }

/** 
 * overloaded method 
 * @param boolean
 */
public void showOptions(boolean shortened) {
        System.out.println("Available options at " + this.name + ":\n + hasDiningRoom() \n + nResidents() \n + isResident() \n + movein() \n + moveout()");
    }
 
public static void main(String[] args) {
  House Park = new House("Park", "134 Elm", 4, false, true);
  House Talbot = new House("Talbot", "25 Prospect", 4, false, false);
  //System.out.println(Park.hasDiningRoom());
  Park.enter();
  Talbot.enter();
  Park.goToFloor(2);
  Talbot.goToFloor(2);
  Park.showOptions();

}

}

