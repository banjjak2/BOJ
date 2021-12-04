package Silver_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 오르막_수_11057 {
    private static final int MOD_VALUE = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10];
        // 길이가 1일 때 끝 자리가 0 ~ 9인 경우는 모두 1
        // 0 1 2 3 4 5 6 7 8 9
        for(int j=0; j<=9; j++) {
            dp[1][j] = 1;
        }

        // 점화식
        // D[i][j] = i번째 수가 j일 때 오르막 수가 될 수 있는 개수
        // D[i][j] = D[i-1][j] + D[i-1][j-1] + D[i-1][j-2] + ... + D[i-1][0]
        // 단, [0 <= j <= 9, 1 <= i <= 1000]
        for(int i=2; i<=N; i++) {
            for(int j=0; j<=9; j++) {
                for(int k=0; k<=j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][k]) % MOD_VALUE;
                }
            }
        }

        // 맨 마지막 숫자가 0~9 중 어떤 것이 나올지 모르므로 N길이에서 0~9까지 모든 경우의 수를 더해줌
        int result = 0;
        for(int i=0; i<=9; i++) {
            result += dp[N][i];
        }

        System.out.println(result % MOD_VALUE);
    }
}
