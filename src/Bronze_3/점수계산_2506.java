package Bronze_3;

import java.util.*;
import java.io.*;

public class 점수계산_2506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        int sum = 0;

        while(st.hasMoreTokens()) {
            if (st.nextToken().equals("0")) {
                sum = 0;
            }
            else {
                sum++;
            }

            result += sum;
        }

        System.out.println(result);
    }
}
