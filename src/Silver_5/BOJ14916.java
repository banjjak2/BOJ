package Silver_5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());

        int countOfFive = 0;
        int countOfTwo = 0;

        while(money != 0) {
            if (money % 5 == 0) {
                countOfFive = money / 5;
                break;
            }
            else if (money < 2) {
                System.out.println(-1);
                return;
            }
            else {
                money -= 2;
                countOfTwo++;
            }
        }

        System.out.println(countOfFive + countOfTwo);
    }
}
