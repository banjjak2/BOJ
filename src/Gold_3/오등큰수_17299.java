package Gold_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class 오등큰수_17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int[] result = new int[N];
        // 하나도 안겹친다는 가정하에 빈도수의 최대 크기는 N이기 때문에
        int[] frequency = new int[N];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            // 빈도수 구하기
            frequency[A[i] - 1] += 1;
        }

        stack.push(0);
        for(int i=1; i<N; i++) {
            if (stack.empty()) {
                stack.push(i);
            }

            while(
                    !stack.empty()
                    && frequency[A[stack.peek()] - 1] < frequency[A[i] - 1]
            )
            {
                result[stack.pop()] = A[i];
            }

            stack.push(i);
        }

        while(!stack.empty()) {
            result[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(result[i]).append(' ');
        }

        System.out.println(sb);
    }
}
