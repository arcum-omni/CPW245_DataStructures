// Travis Eiler
// CPW 245, Winter '20
// Assignment #9: Functional Programming
// Due: Jan 22, 2020
// 
// The purpose of this program is to test the method countNegatives().
// 
// The purpose of this assignment is to use stream operations to create the method
// countNegatives() to count how many negative integers are in a given array.

// I could have used the catch all import statement ( import java.util.*; ),
// but I wanted to be specific about which classes/packages are required to 
// run this program.
import java.util.Arrays;
import java.util.stream.Collectors;

public class countNegativesTester{
    public static void main( String[] args ) {
        
        int[] arr01 =  {5, -1, -3, 20, 47, -10, -8, -4, 0, -6, -6};
        System.out.println( countNegatives( arr01 ));
        
        int[] arr02 =  {-5, -1, -3, -20, -47, -10, -8, -4, -6, -6};
        System.out.println( countNegatives( arr02 ));
        
        int[] arr03 =  {5, 1, 3, 20, 47, 0, 6, 6};
        System.out.println( countNegatives( arr03 ));
        
        int[] arr04 = {};
        System.out.println( countNegatives( arr04 ));
    }
    
    public static long countNegatives( int[] arr ) {
        // https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
        // Stream method:  Type:  Description:
        // count()         long   returns the count of elements in a stream
        return Arrays.stream(arr).filter(n -> n < 0).count();
    }
}
