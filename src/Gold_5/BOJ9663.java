package Gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663 {

    static boolean[] column = null;
    static boolean[] left = null;
    static boolean[] right = null;
    static int n = 0;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        column = new boolean[n];
        left = new boolean[n*2-1];
        right = new boolean[n*2-1];

        backtracking(0);
        System.out.println(answer);
    }

    private static void backtracking(int count) {
        if (count == n) {
            answer++;
            return;
        }

        for (int i=0; i<n; i++) {
            if (column[i] || left[count + i] || right[count - i + n - 1]) {
                continue;
            }

            column[i] = true;
            left[count + i] = true;
            right[count - i + n - 1] = true;
            backtracking(count + 1);
            column[i] = false;
            left[count + i] = false;
            right[count - i + n - 1] = false;
        }
    }
}
