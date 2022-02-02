package Silver_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dist = new int[100_000 * 2];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        dist[N] = 0;

        int cur = 0;
        int origin = 0;
        while (dist[K] == -1) {
            origin = queue.poll();

            cur = origin - 1;
            if (cur >= 0 && cur < 100_000*2 && dist[cur] == -1) {
                dist[cur] = dist[origin]+1;
                queue.add(cur);
            }
            cur = origin + 1;
            if (cur >= 0 && cur < 100_000*2 && dist[cur] == -1) {
                dist[cur] = dist[origin]+1;
                queue.add(cur);
            }
            cur = origin * 2;
            if (cur >= 0 && cur < 100_000*2 && dist[cur] == -1) {
                dist[cur] = dist[origin]+1;
                queue.add(cur);
            }
        }

        System.out.println(dist[K]);
    }
}
