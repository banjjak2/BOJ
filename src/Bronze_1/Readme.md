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
## 피보나치 수 2 (2748번)
https://www.acmicpc.net/problem/2748

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        System.out.println(fibo(N));
    }

    public static long fibo(int num) {
        if (num <= 1) {
            return num;
        }

        long[] arr = new long[num + 1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2; i<=num; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        return arr[num];
    }
}
```
---
## 설탕 배달 (2839번)
https://www.acmicpc.net/problem/2839

### 풀이방법
1. 5키로 봉지로 정확히 나눌 때 가장 개수가 적게 나옴 (예, 15 => 5키로 3, 3키로 5)
2. N이 3보다 작으면 더이상 나눌 수 있는 것이 없으므로 -1
3. 5키로로 정확히 나눠지지 않은 경우 3키로로 나눠지는지 확인 (나누기는 빼기의 연속이므로 빼기로 구현)
4. N이 0이 될 경우 정확히 5, 3키로로 나누어진 것이므로 봉지 개수 반환

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1) 5키로 봉지로 정확히 나눌 때 가장 개수가 적게 나옴 (예, 15 => 5키로 3, 3키로 5)
        // 2) N이 3보다 작으면 더이상 나눌 수 있는 것이 없으므로 -1
        // 3) 5키로로 정확히 나눠지지 않은 경우 3키로로 나눠지는지 확인 (나누기는 빼기의 연속이므로 빼기로 구현)
        // 4) N이 0이 될 경우 정확히 5, 3키로로 나누어진 것이므로 봉지 개수 반환
        
        int N = Integer.parseInt(br.readLine());
        int fiveKg = 0;
        int threeKg = 0;
        while(N != 0) {
            if (N%5 == 0) {
                fiveKg = N/5;
                break;
            }
            else {
                if (N < 3) {
                    System.out.println(-1);
                    return;
                }

                N -= 3;
                threeKg++;
            }
        }

        System.out.println(fiveKg + threeKg);
    }
}
```
---
## BABBA (9625번)
https://www.acmicpc.net/problem/9625

### 풀이방법
버튼을 누를 때마다 A는 무조건 B로 바뀌어야 하고 B는 BA로 바뀌기 때문에

 A   B<br>
 1   0 => A<br>
 0   1 => B<br>
 1   1 => BA<br>
 1   2 => BA -> BA A -> BAB<br>
 2   3 => BAB -> BA A BA -> BABBA<br>
 3   5 => BABBA -> BA A BA BA A -> BABBABAB<br>

규칙을 보면 A는 B의 이전값을 가지고 있고, B는 A를 더한 값을 가지고 있음


```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        
        // A부터 시작하므로 A의 개수는 1
        int countOfA = 1;
        int countOfB = 0;
        int prevCountOfB = 0;
        
        while (K-- > 0) {
            prevCountOfB = countOfB;
            countOfB += countOfA;
            countOfA = prevCountOfB;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(countOfA).append(' ').append(countOfB);
        System.out.println(sb);
    }
}
```
---
## 타일 장식물 (13301번)
https://www.acmicpc.net/problem/13301

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        if (N == 1) {
            System.out.println(4);
            return;
        }
        
        long[] dp = new long[N + 1];
        dp[0] = 0; dp[1] = 1;
        for(int i=2; i<=N; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        
        // 현재값의 이전 두 개 값을 더한게 가로가 되고
        long width = dp[N-1] + dp[N-2];
        // 현재값과 이전값을 더한게 세로가 됨
        long height = dp[N] + dp[N-1];
        
        System.out.println(width * 2 + height * 2);
    }
}
```
---
