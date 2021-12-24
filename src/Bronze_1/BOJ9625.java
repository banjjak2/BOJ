package Bronze_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9625 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        // A부터 시작하므로 A의 개수는 1
        int countOfA = 1;
        int countOfB = 0;
        int prevCountOfB = 0;

        // 버튼을 누를 때마다 A는 무조건 B로 바뀌어야 하고 B는 BA로 바뀌기 때문에
        /*
         *  A   B
         *  1   0 => A
         *  0   1 => B
         *  1   1 => BA
         *  1   2 => BA -> BA A -> BAB
         *  2   3 => BAB -> BA A BA -> BABBA
         *  3   5 => BABBA -> BA A BA BA A -> BABBABAB
         *
         * 규칙을 보면 A는 B의 이전값을 가지고 있고, B는 A를 더한 값을 가지고 있음
        */
        while (K-- > 0) {
            prevCountOfB = countOfB;
            countOfB += countOfA;
            countOfA = prevCountOfB;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(countOfA).append(' ').append(countOfB);
        System.out.println(sb);
    }
}
