package Silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2529_2 {
    private static int[] result = null;
    private static long max = 0;
    private static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] op = new char[K];
        for(int i=0; i<K; i++) {
            op[i] = st.nextToken().charAt(0);
        }

        result = new int[K+1];
        boolean[] visited = new boolean[10];
        solve(op, result, visited, K+1, 0);

        StringBuilder sb = new StringBuilder();
        if (len(max) != K+1) {
            sb.append(0).append(max);
            System.out.println(sb);
        }
        else {
            System.out.println(max);
        }

        if (len(min) != K+1) {
            sb.append(0).append(min);
            System.out.println(sb);
        }
        else {
            System.out.println(min);
        }
    }

    private static int len(long value) {
        int count = 0;
        while (value != 0) {
            value /= 10;
            count++;
        }

        return count;
    }

    private static int count = 0;
    private static StringBuilder sb = new StringBuilder();
    private static void solve(char[] op, int[] result, boolean[] visited, int r, int c) {
        if (c == r) {
            for(int i : result) {
                sb.append(i);
            }

            long answer = Long.parseLong(sb.toString());
            min = Math.min(min, answer);
            max = Math.max(max, answer);
            sb.delete(0, sb.length());
        }
        else {
            for(int i=0; i<=9; i++) {
                if (!visited[i]) {
                    count = c;
                    result[c] = i;

                    if (count >= 1) {
                        if (op[c-1] == '<') {
                            if (result[c-1] > result[c]) {
                                continue;
                            }
                        }
                        else if (op[c-1] == '>') {
                            if (result[c-1] < result[c]) {
                                continue;
                            }
                        }
                    }

                    visited[i] = true;
                    solve(op, result, visited, r, c+1);
                    visited[i] = false;
                    count = c;
                }
            }
        }
    }
}
