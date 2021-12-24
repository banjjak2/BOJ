package Bronze_1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char chr = ' ';
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            chr = str.charAt(i);
            if (chr >= 'A' && chr <= 'Z') {
                chr += 13;
                if (chr > 'Z') {
                    chr = (char)('A' + chr - 'Z' - 1);
                }
            }
            else if (chr >= 'a' && chr <= 'z') {
                chr += 13;
                if (chr > 'z') {
                    chr = (char)('a' + chr - 'z' - 1);
                }
            }

            sb.append(chr);
        }

        System.out.println(sb);
    }
}
