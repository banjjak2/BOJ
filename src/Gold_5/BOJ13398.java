package Gold_5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp1[i] = arr[i];
            dp2[i] = arr[i];
        }

        for(int i=2; i<=n; i++) {
            dp1[i] = Math.max(arr[i], dp1[i-1] + arr[i]);
        }

        for(int i=n-1; i>=1; i--) {
            dp2[i] = Math.max(arr[i], dp2[i+1] + arr[i]);
        }

        int max = dp1[1];
        for(int i=1; i<=n; i++) {
            max = Math.max(dp1[i], max);
        }
        for(int i=1; i<=n-1; i++) {
            max = Math.max(max, dp1[i-1] + dp2[i+1]);
        }

        System.out.println(max);
    }
}
