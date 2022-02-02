package Gold_4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] map = new int[y][x];
        int[][] jDist = new int[y][x];
        int[][] fDist = new int[y][x];
        Queue<int[]> jihoon = new LinkedList<>();
        Queue<int[]> fire = new LinkedList<>();
        for (int i = 0; i < y; i++) {
            StringBuilder str = new StringBuilder(br.readLine());
            for (int j = 0; j < x; j++) {
                jDist[i][j] = -1;
                fDist[i][j] = -1;

                if (str.charAt(j) == '#') map[i][j] = 0;
                else if (str.charAt(j) == '.') map[i][j] = 1;
                else if (str.charAt(j) == 'J') {
                    jihoon.add(new int[]{i, j});
                    map[i][j] = 2;
                    jDist[i][j] = 1;
                } else if (str.charAt(j) == 'F') {
                    fire.add(new int[]{i, j});
                    map[i][j] = 2;
                    fDist[i][j] = 1;
                }
            }
        }

        int[] directX = {1, 0, -1, 0};
        int[] directY = {0, 1, 0, -1};
        int dx = 0;
        int dy = 0;
        int[] cur;
        while (!fire.isEmpty()) {
            cur = fire.poll();

            for (int i = 0; i < 4; i++) {
                dx = cur[1] + directX[i];
                dy = cur[0] + directY[i];

                if (dx < 0 || dx >= x || dy < 0 || dy >= y) continue;
                if (map[dy][dx] == 1 && fDist[dy][dx] == -1) {
                    fDist[dy][dx] = fDist[cur[0]][cur[1]] + 1;
                    fire.add(new int[]{dy, dx});
                }
            }
        }

        while (!jihoon.isEmpty()) {
            cur = jihoon.poll();

            for (int i = 0; i < 4; i++) {
                dx = cur[1] + directX[i];
                dy = cur[0] + directY[i];

                if ((dx < 0 || dx >= x || dy < 0 || dy >= y)) {
                    if ((fDist[cur[0]][cur[1]] > jDist[cur[0]][cur[1]]) || fDist[cur[0]][cur[1]] == -1) {
                        System.out.println(jDist[cur[0]][cur[1]]);
                        return;
                    }
                    continue;
                }
                if (map[dy][dx] == 1 && jDist[dy][dx] == -1) {
                    jDist[dy][dx] = jDist[cur[0]][cur[1]] + 1;
                    jihoon.add(new int[]{dy, dx});
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
