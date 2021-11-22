package Silver_4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Neg2진수_2089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        StringBuilder sb = new StringBuilder();
        long remainder = 0; // 나머지
        long quotient = 0; // 몫
        while(N != 0) {
            quotient = N / -2;
            remainder = N % -2;
            // 나머지가 음수이면 몫을 하나 증가 또는 감소
            // 나머지를 양수로 맞추기 위함
            if (remainder < 0) {
                if (quotient < 0) {
                    quotient--;
                }
                else {
                    quotient++;
                }

                // "어떤 수 = 몫 * 나누는 수 + 나머지" 이므로
                // "나머지 = 어떤 수 - 몫 * 나누는 수" 가 됨
                remainder = N - (quotient * -2);
            }

            N = quotient;
            sb.append(remainder);
        }

        if (sb.length() == 0) {
            System.out.println(0);
        }
        else {
            System.out.println(sb.reverse());
        }
    }
}
