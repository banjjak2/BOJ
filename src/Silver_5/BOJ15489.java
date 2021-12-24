package Silver_5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15489 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] dp = new int[R+W][R+W];
        for(int i=1; i<=R+W-1; i++) {
            dp[i][1] = 1; // 줄의 첫번째 데이터는 1이 되어야 함
            for(int j=1; j<=i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
            dp[i][i] = 1; // 줄의 마지막 데이터는 1이 되어야 함
        }

        int sum = 0;
        int sumCount = C;
        for(int i=R; i<=R+W-1; i++) {
            for(int j=C; j<=sumCount; j++) {
                sum += dp[i][j];
            }
            sumCount++;
        }

        System.out.println(sum);
    }
}
