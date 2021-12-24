package Silver_4;

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        stack.init(N);

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while(--N >= 0) {
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    sb.append(stack.pop()).append("\n");
                    break;

                case "size":
                    sb.append(stack.size()).append("\n");
                    break;

                case "empty":
                    sb.append(stack.empty()).append("\n");
                    break;

                case "top":
                    sb.append(stack.top()).append("\n");
                    break;
            }
        }

        System.out.println(sb.toString());
    }

    public static class Stack {
        int[] arr = null;
        int size = 0;
        public void init(int capacity) {
            arr = new int[capacity];
        }

        public int empty() {
            if (size == 0) {
                return 1;
            }

            return 0;
        }

        public int size() {
            return size;
        }

        public void push(int x) {
            arr[size++] = x;
        }

        public int pop() {
            if (empty() == 1) {
                return -1;
            }

            return arr[--size];
        }

        public int top() {
            if (empty() == 1) {
                return -1;
            }

            return arr[size-1];
        }
    }
}
