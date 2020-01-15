public class ReverseNumber {
    public static void main( String[] args ) {
        System.out.println( reverse( 1234 ) );
    }
    public static int reverse( int n ) {
        int r = 0;
        while ( n > 0 ) {
            r = 10 * r + n % 10;
            n /= 10;
        }
        return r;
    }
}