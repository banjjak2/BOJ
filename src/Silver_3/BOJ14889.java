package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        int[][] spec = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                spec[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] check = new boolean[N];
        solve(spec, check, 0, N, 0, N/2);
        System.out.println(min);
    }

    private static void solve(int[][] spec, boolean[] check, int curIndex, int n, int c, int r) {
        if (c == r) {
            int startSpec = 0;
            int linkSpec = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if (check[i] && check[j]) startSpec += spec[i][j];
                    if (!check[i] && !check[j]) linkSpec += spec[i][j];
                }
            }

            min = Math.min(min, Math.abs(startSpec - linkSpec));
        }
        else {
            for(int i=curIndex; i<=n/2; i++) {
                check[i] = true;
                solve(spec, check, i + 1, n, c + 1, r);
                check[i] = false;
            }
        }
    }
}
