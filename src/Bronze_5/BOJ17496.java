package Bronze_5;

import java.util.*;
import java.io.*;

public class BOJ17496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken()) - 1;
        int T = Integer.valueOf(st.nextToken());
        int C = Integer.valueOf(st.nextToken());
        int P = Integer.valueOf(st.nextToken());

        // 여름일수를 T로 나누면 여름일수동안 몇 번을 수확할 수 있는지 알 수 있음
        // 여름일수를 T로 나눈 값에 C를 곱하면 스타후르츠의 개수를 알 수 있음
        // 스타후르츠의 개수에 가격을 곱하면 총 금액을 알 수 있음
        System.out.println((N/T)*C*P);
    }
}
