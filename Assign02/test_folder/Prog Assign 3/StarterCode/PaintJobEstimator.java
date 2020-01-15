import java.util.*;

// Your name goes here!
// CPW 142 Spring 2016
// Programming Assignment 3
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
        Scanner keyboard = new Scanner( System.in );
        
        // How many square feet do we need to paint?
        double sqft = getInput( keyboard, 
                       "Enter the number of square feet: " );
        
        // How much does a gallon of paint cost?
        double gallonCost = getInput( keyboard, 
                       "Enter the price of a gallon of paint: " );
        
        ////////////////////////////////////////
        // Calculate the cost of this paint job.
        ////////////////////////////////////////
        
        // First, how many gallons of paint do we need?
        int numGallons = calculateGallons( sqft );
        //System.out.println( numGallons );
        
        
        // How long will the job take?
        double hoursLabor = calculateHours( sqft );
        
        // How much will the paint cost?
        double paintCost = calculatePaintCost( numGallons, 
                                               gallonCost );
        
        // How much will the labor cost?
        double laborCost = calculateLaborCost( hoursLabor );
        
        // What's the total bill?
        double totalCost = calculateTotalCost( paintCost, 
                                               laborCost );
        
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
    
    // Your methods go here:
    
    // calculateGallons
    public static int calculateGallons( double sqft ) {
        // TO DO return correct value
        return 0;
    } 
    
    // calculateHours
    public static double calculateHours( double sqft ) {
        // TO DO return correct value
        return 0.0;
    }
    
    // TO DO: calculatePaintCost
    
    // TO DO: calculateLaborCost
    
    // TO DO: calculateTotalCost
    
    // To Do: generateReport        
}