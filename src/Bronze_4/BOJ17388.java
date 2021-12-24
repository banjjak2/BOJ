package Bronze_4;

import java.util.*;
import java.io.*;

public class BOJ17388 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append("Soongsil");
        int min = S;
        if (min > K) {
            sb.delete(0, sb.length());
            sb.append("Korea");
            min = K;
        }
        if (min > H) {
            sb.delete(0, sb.length());
            sb.append("Hanyang");
            min = H;
        }

        if (S + K + H >= 100) {
            System.out.println("OK");
        }
        else {
            System.out.println(sb.toString());
        }
    }
}
