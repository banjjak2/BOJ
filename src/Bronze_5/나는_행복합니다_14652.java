package Bronze_5;

import java.util.*;
import java.io.*;

public class 나는_행복합니다_14652 {
    public static void main(String[] args) throws IOException {
        // n => 자리번호/M
        // m => 자리번호%M
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        int K = Integer.valueOf(st.nextToken());

        int n = (K/M);
        int m = (K%M);

        System.out.println(n + " " + m);
    }
}
