package Bronze_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int getOffCount = 0;
        int getOnCount = 0;
        int max = 0;
        int cur = 0;
        for(int i=0; i<4; i++) {
            st = new StringTokenizer(br.readLine());
            getOffCount = Integer.parseInt(st.nextToken());
            getOnCount = Integer.parseInt(st.nextToken());
            cur = cur - getOffCount + getOnCount;
            max = Math.max(max, cur);
        }

        System.out.println(max);
    }
}
