package Bronze_4;

import java.util.*;
import java.io.*;

public class BOJ5596 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int max = -1;
        int tmp = 0;
        for(int i=0; i<2; i++) {
            st = new StringTokenizer(br.readLine());
            tmp += Integer.valueOf(st.nextToken());
            tmp += Integer.valueOf(st.nextToken());
            tmp += Integer.valueOf(st.nextToken());
            tmp += Integer.valueOf(st.nextToken());

            if (max < tmp) {
                max = tmp;
            }
            tmp = 0;
        }

        System.out.println(max);
    }
}
