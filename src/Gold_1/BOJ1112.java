package Gold_1;

import java.util.*;
import java.io.*;

public class BOJ1112 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 피제수
        long dividend = Long.parseLong(st.nextToken());
        // 제수
        long divisor = Long.parseLong(st.nextToken());

        System.out.println(calcNotation(dividend, divisor));
    }

    // 진법 계산
    private static String calcNotation(long dividend, long divisor) {
        StringBuilder sb = new StringBuilder();

        // 나머지
        long remainder = 0;
        // 몫
        long quotient = 0;

        long tmp = dividend;

        while(dividend != 0) {
            remainder = dividend%divisor;

            if (remainder < 0) {
                if (divisor < 0) {
                    quotient = dividend/divisor;
                    if (quotient < 0) {
                        quotient--;
                    }
                    else {
                        quotient++;
                    }

                    remainder = Math.abs(quotient*divisor) - Math.abs(dividend);
                    dividend = quotient;
                }
                else {
                    dividend /= divisor;
                    remainder = remainder * (-1);
                }
            }
            else {
                dividend /= divisor;
            }


            sb.append(remainder);
        }

        if (divisor > 0 && tmp < 0) {
            return "-" + sb.reverse().toString();
        }
        else if (sb.length() == 0) {
            return "0";
        }
        else {
            return sb.reverse().toString();
        }
    }
}
