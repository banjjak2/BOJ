package Silver_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 골드바흐의_추측_6588 {
    // 10^18 이하에서는 추측이 참이 됨 (위키참조)
    // n은 100만까지 이므로 10^18 이하여서 소수의 합으로 나타낼 수 없는 경우는 없음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        boolean[] checkedPrime = null;

        StringBuilder sb = new StringBuilder();
        checkedPrime = erathosthenes(1000000);
        while(true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            for(int i=3; i<n; i++) {
                if (!checkedPrime[i]) {
                    // n = 소수 + 소수
                    // 두 소수 중 하나가 소수면 다른 하나도 소수여야 함
                    // 가장 처음 해가 발견된 것이 정답이 됨
                    if (!checkedPrime[n - i]) {
                        sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append('\n');
                        break;
                    }
                }
            }
        }

        System.out.println(sb);
    }

    public static boolean[] erathosthenes(int maxNum) {
        boolean[] checkedPrime = new boolean[maxNum + 1];
        checkedPrime[0] = true;
        checkedPrime[1] = true;

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
