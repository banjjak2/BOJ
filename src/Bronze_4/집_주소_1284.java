package Bronze_4;

import java.io.*;

public class 집_주소_1284 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = "";
        int sum = 0;
        char chr = ' ';
        while(!(N = br.readLine()).equals("0")) {
            sum = 0;
            for(int i=0; i<N.length(); i++) {
                chr = N.charAt(i);
                if (chr == '0') {
                    sum += 4;
                }
                else if (chr == '1') {
                    sum += 2;
                }
                else {
                    sum += 3;
                }
            }
            // 각 숫자 사이의 여백 1cm
            sum += N.length() - 1;
            // 경계
            sum += 2;

            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
    }
}
