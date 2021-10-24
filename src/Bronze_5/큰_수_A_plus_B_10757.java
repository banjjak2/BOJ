package Bronze_5;

import java.io.*;
import java.math.*;
import java.util.*;

public class 큰_수_A_plus_B_10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());

        System.out.println(A.add(B));
    }
}
