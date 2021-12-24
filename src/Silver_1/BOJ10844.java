package Silver_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10844 {
    private static final int MOD_VALUE = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][10];
        // 길이가 1일 때
        for(int i=1; i<=9; i++) {
            dp[1][i] = 1;
        }

        for(int i=2; i<=N; i++) {
            for(int j=0; j<=9; j++) {
                dp[i][j] = 0;
                if (j-1 >= 0) {
                    dp[i][j] += dp[i-1][j-1];
                }
                if (j+1 <= 9) {
                    dp[i][j] += dp[i-1][j+1];
                }
                dp[i][j] %= MOD_VALUE;
            }
        }

        long result = 0;
        for(int i=0; i<=9; i++) {
            result += dp[N][i];
        }

        System.out.println(result%MOD_VALUE);
    }
}
