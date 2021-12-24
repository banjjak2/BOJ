package Gold_5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2225 {
    private static final int MOD_VALUE = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[K+1][N+1];
        // D[1][0 ~ N]까지 1로 설정
        // https://imgur.com/a/j7EVxjZ
        for(int i=0; i<=N; i++) {
            dp[1][i] = 1;
        }

        for(int k=2; k<=K; k++) {
            for(int n=0; n<=N; n++) {
                for(int l=0; l<=n; l++) {
                    dp[k][n] += dp[k-1][n-l];
                }
                dp[k][n] %= MOD_VALUE;
            }
        }

        System.out.println(dp[K][N]);
    }
}
