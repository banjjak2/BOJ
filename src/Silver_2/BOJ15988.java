package Silver_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ15988 {
    private static final int MAX_VALUE = 1_000_000;
    private static final int MOD_VALUE = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[MAX_VALUE + 1];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;

        for(int i=4; i<=MAX_VALUE; i++) {
            dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % MOD_VALUE;
        }

        int n = 0;
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }

        System.out.println(sb);
    }
}
