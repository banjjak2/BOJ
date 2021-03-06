package Bronze_3;

import java.io.*;

public class BOJ2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(" ".repeat(N-i-1)).append("*".repeat((i+1)*2-1)).append("\n");
        }

        for(int i=0; i<N-1; i++) {
            sb.append(" ".repeat(i+1)).append("*".repeat(((N-1)*2)-(i*2)-1)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
