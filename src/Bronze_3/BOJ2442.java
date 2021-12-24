package Bronze_3;

import java.io.*;

public class BOJ2442 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=N-i-1; j>0; j--) {
                sb.append(" ");
            }
            for(int j=0; j<((i+1)*2)-1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
