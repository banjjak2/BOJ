package Bronze_4;

import java.util.*;
import java.io.*;

public class 직사각형에서_탈출_1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int min = x;
        if (x < w - x) {
            min = x;
        }
        else {
            min = w - x;
        }

        if (y < h - y) {
            if (min > y) {
                min = y;
            }
        }
        else {
            if (min > h - y) {
                min = h - y;
            }
        }

        System.out.println(min);
    }
}
