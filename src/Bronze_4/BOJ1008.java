package Bronze_4;

import java.util.*;
import java.io.*;

public class BOJ1008 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double A = Double.valueOf(st.nextToken());
        double B = Double.valueOf(st.nextToken());

        System.out.println(A/B);
    }
}
