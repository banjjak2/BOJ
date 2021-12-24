package Silver_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            A[i] = Math.abs(A[i] - S);
        }

        int result = A[0];
        for(int i=1; i<N; i++) {
            result = gcd(result, A[i]);
        }

        System.out.println(result);
    }

    public static int gcd(int a, int b) {
        int r = 0;
        while(b != 0) {
            r = a%b;
            a = b;
            b = r;
        }

        return a;
    }
}
