package Silver_5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // N을 2로 나눈 나머지가 짝수
        System.out.println((N%2)==0? "CY" : "SK");
    }
}
