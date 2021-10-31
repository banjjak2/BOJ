package Bronze_4;

import java.util.*;
import java.io.*;

public class 나이_계산하기_16199 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int inputYear = Integer.parseInt(st.nextToken());
        int inputMonth = Integer.parseInt(st.nextToken());
        int inputDay = Integer.parseInt(st.nextToken());

        // 기준 날짜가 생년월일보다 작을 수 없음
        // (입력으로 주어지는 생년월일은 기준 날짜와 같거나 그 이전이다.)
        // 만 나이
        int age = inputYear - year;
        if (inputMonth < month) {
            age--;
        }
        else if (inputMonth == month) {
            if (inputDay < day) {
                age--;
            }
        }
        System.out.println(age);

        // 세는 나이
        age = inputYear - year;
        System.out.println(age + 1);

        // 연 나이
        age = inputYear - year;
        System.out.println(age);
    }
}
