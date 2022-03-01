package Silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992 {

    static int[][] matrix = null;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        String data = "";

        for (int i=0; i<n; i++) {
            data = br.readLine();
            for (int j=0; j<n; j++) {
                matrix[i][j] = data.charAt(j) - '0';
            }
        }

        recursive(0, 0, n);
        System.out.println(sb);
    }

    static private void recursive(int x, int y, int n) {
        if (checkMatrix(x, y, n)) {
            sb.append(matrix[y][x]);
            return;
        }

        sb.append('(');
        int size = n >> 1;
        recursive(x, y, size); //왼쪽 위
        recursive(x + size, y, size); // 오른쪽 위
        recursive(x, y + size, size); // 왼쪽 아래
        recursive(x + size, y + size, size); // 오른쪽 아래
        sb.append(')');
    }

    static private boolean checkMatrix(int x, int y, int n) {
        int tmpData = matrix[y][x];
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (tmpData != matrix[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
