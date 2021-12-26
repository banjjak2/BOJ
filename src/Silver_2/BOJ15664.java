package Silver_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class BOJ15664 {
    private static StringBuilder sb = new StringBuilder();
    private static int[] result = null;
    private static LinkedHashSet<String> ls = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        int index = 0;
        while (st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        solve(arr, 0, M, 0);

        Iterator<String> iter = ls.iterator();
        while (iter.hasNext()) {
            sb.append(iter.next()).append('\n');
        }

        System.out.println(sb);
    }

    private static void solve(int[] arr, int curIndex, int r, int c) {
        if (r == c) {
            for(int i : result) {
                sb.append(i).append(' ');
            }
            ls.add(sb.toString());
            sb.delete(0, sb.length());
        }
        else {
            for (int i=curIndex; i<arr.length; i++) {
                result[c] = arr[i];
                solve(arr, i+1, r, c+1);
            }
        }
    }
}
