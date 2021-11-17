package Silver_4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class 큐_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Queue queue = new Queue();
        StringBuilder sb = new StringBuilder();

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    sb.append(queue.pop()).append('\n');
                    break;

                case "size":
                    sb.append(queue.size()).append('\n');
                    break;

                case "empty":
                    sb.append(queue.empty()).append('\n');
                    break;

                case "front":
                    sb.append(queue.front()).append('\n');
                    break;

                case "back":
                    sb.append(queue.back()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }

    public static class Queue {
        List<Integer> list = new LinkedList<>();

        public int empty() {
            if (list.size() == 0) {
                return 1;
            }

            return 0;
        }

        public void push(int x) {
            list.add(x);
        }

        public int pop() {
            if (empty() == 1) {
                return -1;
            }

            int popData = list.get(0);
            list.remove(0);
            return popData;
        }

        public int size() {
            return list.size();
        }

        public int front() {
            if (empty() == 1) {
                return -1;
            }

            return list.get(0);
        }

        public int back() {
            if (empty() == 1) {
                return -1;
            }

            return list.get(list.size() - 1);
        }
    }
}
