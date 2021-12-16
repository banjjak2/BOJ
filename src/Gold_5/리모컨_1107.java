package Gold_5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 리모컨_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int targetChannel = Integer.parseInt(br.readLine());
        int brokenButtonCount = Integer.parseInt(br.readLine());
        boolean[] brokenButtons = new boolean[10];
        int min = Math.abs(targetChannel - 100);

        if (brokenButtonCount > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            if (targetChannel == 100) {
                System.out.println(0);
                return;
            }

            int index = 0;
            while (st.hasMoreTokens()) {
                index = Integer.parseInt(st.nextToken());
                brokenButtons[index] = true;
            }
        }

        int i = 0;
        for(i=0; i<1_000_000; i++) {
            if (isBrokenButtonPressed(i, brokenButtons)) {
                continue;
            }

            min = Math.min(min, Math.abs(targetChannel - i) + intLen(i));
        }

        System.out.println(min);
    }

    private static boolean isBrokenButtonPressed(int num, boolean[] brokenButtons) {
        for(int i=0; i<intLen(num); i++) {
            if (brokenButtons[getIntPosition(num, i)]) {
                return true;
            }
        }
        return false;
    }

    private static int getIntPosition(int num, int position) {
        int r = 0;
        while (position-- >= 0) {
            r = num % 10;
            while (true) {
                if (r < 10) {
                    break;
                }

                r = r % 10;
            }
            num /= 10;
        }

        return r;
    }

    private static int intLen(int num) {
        if (num < 10) {
            return 1;
        }

        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }

        return count;
    }
}
