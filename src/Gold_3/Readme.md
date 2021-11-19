# 백준 문제풀이 (Gold 3)

---

## 오등큰수 (17299번)
https://www.acmicpc.net/problem/17299

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int[] result = new int[N];
        // A[i]의 값이 1000000일 경우 A[1000000]에 +1을 해주어야 하기 때문에
        // 크기를 1000000으로 줌
        int[] frequency = new int[1000000];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            // 빈도수 구하기
            frequency[A[i] - 1] += 1;
        }

        stack.push(0);
        for(int i=1; i<N; i++) {
            if (stack.empty()) {
                stack.push(i);
            }

            while(
                    !stack.empty()
                    && frequency[A[stack.peek()] - 1] < frequency[A[i] - 1]
            )
            {
                result[stack.pop()] = A[i];
            }

            stack.push(i);
        }

        while(!stack.empty()) {
            result[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(result[i]).append(' ');
        }

        System.out.println(sb);
    }
}
```
---
## 후위 표기식 (1918번)
https://www.acmicpc.net/problem/1918

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inorder = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        char c = ' ';
        char popChar = ' ';
        for(int i=0; i<inorder.length(); i++) {
            c = inorder.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
            }
            else {
                if (stack.empty()) {
                    stack.push(c);
                }
                else {
                    if (c == '(') {
                        stack.push(c);
                        continue;
                    }
                    else if (c == ')') {
                        while(true) {
                            popChar = stack.pop();
                            if (popChar == '(') {
                                break;
                            }
                            sb.append(popChar);
                        }
                        continue;
                    }

                    // 연산자 스택의 최상위와 현재 연산자의 우선순위 비교
                    // 현재 연산자가 더 높으면 스택에 쌓는다.
                    if (opPriority(stack.peek()) < opPriority(c)) {
                        stack.push(c);
                    }
                    // 현재 연산자와 작거나 같으면 빼낸다
                    else {
                        while (!stack.empty() && opPriority(stack.peek()) >= opPriority(c)) {
                            sb.append(stack.pop());
                        }
                        stack.push(c);
                    }
                }
            }
        }

        while(!stack.empty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    // 연산자의 우선 순위 반환
    private static int opPriority(char op) {
        switch (op) {
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }

        return -1;
    }
}
```
---
