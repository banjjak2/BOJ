package Silver_5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String roomNumber = st.nextToken();

        int setCount = 1;
        int[] numberCount = new int[10];
        for(int i=0; i<=9; i++) {
            numberCount[i] = 1;
        }

        int number = 0;
        for(int i=0; i<roomNumber.length(); i++) {
            number = roomNumber.charAt(i) - '0';
            if (numberCount[number] == 0) {
                if (number == 6 && numberCount[9] != 0) number = 9;
                else if (number == 9 && numberCount[6] != 0) number = 6;
                else {
                    for (int j = 0; j <= 9; j++) numberCount[j] += 1;
                    setCount++;
                }
            }
            numberCount[number] -= 1;
        }

        System.out.println(setCount);
    }
}
