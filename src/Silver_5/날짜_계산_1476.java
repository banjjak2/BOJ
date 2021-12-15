package Silver_5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 날짜_계산_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] esm = new int[3];
        int[] tmpesm = new int[3];
        for(int i=0; i<3; i++) {
            esm[i] = Integer.parseInt(st.nextToken());
            tmpesm[i] = 1;
        }

        int years = 1;
        while(true) {
            if (tmpesm[0] == esm[0] && tmpesm[1] == esm[1] && tmpesm[2] == esm[2]) {
                break;
            }

            if (++tmpesm[0] > 15) {
                tmpesm[0] = 1;
            }
            if (++tmpesm[1] > 28) {
                tmpesm[1] = 1;
            }
            if (++tmpesm[2] > 19) {
                tmpesm[2] = 1;
            }
            years++;
        }

        System.out.println(years);
    }
}
