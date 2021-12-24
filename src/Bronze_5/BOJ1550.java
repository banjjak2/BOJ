package Bronze_5;

import java.util.*;

public class BOJ1550 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String order = "0123456789ABCDEF";
        String hex = scanner.nextLine();

        int result = 0;
        char c = ' ';
        int index = 0;
        for(int i=hex.length() - 1; i>=0; i--){
            c = hex.charAt(i);
            index = order.indexOf(c);
            if (index >= 0){
                result += (index * Math.pow(16, hex.length() - 1 - i));
            }
        }

        System.out.println(result);
    }
}
