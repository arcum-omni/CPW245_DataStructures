// Your Name Here
// 7/2/16
// CPW 142
// Example for Assignment #2
//
// This program will print a rug pattern
// like this:
//  +---------+
//  |    *    |
//  |   /*\   |
//  |  //*\\  |
//  | ///*\\\ |
//  | \\\*/// |
//  |  \\*//  |
//  |   \*/   |
//  |    *    |
//  +---------+
//  | \\\*/// |
//  |  \\*//  |
//  |   \*/   |
//  |    *    |
//  |    *    |
//  |   /*\   |
//  |  //*\\  |
//  | ///*\\\ |
//  +---------+

public class RugPattern {

    // global constant that controls size of rug.
    // RUG_SIZE is the number of forward slashes
    // in the lowest line with forward slashes.
    public static final int RUG_SIZE = 3;
    
    public static void main( String[] args ) {
        // the rug has two parts, delimited
        // by lines above, below, and between.
        printLine();   // +---------+
        printTop();    //     top
        printLine();   // +---------+
        printBottom(); //    bottom
        printLine();   // +---------+
    }
    
    // print top part of rug
    public static void printTop() {
        // the diamond pattern has
        // two parts that can be reused:
        // the part that opens downward
        // and the aprt that closes downward.
        open();        
        close();
    }
    
    // print bottom part of rug
    public static void printBottom() {
        // just the reverse of the top.
        close();
        open();        
    }
    
    // print pattern:
    //  |    *    |
    //  |   /*\   |
    //  |  //*\\  |
    public static void open() {
        for( int i = 1; i <= RUG_SIZE + 1; i++ ) {
            System.out.print( "|" );
            for( int j = 1; j <= RUG_SIZE + 2 - i; j++ ) {
                System.out.print( " " );
            }
            for( int j = 1; j <= i -1; j++ ) {
                System.out.print( "/" );
            }
            System.out.print( "*" );
            for( int j = 1; j <= i - 1; j++ ) {
                System.out.print( "\\" );
            }
            for( int j = 1; j <= RUG_SIZE + 2 - i; j++ ) {
                System.out.print( " " );
            }
            System.out.println( "|" );
        }
    }
    
    // print pattern:
    //  |  \\*//  |
    //  |   \*/   |
    //  |    *    |
    public static void close() {
        for( int i = 1; i <= RUG_SIZE + 1; i++ ) {
            System.out.print( "|" );
            for( int j = 1; j <= i; j++ ) {
                System.out.print( " " );
            }
            for( int j = 1; j <= RUG_SIZE + 1 - i; j++ ) {
                System.out.print( "\\" );
            }
            System.out.print( "*" );
            for( int j = 1; j <= RUG_SIZE + 1 - i; j++ ) {
                System.out.print( "/" );
            }
            for( int j = 1; j <= i; j++ ) {
                System.out.print( " " );
            }
            System.out.println( "|" );
        }
    }
    
    // print pattern:
    //  +---------+
    public static void printLine() {
        System.out.print( "+" );
        for( int i = 1; i < 2 * RUG_SIZE + 4; i++ ) {
            System.out.print( "-" );
        }
        System.out.println( "+" );
    }
}