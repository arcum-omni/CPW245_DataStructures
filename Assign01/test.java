import java.util.*;

public class test {
    public static void main( String[] args ) {
        
//        public static void addData(int n) {
            int n = 9;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    list.add(0, i);
                    System.out.print(i);
                }
                list.clear();
            }
            while (!list.isEmpty()) {
            list.remove(0);
            }
            System.out.print(list);
//        }
    }
} 