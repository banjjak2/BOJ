package Bronze_5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 큰_수_BIG_14928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // 수학에서 나눗셈을 구하듯이 구현
        int result = 0;
        for(int i=0; i<str.length(); i++) {
            result = (result * 10 + str.charAt(i) - '0') % 20000303;
        }

        System.out.println(result);
    }
}
