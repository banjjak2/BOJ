package Silver_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ15665 {
    private static StringBuilder sb = new StringBuilder();
    private static int[] result = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        TreeSet<Integer> ts = new TreeSet<>();
        while (st.hasMoreTokens()) {
            ts.add(Integer.parseInt(st.nextToken()));
        }

        int index = 0;
        int[] arr = new int[ts.size()];
        Iterator<Integer> iter = ts.iterator();
        while (iter.hasNext()) {
            arr[index++] = iter.next();
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
