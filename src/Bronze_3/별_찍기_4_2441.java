package Bronze_3;

import java.io.*;

public class 별_찍기_4_2441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=N-i; j>0; j--) {
                sb.append("*");
            }
            sb.append("\n");
            for(int j=0; j<=i; j++) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
