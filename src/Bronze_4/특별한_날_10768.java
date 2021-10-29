package Bronze_4;

import java.io.*;

public class 특별한_날_10768 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());

        if (month == 2 && day == 18) {
            System.out.println("Special");
            return;
        }

        if (month < 2) {
            System.out.println("Before");
        }
        else {
            if (month == 2 && day < 18) {
                System.out.println("Before");
            }
            else {
                System.out.println("After");
            }
        }
    }
}
