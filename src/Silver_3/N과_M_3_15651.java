package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과_M_3_15651 {
    private static StringBuilder sb = new StringBuilder();
    private static int[] result = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        result = new int[M];

        for(int i=0; i<N; i++) {
            arr[i] = i+1;
        }

        solve(arr, M, 0);
        System.out.println(sb);
    }

    private static void solve(int[] arr, int r, int c) {
        if (c == r) {
            for(int i : result) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        else {
            for(int i=0; i<arr.length; i++) {
                result[c] = arr[i];
                solve(arr, r, c+1);
            }
        }
    }
}
