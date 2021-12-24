package Bronze_2;

import java.util.*;
import java.io.*;

public class BOJ1173 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        if (m + T > M) {
            System.out.println(-1);
            return;
        }

        int curPulse = m;
        int restTime = 0;
        int exerciseTime = 0;
        while(exerciseTime < N) {
            if (curPulse < m) {
                curPulse = m;
            }

            if (curPulse + T <= M) {
                curPulse += T;
                exerciseTime++;
                continue;
            }

            while(true) {
                if (Math.abs(curPulse - M) < T) {
                    restTime++;
                    curPulse -= R;
                }
                else {
                    break;
                }
            }
        }

        System.out.println(N + restTime);
    }
}
