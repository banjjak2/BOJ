package Bronze_4;

import java.io.*;
import java.math.BigInteger;

public class Seventeen_5893 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger b = new BigInteger(br.readLine(), 2);
        b = b.multiply(new BigInteger("17"));

        System.out.println(b.toString(2));
    }
}
