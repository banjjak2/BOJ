package Bronze_5;

import java.io.*;
import java.util.*;

public class BOJ2914 {
    // 항상 올려서 정수로 계산함
    // 예제 1번에서 38 24 일 때,
    // 평균값이 24가 되려면 평균값>23 또는 평균값<=24가 되어야 함
    // 따라서 23일때 38을 곱한 후 +1을 해주어야 위 범위에 들어가게 됨

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int A = Integer.valueOf(st.nextToken());
        int I = Integer.valueOf(st.nextToken());

        System.out.println(A*(I - 1)+1);
    }
}
