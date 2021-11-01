package Bronze_4;

import java.util.*;
import java.io.*;

public class 베시와_데이지_16431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int B1 = Integer.parseInt(st.nextToken());
        int B2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int D1 = Integer.parseInt(st.nextToken());
        int D2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int J1 = Integer.parseInt(st.nextToken());
        int J2 = Integer.parseInt(st.nextToken());

        double bessie = (int)Math.sqrt(Math.pow(B2 - J2, 2) + Math.pow(B1 - J1, 2));
        int daisy = Math.abs(D2 - J2) + Math.abs(D1 - J1);

        if (bessie < daisy) {
            System.out.println("bessie");
        }
        else if (bessie > daisy) {
            System.out.println("daisy");
        }
        else {
            System.out.println("tie");
        }
    }
}
