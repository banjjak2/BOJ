package Bronze_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            queue.add(i+1);
        }

        StringBuilder sb = new StringBuilder();
        while(queue.size() != 1) {
            sb.append(queue.remove()).append(" ");
            queue.add(queue.remove());
        }

        sb.append(queue.remove());
        System.out.println(sb.toString());
    }
}
