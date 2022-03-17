package Silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16987 {

    static int n = 0;
    static int[] s = null;
    static int[] w = null;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        s = new int[n];
        w = new int[n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, 0);
        System.out.println(max);
    }

    private static void solve(int eggNumber, int brokenEggCount) {
        if (eggNumber == n) {
            max = Math.max(max, brokenEggCount);
            return;
        }

        // 현재 계란의 내구도가 0이하이거나
        // 깨진 계란의 개수가 n - 1개인 경우 (계란이 하나 남은 경우)
        if (s[eggNumber] <= 0 || brokenEggCount == n - 1) {
            solve(eggNumber + 1, brokenEggCount);
            return;
        }

        for (int i=0; i<n; i++) {
            if (i == eggNumber || s[i] <= 0) {
                continue;
            }

            if ((s[eggNumber] -= w[i]) <= 0) {
                brokenEggCount++;
            }
            if ((s[i] -= w[eggNumber]) <= 0) {
                brokenEggCount++;
            }
            solve(eggNumber + 1, brokenEggCount);

            if (s[eggNumber] <= 0) {
                brokenEggCount--;
            }
            s[eggNumber] += w[i];

            if (s[i] <= 0) {
                brokenEggCount--;
            }
            s[i] += w[eggNumber];
        }
    }
}
