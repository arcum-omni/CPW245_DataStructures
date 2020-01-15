// Your header comment goes here.

public class RocketShip {
    public static final int ROCKET_SIZE = 3;
    
    public static void main( String[] args ) {
        printNoseCone();
        printBody();
        printNozzle();
    }

    /**
     Print the nozzle at the bottom of the rocket.
     This reuses the pattern of the nose cone.
     */
    public static void printNozzle() {
        printNoseCone();
    }
    
    /**
     Print the nose cone. There is a pattern of **
     down the middle of the cone with a widening pattern
     of //...\\ on either side.
     */
    public static void printNoseCone() {
        // your code goes here.
        System.out.println("A nose cone should be here.");
    }
    
    /**
      Print body of rocket. This is a two-stage pattern
      with a diamond pattern in the top half and an
      hour glass on the bottom.
     */
    public static void printBody() {
        printEdge();
        printDiamondTop();
        printDiamondBottom();        
        printEdge();
        printDiamondBottom();        
        printDiamondTop();
                
        printEdge();        
    }
    
    /**
     Print the top half of two diamonds between vertical lines.
     */
    public static void printDiamondTop() {
        // your code goes here.
        System.out.println("A diamond top should be here.");
    }
    
    /**
     Print the bottom half of two diamonds between vertical lines.
     */
    public static void printDiamondBottom() {
        // your code goes here.
        System.out.println("A diamond bottom should be here.");
    }
    /**
      Print +=*=*=*...=+ to fit the width of the rocket.
     */
    public static void printEdge() {
        // your code goes here.
        System.out.println("An edge should be here.");
    }
}