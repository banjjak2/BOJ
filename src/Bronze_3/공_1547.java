package Bronze_3;

import java.util.*;
import java.io.*;

public class 공_1547 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.valueOf(br.readLine());

        boolean[] cups = {true, false, false};
        StringTokenizer st = null;

        int X = 0;
        int Y = 0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            X = Integer.parseInt(st.nextToken()) - 1;
            Y = Integer.parseInt(st.nextToken()) - 1;

            if (X == Y) {
                continue;
            }

            swap(cups, X, Y);
        }

        if (cups[0])
            System.out.println("1");
        else if (cups[1])
            System.out.println("2");
        else if (cups[2])
            System.out.println("3");
    }

    private static void swap(boolean[] cups, int X, int Y) {
        boolean tmp = cups[X];
        cups[X] = cups[Y];
        cups[Y] = tmp;
    }
}
