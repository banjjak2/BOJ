package Bronze_4;

import java.util.*;
import java.io.*;

public class BOJ15963 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        if (st.nextToken().equals(st.nextToken())) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}
