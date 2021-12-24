package Bronze_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder bin = new StringBuilder(br.readLine());
        if (bin.length() % 3 == 1) {
            bin.insert(0, "00");
        }
        else if (bin.length() % 3 == 2) {
            bin.insert(0, "0");
        }

        StringBuilder sb = new StringBuilder();
        int[] eight = {4, 2, 1};
        int sum = 0;
        for(int i=0; i<bin.length(); i++) {
            if (i % 3 == 0 && i != 0) {
                sb.append(sum);
                sum = 0;
            }

            if (bin.charAt(i) == '1') {
                sum += eight[i % 3];
            }
        }

        sb.append(sum);
        System.out.println(sb);
    }
}
