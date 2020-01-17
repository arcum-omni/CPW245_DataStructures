// Travis Eiler
// CPW 245, Winter '20
// Assignment #3: ArrayIntListTester Extra Credit
// Due: Jan 22, 2020
//
// The purpose of this extra credit is to add test code for for the method public void addAll( int index, ArrayIntList list ).

public class ArrayIntListTester {
    public static void main(String[] args) {
        // construct and print list
        int[] data = {5, 19, 0, 2, 4, 0, 13, 85, -8, 0, 23};
        ArrayIntList list = new ArrayIntList();
        for (int n : data) {
            list.add(n);
        }
        System.out.println("list = " + list);
        
        int[] data2 = { 42, 12, 7, -4};
        ArrayIntList list2 = new ArrayIntList();
        for (int n : data2) {
            list2.add(n);
        }
        System.out.println("list2 = " + list2);
        
        list.addAll(list2);
        System.out.println("after addAll, list = " + list);
        
        // Extra Credit
        int[] data5 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        ArrayIntList list5 = new ArrayIntList();
        for (int n : data5) {
            list5.add(n);
        }
        System.out.println("list5 = " + list5);
        
        int[] data6 = { 60, 61, 62, 63};
        ArrayIntList list6 = new ArrayIntList();
        for (int n : data6) {
            list6.add(n);
        }
        System.out.println("list6 = " + list6);
        
        list5.addAll( 4, list6 );
        System.out.println("list5 after list5.addAll(4,list6) = " + list5);
        
        // should return true
        System.out.println("containsAll: " + list.containsAll(list2) );
        
        // should return false
        ArrayIntList list4 = new ArrayIntList();
        list4.add(100);
        System.out.println("containsAll: " + list.containsAll(list4) );
        
        ArrayIntList list3 = new ArrayIntList();
        for (int n : data2) {
            list3.add(n);
        }
        // should return true
        System.out.println("list2 equals list3: " + list2.equals(list3) );
        
        // should return 9
        System.out.println("list lastIndexOf(0): " + list.lastIndexOf(0)); 
    }
}
