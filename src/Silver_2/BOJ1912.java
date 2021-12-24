package Silver_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 점화식
        // 1. 선택된 숫자가 마지막으로 선택된 숫자인 경우
        //    dp[i] = dp[i-1] + arr[i]
        // 2. 새롭게 연속합이 시작될 경우
        //    dp[i] = A[i]
        // 최대합을 구해야 하므로 1, 2를 비교해서 큰 값을 저장

        int[] dp = new int[n+1];
        int[] numbers = new int[n+1];
        int index = 1;
        while (st.hasMoreTokens()) {
            numbers[index++] = Integer.parseInt(st.nextToken());
        }

        int max = (-1) * Integer.MAX_VALUE;
        for(int i=1; i<=n; i++) {
            dp[i] = Math.max(dp[i-1] + numbers[i], numbers[i]);
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
