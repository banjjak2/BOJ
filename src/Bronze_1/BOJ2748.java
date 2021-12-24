package Bronze_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        System.out.println(fibo(N));
    }

    public static long fibo(int num) {
        if (num <= 1) {
            return num;
        }

        long[] arr = new long[num + 1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2; i<=num; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        return arr[num];
    }
}
