package Bronze_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 알파벳_개수_10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S = br.readLine().toCharArray();
        int[] alphabet = new int[26];

        for(int i=0; i<S.length; i++) {
            alphabet[S[i] - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<alphabet.length; i++) {
            sb.append(alphabet[i]).append(' ');
        }
        System.out.println(sb);
    }
}
