package Silver_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[N];
        int[] dp = new int[N];
        int index = 0;
        while(st.hasMoreTokens()) {
            numbers[index] = Integer.parseInt(st.nextToken());
            dp[index] = 1;
            index++;
        }

        int max = 1;
        for(int i=0; i<N; i++) {
            for(int j=0; j<i; j++) {
                if (numbers[j] < numbers[i]) {
                    max = Math.max(dp[i] + dp[j], max);
                }
            }
            dp[i] = max;
            max = 1;
        }

        int result = 0;
        for(int i=0; i<N; i++) {
            if (dp[i] > result) {
                result = dp[i];
            }
        }

        System.out.println(result);
    }
}
