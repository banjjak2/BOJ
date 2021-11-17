package Silver_4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class 덱_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Deque deque = new Deque();
        StringBuilder sb = new StringBuilder();

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()) {
                case "push_front":
                    deque.push_front(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    deque.push_back(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    sb.append(deque.pop_front()).append('\n');
                    break;

                case "pop_back":
                    sb.append(deque.pop_back()).append('\n');
                    break;

                case "size":
                    sb.append(deque.size()).append('\n');
                    break;

                case "empty":
                    sb.append(deque.empty()).append('\n');
                    break;

                case "front":
                    sb.append(deque.front()).append('\n');
                    break;

                case "back":
                    sb.append(deque.back()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }

    public static class Deque {
        LinkedList<Integer> list = new LinkedList<>();

        public int empty() {
            if (list.size() == 0) {
                return 1;
            }

            return 0;
        }

        public void push_front(int x) {
            list.addFirst(x);
        }

        public void push_back(int x) {
            list.addLast(x);
        }

        public int pop_front() {
            if (empty() == 1) {
                return -1;
            }

            return list.removeFirst();
        }

        public int pop_back() {
            if (empty() == 1) {
                return -1;
            }

            return list.removeLast();
        }

        public int size() {
            return list.size();
        }

        public int front() {
            if (empty() == 1) {
                return -1;
            }

            return list.peekFirst();
        }

        public int back() {
            if (empty() == 1) {
                return -1;
            }

            return list.peekLast();
        }
    }
}
