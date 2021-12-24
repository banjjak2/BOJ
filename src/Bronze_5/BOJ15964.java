package Bronze_5;

import java.util.*;
import java.io.*;

public class BOJ15964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.valueOf(st.nextToken());
        long B = Long.valueOf(st.nextToken());

        System.out.println((A+B)*(A-B));
    }
}
