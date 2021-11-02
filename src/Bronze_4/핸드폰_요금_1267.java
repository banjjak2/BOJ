package Bronze_4;

import java.util.*;
import java.io.*;

public class 핸드폰_요금_1267 {
    private static final int MINSIK_TIME = 60;
    private static final int MINSIK_PAY = 15;

    private static final int YOUNGSIK_TIME = 30;
    private static final int YOUNGSIK_PAY = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int minsik = 0;
        int youngsik = 0;
        int time = 0;
        while(st.hasMoreTokens()) {
            time = Integer.parseInt(st.nextToken());
            minsik += (time / MINSIK_TIME + 1) * MINSIK_PAY;
            youngsik += (time / YOUNGSIK_TIME + 1) * YOUNGSIK_PAY;
        }

        if (minsik == youngsik) {
            System.out.println("Y M " + minsik);
        }
        else if (minsik > youngsik) {
            System.out.println("Y " + youngsik);
        }
        else {
            System.out.println("M " + minsik);
        }
    }
}
