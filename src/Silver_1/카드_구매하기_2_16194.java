package Silver_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드_구매하기_2_16194 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] P = new int[N + 1];
        int[] dp = new int[N + 1];
        for(int i=1; i<=N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        // 중복이 허용되니까 1
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j] + P[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
