package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[] arr = new int[2_000_001];
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int max = 0;
        int index = 0;
        for (int i=0; i<n; i++) {
            index = Integer.parseInt(st.nextToken());
            arr[index] = 1;
            max = Math.max(max, index);
        }

        int x = Integer.parseInt(br.readLine());
        int pairCount = 0;
        for(int i=1; i<=max; i++) {
            if (x-i > i && arr[i] != 0 && arr[x-i] == 1) {
                pairCount++;
            }
        }

        System.out.println(pairCount);
    }
}
