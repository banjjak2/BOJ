package Bronze_5;

import java.io.*;

public class BOJ15894 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.valueOf(br.readLine());

        // 네모의 왼쪽과 오른쪽 실선의 개수 : 맨 아랫부분의 정사각형 개수 * 2
        // 맨 아랫부분 실선의 개수 : 맨 아랫부분의 정사각형 개수
        // 맨 윗부분 실선의 개수 : 1
        // 각 층마다 반절씩 잘린 부분의 개수 : 맨 아랫부분 정사각형 개수 - 1
        // (n * 2) + n + 1 + n - 1
        // (n * 2) + 2n

        System.out.println((n * 2) + 2 * n);
    }
}
