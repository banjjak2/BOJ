package Gold_5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10026 {
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j=0; j<N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int rgbCount = 0;
        int rrbCount = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[i][j]) {
                    char c = map[i][j];
                    bfs(c, j, i, N);
                    rgbCount++;
                }
            }
        }

        changeMap(N);
        visited = new boolean[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[i][j]) {
                    char c = map[i][j];
                    bfs(c, j, i, N);
                    rrbCount++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(rgbCount).append(' ').append(rrbCount);
        System.out.println(sb);
    }

    public static void changeMap(int N) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == 'R') map[i][j] = 'G';
            }
        }
    }

    public static void bfs(char c, int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
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

                if (dx < 0 || dx >= n || dy < 0 || dy >= n) continue;
                if (visited[dy][dx] || map[dy][dx] != c) continue;
                visited[dy][dx] = true;
                queue.add(new int[] { dx, dy });
            }
        }
    }
}
