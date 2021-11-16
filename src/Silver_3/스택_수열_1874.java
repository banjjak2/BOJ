package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택_수열_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int input = 0;
        int curValue = 0;
        StringBuilder sb = new StringBuilder();

        while(n-- > 0) {
            input = Integer.parseInt(br.readLine());

            if (input > curValue) {
                while(input > curValue) {
                    stack.push(++curValue);
                    sb.append("+\n");
                }
            }
            else {
                if (stack.peek() != input) {
                    System.out.println("NO");
                    return;
                }
            }

            stack.pop();
            sb.append("-\n");
        }

        System.out.println(sb);
    }
}
