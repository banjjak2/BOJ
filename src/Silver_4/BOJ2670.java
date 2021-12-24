package Silver_4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2670 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] inputArray = new double[N];
        double[] dp = new double[N];
        double max = 0;

        for(int i=0; i<N; i++) {
            inputArray[i] = Double.parseDouble(br.readLine());
        }

        dp[0] = inputArray[0];
        max = dp[0];
        for(int i=1; i<N; i++) {
            dp[i] = Math.max(dp[i-1]*inputArray[i], inputArray[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(String.format("%.3f", max));
    }
}
