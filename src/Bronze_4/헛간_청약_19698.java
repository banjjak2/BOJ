package Bronze_4;

import java.util.*;
import java.io.*;

public class 헛간_청약_19698 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] cow = new int[4];
        for(int i=0; i<4; i++) {
            cow[i] = Integer.parseInt(st.nextToken());
        }

        int totalCow = (int)(cow[1]/cow[3]) * (int)(cow[2]/cow[3]);
        if (totalCow > cow[0]) {
            System.out.println(cow[0]);
        }
        else {
            System.out.println(totalCow);
        }
    }
}
