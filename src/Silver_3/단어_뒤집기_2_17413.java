package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 단어_뒤집기_2_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine() + "\n";
        char chr = ' ';
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean openTag = false;

        for(int i=0; i<str.length(); i++) {
            chr = str.charAt(i);

            if (openTag) {
                sb.append(chr);
                if (chr == '>') {
                    openTag = false;
                }
                continue;
            }

            if (chr == '<') {
                openTag = true;
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append('<');
            }
            else if (chr == ' ' || chr == '\n') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(' ');
            }
            else {
                stack.push(chr);
            }
        }

        System.out.println(sb);
    }
}
