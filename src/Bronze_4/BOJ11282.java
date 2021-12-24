package Bronze_4;

import java.io.*;

public class BOJ11282 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println((char)(N + '가' - 1));
    }
}
