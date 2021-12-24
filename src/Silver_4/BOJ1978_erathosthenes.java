package Silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1978_erathosthenes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] checkedPrime = erathosthenes(1000);
        int num = 0;

        int count = 0;
        while(st.hasMoreTokens()) {
            num = Integer.parseInt(st.nextToken());
            if (!checkedPrime[num]) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean[] erathosthenes(int maxNum) {
        int[] prime = new int[maxNum];
        boolean[] checkedPrime = new boolean[maxNum + 1];
        checkedPrime[0] = true; // 0
        checkedPrime[1] = true; // 1 은 소수가 아니므로

        for(int i=0; i<maxNum; i++) {
            prime[i] = (i+1);
        }

        for(int i=2; i<=maxNum; i++) {
            if (!checkedPrime[i]) {
                for(int j=i*i; j<=maxNum; j+=i) {
                    checkedPrime[j] = true;
                }
            }
        }

        return checkedPrime;
    }
}
