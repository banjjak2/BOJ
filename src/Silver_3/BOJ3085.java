package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ3085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = "";
        char[][] candy = new char[N][N];

        for(int i=0; i<N; i++) {
            str = br.readLine();
            for(int j=0; j<N; j++) {
                candy[i][j] = str.charAt(j);
            }
        }

        System.out.println(maxSameCount(candy));
    }

    private static int maxSameCount(char[][] candy) {
        int N = candy.length;
        int count = 0;
        int max = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                // 가로
                if (j+1 < N) {
                    swap(candy, j, i, j+1, i);
                    count = verticalSameCount(candy, j);
                    max = Math.max(count, max);
                    count = verticalSameCount(candy, j+1);
                    max = Math.max(count, max);
                    count = horizontalSameCount(candy, i);
                    max = Math.max(count, max);
                    swap(candy, j, i, j+1, i);
                }

                // 세로
                if (i+1 < N) {
                    swap(candy, j, i, j, i+1);
                    count = horizontalSameCount(candy, i);
                    max = Math.max(count, max);
                    count = horizontalSameCount(candy, i+1);
                    max = Math.max(count, max);
                    count = verticalSameCount(candy, j);
                    max = Math.max(count, max);
                    swap(candy, j, i, j, i+1);
                }
            }
        }

        return max;
    }

    private static void swap(char[][] candy, int x1, int y1, int x2, int y2) {
        char tmp = candy[y1][x1];
        candy[y1][x1] = candy[y2][x2];
        candy[y2][x2] = tmp;
    }

    private static int verticalSameCount(char[][] candy, int x) {
        char ch = candy[0][x];
        int count = 1;
        int N = candy.length;
        int max = 0;
        for(int i=1; i<N; i++) {
            if (ch == candy[i][x]) {
                count++;
            }
            else {
                ch = candy[i][x];
                count = 1;
            }
            max = Math.max(max, count);
        }

        return max;
    }

    private static int horizontalSameCount(char[][] candy, int y) {
        char ch = candy[y][0];
        int count = 1;
        int N = candy.length;
        int max = 0;
        for(int i=1; i<N; i++) {
            if (ch == candy[y][i]) {
                count++;
            }
            else {
                ch = candy[y][i];
                count = 1;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
