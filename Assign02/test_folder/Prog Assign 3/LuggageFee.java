import java.util.*;
// A certain airline charges luggage
// fees as follows:
// 1. Each passenger is allowed at most two
//    pieces of luggage.
// 2. Each passenger is allowed at most 50
//    pounds without an additional fee.
// 3. Overwieght luggage is assessed a charge
//    of $2 per pound over 50 pounds.
// 4. Each piece of luggage must satisfy a
//    size requirement: the sum of its
//    length, width, and height must be
//    less than or equal to 62 inches.
//    Oversized luggage is assessed a charge
//    of $5 for each oversized piece of luggage.

public class LuggageFee {
    public static void main( String[] args ) {
        Scanner console = new Scanner( System.in );
        
        int numLuggage = luggageCount( console );

    }
    
    public static int luggageCount( Scanner console ) {
    
        int numLuggage = 0;
    
        System.out.print( "You are allowed at most two pieces of luggage." );
        System.out.print( "How many pieces of luggage do you have? " );
        
        while ( !console.hasNextInt() ) {
            System.out.print( "You are allowed at most two pieces of luggage." );
            System.out.print( "How many pieces of luggage do you have? " );
        }
        
        numLuggage =  console.nextInt();
        console.nextLine();
        return numLuggage;
    }
}