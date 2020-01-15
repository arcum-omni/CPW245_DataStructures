import java.util.*;

// Your name goes here!
// CIT 142 Winter 2015
// Programming Exercise 3
// This program will ... fill in a good description here!

public class PaintJobEstimator {

    // square feet per one gallon of paint.
    public static final double AREA_PER_GALLON = 112.0; 
    
    // hours of labor needed to paint AREA_PER_GALLON square feet.
    public static final double HOURS_PER_UNIT_AREA = 8.0;
    
    // charge to customer for one hour of labor.
    public static final double LABOR_COST_PER_HOUR = 35.0;

    // main declares a Scanner that is passed to
    // the input methods. main also controls the
    // order of calculations.
    public static void main( String[] args ) {
    System.out.printf("This is %f with %d digits: %.2f.", 1.2367, 2, 1.2367);
        Scanner keyboard = new Scanner( System.in );
        
        // How many square feet do we need to paint?
        double sqft = getInput( keyboard, "Enter the number of square feet: " );
        
        // How much does a gallon of paint cost?
        double gallonCost = getInput( keyboard, 
                                     "Enter the price of a gallon of paint: " );
        
        ////////////////////////////////////////
        // Calculate the cost of this paint job.
        ////////////////////////////////////////
        
        // First, how many gallons of paint do we need?
        int numGallons = calculateGallons( sqft );
        
        // How long will the job take?
        double hoursLabor = calculateHours( sqft );
        
        // How much will the paint cost?
        double paintCost = calculatePaintCost( numGallons, gallonCost );
        
        // How much will the labor cost?
        double laborCost = calculateLaborCost( hoursLabor );
        
        // What's the total bill?
        double totalCost = calculateTotalCost( paintCost, laborCost );
        
        // Print the results.
        generateReport( sqft, gallonCost, numGallons, hoursLabor, 
                        paintCost, laborCost, totalCost);
        
    }
    
    public static double getInput( Scanner input, String prompt ) {
        System.out.print( prompt );
        while ( !input.hasNextDouble() ) {
            input.nextLine(); // get rid of bad input.
            System.out.print( prompt );
        }
        double inValue = input.nextDouble();
        input.nextLine(); // clear the input line.
        return inValue;
    }
    
    public static int calculateGallons( double sqft ) {
        return (int)Math.ceil( sqft / AREA_PER_GALLON );
    }
    
    public static double calculateHours( double sqft ) {
        return sqft * HOURS_PER_UNIT_AREA / AREA_PER_GALLON;
    }
    
    public static double calculatePaintCost( int numGallons, double gallonCost ) {
        return numGallons * gallonCost;
    }
    
    public static double calculateLaborCost( double hoursLabor ) {
        return hoursLabor * LABOR_COST_PER_HOUR;
    }
    
    public static double calculateTotalCost( double paintCost, 
                                             double laborCost ) {
        return paintCost + laborCost;
    }
    
    public static void generateReport( double sqft, double gallonCost,  
                                       int numGallons,double hoursLabor,  
                                       double paintCost, double laborCost, 
                                       double totalCost ) {
        System.out.printf( "To paint %.2f square feet, with\n", sqft );
        System.out.printf( "paint that costs %.2f per gallon,\n",  gallonCost );
        System.out.printf( "you will need %d gallons of paint\n", numGallons );
        System.out.printf( "and %.2f hours of labor.\n", hoursLabor );
        System.out.printf( "The cost of the paint is: %.2f\n", paintCost );
        System.out.printf( "The cost of the labor is: %.2f\n", laborCost );
        System.out.printf( "The total cost of the job is: %.2f\n", totalCost );
    }
}