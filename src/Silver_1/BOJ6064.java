package Silver_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int M, N, x, y;
        boolean find = false;
        StringBuilder sb = new StringBuilder();

        // X < M 이면 X' = X + 1
        // Y < M 이면 Y' = Y + 1

        // X+1 < M 이 아니라 X < M 인 것에 주의
        // Y+1 < M 이 아니라 Y < N 인 것에 주의
        // <x:y>에서 y값을 N값으로 나눴을 때 나머지가 0일 경우 예외 처리

        while (T-- > 0) {
            find = false;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            for(int i=x; i<(M*N); i+=M) {
                if (i%N == y) {
                    sb.append(i).append('\n');
                    find = true;
                    break;
                }
                else if (i%N == 0) {
                    if (y == N) {
                        sb.append(i).append('\n');
                        find = true;
                        break;
                    }
                }
            }

            if (!find) {
                sb.append(-1).append('\n');
            }
        }

        System.out.println(sb);
    }
}
