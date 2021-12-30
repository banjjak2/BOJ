package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9095_Recur {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {1, 2, 3};
        int T = Integer.parseInt(br.readLine());
        int n = 0;
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            sb.append(solve(arr, n, 0)).append('\n');
        }

        System.out.println(sb);
    }

    private static int solve(int[] arr, int n, int sum) {
        if (sum > n) {
            return 0;
        }
        else if (sum == n) {
            return 1;
        }

        int curSumData = 0;
        for(int i=0; i<arr.length; i++) {
            curSumData += solve(arr, n, sum+arr[i]);
        }
        return curSumData;
    }
}
