import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        
        myMap.addBuilding(new Building("Seelye", "Seelye"));
        myMap.addBuilding(new Library("Nielson", "123 Idk"));
        myMap.addBuilding(new Building("McConnell", "McConnel"));
        myMap.addBuilding(new Building("Campus Center", "Campus Center"));
        myMap.addBuilding(new House("Talbot", "25 Prospect Street", 4, false, true));
        myMap.addBuilding(new House("Lee", "34 Green Street", 2));
        myMap.addBuilding(new House("Capen", "34 Green Street", 2));
        myMap.addBuilding(new Building("Mendell Hall", "Mendell Hall"));
        myMap.addBuilding(new Library("Josten", "Mendell Hall"));
        myMap.addBuilding(new Cafe("CC", "Campus Center", 1));
        System.out.println(myMap);
    }
    
}
