package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class One_Two_Three_더하기_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n = 0;
        int[] dp = new int[11 + 1];

        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for(int i=4; i<dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }

        System.out.println(sb);
    }
}
