package Bronze_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ15312 {
    static int[] alphabetCount = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        int[] arrayOfAB = new int[A.length() * 2];
        for(int i=0; i<A.length(); i++) {
            arrayOfAB[i * 2] = alphabetCount[A.charAt(i) - 'A'];
            arrayOfAB[(i * 2) + 1] = alphabetCount[B.charAt(i) - 'A'];
        }

        int[] result = solution(arrayOfAB);
        System.out.println(String.valueOf(result[0]) + String.valueOf(result[1]));
    }

    public static int[] solution(int[] arr) {
        int[] result = new int[arr.length - 1];

        for(int i=0; i<arr.length - 1; i++) {
            result[i] = (arr[i] + arr[i + 1]) % 10;
        }
        if (result.length == 2) {
            return result;
        }

        return solution(result);
    }
}
