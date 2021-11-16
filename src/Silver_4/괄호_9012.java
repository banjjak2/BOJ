package Silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        int T = Integer.parseInt(br.readLine());
        String str = null;
        char chr = ' ';
        StringBuilder sb = new StringBuilder();
        boolean fail = false;
        while(T-- > 0) {
            str = br.readLine();
            stack.clear();
            for(int i=0; i<str.length(); i++) {
                chr = str.charAt(i);

                if (chr == ')') {
                    if (stack.empty()) {
                        sb.append("NO").append('\n');
                        fail = true;
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
                else {
                    stack.push(chr);
                }
            }

            if (!fail && stack.empty()) {
                sb.append("YES").append('\n');
            }
            else if (!stack.empty()) {
                sb.append("NO").append('\n');
            }
            fail = false;
        }

        System.out.println(sb.toString());
    }
}
