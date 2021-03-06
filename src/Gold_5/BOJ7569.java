package Gold_5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
    static Queue<int[]> queue = new LinkedList<>();
    static int[][][] map;
    static int[][][] dist;
    static int zeroCount;
    static int max = 0;
    static int M = 0;
    static int N = 0;
    static int H = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];
        dist = new int[H][N][M];
        zeroCount = 0;

        for(int i=0; i<H; i++) {
            for (int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k=0; k<M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 0) {
                        dist[i][j][k] = -1;
                        zeroCount++;
                    }
                    if (map[i][j][k] == 1) {
                        dist[i][j][k] = 0;
                        queue.add(new int[] { k, j, i });
                    }
                }
            }
        }

        if (zeroCount == 0) {
            System.out.println(0);
            return;
        }

        bfs();
        if (zeroCount != 0) System.out.println(-1);
        else System.out.println(max);
    }

    private static void bfs() {
        int[] cur;
        int[] xPos = {1, 0, -1, 0, 0, 0};
        int[] yPos = {0, 1, 0, -1, 0, 0};
        int[] zPos = {0, 0, 0, 0, -1, 1};
        int dx = 0; int dy = 0; int dz = 0;
        while (!queue.isEmpty()) {
            cur = queue.poll();

            for(int i=0; i<6; i++) {
                dx = cur[0] + xPos[i];
                dy = cur[1] + yPos[i];
                dz = cur[2] + zPos[i];

                if (dx < 0 || dx >= M || dy < 0 || dy >= N || dz < 0 || dz >= H) continue;
                if (dist[dz][dy][dx] != -1) continue;
                dist[dz][dy][dx] = dist[cur[2]][cur[1]][cur[0]] + 1;
                queue.add(new int[] { dx, dy, dz });
                max = Math.max(max, dist[dz][dy][dx]);
                zeroCount--;
            }
        }
    }
}
