package Bronze_4;

import java.util.*;
import java.io.*;

public class 오븐_시계_2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.valueOf(st.nextToken());
        int B = Integer.valueOf(st.nextToken());
        int C = Integer.valueOf(br.readLine());

        // 분(B)에 걸리는 시간(C) 더하기
        B += C;
        // 더해진 분(B)을 60으로 나누어 시간에 더함
        A += (B / 60);
        // B의 잔여 분
        B %= 60;
        A %= 24;

        System.out.println(A + " " + B);
    }
}
