package Bronze_3;

import java.io.*;

public class 오각형_1964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long sum = (long)Math.pow(N + 1, 2);
        // 등차수열의 합
        sum += (N * (N+1))/2;

        sum %= 45678;
        System.out.println(sum);
    }
}
