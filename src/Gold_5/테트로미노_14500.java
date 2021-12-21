package Gold_5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노_14500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0;
        int max = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                /*
                . . . .
                 */
                if (j+3 < M) {
                    sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3];
                    max = Math.max(max, sum);
                }
                /*
                .
                .
                .
                .
                 */
                if (i+3 < N) {
                    sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
                    max = Math.max(max, sum);
                }
                /*
                . .
                . .
                 */
                if (i+1 < N && j+1 < M) {
                    sum = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+1][j+1];
                    max = Math.max(max, sum);
                }
                /*
                .
                .
                . .
                 */
                if (i+2 < N && j+1 < M) {
                    sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j+1];
                    max = Math.max(max, sum);
                }
                /*
                . . .
                .
                 */
                if (j+2 < M && i+1 < N) {
                    sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j];
                    max = Math.max(max, sum);
                }
                /*
                . .
                  .
                  .
                 */
                if (j+1 < M && i+2 < N) {
                    sum = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1];
                    max = Math.max(max, sum);
                }
                /*
                    .
                . . .
                 */
                if (j+2 < M && i+1 < N) {
                    sum = map[i][j+2] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
                    max = Math.max(max, sum);
                }
                /*
                .
                . .
                  .
                 */
                if (j+1 < M && i+2 < N) {
                    sum = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1];
                    max = Math.max(max, sum);
                }
                /*
                  . .
                . .
                 */
                if (j+2 < M && i+1 < N) {
                    sum = map[i][j+1] + map[i][j+2] + map[i+1][j] + map[i+1][j+1];
                    max = Math.max(max, sum);
                }
                /*
                . . .
                  .
                 */
                if (j+2 < M && i+1 < N) {
                    sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1];
                    max = Math.max(max, sum);
                }
                /*
                  .
                . .
                  .
                 */
                if (j+1 < M && i+2 < N) {
                    sum = map[i][j+1] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1];
                    max = Math.max(max, sum);
                }
                /*
                  .
                . . .
                 */
                if (j+2 < M && i+1 < N) {
                    sum = map[i][j+1] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
                    max = Math.max(max, sum);
                }
                /*
                .
                . .
                .
                 */
                if (j+1 < M && i+2 < N) {
                    sum = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j];
                    max = Math.max(max, sum);
                }
                /*
                  .
                  .
                . .
                 */
                if (j+1 < M && i+2 < N) {
                    sum = map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i+2][j];
                    max = Math.max(max, sum);
                }
                /*
                .
                . . .
                 */
                if (j+2 < M && i+1 < N) {
                    sum = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
                    max = Math.max(max, sum);
                }
                /*
                . .
                .
                .
                 */
                if (j+1 < M && i+2 < N) {
                    sum = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+2][j];
                    max = Math.max(max, sum);
                }
                /*
                . . .
                    .
                 */
                if (j+2 < M && i+1 < N) {
                    sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+2];
                    max = Math.max(max, sum);
                }
                /*
                  .
                . .
                .
                 */
                if (j+1 < M && i+2 < N) {
                    sum = map[i][j+1] + map[i+1][j] + map[i+1][j+1] + map[i+2][j];
                    max = Math.max(max, sum);
                }
                /*
                . .
                  . .
                 */
                if (j+2 < M && i+1 < N) {
                    sum = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+1][j+2];
                    max = Math.max(max, sum);
                }
            }
        }

        System.out.println(max);
    }
}