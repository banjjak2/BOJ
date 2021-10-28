package Bronze_4;

import java.util.*;
import java.io.*;

public class 주사위_세개_2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.valueOf(st.nextToken());
        int B = Integer.valueOf(st.nextToken());
        int C = Integer.valueOf(st.nextToken());

        // AB, AC, BC 만 확인하면 됨
        int duplicateCount = 0;
        int duplicateNumber = 0;
        if (A == B) {
            duplicateCount++;
            duplicateNumber = A;
            if (B == C) {
                duplicateCount++;
            }
        }
        else if (A == C) {
            duplicateNumber = A;
            duplicateCount++;
        }
        else if (B == C) {
            duplicateNumber = B;
            duplicateCount++;
        }

        switch (duplicateCount) {
            // 중복이 없을 때
            case 0:
                int max = A;
                if (B > max) max = B;
                if (C > max) max = C;
                System.out.println(max * 100);
                break;

            // 두 개가 동일할 경우
            case 1:
                System.out.println(1000 + (duplicateNumber * 100));
                break;

            // 모두 다 동일한 경우
            case 2:
                System.out.println(10000 + (duplicateNumber * 1000));
                break;
        }
    }
}
