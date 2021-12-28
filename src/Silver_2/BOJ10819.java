package Silver_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10819 {
    private static int max = 0;
    private static int[] result = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        result = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve(arr, visited, N, 0);

        System.out.println(max);
    }

    private static void solve(int[] arr, boolean[] visited, int r, int c) {
        if (c == r) {
            int sum = 0;
            for(int i=0; i<arr.length-1; i++) {
                sum += Math.abs(result[i] - result[i+1]);
            }
            max = Math.max(max, sum);
            return;
        }
        else {
            for (int i=0; i<arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    result[c] = arr[i];
                    solve(arr, visited, r, c+1);
                    visited[i] = false;
                }
            }
        }
    }
}
