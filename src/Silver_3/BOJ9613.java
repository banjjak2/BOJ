package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9613 {
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스 개수
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // 수의 개수
        int n = 0;
        // 배열 인덱스
        int index = 0;
        // 조합에서 사용할 배열 (쌍이므로 2개로 설정)
        int[] result = new int[2];
        // 전달받은 숫자들
        int[] arr = null;
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            while(st.hasMoreTokens()) {
                arr[index++] = Integer.parseInt(st.nextToken());
            }

            combination(arr, result, n, 2, 0, 0);
            sb.append(sum).append('\n');
            sum = 0;
            index = 0;
        }

        System.out.println(sb);
    }

    public static void combination(int[] arr, int[] result, int n, int r, int combIndex, int depth) {
        if (r == 0) {
            sum += gcd(result[0], result[1]);
            return;
        }
        else if (depth == n) {
            return;
        }

        result[combIndex] = arr[depth];
        combination(arr, result, n, r - 1, combIndex + 1, depth + 1);
        combination(arr, result, n, r, combIndex, depth + 1);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        else {
            return gcd(b, a%b);
        }
    }
}
