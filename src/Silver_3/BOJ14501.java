package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {
    private static StringBuilder sb = new StringBuilder();
    private static int max = 0;
    private static int[] days = null;
    private static int[] pays = null;
    private static boolean[] result = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        days = new int[N];
        pays = new int[N];
        result = new boolean[N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            pays[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, N, 0);

        System.out.println(max);
    }

    private static void solve(int curIndex, int N, int lastIndex) {
        if (curIndex >= N) {
            if (curIndex != N) {
                result[curIndex - lastIndex] = false;
            }
            int answer = 0;
            for(int i=0; i<result.length; i++) {
                if (result[i]) {
                    answer += pays[i];
                }
            }
            max = Math.max(max, answer);
            return;
        }
        else {
            for(int i=curIndex; i<days.length; i++) {
                result[i] = true;
                solve(i+days[i], N, days[i]);
                result[i] = false;
            }
        }
    }
}
