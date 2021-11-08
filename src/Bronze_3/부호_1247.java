package Bronze_3;

import java.io.*;
import java.math.*;

public class 부호_1247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 0;
        BigInteger sum = null;
        char[] sign = new char[3];

        for(int i=0; i<3; i++) {
            sum = new BigInteger("0");
            N = Integer.parseInt(br.readLine());

            for(int j=0; j<N; j++) {
                sum = sum.add(new BigInteger(br.readLine()));
            }

            if (sum.compareTo(BigInteger.valueOf(0)) == 0) {
                sign[i] = '0';
            }
            else if (sum.compareTo(BigInteger.valueOf(0)) > 0) {
                sign[i] = '+';
            }
            else {
                sign[i] = '-';
            }
        }

        for(int i=0; i<sign.length; i++) {
            System.out.println(sign[i]);
        }
    }
}
