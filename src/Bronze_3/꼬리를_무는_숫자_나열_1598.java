package Bronze_3;

import java.util.*;
import java.io.*;

public class 꼬리를_무는_숫자_나열_1598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int sum = 0;
        sum += Math.abs(calculateX(A) - calculateX(B));
        sum += Math.abs(calculateY(A) - calculateY(B));

        System.out.println(sum);
    }

    private static int calculateX(int num) {
        int sum = 0;

        // 가로 구하기
        sum += (num/4);
        if (num%4 == 0) {
            sum--;
        }

        return sum;
    }

    private static int calculateY(int num) {
        int sum = 0;

        // 세로 구하기
        sum += (num%4);
        if (num%4 == 0) {
            sum += 3;
        }
        else {
            sum--;
        }

        return sum;
    }
}
