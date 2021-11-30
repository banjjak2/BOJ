package Silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 악수_8394_array {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        dp[1] = 1; dp[2] = 2;
        for(int i=3; i<=n; i++) {
            dp[i] = (dp[i-1]%10 + dp[i-2]%10)%10;
        }

        System.out.println(dp[n]);
    }
}
