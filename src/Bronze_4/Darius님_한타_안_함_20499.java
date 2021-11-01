package Bronze_4;

import java.util.*;
import java.io.*;

public class Darius님_한타_안_함_20499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "/");

        int K = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());

        if (K + A < D || D == 0) {
            System.out.println("hasu");
        }
        else {
            System.out.println("gosu");
        }
    }
}
