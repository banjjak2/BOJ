package Bronze_4;

import java.util.*;
import java.io.*;

public class 삼각형_외우기_10101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        if (A == 60 && B == 60 && C == 60) {
            bw.write("Equilateral");
        }
        else if (A+B+C != 180) {
            bw.write("Error");
        }
        else if (A == B || A == C || B == C) {
            bw.write("Isosceles");
        }
        else {
            bw.write("Scalene");
        }

        bw.flush();
    }
}
