package Bronze_4;

import java.io.*;

public class BOJ16486 {
    private static final double PI = 3.141592;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Double d1 = Double.parseDouble(br.readLine());
        Double d2 = Double.parseDouble(br.readLine());

        System.out.println(d1 * 2 + 2 * PI * d2);
    }
}
