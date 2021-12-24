package Silver_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = 0;

        boolean[] checkedPrime = eratosthenes(1000000);
        int sumOfGoldbachCount = 0;
        int restPrime = 0;
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());

            for(int i=2; i<checkedPrime.length; i++) {
                if (!checkedPrime[i]) {
                    restPrime = N - i;
                    // i를 제외한 또다른 소수 restPrime이 i보다 작으면 역으로 돌게 되므로 break
                    // 10의 경우
                    // i 3, restPrime 7
                    // i 5, restPrime 5
                    // i 7, restPrime 3 => 이런 경우는 "두 소수의 순서만 다른 것은 같은 파티션이다." 조건에 맞지 않으므로 종료
                    if (restPrime < i) {
                        break;
                    }
                    else if (!checkedPrime[restPrime]) {
                        sumOfGoldbachCount++;
                    }
                }
            }

            sb.append(sumOfGoldbachCount).append('\n');
            sumOfGoldbachCount = 0;
        }

        System.out.println(sb);
    }

    public static boolean[] eratosthenes(int maxNum) {
        // true는 소수가 아닌 것들
        boolean[] checkedPrime = new boolean[maxNum + 1];
        checkedPrime[0] = true; // 0
        checkedPrime[1] = true; // 1 은 소수가 아님

        for(int i=2; i<=maxNum; i++) {
            if (!checkedPrime[i]) {
                for(int j=i*2; j<=maxNum; j+=i) {
                    checkedPrime[j] = true;
                }
            }
        }

        return checkedPrime;
    }
}
