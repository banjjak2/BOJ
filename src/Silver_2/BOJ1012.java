package Silver_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1012 {
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int bugCount = 0;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                map[Y][X] = 1;
            }

            for(int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(j, i, M, N);
                        bugCount++;
                    }
                }
            }
            sb.append(bugCount).append('\n');
            bugCount = 0;
        }

        System.out.println(sb);
    }

    public static void bfs(int x, int y, int m, int n) {
        queue.add(new int[] { x, y });
        visited[y][x] = true;
        int[] cur;
        int[] xPos = {1, 0, -1, 0};
        int[] yPos = {0, 1, 0, -1};
        int dx = 0; int dy = 0;
        while (!queue.isEmpty()) {
            cur = queue.poll();

            for (int i=0; i<4; i++) {
                dx = cur[0] + xPos[i];
                dy = cur[1] + yPos[i];

                if (dx < 0 || dx >= m || dy < 0 || dy >= n) continue;
                if (visited[dy][dx] || map[dy][dx] != 1) continue;
                visited[dy][dx] = true;
                queue.add(new int[] { dx, dy });
            }
        }
    }
}
