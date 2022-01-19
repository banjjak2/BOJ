package Silver_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2529 {
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

        if (len(max) != K+1) {
            System.out.println("0" + max);
        }
        else {
            System.out.println(max);
        }

        if (len(min) != K+1) {
            System.out.println("0" + min);
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

    private static void solve(char[] op, int[] result, boolean[] visited, int r, int c) {
        if (c == r) {
            if (!validate(op, result)) {
                return;
            }

            long answer = 0;
            for(int i=0; i<result.length; i++) {
                answer *= 10;
                answer += result[i];
            }

            min = Math.min(min, answer);
            max = Math.max(max, answer);
        }
        else {
            for(int i=0; i<=9; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    result[c] = i;
                    solve(op, result, visited, r, c+1);
                    visited[i] = false;
                }
            }
        }
    }

    private static boolean validate(char[] op, int[] result) {
        for(int i=0; i<result.length-1; i++) {
            if (op[i] == '<') {
                if (result[i] > result[i+1]) {
                    return false;
                }
            }
            else if (op[i] == '>') {
                if (result[i] < result[i+1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
