package Bronze_4;

import java.util.*;
import java.io.*;

public class 팀_나누기_13866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] skill = new int[4];

        for(int i=0; i<4; i++) {
            skill[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println((skill[3] + skill[0]) - (skill[1] + skill[2]));
    }
}
