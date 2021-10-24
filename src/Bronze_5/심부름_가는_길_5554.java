package Bronze_5;

import java.io.*;

public class 심부름_가는_길_5554 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalSeconds = 0;
        for(int i=0; i<4; i++){
            totalSeconds += Integer.valueOf(br.readLine());
        }
        System.out.println(totalSeconds/60 + "\n" + totalSeconds%60);
    }
}
