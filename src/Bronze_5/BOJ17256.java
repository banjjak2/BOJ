package Bronze_5;

import java.util.*;
import java.io.*;

public class BOJ17256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ax, ay, az;
        ax = Integer.valueOf(st.nextToken());
        ay = Integer.valueOf(st.nextToken());
        az = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int cx, cy, cz;
        cx = Integer.valueOf(st.nextToken());
        cy = Integer.valueOf(st.nextToken());
        cz = Integer.valueOf(st.nextToken());

        int bx, by, bz;
        bx = cx - az;
        by = cy / ay;
        bz = cz - ax;

        System.out.println(bx + " " + by + " " + bz);
    }
}
