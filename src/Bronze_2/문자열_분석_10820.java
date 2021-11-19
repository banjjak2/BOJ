package Bronze_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 문자열_분석_10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[4];
        String S = "";
        char chr = ' ';
        StringBuilder sb = new StringBuilder();
        while((S = br.readLine()) != null) {
            for(int i=0; i<S.length(); i++) {
                chr = S.charAt(i);
                if (chr >= 'a' && chr <= 'z') {
                    count[0]++;
                }
                else if (chr >= 'A' && chr <= 'Z') {
                    count[1]++;
                }
                else if (chr >= '0' && chr <= '9') {
                    count[2]++;
                }
                else {
                    count[3]++;
                }
            }

            for(int i=0; i<count.length; i++) {
                sb.append(count[i]).append(' ');
            }
            sb.append('\n');

            count[0] = 0; count[1] = 0; count[2] = 0; count[3] = 0;
        }

        System.out.println(sb);
    }
}
