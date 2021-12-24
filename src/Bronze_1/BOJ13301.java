package Bronze_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ13301 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        long[] dp = new long[N + 1];
        dp[0] = 0; dp[1] = 1;
        for(int i=2; i<=N; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        // 현재값의 이전 두 개 값을 더한게 가로가 되고
        long width = dp[N-1] + dp[N-2];
        // 현재값과 이전값을 더한게 세로가 됨
        long height = dp[N] + dp[N-1];

        System.out.println(width * 2 + height * 2);
    }
}
