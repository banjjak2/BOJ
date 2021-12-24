package Bronze_4;

import java.io.*;

public class BOJ5532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 방학
        int L = Integer.valueOf(br.readLine());
        // 국어 총 페이지 수
        int A = Integer.valueOf(br.readLine());
        // 수학 총 페이지 수
        int B = Integer.valueOf(br.readLine());
        // 하루에 국어 최대 페이지
        int C = Integer.valueOf(br.readLine());
        // 하루에 수학 최대 페이지
        int D = Integer.valueOf(br.readLine());

        int sum = 0;
        // C는 최대 페이지이므로 C보다 작을 수 있음
        // 총 페이지 수를 최대 페이지 수로 나눈 나머지가 있으면
        // 최대 페이지 미만의 페이지가 남아있는 것이므로 하루를 더 해야함
        if (A%C > 0) {
            sum = A/C+1;
        }
        else {
            sum = A/C;
        }

        if (B%D > 0) {
            // sum은 국어를 몇 일동안 푸는지에 대한 결과값이며,
            // B/D+1은 최대 페이지 미만이 남았으므로 하루를 더해줌
            if (sum < B/D+1) {
                // B/D+1 이 sum보다 더 크다면 국어를 푸는 날보다 수학을 푸는 날이 더 많으므로 빼주어야 함
                sum += (B/D+1 - sum);
            }
        }
        else {
            if (sum < B/D) {
                sum += (B/D - sum);
            }
        }

        System.out.println(L - sum);
    }
}
