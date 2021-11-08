package Silver_1;

import java.util.*;
import java.io.*;

public class 물병_1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int oneCountFromBinary = 0;
        int tmp = N;
        do {
            oneCountFromBinary = getOneCountFromBinary(N++);
            if (oneCountFromBinary <= K) {
                break;
            }
        }while(oneCountFromBinary > K);

        System.out.println(N - tmp - 1);
    }

    // 1의 개수가 현재 물이있는 통의 개수가 됨
    // 13 -> 1101 -> 3개의 물통
    private static int getOneCountFromBinary(int num) {
        int oneCount = 0;
        while(num != 0) {
            if (num % 2 == 1) {
                oneCount++;
            }
            num /= 2;
        }

        return oneCount;
    }
}
