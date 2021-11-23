# 백준 문제풀이 (Silver 3)

---

## 숫자 정사각형
https://www.acmicpc.net/problem/1051

### 걸림돌
- 범위에서 벗어날 경우의 조건을 잘못주었음.
  - `j+distance >= M`이 되어야 하는데 `i+distance >= M`으로 조건을 주었음


### 풀이방법
- `0, 0`부터 `N, M`까지 가로 방향으로 진행하면서 각 위치의 값과 동일한 값이 있는지 
  탐색한 후 있다면 그 지점까지의 거리를 구해 정사각형이 되는 각 위치에 동일한 값이 있는지 
  확인하는 과정을 반복해서 수행

```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 세로
        int N = Integer.parseInt(st.nextToken());
        // 가로
        int M = Integer.parseInt(st.nextToken());

        char[][] maps = new char[N][];
        for(int i=0; i<N; i++) {
            maps[i] = br.readLine().toCharArray();
        }

        int max = 1;
        char value = ' ';
        int result = 0;
        int distance = 0;
        for(int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                // 각 위치의 값
                value = maps[i][j];

                for(int k=j+1; k<M; k++) {
                    // 탐색을 진행하면서 동일한 값이 있는지 확인
                    if (value == maps[i][k]) {
                        // 거리 계산
                        distance = k - j;

                        // 범위에서 벗어날 경우 정사각형을 만들 수 없는 것으로 간주
                        if (i+distance >= N || j+distance >= M) {
                            break;
                        }

                        // 정사각형이 되기 위한 각 위치에 있는 값이 모두 동일한지 확인 
                        if (
                            maps[i][j] == maps[i][k]
                            && maps[i][k] == maps[i+distance][j]
                            && maps[i+distance][j] == maps[i+distance][k]
                        )
                        {
                            // 정사각형의 크기 계산 및 최대값 확인
                            result = (int)Math.pow(distance + 1, 2);
                            if (max < result) {
                                max = result;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }
}
```
---
## 스택 수열 (1874번)
https://www.acmicpc.net/problem/1874

### 풀이방법
- 예제를 직접 그리면서 확인해보면 쉽게 구현 가능
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int input = 0;
        int curValue = 0;
        StringBuilder sb = new StringBuilder();

        while(n-- > 0) {
            input = Integer.parseInt(br.readLine());

            if (input > curValue) {
                while(input > curValue) {
                    stack.push(++curValue);
                    sb.append("+\n");
                }
            }
            else {
                if (stack.peek() != input) {
                    System.out.println("NO");
                    return;
                }
            }

            stack.pop();
            sb.append("-\n");
        }

        System.out.println(sb);
    }
}
```
---
## 에디터 (1406번)
https://www.acmicpc.net/problem/1406

### 풀이방법
- 문자열을 관리할 Stack과 커서 이동으로 인한 임시 Stack을 선언
- `L` : 왼쪽으로 한 칸 (문자열 Stack에서 pop 후 임시저장 Stack에 push, 비어있으면 수행 X)
- `D` : 오른쪽으로 한 칸 (임시저장 Stack에서 pop 후 문자열 Stack에 push, 비어있으면 수행 X)
- `B` : 문자열 스택 pop (비어있으면 수행 X)
- `P` : 문자열 스택에 데이터 push (커서의 왼쪽에 추가한다고 하였으므로)
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> strStack = new Stack<>();
        Stack<Character> tmpStoreStack = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            strStack.push(str.charAt(i));
        }

        int cmdCount = Integer.parseInt(br.readLine());
        String cmd;
        while(cmdCount-- > 0) {
            cmd = br.readLine();

            switch(cmd.charAt(0)) {
                case 'L':
                    if (strStack.isEmpty()) {
                        break;
                    }

                    tmpStoreStack.push(strStack.pop());
                    break;

                case 'D':
                    if (tmpStoreStack.isEmpty()) {
                        break;
                    }

                    strStack.push(tmpStoreStack.pop());
                    break;

                case 'B':
                    if (strStack.isEmpty()) {
                        break;
                    }

                    strStack.pop();
                    break;

                case 'P':
                    strStack.push(cmd.charAt(2));
                    break;
            }
        }

        while(!tmpStoreStack.isEmpty()) {
            strStack.push(tmpStoreStack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!strStack.isEmpty()) {
            sb.append(strStack.pop());
        }
        sb = sb.reverse();
        sb.append('\n');
        System.out.println(sb);
    }
}
```
---
## 쇠막대기 (10799번)
https://www.acmicpc.net/submit/10799/35506958

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] array = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();

        char chr = ' ';
        int sum = 0;
        for(int i=0; i<array.length; i++) {
            chr = array[i];

            if (chr == '(') {
                stack.push(i);
            }
            else {
                // 레이저 일 때 (현재 인덱스와 이전 인덱스의 차이가 1일 때)
                if (i - 1 == stack.peek()) {
                    stack.pop();
                    sum += stack.size();
                }
                // 쇠막대기의 끝점 일 때 (현재 인덱스와 이전 인덱스의 차이가 1보다 클 때)
                // 끝점은 겹치지 않느다고 하였으므로 무조건 1개가 나옴
                else {
                    stack.pop();
                    sum += 1;
                }
            }
        }

        System.out.println(sum);
    }
}
```
---
## 후위 표기식2 (1935번)
https://www.acmicpc.net/problem/1935

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String notation = br.readLine();
    List<String> listNotation = new ArrayList<>();

    for(int i=0; i<notation.length(); i++) {
      listNotation.add(String.valueOf(notation.charAt(i)));
    }

    double[] operand = new double[N];
    for(int i=0; i<N; i++) {
      operand[i] = Double.parseDouble(br.readLine());
    }

    convAlphabetToNumber(operand, listNotation);

    char chr = ' ';
    Stack<Double> stack = new Stack<>();
    double op1 = 0;
    double op2 = 0;
    for(int i=0; i<listNotation.size(); i++) {
      chr = listNotation.get(i).charAt(0);
      if (Character.isDigit(chr)) {
        stack.push(Double.parseDouble(listNotation.get(i)));
      }
      else {
        op2 = stack.pop();
        op1 = stack.pop();
        stack.push(calculate(op1, op2, chr));
      }
    }

    System.out.println(String.format("%.2f", stack.pop()));
  }

  private static void convAlphabetToNumber(double[] operand, List<String> listNotation) {
    char chr = ' ';
    for(int i=0; i<operand.length; i++) {
      for(int j=0; j<listNotation.size(); j++) {
        chr = listNotation.get(j).charAt(0);
        if (chr >= 'A' && chr <= 'Z') {
          if (chr == 'A' + i) {
            listNotation.set(j, String.valueOf(operand[i]));
          }
        }
      }
    }
  }

  private static double calculate(double op1, double op2, char operator) {
    switch (operator) {
      case '+':
        return op1 + op2;
      case '-':
        return op1 - op2;
      case '*':
        return op1 * op2;
      default:
        return op1 / op2;
    }
  }
}
```
---
## GCD 합 (9613번)
https://www.acmicpc.net/problem/9613

