package Gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[N];
        int[] dp = new int[N];
        int[] seq = new int[N];
        int index = 0;
        while(st.hasMoreTokens()) {
            numbers[index] = Integer.parseInt(st.nextToken());
            dp[index] = 1;
            seq[index] = -1;
            index++;
        }

        int max = 1;
        int prevMax = max;
        for(int i=0; i<N; i++) {
            for(int j=0; j<i; j++) {
                if (numbers[j] < numbers[i]) {
                    max = Math.max(dp[i] + dp[j], max);
                    if (prevMax < max) {
                        seq[i] = j;
                    }
                    prevMax = max;
                }
            }

            dp[i] = max;
            max = 1;
            prevMax = 1;
        }

        int result = 0;
        for(int i=0; i<N; i++) {
            if (dp[i] > result) {
                result = dp[i];
                index = i;
            }
        }

        sb.append(result).append('\n');
        print(numbers, seq, index);
        sb.append('\n');
        System.out.println(sb);
    }

    static StringBuilder sb = new StringBuilder();
    private static void print(int[] numbers, int[] seq, int index) {
        if (index == -1) {
            return;
        }

        print(numbers, seq, seq[index]);
        sb.append(numbers[index]).append(' ');
    }
}
