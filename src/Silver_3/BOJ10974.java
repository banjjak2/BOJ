package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10974 {
    private static StringBuilder sb = new StringBuilder();
    private static int[] result = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        result = new int[N];
        boolean[] visited = new boolean[N];

        for(int i=0; i<N; i++) {
            arr[i] = i+1;
        }

        solve(arr, visited, N, 0);

        System.out.println(sb);
    }

    private static void solve(int[] arr, boolean[] visited, int r, int c) {
        if (c == r) {
            for(int i : result) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        else {
            for(int i=0; i<arr.length; i++) {
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
