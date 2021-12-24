package Bronze_4;

import java.io.*;

public class BOJ10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        if (T%10 > 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(T/(5*60) + " " + T%(5*60)/60 + " " + T%(5*60)%60/10);
    }
}
