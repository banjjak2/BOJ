package Silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182_2 {
    static int n = 0;
    static int s = 0;
    static int[] map;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        map = new int[n];
        visited = new boolean[n];

        for (int i=0; i<n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0);
        if (s == 0) {
            count--;
        }
        System.out.println(count);
    }

    private static void backtracking(int curPos, int result) {
        if (curPos > n-1) {
            if (result == s) {
                count++;
            }
            return;
        }

        backtracking(curPos+1, result+map[curPos]);
        backtracking(curPos+1, result);
    }
}
