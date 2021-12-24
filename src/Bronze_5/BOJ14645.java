package Bronze_5;

import java.util.*;
import java.io.*;

public class BOJ14645 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.valueOf(st.nextToken());

        for(int i=0; i<N; i++){
            str = br.readLine();
        }

        System.out.println("비와이");
    }
}
