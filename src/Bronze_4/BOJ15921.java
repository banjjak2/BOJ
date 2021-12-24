package Bronze_4;

import java.util.*;
import java.io.*;

public class BOJ15921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            System.out.println("divide by zero");
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        double average = 0; // 평균
        double chance = 0; // 확률
        int input = 0;
        for(int i=0; i<N; i++) {
            input = Integer.parseInt(st.nextToken());
            average += input;
            chance += (input * (1/(double)N));
        }

        if (chance == 0) {
            System.out.println("divide by zero");
            return;
        }

        average /= N;

        System.out.println(String.format("%.2f", average/chance));
    }
}
