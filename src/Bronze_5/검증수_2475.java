package Bronze_5;

import java.io.*;
import java.util.StringTokenizer;

public class 검증수_2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int result = 0;
        while(st.hasMoreTokens()){
            result += Math.pow(Integer.valueOf(st.nextToken()), 2);
        }

        System.out.println(result % 10);
    }
}
