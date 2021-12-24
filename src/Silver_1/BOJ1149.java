package Silver_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][3+1];
        int[][] arr = new int[N+1][3+1];
        StringTokenizer st = null;

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 점화식
        // 1. DP[i][c] = i번째 집을 c로 칠할 때 1 ~ i번째 집 까지의 최소 비용

        // 2. DP[i][빨] = DP[i-1][녹] + Arr[빨]
        //    -> i번째 집을 빨간색으로 칠할 때 i-1번째 집이 녹색일 경우의 수 중 최소값
        // 2-1. DP[i][빨] = DP[i-1][파] + Arr[빨]
        //    -> i번째 집을 빨간색으로 칠할 때 i-1번째 집이 파란색일 경우의 수 중 최소값

        // 3. DP[i][녹] = DP[i-1][빨] + Arr[녹]
        //    -> i번째 집을 녹색으로 칠할 때 i-1번째 집이 빨간색일 경우의 수 중 최소값
        // 3-1. DP[i][녹] = DP[i-1][파] + Arr[녹]
        //    -> i번째 집을 녹색으로 칠할 때 i-1번째 집이 파란색일 경우의 수 중 최소값

        // 4. DP[i][파] = DP[i-1][빨] + Arr[파]
        //    -> i번째 집을 파란색으로 칠할 때 i-1번째 집이 빨간색일 경우의 수 중 최소값
        // 4-1. DP[i][파] = DP[i-1][녹] + Arr[파]
        //    -> i번째 집을 파란색으로 칠할 때 i-1번째 집이 녹색일 경우의 수 중 최소값

        for(int i=1; i<=N; i++) {
            dp[i][1] = Math.min(dp[i-1][2], dp[i-1][3]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][3]) + arr[i][2];
            dp[i][3] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][3];
        }

        System.out.println(Math.min(Math.min(dp[N][1], dp[N][2]), dp[N][3]));
    }
}
