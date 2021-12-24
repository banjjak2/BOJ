package Bronze_5;

import java.io.*;

public class BOJ6749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int youngest = Integer.valueOf(br.readLine());
        int middle = Integer.valueOf(br.readLine());

        System.out.println(middle + (middle-youngest));
    }
}
