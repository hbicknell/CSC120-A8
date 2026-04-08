/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements{
    /* Attributes */
    private int nCoffeeOunces;
    private int nSugarPackets; 
    private int nCreams; 
    private int nCups;
    
    /* overloaded constructor */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 100;
        this.nCreams = 100; 
        this.nCups = 100;

    }

    /* normal constructor */
    public Cafe(String name, String address, int nFloors, int Ounces, int Sugars, int Creams, int Cups) {
        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");
        this.nCoffeeOunces = Ounces;
        this.nSugarPackets = Sugars;
        this.nCreams = Creams; 
        this.nCups = Cups;

    }

    /**
     * sells coffee, lowers all attributes 
     * if out of a certain attribute, it restocks the inventory
     * @param size
     * @param SugarPackets
     * @param Creams
     */
    public void sellCoffee(int size, int SugarPackets, int Creams){
        if (this.nCoffeeOunces < size || this.nSugarPackets < SugarPackets || 
        this.nCreams < Creams || this.nCups < 1){
            System.out.println("Restocking...");
            this.restock(30, 15, 15,30);
        }else{
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= SugarPackets;
            this.nCreams -= Creams;
            this.nCups -= 1;
        }
        System.out.println("1 Coffee Sold!");
    }

    /**
     * overloaded method 
     * @param size
    */
    public void sellCoffee(int size){
        int SugarPackets = 3;
        int Creams = 3;
        if (this.nCoffeeOunces < size || this.nSugarPackets < SugarPackets || 
        this.nCreams < Creams || this.nCups < 1){
            System.out.println("Restocking...");
            this.restock(30, 15, 15,30);
        }else{
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= SugarPackets;
            this.nCreams -= Creams;
            this.nCups -= 1;
        }
        System.out.println("1 Coffee Sold!");
    }

    /**
     * restocks the store -- private so not any old perosn can restock
     * @param Ounces 
     * @param SugarPackets 
     * @param Creams 
     * @param Cups
     */
    private void restock(int Ounces, int SugarPackets, int Creams, int Cups){
        this.nCoffeeOunces = Ounces; 
        this.nSugarPackets = SugarPackets;
        this.nCreams = Creams;
        this.nCups = Cups;
    }

    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        if (floorNum > this.activeFloor) {
            throw new RuntimeException("You can't do that");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n + sellCoffee");
    }
 

    
    public static void main(String[] args) {
        Cafe CC = new Cafe("CC", "123 Hi", 1, 12, 8, 10, 20);
        CC.sellCoffee(12,1,2);
        CC.sellCoffee(12,1,2);
        
    }
    
}
