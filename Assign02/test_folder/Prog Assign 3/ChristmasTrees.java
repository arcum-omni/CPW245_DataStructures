public class ChristmasTrees {
    public static void main( String[] args ) {
        System.out.println( christmasTree( 3, 4 ) );
        System.out.println( christmasTree( 2, 5 ) );
        System.out.println( christmasTree( 4, 6 ) );
    }
    
    public static int christmasTree( int numSegments, int segmentHeight ) {
        
        for ( int segment = 1; segment <= numSegments; segment++ ) {
            for ( int line = 1; line <= segmentHeight; line++ ) {
                for ( int j = 1; j <= numSegments + segmentHeight - segment - line; j++ ) {
                    System.out.print( " " );
                }
                for ( int j = 1; j <= 2 * segment + 2 * line - 3; j++ ) {
                    System.out.print( "*" );
                }
                System.out.println();
            }
        }
        
        return numSegments * segmentHeight + 3;
    }
}