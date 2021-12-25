package Silver_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.LinkedHashSet;
import java.util.Arrays;
import java.util.Set;

public class BOJ15663 {
    private static Set<String> set = new LinkedHashSet<>();
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
        st = new StringTokenizer(br.readLine());
        int index = 0;
        while (st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        solve(arr, visited, M, 0);

        sb.delete(0, sb.length());
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            sb.append(iter.next()).append('\n');
        }

        System.out.println(sb);
    }

    private static void solve(int[] arr, boolean[] visited, int r, int c) {
        if (c == r) {
            for(int i : result) {
                sb.append(i).append(' ');
            }
            set.add(sb.toString());
            sb.delete(0, sb.length());
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
