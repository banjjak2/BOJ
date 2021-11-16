package Bronze_1;

import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어_뒤집기_9093_Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        String input = null;
        StringBuilder sb = new StringBuilder();
        char chr = ' ';
        while(T-- > 0) {
            input = br.readLine() + "\n";

            for(int i=0; i<input.length(); i++) {
                chr = input.charAt(i);
                if (chr == ' ' || chr == '\n') {
                    while(!stack.empty()) {
                        sb.append(stack.pop());
                    }

                    if (chr != '\n') {
                        sb.append(chr);
                    }
                }
                else {
                    stack.push(chr);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
