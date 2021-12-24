package Silver_4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // 뒤 숫자가 0이 나오려면 2*5 형태가 있어야 함
        // 5의 개수는 2의 개수보다 작음 (2는 N까지의 모든 짝수이고 5는 5의 배수일 뿐이니까)
        // 25, 50, 75, 100는 5가 1번 더 들어감 (25 = 5 * 5, 50 = 5 * 5 * 2, ...)
        // 따라서, 5의 거듭제곱만큼 계속 나누면 됨
        int sum = 0;
        for(int i=5; i<N; i*=5) {
            sum += (N / i);
        }

        System.out.println(sum);
    }
}
