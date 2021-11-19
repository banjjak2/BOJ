# 백준 문제풀이 (Bronze 1)

---

## 명령 프롬프트 (1032번)
https://www.acmicpc.net/problem/1032

### 풀이방법
```java
import java.io.*;

public class Main {
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
```
---
## 단어 뒤집기 (9093번)
https://www.acmicpc.net/problem/9093

### 풀이방법 1 (스택)
```java
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        String input = null;
        StringBuilder sb = new StringBuilder();
        char chr = ' ';
        while(T-- > 0) {
            input = br.readLine() + "\n";

            for(int i=0; i<input.length(); i++) {
                chr = input.charAt(i);
                if (chr == ' ' || chr == '\n') {
                    while(!stack.empty()) {
                        sb.append(stack.pop());
                    }

                    if (chr != '\n') {
                        sb.append(chr);
                    }
                }
                else {
                    stack.push(chr);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
```

### 풀이방법 2 (StringBuilder)
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        StringBuilder word = null;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()) {
                word = new StringBuilder(st.nextToken());
                sb.append(word.reverse().append(' '));
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}
```
---
## ROT13 (11655번)
https://www.acmicpc.net/problem/11655

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char chr = ' ';
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            chr = str.charAt(i);
            if (chr >= 'A' && chr <= 'Z') {
                chr += 13;
                if (chr > 'Z') {
                    chr = (char)('A' + chr - 'Z' - 1);
                }
            }
            else if (chr >= 'a' && chr <= 'z') {
                chr += 13;
                if (chr > 'z') {
                    chr = (char)('a' + chr - 'z' - 1);
                }
            }

            sb.append(chr);
        }

        System.out.println(sb);
    }
}
```
---
