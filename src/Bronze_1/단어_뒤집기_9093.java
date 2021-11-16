package Bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 단어_뒤집기_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        StringBuilder word = null;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()) {
                word = new StringBuilder(st.nextToken());
                sb.append(word.reverse().append(' '));
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}
