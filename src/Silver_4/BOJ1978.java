package Silver_4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = 0;
        int count = 0;
        while(st.hasMoreTokens()) {
            num = Integer.parseInt(st.nextToken());
            if (isPrime(num)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for(int i=2; i*i<=num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
