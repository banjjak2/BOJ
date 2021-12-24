package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> strStack = new Stack<>();
        Stack<Character> tmpStoreStack = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            strStack.push(str.charAt(i));
        }

        int cmdCount = Integer.parseInt(br.readLine());
        String cmd;
        while(cmdCount-- > 0) {
            cmd = br.readLine();

            switch(cmd.charAt(0)) {
                case 'L':
                    if (strStack.isEmpty()) {
                        break;
                    }

                    tmpStoreStack.push(strStack.pop());
                    break;

                case 'D':
                    if (tmpStoreStack.isEmpty()) {
                        break;
                    }

                    strStack.push(tmpStoreStack.pop());
                    break;

                case 'B':
                    if (strStack.isEmpty()) {
                        break;
                    }

                    strStack.pop();
                    break;

                case 'P':
                    strStack.push(cmd.charAt(2));
                    break;
            }
        }

        while(!tmpStoreStack.isEmpty()) {
            strStack.push(tmpStoreStack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!strStack.isEmpty()) {
            sb.append(strStack.pop());
        }
        sb = sb.reverse();
        sb.append('\n');
        System.out.println(sb);
    }
}
