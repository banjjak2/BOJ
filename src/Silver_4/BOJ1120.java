package Silver_4;

import java.util.*;
import java.io.*;

public class BOJ1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int lenA = A.length();
        int lenB = B.length();

        int min = 100;
        int compareCount = 0;
        int curIdxOfA = 0;
        for(int i=0; i<=lenB-lenA; i++) {
            curIdxOfA = 0;
            compareCount = 0;
            for(int j=i; j<lenB; j++) {
                if (curIdxOfA >= lenA) {
                    break;
                }
                else if (B.charAt(j) != A.charAt(curIdxOfA)) {
                    compareCount++;
                }

                curIdxOfA++;
            }

            min = Math.min(min, compareCount);
        }

        System.out.println(min);
    }
}
