package Bronze_4;

import java.util.*;
import java.io.*;

public class 이칙연산_15726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double A = Double.valueOf(st.nextToken());
        double B = Double.valueOf(st.nextToken());
        double C = Double.valueOf(st.nextToken());

        int result = (int)(((A * B / C) > (A / B * C))? (A * B / C) : (A / B * C));
        System.out.println(result);
    }
}
