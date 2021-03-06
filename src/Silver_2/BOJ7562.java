package Silver_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int I = 0;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            I = Integer.parseInt(br.readLine());

            int[] curPos = new int[2];
            st = new StringTokenizer(br.readLine());
            curPos[0] = Integer.parseInt(st.nextToken());
            curPos[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] targetPos = new int[2];
            targetPos[0] = Integer.parseInt(st.nextToken());
            targetPos[1] = Integer.parseInt(st.nextToken());

            int[][] dist = new int[I+1][I+1];
            initDist(dist);

            if (curPos[0] == targetPos[0] && curPos[1] == targetPos[1]) {
                sb.append(0).append('\n');
            } else {
                bfs(dist, curPos, targetPos, I);
                sb.append(dist[targetPos[1]][targetPos[0]]).append('\n');
            }
        }

        System.out.println(sb);
    }

    private static void initDist(int[][] dist) {
        for(int i=0; i<dist.length; i++) {
            for (int j=0; j<dist.length; j++) {
                dist[i][j] = -1;
            }
        }
    }

    private static void bfs(int[][] dist, int[] curPos, int[] targetPos, int I) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(curPos);
        dist[curPos[1]][curPos[0]] = 0;

        int[] cur;
        int[] xPos = {-1, -1, 1, 1, -2, -2, 2, 2};
        int[] yPos = {2, -2, 2, -2, 1, -1, 1, -1};
        int dx = 0; int dy = 0;
        while (!queue.isEmpty()) {
            cur = queue.poll();

            for(int i=0; i<8; i++) {
                dx = cur[0] + xPos[i];
                dy = cur[1] + yPos[i];

                if (dx < 0 || dx >= I || dy < 0 || dy >= I) continue;
                if (dist[dy][dx] != -1) continue;
                dist[dy][dx] = dist[cur[1]][cur[0]] + 1;

                if (dx == targetPos[0] && dy == targetPos[1]) return;
                queue.add(new int[] { dx, dy });
            }
        }
    }
}
