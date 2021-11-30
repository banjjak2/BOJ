package Silver_4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 악수_8394 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ppNumber = 1; // prev prev Number
        int pNumber = 2; // prev Number
        int result = 0;

        if (n == 1) {
            System.out.println(ppNumber);
            return;
        }
        else if (n == 2) {
            System.out.println(pNumber);
            return;
        }

        for(int i=3; i<=n; i++) {
            result = (ppNumber%10 + pNumber%10)%10;
            ppNumber = pNumber%10;
            pNumber = result%10;
        }

        System.out.println(result);
    }
}
