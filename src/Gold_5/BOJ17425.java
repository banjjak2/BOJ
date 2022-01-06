package Gold_5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ17425 {
    private static final int MAX_VALUE = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] saved = new long[MAX_VALUE+1];

        for(int i=1; i<=MAX_VALUE; i++) {
            for(int j=i; j<=MAX_VALUE; j+=i) {
                saved[j] += i;
            }
            saved[i] += saved[i-1];
        }


        int T = Integer.parseInt(br.readLine());
        int N = 0;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            sb.append(saved[N]).append('\n');
        }

        System.out.println(sb);
    }
}