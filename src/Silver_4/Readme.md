# 백준 문제풀이 (Silver 4)

---

## 킹 (1063번)
https://www.acmicpc.net/problem/1063

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 인덱스를 이용해 A~H를 표현하기 위함
        char[] widthPos = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        String tmp = st.nextToken();
        // 현재 킹의 위치
        int[] kingPos = { tmp.charAt(0) - 'A' + 1, tmp.charAt(1) - '0' };
        tmp = st.nextToken();
        // 현재 돌의 위치
        int[] stonePos = { tmp.charAt(0) - 'A' + 1, tmp.charAt(1) - '0' };

        int N = Integer.parseInt(st.nextToken());

        String command = "";
        for(int i=0; i<N; i++) {
            command = br.readLine();

            calculatePos(command, kingPos, stonePos);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(widthPos[kingPos[0]]).append((char)(kingPos[1] + '0')).append("\n");
        sb.append(widthPos[stonePos[0]]).append((char)(stonePos[1] + '0'));

        System.out.println(sb);
    }

    private static void calculatePos(String command, int[] kingPos, int[] stonePos) {
        int widthMoveCount = 0;
        int heightMoveCount = 0;
        // R, L, B, T의 조합으로만 이루어져 있으므로
        for(int i=0; i<command.length(); i++) {
            switch (command.charAt(i)) {
                case 'R':
                    widthMoveCount = 1;
                    break;
                case 'L':
                    widthMoveCount = -1;
                    break;
                case 'B':
                    heightMoveCount = -1;
                    break;
                case 'T':
                    heightMoveCount = 1;
                    break;
            }
        }

        // 8x8 범위에서 벗어났는지 확인
        if (!checkArea(kingPos, widthMoveCount, heightMoveCount)) {
            return;
        }

        // 현재 킹의 위치에 이동횟수를 더한 위치값이 돌의 위치값이라면
        if (
                kingPos[0] + widthMoveCount == stonePos[0]
                && kingPos[1] + heightMoveCount == stonePos[1]
        )
        {
            // 돌의 위치가 8x8에서 벗어났는지 확인
            if (!checkArea(stonePos, widthMoveCount, heightMoveCount)) {
                return;
            }

            // 벗어나지 않았다면 둘 다 동일한 방향으로 밀기
            kingPos[0] += widthMoveCount;
            kingPos[1] += heightMoveCount;

            stonePos[0] += widthMoveCount;
            stonePos[1] += heightMoveCount;
        }
        // 현재 킹의 위치에 이동횟수를 더한 위치값이 돌의 위치와 같지 않다면 이동 가능하므로 더해줌
        else {
            kingPos[0] += widthMoveCount;
            kingPos[1] += heightMoveCount;
        }
    }

    // 8x8 배열에서 벗어났는지 확인
    private static boolean checkArea(int[] arr, int width, int height) {
        if (
            arr[0] + width > 8
            || arr[0] + width < 1
            || arr[1] + height > 8
            || arr[1] + height < 1
        )
        {
            return false;
        }

        return true;
    }
}
```
---
## 문자열 (1120번)
https://www.acmicpc.net/problem/1120

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {

    /**
     * 
     * A B C D E
     * A B C
     * 인 경우    
     * 
     * A B C D E
     * A B C ? ?
     * 
     * A B C D E
     * ? A B C ?
     * 
     * A B C D E
     * ? ? A B C
     * 
     * 로 비교
     * 
     */
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int lenA = A.length();
        int lenB = B.length();

        int min = 100;
        int compareCount = 0;
        int curIdxOfA = 0;
        for(int i=0; i<=lenB-lenA; i++) {
            curIdxOfA = 0;
            compareCount = 0;
            for(int j=i; j<lenB; j++) {
                if (curIdxOfA >= lenA) {
                    break;
                }
                else if (B.charAt(j) != A.charAt(curIdxOfA)) {
                    compareCount++;
                }

                curIdxOfA++;
            }

            min = Math.min(min, compareCount);
        }

        System.out.println(min);
    }
}
```
---
## 스택 (10828번)
https://www.acmicpc.net/problem/10828

### 사전지식
- 스택 (Stack)

### 풀이방법
```java
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        stack.init(N);

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while(--N >= 0) {
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
//                    bw.write(stack.pop() + "\n");
                    sb.append(stack.pop()).append("\n");
                    break;

                case "size":
//                    bw.write(stack.size() + "\n");
                    sb.append(stack.size()).append("\n");
                    break;

                case "empty":
//                    bw.write(stack.empty() + "\n");
                    sb.append(stack.empty()).append("\n");
                    break;

                case "top":
//                    bw.write(stack.top() + "\n");
                    sb.append(stack.top()).append("\n");
                    break;
            }
        }

        System.out.println(sb.toString());
    }

    public static class Stack {
        int[] arr = null;
        int size = 0;
        public void init(int capacity) {
            arr = new int[capacity];
        }

        public int empty() {
            if (size == 0) {
                return 1;
            }

            return 0;
        }

        public int size() {
            return size;
        }

        public void push(int x) {
            arr[size++] = x;
        }

        public int pop() {
            if (empty() == 1) {
                return -1;
            }

            return arr[--size];
        }

        public int top() {
            if (empty() == 1) {
                return -1;
            }

            return arr[size-1];
        }
    }
}
```
---
## 괄호 (9012번)
https://www.acmicpc.net/problem/9012

### 참고
- 스택을 이용하지 않고도 풀 수 있음
- `(`와 `)`는 짝이 맞아야 함
- 문자열을 확인할 때 `(`를 만나면 +1, `)`을 만나면 -1 과정을 반복하다가
음수가 나오면 `(` 문자는 없는데 `)` 문자가 나온 것이므로 `NO`로 출력

### 풀이방법
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        int T = Integer.parseInt(br.readLine());
        String str = null;
        char chr = ' ';
        StringBuilder sb = new StringBuilder();
        boolean fail = false;
        while(T-- > 0) {
            str = br.readLine();
            stack.clear();
            for(int i=0; i<str.length(); i++) {
                chr = str.charAt(i);

                if (chr == ')') {
                    if (stack.empty()) {
                        sb.append("NO").append('\n');
                        fail = true;
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
                else {
                    stack.push(chr);
                }
            }

            if (!fail && stack.empty()) {
                sb.append("YES").append('\n');
            }
            else if (!stack.empty()) {
                sb.append("NO").append('\n');
            }
            fail = false;
        }

        System.out.println(sb.toString());
    }
}
```
---
