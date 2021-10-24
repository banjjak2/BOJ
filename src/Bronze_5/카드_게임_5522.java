package Bronze_5;

import java.io.*;

public class 카드_게임_5522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sum = 0;

        for(int i=0; i<5; i++){
            sum += Long.valueOf(br.readLine());
        }
        System.out.println(sum);
    }
}
