package Bronze_4;

import java.io.*;

public class BOJ3004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        int x = N/2 + 1;
        int y = N - x + 2;

        System.out.println(x * y);

//        int sum = 0;
//        int add = 2;
//        for(int i=1; i<=N; i++) {
//            if (i%2 == 0 && i != 2) {
//                add++;
//            }
//
//            sum += add;
//        }
//
//        System.out.println(sum);
    }
}
