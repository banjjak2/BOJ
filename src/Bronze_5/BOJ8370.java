package Bronze_5;

import java.io.*;
import java.util.*;

public class BOJ8370 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int businessSeats = Integer.valueOf(st.nextToken()) * Integer.valueOf(st.nextToken());
        int economicSeats = Integer.valueOf(st.nextToken()) * Integer.valueOf(st.nextToken());

        System.out.println(businessSeats + economicSeats);
    }
}
