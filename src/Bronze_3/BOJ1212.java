package Bronze_3;

import java.io.*;

public class BOJ1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(octalToBinary(br.readLine()));
    }

    private static String octalToBinary(String octal) {
        StringBuilder convSb = new StringBuilder();
        String tmp = "";
        for (int i = 0; i < octal.length(); i++) {
            tmp = convBinary(octal.charAt(i));
            convSb.append(tmp);
        }

        while (convSb.length() != 0 && convSb.charAt(0) != '1') {
            convSb.deleteCharAt(0);
        }

        if (convSb.length() == 0) {
            return "0";
        }

        return convSb.toString();
    }

    private static String convBinary(char c) {
        int value = c - '0';
        char[] bin = new char[3];

        for(int i=0; i<3; i++) {
            bin[2 - i] = (char)(value%2 + '0');
            value/=2;
        }

        return new String(bin);
    }
}

