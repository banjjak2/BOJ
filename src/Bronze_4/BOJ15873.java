package Bronze_4;

import java.io.*;

public class BOJ15873 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int len = s.length();

        int sum = 0;
        for(int i=0; i<s.length(); i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }

        if (len == 3) {
            sum -= 1;
            sum += 10;
        }
        else if (len == 4) {
            sum -= 2;
            sum += 20;
        }

        System.out.println(sum);
    }
}
