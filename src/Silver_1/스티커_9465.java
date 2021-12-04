package Silver_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int n = 0;
        int[][] dp = null;
        int[][] arr = null;
        StringBuilder sb = new StringBuilder();
        int max = 0;

        while(T-- > 0) {
            n = Integer.parseInt(br.readLine());
            dp = new int[n + 1][3];
            arr = new int[n + 1][2];

            for(int i=0; i<2; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=n; j++) {
                    arr[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=1; i<=n; i++) {
                dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + arr[i][0];
                dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + arr[i][1];
            }

            max = Math.max(Math.max(dp[n][0], dp[n][1]), dp[n][2]);
            sb.append(max).append('\n');
        }

        System.out.println(sb);
    }
}
