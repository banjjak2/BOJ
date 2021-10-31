package Bronze_4;

import java.util.*;
import java.io.*;

public class 카드_뽑기_16204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 카드의 총 개수
        int N = Integer.parseInt(st.nextToken());
        // 앞면에 O가 적혀있는 개수
        int M = Integer.parseInt(st.nextToken());
        // 뒷면에 적힌 O의 개수
        int K = Integer.parseInt(st.nextToken());

        int sum = 0;
        sum += (M < K)? M : K;
        sum += ((N-K) < (N-M))? N-K : N-M;

        System.out.println(sum);
    }
}
