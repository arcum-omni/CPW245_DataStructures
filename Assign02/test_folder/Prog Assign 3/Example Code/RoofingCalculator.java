/*
Example code for chapter 3 using 
parameters and return values.

Determine the cost of replacing
the roof on a house.
The cost depends on: 
- the sq. ft. of roofing material needed, 
- cost per sq. ft.,
- the slope of the roof,
- and the number of planes in the roof.

A simple "monopoly house" only has two planes,
  __
 /__/\
 |__||
while a "McMansion" may have many planes.

*/

import java.util.*;

public class RoofingCalculator {
    // cost per sq. ft. of roofing material
    public static final double SLATE_COST = 20.50; // slate roofing
    public static final double SHAKE_COST = 15.75; // cedar shakes
    public static final double COMPO_COST = 12.00; // composition shingles
    
    // other cost factors
    public static final double FEE_PER_PLANE = 100.00; // cost per flat surface
    public static final double FEE_FOR_STEEP = 200.00; // steep roof cost extra
    
    // 
    public static void main( String[] args ) {
    
        Scanner console = new Scanner( System.in );
    
        printInstructions();
         
        double sqFt = getSqFt( console );
         
        double costPerSqFt = getCostPerSqFt( console );
         
        double slopeFee = getSlopeFee( console );
         
        int numPlanes = getNumPlanes( console );
         
        double totalCost = getTotalCost( sqFt, costPerSqFt, slopeFee, numPlanes );
         
        printReport( totalCost, sqFt, costPerSqFt, slopeFee, numPlanes * FEE_PER_PLANE );
         
    }
    
    // Welcome the user.
    public static void printInstructions() {
        System.out.println( "This program will estimate the cost" );
        System.out.println( "of a new roof. We will need some data..." );
    }
    
    // ask user for square footage of the roof.
    public static double getSqFt( Scanner console ) {
        System.out.print( "How many sq. ft. of roof? " );
        double sqFt = console.nextDouble();
        return sqFt;
    }
    
    // ask user what type of roofing material to use.
    public static double getCostPerSqFt( Scanner console ) {
        System.out.print( "Slate, Shakes, or Composition? (1, 2, 3): " );
        int type = console.nextInt();
        if ( type == 1 ) {
            return SLATE_COST;
        }
        else if ( type == 2 ) {
            return SHAKE_COST;
        }
        else {
            return COMPO_COST;
        }
    }
    
    // steep roofs cost more to install.
    public static double getSlopeFee( Scanner console ) {
        System.out.print( "Is the roof pitched more than 35 degrees? (y, n): " );
        String degrees = console.next();
        if ( degrees.equals( "y" ) ) {
            return FEE_FOR_STEEP;
        }
        else {
            return 0.0;
        }
    }
    
    // how complex is the roof?
    public static int getNumPlanes( Scanner console ) {
        System.out.print( "How many surfaces does the roof have? ");
        int numSurfaces = console.nextInt();
        return numSurfaces;
    }
    
    // add up the costs.
    public static double getTotalCost( double sqFt, // total roof area
                                       double costPerSqFt, // roof material cost
                                       double slopeFee, // steepness fee
                                       int numPlanes // how complex the roof is
                                     ) {
        return sqFt * costPerSqFt + slopeFee + numPlanes * FEE_PER_PLANE;
    }
    
    // print the job estimate.
    public static void printReport( double totalCost, // final bill
                                    double sqFt, // total roof area
                                    double costPerSqFt, // roof material cost
                                    double slopeFee, // steepness fee
                                    double complexityCost // how complex the roof is
                                  ) {
        System.out.println( "Cost breakdown:" );
        System.out.println( "Roof has an area of " + sqFt + " sq. ft." );
        System.out.println( "Cost per sq. ft. is: " + costPerSqFt );
        System.out.println( "Steepness fee is: " + slopeFee );
        System.out.println( "Complexity of roof: " + complexityCost );
        System.out.println( "Total: " + totalCost );
    }
}