package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int numberN = Integer.parseInt(N);

        long start = 0;
        long end = 0;
        long sum = 0;
        for(int i=0; i<N.length(); i++) {
            start = (long)Math.pow(10, i);
            end = (long)Math.pow(10, i+1)-1;

            if (end > numberN) {
                sum += ((numberN - start + 1) * (i+1));
            }
            else {
                sum += ((end - start + 1) * (i+1));
            }
        }

        System.out.println(sum);
    }
}
