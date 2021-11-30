package Silver_5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리_놓기_1010 {
    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        int eastCount = 0;
        int westCount = 0;

        for(int r=1; r<=30; r++) {
            for(int n=r; n<=30; n++) {
                dp[n][r] = combination(n, r);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            westCount = Integer.parseInt(st.nextToken());
            eastCount = Integer.parseInt(st.nextToken());
            sb.append(dp[eastCount][westCount]).append('\n');
        }

        System.out.println(sb);
    }

    public static int combination(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        }

        return combination(n-1, r-1) + combination(n-1, r);
    }
}
