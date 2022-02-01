package Gold_5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] dist = new int[N][M];
        int zeroCount = 0;

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;
                if (map[i][j] == 1) queue.add(new int[]{i, j});
                if (map[i][j] == 0) zeroCount++;
            }
        }

        int[] xPos = {1, 0, -1, 0};
        int[] yPos = {0, 1, 0, -1};
        int dx = 0; int dy = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i=0; i<4; i++) {
                dx = cur[1] + xPos[i];
                dy = cur[0] + yPos[i];
                if (dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
                if (map[dy][dx] == 0 && dist[dy][dx] == -1) {
                    dist[dy][dx] = dist[cur[0]][cur[1]]+1;
                    max = Math.max(dist[dy][dx], max);
                    zeroCount--;
                    queue.add(new int[] { dy, dx });
                }
            }
        }

        if (zeroCount != 0) System.out.println(-1);
        else if(max == 0) System.out.println(0);
        else System.out.println(max+1);
    }
}
