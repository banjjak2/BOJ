package Silver_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1309 {
    private static final int MOD_VALUE = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // dp[1][0] => 1번째 줄에 배치하지 않을 경우
        // dp[1][1] => 1번째 줄의 왼쪽에 배치할 경우
        // dp[1][2] => 1번째 줄의 오른쪽에 배치할 경우
        int[][] dp = new int[N+1][3];
        // 1번째 줄
        dp[1][0] = 1; // "사자를 한 마리도 배치하지 않는 경우도 하나의 경우의 수" 조건
        dp[1][1] = 1; // 왼쪽에 배치할 경우
        dp[1][2] = 1; // 오른쪽에 배치할 경우

        for(int i=2; i<=N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD_VALUE;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD_VALUE;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD_VALUE;
        }

        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % MOD_VALUE);
    }
}
