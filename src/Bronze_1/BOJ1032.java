package Bronze_1;

import java.io.*;

public class BOJ1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] files = new String[N];
        for(int i=0; i<N; i++) {
            files[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        // 파일명 길이 확인 (파일명 길이는 모두 같다고 하였으므로 고정가능)
        int fileLen = files[0].length();
        // 각 파일명에서 한자리씩 확인하기 위해
        char fileChar = ' ';
        // 각 자리의 문자가 모두 같은지 확인
        boolean notSameFileChar = false;

        for(int i=0; i<fileLen; i++) {
            fileChar = files[0].charAt(i);
            for(int j=0; j<N; j++) {
                if (files[j].charAt(i) != fileChar) {
                    notSameFileChar = true;
                    break;
                }
            }

            if (notSameFileChar) {
                sb.append("?");
                notSameFileChar = false;
            }
            else {
                sb.append(fileChar);
            }
        }

        System.out.println(sb.toString());
    }
}
