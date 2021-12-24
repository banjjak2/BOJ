package Bronze_5;

import java.util.*;
import java.io.*;

public class BOJ3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int[] chess = {1, 1, 2, 2, 2, 8};

        for(int i=0; i<6; i++) {
            System.out.print(chess[i] - Integer.valueOf(st.nextToken()) + " ");
        }
    }
}
