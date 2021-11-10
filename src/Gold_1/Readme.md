# 백준 문제풀이 (Gold 1)

---
## 진법 변환 (1112번)
https://www.acmicpc.net/problem/1112

### 풀이방법
- 주석참조

```java
import java.util.*;
import java.io.*;

public class Main {
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

            // 나머지가 음수라면 제수가 음수인지 양수인지 확인해야 함
            // 왜냐하면 제수가 음수일 경우 "음의 진법일 때는 음수를 나타낼 때 -부호가 있으면 안 된다." 조건이 있으므로
            if (remainder < 0) {
                // 제수가 음수일 경우
                if (divisor < 0) {
                    // 몫을 구하고 몫이 음수인지 양수인지 판단
                    // 몫을 하나 더 주어야 나머지가 양수가 나올 수 있기 때문에 음수일 경우 -1, 양수일 경우 +1
                    quotient = dividend/divisor;
                    if (quotient < 0) {
                        quotient--;
                    }
                    else {
                        quotient++;
                    }

                    // 나머지 계산
                    remainder = Math.abs(quotient*divisor - dividend);
                    // 피제수를 몫으로 변환
                    dividend = quotient;
                }
                // 제수가 양수이지만 나머지는 음수일 경우
                else {
                    // 피제수를 구함
                    dividend /= divisor;
                    // 나머지는 양수로 변환 (예제 : -38 4 => -212 가 나와야 하므로)
                    remainder = remainder * (-1);
                }
            }
            // 나머지가 양수일 경우
            else {
                // 피제수를 구함
                dividend /= divisor;
            }


            sb.append(remainder);
        }

        // 제수가 양수이고 피제수가 음수일 경우 (-38 4)
        if (divisor > 0 && tmp < 0) {
            return "-" + sb.reverse().toString();
        }
        // 길이가 0일 경우 (0 2)
        else if (sb.length() == 0) {
            return "0";
        }
        // 나머지
        else {
            return sb.reverse().toString();
        }
    }
}
```