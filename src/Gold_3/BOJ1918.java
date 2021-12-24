package Gold_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inorder = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        char c = ' ';
        char popChar = ' ';
        for(int i=0; i<inorder.length(); i++) {
            c = inorder.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
            }
            else {
                if (stack.empty()) {
                    stack.push(c);
                }
                else {
                    if (c == '(') {
                        stack.push(c);
                        continue;
                    }
                    else if (c == ')') {
                        while(true) {
                            popChar = stack.pop();
                            if (popChar == '(') {
                                break;
                            }
                            sb.append(popChar);
                        }
                        continue;
                    }

                    // 연산자 스택의 최상위와 현재 연산자의 우선순위 비교
                    // 현재 연산자가 더 높으면 스택에 쌓는다.
                    if (opPriority(stack.peek()) < opPriority(c)) {
                        stack.push(c);
                    }
                    // 현재 연산자와 작거나 같으면 빼낸다
                    else {
                        while (!stack.empty() && opPriority(stack.peek()) >= opPriority(c)) {
                            sb.append(stack.pop());
                        }
                        stack.push(c);
                    }
                }
            }
        }

        while(!stack.empty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    // 연산자의 우선 순위 반환
    private static int opPriority(char op) {
        switch (op) {
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }

        return -1;
    }
}
