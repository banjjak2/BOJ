package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        StringBuilder sb = new StringBuilder();

        int n = 0;
        int remainder = 1;
        int count = 1;
        while ((str = br.readLine()) != null) {
            n = Integer.parseInt(str);
            if (n == 1) {
                System.out.println(1);
                continue;
            }

            count = 1;
            remainder = 1;

            while (remainder != 0) {
                remainder = (10 * remainder + 1) % n;
                count++;
            }

            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }
}
