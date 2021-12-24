package Silver_4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class BOJ1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            queue.add(i);
        }

        LinkedList<Integer> removeData = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            removeData.add(Integer.parseInt(st.nextToken()));
        }

        int lCount = 0;
        int rCount = 0;
        int step2 = 0;
        int step3 = 0;
        while(!removeData.isEmpty()) {
            lCount = leftCount(queue, removeData.peekFirst());
            rCount = rightCount(queue, removeData.peekFirst());
            removeData.poll();
            if (lCount < rCount) {
                while(lCount-- > 0) {
                    step2++;
                    left(queue);
                }
                queue.poll();
            }
            else {
                while(rCount-- > 0) {
                    step3++;
                    right(queue);
                }
                queue.poll();
            }
        }

        System.out.println(step2 + step3);
    }

    private static void left(LinkedList<Integer> queue) {
        queue.addLast(queue.removeFirst());
    }

    private static void right(LinkedList<Integer> queue) {
        queue.addFirst(queue.removeLast());
    }

    private static int leftCount(LinkedList<Integer> queue, int target) {
        for(int i=0; i<queue.size(); i++) {
            if (queue.get(i) == target) {
                return i;
            }
        }
        return -1;
    }

    private static int rightCount(LinkedList<Integer> queue, int target) {
        for(int i=queue.size()-1; i>=0; i--) {
            if (queue.get(i) == target) {
                return queue.size() - i;
            }
        }
        return -1;
    }
}
