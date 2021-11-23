package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 일로_만들기_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        // 구현하기 편하도록 +1
        int[] arr = new int[N + 1];
        // %3, %2, -1 중 어떤 것을 먼저 했을 때 최소값이 되는지 모름
        // %3, %2는 제약사항 (2의 배수, 3의 배수)이 있어 -1을 먼저 진행한 후
        // %3, %2로 했을 때와 비교
        for(int i=2; i<=N; i++) {
            arr[i] = arr[i-1] + 1;

            if (i % 2 == 0 && arr[i] > arr[i / 2] + 1) {
                arr[i] = arr[i / 2] + 1;
            }

            if (i % 3 == 0 && arr[i] > arr[i / 3] + 1) {
                arr[i] = arr[i / 3] + 1;
            }
        }

        System.out.println(arr[N]);
    }
}
