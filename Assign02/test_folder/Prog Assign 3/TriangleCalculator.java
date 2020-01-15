public class TriangleCalculator {
    public static void main( String[] args ) {
        System.out.println( largestAngle(3,4,5) );
    }
    
    public static double largestAngle( double a, double b, double c ) {
        double angleA = Math.acos( ( b * b + c * c - a * a ) / ( 2 * b * c ) );
        double angleB = Math.acos( ( a * a + c * c - b * b ) / ( 2 * a * c ) );
        double angleC = Math.acos( ( a * a + b * b - c * c ) / ( 2 * a * b ) );
        
        return Math.toDegrees( Math.max( Math.max( angleA, angleB ), angleC ) );
    }
}