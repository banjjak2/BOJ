package Bronze_5;

import java.util.*;
import java.io.*;

public class 제리와_톰_16430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.valueOf(st.nextToken());
        int B = Integer.valueOf(st.nextToken());

        int P = B - A;
        int Q = B;

        if (Q%P == 0){
            Q /= P;
            P /= P;
        }

        System.out.println(P + " " + Q);
    }
}
