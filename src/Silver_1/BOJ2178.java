package Silver_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] distance = new int[N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = str.charAt(j) - '0';
                distance[i][j] = -1;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int[] directX = {1, 0, -1, 0};
        int[] directY = {0, 1, 0, -1};
        int curX = 0;
        int curY = 0;
        int dx = 0;
        int dy = 0;
        queue.add(new int[] { 0, 0 });
        distance[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            curX = cur[0]; curY = cur[1];
            for(int i=0; i<4; i++) {
                dx = curX + directX[i];
                dy = curY + directY[i];

                if (dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
                if (map[dy][dx] != 0 && distance[dy][dx] == -1) {
                    distance[dy][dx] = distance[curY][curX]+1;
                    queue.add(new int[] { dx, dy });
                }
            }
        }

        System.out.println(distance[N-1][M-1]);
    }
}
