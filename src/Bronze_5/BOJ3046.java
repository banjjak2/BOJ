package Bronze_5;

import java.util.*;
import java.io.*;

public class BOJ3046 {
    // S = (R1 + R2) / 2
    // R2 = S * 2 - R1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int R1 = Integer.valueOf(st.nextToken());
        int S = Integer.valueOf(st.nextToken());

        System.out.println(S * 2 - R1);
    }
}
