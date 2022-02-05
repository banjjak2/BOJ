package Silver_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11729 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sb.append((int)(Math.pow(2, n)-1)).append('\n');
        hanoi(1, 2, 3, n);
        System.out.println(sb);
    }

    private static void hanoi(int from, int mid, int to, int n) {
        if (n == 1) {
            sb.append(from).append(' ').append(to).append('\n');
            return;
        }

        hanoi(from, to, mid, n-1);
        sb.append(from).append(' ').append(to).append('\n');
        hanoi(mid, from, to, n-1);
    }
}
