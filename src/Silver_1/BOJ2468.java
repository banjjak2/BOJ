package Silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2468 {

    static int n = 0;
    static int[][] map = null;
    static boolean[][] visited = null;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int maxNumber = 0;
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                maxNumber = Math.max(maxNumber, tmp);
                map[i][j] = tmp;
            }
        }

        for (int water=0; water<maxNumber; water++) {
            int count = 0;
            visited = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!visited[j][k] && map[j][k] > water) {
                        bfs(k, j, water);
                        count++;
                    }
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    static Queue<int[]> queue = new LinkedList<>();
    static int[] directX = {1, 0, -1, 0};
    static int[] directY = {0, 1, 0, -1};
    private static void bfs(int x, int y, int maxNumber) {
        queue.add(new int[] { x, y });
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int curX = pos[0];
            int curY = pos[1];

            for (int i=0; i<4; i++) {
                int dx = curX + directX[i];
                int dy = curY + directY[i];

                if (dx < 0 || dx >= n || dy < 0 || dy >= n || visited[dy][dx]) continue;

                if (map[dy][dx] > maxNumber) {
                    queue.add(new int[]{dx, dy});
                    visited[dy][dx] = true;
                }
            }
        }
    }
}
