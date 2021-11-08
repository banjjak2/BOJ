package Bronze_3;

import java.io.*;

public class 별_찍기_6_2443 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(" ".repeat(i)).append("*".repeat((N*2)-(i*2)-1)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
