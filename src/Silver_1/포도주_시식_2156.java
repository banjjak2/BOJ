package Silver_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 포도주_시식_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int[] arr = new int[n+1];

        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(arr[1]);
            return;
        } else if (n == 2) {
            System.out.println(arr[1] + arr[2]);
            return;
        }

        // 점화식
        // 1. arr[i]를 마시지 않은 경우
        //     -> dp[i] = dp[i-1]
        // 2. arr[i-1]을 마시고 arr[i]를 마신 경우
        //     -> dp[i] = dp[i-3] + arr[i-1] + arr[i]
        //     arr[i-2]를 마시면 3잔이 연속 되므로 arr[i-2]를 마시기 이전인 dp[i-3]을 취함
        // 3. arr[i-2]를 마시고 arr[i]를 마신 경우
        //     -> dp[i] = dp[i-2] + arr[i]

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        for(int i=3; i<=n; i++) {
            dp[i] = Math.max(Math.max(dp[i-1], dp[i-3]+arr[i-1]+arr[i]), dp[i-2]+arr[i]);
        }

        System.out.println(dp[n]);
    }
}
