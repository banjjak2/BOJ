package Silver_3;

import java.util.*;
import java.io.*;

public class 숫자_정사각형_1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 세로
        int N = Integer.parseInt(st.nextToken());
        // 가로
        int M = Integer.parseInt(st.nextToken());

        char[][] maps = new char[N][];
        for(int i=0; i<N; i++) {
            maps[i] = br.readLine().toCharArray();
        }

        int max = 1;
        char value = ' ';
        int result = 0;
        int distance = 0;
        for(int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                // 각 위치의 값
                value = maps[i][j];

                for(int k=j+1; k<M; k++) {
                    // 탐색을 진행하면서 동일한 값이 있는지 확인
                    if (value == maps[i][k]) {
                        // 거리 계산
                        distance = k - j;

                        // 범위에서 벗어날 경우 정사각형을 만들 수 없는 것으로 간주
                        if (i+distance >= N || j+distance >= M) {
                            break;
                        }

                        // 정사각형이 되기 위한 각 위치에 있는 값이 모두 동일한지 확인
                        if (
                                maps[i][j] == maps[i][k]
                                        && maps[i][k] == maps[i+distance][j]
                                        && maps[i+distance][j] == maps[i+distance][k]
                        )
                        {
                            // 정사각형의 크기 계산 및 최대값 확인
                            result = (int)Math.pow(distance + 1, 2);
                            if (max < result) {
                                max = result;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }
}
