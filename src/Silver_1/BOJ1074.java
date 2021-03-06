package Silver_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {
    /*
    1. r, c가 몇 사분면 위에 있는지 확인
    2. 해당 사분면의 시작번호 파악
        - 8x8 에서는 4x4가 하나의 사분면이므로
            1사분면 : 0~15     2사분면 : 16~31
            3사분면 : 32~47    4사분면 : 48~63
        - 해당사분면의 시작 번호 : 2^n-1 + 2^n-1 * (해당사분면 - 1)
    3. r, c값을 현재 사분면을 기준으로 뺌
        - ex) 2^2 x 2^2 일 때 (3,2)면 4사분면이고 해당 면에서는 (3,2)가 (1, 0)이 됨
        - 즉, r, c를 2^n-1로 나눈 나머지를 구하면 됨
    4. 1~3과정을 재귀로 반복해서 2x2 배열이 될 때까지 나누고 시작값에 x+2y하면 정답이 됨
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = (int)Math.pow(2, Integer.parseInt(st.nextToken()));
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        recursive(0, x, y, n);
    }

    private static void recursive(int startValue, int x, int y, int nn) {
        if (nn == 2) {
            System.out.println(startValue + (x + 2*y));
            return;
        }

        int quadrant = getQuadrant(x, y, nn);
        int tmpStartValue = startValue + (nn>>1) * (nn>>1) * (quadrant - 1);
        recursive(tmpStartValue, x % (nn>>1), y % (nn>>1), nn>>1);
    }

    private static int getQuadrant(int x, int y, int nn) {
        if (x < nn>>1 && y < nn>>1) {
            return 1;
        } else if (x >= nn>>1 && y < nn>>1) {
            return 2;
        } else if (x < nn>>1 && y >= nn>>1) {
            return 3;
        } else {
            return 4;
        }
    }
}
