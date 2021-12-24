package Bronze_3;

import java.util.*;
import java.io.*;

public class BOJ2355 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long max = 0;
        long min = 0;

        max = (A<B)? B : A;
        min = (A<B)? A : B;

        System.out.println((((max - min) + 1) * (max + min))/2);
    }
}
