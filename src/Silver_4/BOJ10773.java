package Silver_4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10773 {
    static class Stack {
        int pos = 0;
        int countOfData = 0;
        int[] array = null;

        public Stack(int size) {
            array = new int[size];
        }

        public int pop() {
            countOfData--;
            int rData = array[--pos];
            array[pos] = 0;
            return rData;
        }

        public void push(int c) {
            array[pos++] = c;
            countOfData++;
        }

        public boolean isEmpty() {
            return (countOfData == 0);
        }

        public int size() {
            return countOfData;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack stack = new Stack(K);
        int value = 0;
        int sum = 0;

        while (K-- > 0) {
            value = Integer.parseInt(br.readLine());
            if (value == 0 && !stack.isEmpty()) sum -= stack.pop();
            else {
                sum += value;
                stack.push(value);
            }
        }

        System.out.println(sum);
    }
}
