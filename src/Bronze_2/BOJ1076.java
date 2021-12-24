package Bronze_2;

import java.io.*;

public class BOJ1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 10^값 => 곱
        int first = getResistanceValue(br.readLine());
        int second = getResistanceValue(br.readLine());
        int third = getResistanceValue(br.readLine());

        System.out.println((long)(first*10 + second) * (long)Math.pow(10, third));
    }

    private static int getResistanceValue(String color) {
        switch (color) {
            case "black":
                return 0;

            case "brown":
                return 1;

            case "red":
                return 2;

            case "orange":
                return 3;

            case "yellow":
                return 4;

            case "green":
                return 5;

            case "blue":
                return 6;

            case "violet":
                return 7;

            case "grey":
                return 8;

            default:
                return 9;
        }
    }
}
