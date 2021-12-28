package Silver_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10971 {
    private static int[] result = null;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        result = new int[N+1];
        StringTokenizer st = null;

        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        for(int i=0; i<N; i++) {
            arr[i] = i+1;
        }

        int[][] W = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(arr, W, visited, N, 0);

        System.out.println(min);
    }

    private static void calculate(int[][] W, int[] tmp) {
        boolean canMove = true;
        int sum = 0;

        for(int j=0; j<tmp.length-1; j++) {
            if (W[tmp[j]][tmp[j+1]] == 0) {
                canMove = false;
            }

            sum += W[tmp[j]][tmp[j+1]];
        }

        if (canMove) {
            min = Math.min(min, sum);
        }
    }

    private static void solve(int[] arr, int[][] W, boolean[] visited, int r, int c) {
        if (c == r) {
            result[arr.length] = result[0];
            calculate(W, result);
        }
        else {
            for(int i=0; i<arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    result[c] = arr[i];
                    solve(arr, W, visited, r, c+1);
                    visited[i] = false;
                }
            }
        }
    }
}
