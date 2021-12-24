package Bronze_4;

import java.io.*;

public class BOJ14470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        int time = 0;
        // 얼어있을 때
        if (A < 0) {
            // 현재온도 * 얼어있는 고기를 1도 데우는데 걸리는 시간
            // 현재온도 ~ 0도까지이기 때문
            time += Math.abs(A) * C;
            // 해동 시간
            time += D;
            A = 0;
        }

        // 얼어있지 않을 때 목표 온도까지 걸리는 시간
        time += (B - Math.abs(A)) * E;

        System.out.println(time);
    }
}
