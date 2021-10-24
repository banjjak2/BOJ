package Bronze_5;

import java.io.*;

public class 한글_2_11283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println((int)str.charAt(0) - 0xAC00 + 1);
//        System.out.println((int)str.charAt(0) - '가' + 1);
    }
}
