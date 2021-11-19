package Bronze_3;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 네_수_10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append(st.nextToken()).append(st.nextToken());
        long AB = Long.parseLong(sb.toString());

        sb.delete(0, sb.length());
        sb.append(st.nextToken()).append(st.nextToken());
        long CD = Long.parseLong(sb.toString());
        System.out.println(AB + CD);
    }
}