### 풀이방법
- 조합을 이용해 풀이
`nCr = n-1Cr-1 + n-1Cr`

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스 개수
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // 수의 개수
        int n = 0;
        // 배열 인덱스
        int index = 0;
        // 조합에서 사용할 배열 (쌍이므로 2개로 설정)
        int[] result = new int[2];
        // 전달받은 숫자들
        int[] arr = null;
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            while(st.hasMoreTokens()) {
                arr[index++] = Integer.parseInt(st.nextToken());
            }

            combination(arr, result, n, 2, 0, 0);
            sb.append(sum).append('\n');
            sum = 0;
            index = 0;
        }

        System.out.println(sb);
    }

    public static void combination(int[] arr, int[] result, int n, int r, int combIndex, int depth) {
        if (r == 0) {
            sum += gcd(result[0], result[1]);
            return;
        }
        else if (depth == n) {
            return;
        }

        result[combIndex] = arr[depth];
        combination(arr, result, n, r - 1, combIndex + 1, depth + 1);
        combination(arr, result, n, r, combIndex, depth + 1);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        else {
            return gcd(b, a%b);
        }
    }
}
```
---
## 1로 만들기 (1463번)
## 재풀이 예정
https://www.acmicpc.net/problem/1463

### 사전지식
- 동적 계획법 (다이나믹 프로그래밍, DP)

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
            System.out.println(0);
            return;
        }

        // 구현하기 편하도록 +1
        int[] arr = new int[N + 1];
        // %3, %2, -1 중 어떤 것을 먼저 했을 때 최소값이 되는지 모름
        // %3, %2는 제약사항 (2의 배수, 3의 배수)이 있어 -1을 먼저 진행한 후
        // %3, %2로 했을 때와 비교
        for(int i=2; i<=N; i++) {
            arr[i] = arr[i-1] + 1;

            if (i % 2 == 0 && arr[i] > arr[i / 2] + 1) {
                arr[i] = arr[i / 2] + 1;
            }

            if (i % 3 == 0 && arr[i] > arr[i / 3] + 1) {
                arr[i] = arr[i / 3] + 1;
            }
        }

        System.out.println(arr[N]);
    }
}
```