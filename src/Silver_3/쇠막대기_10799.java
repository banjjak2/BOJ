package Silver_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] array = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();

        char chr = ' ';
        int sum = 0;
        for(int i=0; i<array.length; i++) {
            chr = array[i];

            if (chr == '(') {
                stack.push(i);
            }
            else {
                // 레이저 일 때 (현재 인덱스와 이전 인덱스의 차이가 1일 때)
                if (i - 1 == stack.peek()) {
                    stack.pop();
                    sum += stack.size();
                }
                // 쇠막대기의 끝점 일 때 (현재 인덱스와 이전 인덱스의 차이가 1보다 클 때)
                // 끝점은 겹치지 않느다고 하였으므로 무조건 1개가 나옴
                else {
                    stack.pop();
                    sum += 1;
                }
            }
        }

        System.out.println(sum);
    }
}
