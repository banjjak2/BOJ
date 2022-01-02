package Gold_5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
    private static StringBuilder sb = new StringBuilder();
    private static char[] result = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        result = new char[L];
        int C = Integer.parseInt(st.nextToken());
        char[] arr = new char[C];
        st = new StringTokenizer(br.readLine());
        int index = 0;
        while (st.hasMoreTokens()) {
            arr[index++] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        solve(arr, 0, 0, 0, L, 0);
        System.out.println(sb);
    }

    private static void solve(char[] arr, int vowelCount, int consonantCount, int curIndex, int r, int c) {
        if (c == r) {
            if (vowelCount >= 1 && consonantCount >= 2) {
                sb.append(result).append('\n');
            }
            return;
        }
        else {
            for(int i=curIndex; i<arr.length; i++){
                result[c] = arr[i];
                if (checkVowel(arr[i])) {
                    solve(arr, vowelCount+1, consonantCount, i+1, r, c+1);
                }
                else {
                    solve(arr, vowelCount, consonantCount+1, i+1, r, c+1);
                }
            }
        }
    }

    private static boolean checkVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }

        return false;
    }
}
