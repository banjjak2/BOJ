package Bronze_4;

import java.math.*;
import java.io.*;

public class 감정이입_14623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger B1 = new BigInteger(br.readLine(), 2);
        BigInteger B2 = new BigInteger(br.readLine(), 2);

        B1 = B1.multiply(B2);
        System.out.println(B1.toString(2));
    }
}
