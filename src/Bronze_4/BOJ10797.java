package Bronze_4;

import java.util.*;
import java.io.*;

public class BOJ10797 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int day = Integer.parseInt(br.readLine());

        int count = 0;
        int tmp = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<5; i++) {
            tmp = Integer.parseInt(st.nextToken());
            if (tmp == day) {
                count++;
            }
        }

        System.out.println(count);
    }
}
