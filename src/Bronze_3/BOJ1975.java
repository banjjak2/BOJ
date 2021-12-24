package Bronze_3;

import java.io.*;

public class BOJ1975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int sum = 0;
        int N = 0;
        int tmp = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
            tmp = N;
            for(int j=2; j<=N; j++) {
                while(tmp != 0) {
                    if (tmp%j == 0) {
                        tmp /= j;
                        sum++;
                    }
                    else {
                        break;
                    }
                }

                tmp = N;
            }
            sb.append(sum).append("\n");
            sum = 0;
        }

        System.out.println(sb.toString());
    }
}
