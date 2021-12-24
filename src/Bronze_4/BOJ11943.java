package Bronze_4;

import java.util.*;
import java.io.*;

public class BOJ11943 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        if (A + D >= B + C) {
            System.out.println(B + C);
        }
        else {
            System.out.println(A + D);
        }
    }
}
