package Gold_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N+1];
        int[] dp1 = new int[N+1];
        int[] dp2 = new int[N+1];
        for(int i=1; i<=N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            dp1[i] = 1;
            dp2[i] = 1;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<i; j++) {
                if (A[i] > A[j]) {
                    if (dp1[i] < dp1[j] + 1) {
                        dp1[i] = dp1[j] + 1;
                    }
                }
            }
        }

        for (int i=N-1; i>0; i--) {
            for (int j=i+1; j<=N; j++) {
                if (A[i] > A[j]) {
                    if (dp2[i] < dp2[j]+1) {
                        dp2[i] = dp2[j] + 1;
                    }
                }
            }
        }

        int max = 1;
        for(int i=1; i<=N; i++) {
            max = Math.max(max, dp1[i] + dp2[i] - 1);
        }

        System.out.println(max);
    }
}
