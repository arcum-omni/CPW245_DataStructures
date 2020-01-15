public class Calendar {
    public static void main( String[] args ) {
        int weeks = calendar(3, 31);
        System.out.println( "The number of full weeks is " + weeks );
    }
    public static int calendar( int startDay, int daysInMonth ) {
        System.out.println( "  Sun    Mon    Tue    Wed    Thu    Fri    Sat" );
        System.out.println( "+------+------+------+------+------+------+------+"); 
        int daysInFirstWeek = 8 - startDay;
        int remainingDays = daysInMonth - daysInFirstWeek;
        int numFullWeeks = remainingDays / 7;
        int daysInLastWeek = remainingDays % 7;
        // print
        int currentDay = daysInFirstWeek + 1;
        for ( int i = 1; i <= numFullWeeks; i++ ) {
            for ( int j = 1; j <= 7; j++ ) {
                System.out.print( "|" + padded(currentDay,4) + "  " );
                currentDay++;
            }
            System.out.println( "|");
        }
        // print last row
        System.out.println( "+------+------+------+------+------+------+------+"); 
        return numFullWeeks;
    }
    public static String padded( int n, int width ) {
        String s = "" + n;
        for ( int i = s.length(); i < width; i++ ) {
            s = " " + s;
        }
        return s;
    }
}