package Gold_4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {

    private static int[][][] distance = null;
    private static int[][] map = null;
    private static int[] directX = {1, 0, -1, 0};
    private static int[] directY = {0, 1, 0, -1};
    private static int n = 0;
    private static int m = 0;
    private static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 벽 부수지 않고 최단거리
        // 벽 부수고 최단거리
        distance = new int[n][m][2];
        map = new int[n][m];
        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int dx = 0;
        int dy = 0;
        int curX = 0;
        int curY = 0;
        int broken = 0;

        queue.add(new int[] { 0, 0, 0 });
        distance[0][0][0] = 1;
        distance[0][0][1] = 1;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            curX = pos[0];
            curY = pos[1];
            broken = pos[2];

            if (curX == m - 1 && curY == n - 1) {
                return distance[curY][curX][broken];
            }

            for (int i=0; i<4; i++) {
                dx = curX + directX[i];
                dy = curY + directY[i];

                if (dx < 0 || dx >= m || dy < 0 || dy >= n) continue;

                int curDist = distance[curY][curX][broken];
                if (map[dy][dx] == 0 && distance[dy][dx][broken] == 0) {
                    distance[dy][dx][broken] = curDist + 1;
                    queue.add(new int[] { dx, dy, broken });
                } else if (broken != 1 && map[dy][dx] == 1 && distance[dy][dx][broken] == 0) {
                    distance[dy][dx][1] = curDist + 1;
                    queue.add(new int[] { dx, dy, 1 });
                }
            }
        }

        return -1;
    }
}
