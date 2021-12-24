package Bronze_3;

import java.io.*;

public class BOJ2010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int P = 0;
        int sum = 0;
        for(int i=0; i<N - 1; i++) {
            P = Integer.parseInt(br.readLine());
            sum += (P - 1);
        }
        P = Integer.parseInt(br.readLine());
        sum += P;

        System.out.println(sum);
    }
}
