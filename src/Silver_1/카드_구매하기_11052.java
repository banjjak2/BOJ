package Silver_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드_구매하기_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] P = new int[N + 1];
        int[] dp = new int[N + 1];
        for(int i=1; i<=N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 중복이 허용되니까 1
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=i; j++) {
                // 새로운 누적값과 이전 누적값 비교
                /* N = 4,
                    1) 1   1   1   1
                    2) 1   1   2
                    3) 1   3
                    4) 4
                    비교해야 함
                 */
                dp[i] = Math.max(dp[i], dp[i-j] + P[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
