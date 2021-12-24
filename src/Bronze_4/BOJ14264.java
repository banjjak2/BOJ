package Bronze_4;

import java.io.*;

public class BOJ14264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double L = Double.parseDouble(br.readLine());
        double a = L/2;
        double b = Math.sqrt(L*L - (a * a));

        System.out.println((2*a*b)/2);
    }
}
