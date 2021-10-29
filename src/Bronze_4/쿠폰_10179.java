package Bronze_4;

import java.io.*;

public class 쿠폰_10179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        double dollar = 0;
        for(int i=0; i<N; i++) {
            dollar = Double.parseDouble(br.readLine());
            sb.append(String.format("$" + "%.2f", dollar*0.8)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
