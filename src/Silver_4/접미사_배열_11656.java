package Silver_4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class 접미사_배열_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        List<String> list = new ArrayList<>();

        int len = sb.length();
        list.add(sb.toString());
        for(int i=0; i<len - 1; i++) {
            list.add(sb.deleteCharAt(0).toString());
        }

        Collections.sort(list);
        sb.delete(0, sb.length());
        for(String s : list) {
            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }
}
