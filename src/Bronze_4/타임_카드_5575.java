package Bronze_4;

import java.util.*;
import java.io.*;

public class 타임_카드_5575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int H = 0, H1 = 0;
        int M = 0, M1 = 0;
        int S = 0, S1 = 0;
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.valueOf(st.nextToken());
            M = Integer.valueOf(st.nextToken());
            S = Integer.valueOf(st.nextToken());
            H1 = Integer.valueOf(st.nextToken());
            M1 = Integer.valueOf(st.nextToken());
            S1 = Integer.valueOf(st.nextToken());

            H1 -= H;
            M1 -= M;
            S1 -= S;

            if (S1 < 0) {
                M1--;
                S1 = 60 + S1;
            }

            if (M1 < 0) {
                H1--;
                M1 = 60 + M1;
            }

            sb.append(H1).append(" ").append(M1).append(" ").append(S1).append("\n");
        }

        System.out.println(sb.toString());
    }
}
