package Bronze_3;

import java.util.*;
import java.io.*;

public class BOJ1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int a = 0;
        int b = 0;
        int result = 1;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            for(int j=1; j<=b; j++) {
                result = (result * a) % 10;
            }

            if (result == 0) {
                sb.append(10).append("\n");
            }
            else {
                sb.append(result).append("\n");
            }
            result = 1;
        }

        System.out.println(sb.toString());
    }
}

