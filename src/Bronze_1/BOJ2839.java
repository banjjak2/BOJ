package Bronze_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int fiveKg = 0;
        int threeKg = 0;
        while(N != 0) {
            if (N%5 == 0) {
                fiveKg = N/5;
                break;
            }
            else {
                if (N < 3) {
                    System.out.println(-1);
                    return;
                }

                N -= 3;
                threeKg++;
            }
        }

        System.out.println(fiveKg + threeKg);
    }
}
