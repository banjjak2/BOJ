package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10973 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int index = 0;

        while (st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        if (nextPermutation(arr)) {
            for(int i : arr) {
                sb.append(i).append(' ');
            }
            System.out.println(sb);
        }
        else {
            System.out.println(-1);
        }
    }

    private static boolean nextPermutation(int[] arr) {
        int i = arr.length-1;
        while (i > 0 && arr[i-1] < arr[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }

        int j = arr.length-1;
        while (arr[i-1] < arr[j]) {
            j--;
        }
        swap(arr, i-1, j);

        reverse(arr, i);

        return true;
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    private static void reverse(int[] arr, int startIndex) {
        int endIndex = arr.length-1;

        while (startIndex <= endIndex) {
            swap(arr, startIndex++, endIndex--);
        }
    }
}
