package Bronze_3;

import java.io.*;

public class BOJ1864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        int num = 0;
        StringBuilder sb = new StringBuilder();
        while(!(str = br.readLine()).equals("#")) {
            for(int i=0; i<str.length(); i++) {
                num += (whatNumber(str.charAt(i)) * Math.pow(8, str.length() - 1 - i));
            }

            sb.append(num).append("\n");
            num = 0;
        }

        System.out.println(sb.toString());
    }

    private static int whatNumber(char c) {
        switch(c) {
            case '-': return 0;
            case '\\': return 1;
            case '(': return 2;
            case '@': return 3;
            case '?': return 4;
            case '>': return 5;
            case '&': return 6;
            case '%': return 7;
            default: return -1;
        }
    }
}
