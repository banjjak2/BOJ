package Bronze_5;

import java.io.*;
import java.util.*;

public class BOJ2845 {
    private static final int NEWS_COUNT = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int L = Integer.valueOf(st.nextToken());
        int P = Integer.valueOf(st.nextToken());
        int peopleCount = L * P;

        str = br.readLine();
        st = new StringTokenizer(str);
        for(int i=0; i<NEWS_COUNT; i++){
            System.out.print(Integer.valueOf(st.nextToken()) - peopleCount + " ");
        }
    }
}
