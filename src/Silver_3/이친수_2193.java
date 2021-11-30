package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 이친수_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        // 점화식
        // 1. dp[N][0] = DP[N-1][0] + DP[N-1][1]
        //    끝자리가 0일 때 앞자리엔 0과 1이 올 수 있으므로
        //
        // 2. dp[N][1] = DP[N-1][0]
        //    끝자리가 1일 때 앞자리엔 0만 올 수 있으므로

        // 구현의 편의를 위해 +1
        // N+1 : 길이
        // 2   : N 위치에 가능한 숫자 개수
        long[][] dp = new long[N+1][2];
        // 첫번째 자리에는 0이 올 수 없음
        dp[1][0] = 0;
        dp[1][1] = 1;
        // N이 2일 경우 10만 가능
        dp[2][1] = 0;
        dp[2][0] = 1;

        for(int i=3; i<=N; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[N][0] + dp[N][1]);
    }
}
