package Bronze_5;

import java.io.*;

public class BOJ20492 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        int one = N - (int)(N * 0.22);
        int two = (int)(N - (N - N*0.80) * 0.22);

        System.out.println(one + " " + two);
    }
}
