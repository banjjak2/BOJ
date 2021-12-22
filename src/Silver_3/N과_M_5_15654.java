package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N과_M_5_15654 {
    private static StringBuilder sb = new StringBuilder();
    private static int[] result = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        result = new int[M];

        int index = 0;
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }

        int[] sortResult = sort(arr);
        solve(sortResult, visited, M, 0);

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

    private static int[] sort(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++) {
            pq.add(arr[i]);
        }

        int[] result = new int[arr.length];
        int index = 0;
        while (!pq.isEmpty()) {
            result[index++] = pq.remove();
        }

        return result;
    }
}
