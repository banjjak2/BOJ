package Bronze_3;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;

public class BOJ2052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        BigDecimal result = new BigDecimal(2);
        result = result.pow(N);

        result = BigDecimal.valueOf(1).divide(result);
        System.out.println(result.toPlainString());
    }
}
