package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 제곱수의_합_1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 점화식
        // 끝자리가 1^2, 2^2, 3^2, 4^2, ... 일 때
        // (N - 1^2) + 1^2 = N
        // (N - 2^2) + 2^2 = N
        // (N - 3^2) + 3^2 = N
        // ...
        //
        // 1. DP[i] = DP[i-j^2] + 1
        // i=1, j^2=1^2 => DP[1] = DP[0] + 1 (1)
        // i=2, j^2=1^2 => DP[2] = DP[1] + 1 (2)
        // i=3, j^2=1^2 => DP[3] = DP[2] + 1 (3)
        // i=4, j^2=1^2 => DP[4] = DP[3] + 1 (4) X
        // i=4, j^2=2^2 => DP[4] = DP[0] + 1 (1)
        // ...

        int[] dp = new int[N+1];
        // 1+1+1+1+... 이 최소라고 가정하기 위해
        for(int i=1; i<=N; i++) {
            dp[i] = i;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }

        System.out.println(dp[N]);
    }
}
