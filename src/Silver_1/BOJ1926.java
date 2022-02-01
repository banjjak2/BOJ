package Silver_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] paper = new int[y][x];
        boolean[][] visited = new boolean[y][x];

        int[] directX = {1, 0, -1, 0};
        int[] directY = {0, 1, 0, -1};

        for(int i=0; i<y; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<x; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int dx = 0;
        int dy = 0;
        int curX = 0;
        int curY = 0;
        int countOfPicture = 0;
        int maxAreaOfPicture = 0;
        int areaOfPicture = 0;
        for(int i=0; i<y; i++) {
            for(int j=0; j<x; j++) {
                if (visited[i][j] || paper[i][j] == 0) continue;
                queue.add(new int[]{i, j});
                visited[i][j] = true;
                countOfPicture++;

                while (!queue.isEmpty()) {
                    areaOfPicture++;
                    int[] pos = queue.poll();
                    curX = pos[1]; curY = pos[0];

                    for(int k=0; k<4; k++) {
                        dx = curX + directX[k];
                        dy = curY + directY[k];

                        if (dx < 0 || dx >= x || dy < 0 || dy >= y) continue;
                        if (visited[dy][dx] || paper[dy][dx] != 1) continue;

                        queue.add(new int[]{dy, dx});
                        visited[dy][dx] = true;
                    }
                }

                maxAreaOfPicture = Math.max(maxAreaOfPicture, areaOfPicture);
                areaOfPicture = 0;
            }
        }

        System.out.println(countOfPicture);
        System.out.println(maxAreaOfPicture);
    }
}
