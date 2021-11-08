package Bronze_3;

import java.util.*;
import java.io.*;

public class 생장점_1703 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String str = "";
        int sum = 1;
        int a = 0;
        StringBuilder sb = new StringBuilder();
        while(!(str = br.readLine()).equals("0")) {
            st = new StringTokenizer(str);

            a = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) {
                sum *= Integer.parseInt(st.nextToken());
                sum -= Integer.parseInt(st.nextToken());
            }

            sb.append(sum).append("\n");
            sum = 1;
        }

        System.out.println(sb.toString());
    }
}
