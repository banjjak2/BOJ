package Silver_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 {
    private static int[] result = new int[6];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = 0;

        while(true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            if (N == 0) {
                break;
            }

            int[] arr = new int[N];
            for(int i=0; i<arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            solve(arr, 0, 0);
            sb.append('\n');
        }


        System.out.println(sb);
    }

    private static void solve(int[] arr, int curIndex, int c) {
        if (c == 6) {
            for(int i : result) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        else {
            for(int i=curIndex; i<arr.length; i++) {
                result[c] = arr[i];
                solve(arr, i+1, c+1);
            }
        }
    }
}
