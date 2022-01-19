package Bronze_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[] arr = new int[21];
        for (int i=1; i<=20; i++) {
            arr[i] = i;
        }

        int a = 0;
        int b = 0;
        for(int i=0; i<10; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            while(a < b) {
                swap(arr, a++, b--);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<arr.length; i++) {
            sb.append(arr[i]).append(' ');
        }

        System.out.println(sb);
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
