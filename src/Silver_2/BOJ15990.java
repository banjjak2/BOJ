package Silver_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ15990 {
    private static final int MOD_VALUE = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int n = 0;
        long[][] dp = new long[100000 + 1][4];
        // n이 1일 때 수식의 끝자리가 1, 2, 3의 개수
        dp[1][1] = 1; dp[1][2] = 0; dp[1][3] = 0;
        // n이 2일 때 수식의 끝자리가 1, 2, 3의 개수
        dp[2][1] = 0; dp[2][2] = 1; dp[2][3] = 0;
        // n이 3일 때 수식의 끝자리가 1, 2, 3의 개수
        dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;

        for(int i=4; i<=100_000; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3])%MOD_VALUE;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3])%MOD_VALUE;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2])%MOD_VALUE;
        }

        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            n = Integer.parseInt(br.readLine());
            sb.append((dp[n][1] + dp[n][2] + dp[n][3])%MOD_VALUE).append('\n');
        }

        System.out.println(sb);
    }
}
