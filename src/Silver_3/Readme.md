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
---
## 2 X n 타일링 (11726번)
https://www.acmicpc.net/problem/11726

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n < 3) {
            System.out.println(n);
            return;
        }
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 10007;
        }

        System.out.println(dp[n]);
    }
}
```
---
## 2 X n 타일링 2 (11727번)
https://www.acmicpc.net/problem/11727

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n<=3) {
            if (n == 1) {
                System.out.println(1);
            }
            else if (n == 2) {
                System.out.println(3);
            }
            else {
                System.out.println(5);
            }

            return;
        }

        int[] dp = new int[n+1];
        dp[1] = 1; dp[2] = 3; dp[3] = 5;
        for(int i=4; i<=n; i++) {
            dp[i] = dp[i-1] + 2 * dp[i-2];
            dp[i] %= 10007;
        }

        System.out.println(dp[n]);
    }
}
```
---
## 1, 2, 3 더하기 (9095번)
https://www.acmicpc.net/problem/9095

### 풀이방법 (DP)
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n = 0;
        int[] dp = new int[11 + 1];
        
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for(int i=4; i<dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }
        
        System.out.println(sb);
    }
}
```

### 풀이방법 (브루트 포스)
- `1, 2, 3`을 계속 순회하면서 더한 값들이 `n`값이 되는지 확인하고 `n`보다 클 경우 `0`을 반환하여 
카운트를 세지 않고 `n` 값이 되는 경우 카운트를 세기 위해 1을 반환한다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {1, 2, 3};
        int T = Integer.parseInt(br.readLine());
        int n = 0;
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            sb.append(solve(arr, n, 0)).append('\n');
        }

        System.out.println(sb);
    }

    private static int solve(int[] arr, int n, int sum) {
        if (sum > n) {
            return 0;
        }
        else if (sum == n) {
            return 1;
        }

        int curSumData = 0;
        for(int i=0; i<arr.length; i++) {
            curSumData += solve(arr, n, sum+arr[i]);
        }
        return curSumData;
    }
}
```

---
## 이친수 (2193번)
https://www.acmicpc.net/problem/2193

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
            System.out.println(1);
            return;
        }
        
        // 점화식
        // 1. dp[N][0] = DP[N-1][0] + DP[N-1][1]
        //    끝자리가 0일 때 앞자리엔 0과 1이 올 수 있으므로
        //
        // 2. dp[N][1] = DP[N-1][0]
        //    끝자리가 1일 때 앞자리엔 0만 올 수 있으므로

        // 구현의 편의를 위해 +1
        // N+1 : 길이
        // 2   : N 위치에 가능한 숫자 개수
        long[][] dp = new long[N+1][2];
        // 첫번째 자리에는 0이 올 수 없음
        dp[1][0] = 0;
        dp[1][1] = 1;
        // N이 2일 경우 10만 가능
        dp[2][1] = 0;
        dp[2][0] = 1;

        for(int i=3; i<=N; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[N][0] + dp[N][1]);
    }
}
```
---
## 제곱수의 합 (1699번)
https://www.acmicpc.net/problem/1699

### 사전지식
- 다이나믹 프로그래밍

### 풀이방법
- 점화식<br>
끝자리가 1^2, 2^2, 3^2, 4^2, ... 일 때<br>
(N - 1^2) + 1^2 = N<br>
(N - 2^2) + 2^2 = N<br>
(N - 3^2) + 3^2 = N<br>
...<br>
  - 정의 : DP[i] = DP[i-j^2] + 1<br>
i=1, j^2=1^2 => DP[1] = DP[0] + 1 (1)<br>
i=2, j^2=1^2 => DP[2] = DP[1] + 1 (2)<br>
i=3, j^2=1^2 => DP[3] = DP[2] + 1 (3)<br>
i=4, j^2=1^2 => DP[4] = DP[3] + 1 (4) X<br>
i=4, j^2=2^2 => DP[4] = DP[0] + 1 (1)<br>
...

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 점화식
        // 끝자리가 1^2, 2^2, 3^2, 4^2, ... 일 때
        // (N - 1^2) + 1^2 = N
        // (N - 2^2) + 2^2 = N
        // (N - 3^2) + 3^2 = N
        // ...
        //
        // 1. DP[i] = DP[i-j^2] + 1
        // i=1, j^2=1^2 => DP[1] = DP[0] + 1 (1)
        // i=2, j^2=1^2 => DP[2] = DP[1] + 1 (2)
        // i=3, j^2=1^2 => DP[3] = DP[2] + 1 (3)
        // i=4, j^2=1^2 => DP[4] = DP[3] + 1 (4) X
        // i=4, j^2=2^2 => DP[4] = DP[0] + 1 (1)
        // ...

        int[] dp = new int[N+1];
        // 1+1+1+1+... 이 최소라고 가정하기 위해
        for(int i=1; i<=N; i++) {
            dp[i] = i;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }

        System.out.println(dp[N]);
    }
}
```
---
## 사탕 게임 (3085번)
https://www.acmicpc.net/problem/3085

### 풀이방법
- 다른 인접한 두 칸을 고를 때 `오른쪽`과 `아래쪽`을 선택하면 모두 탐색이 가능함
  - 단, N에서 벗어나는지 판단 필요
- 사탕을 오른쪽과 교환한 경우 영향을 받는 행 또는 열은 총 3개이다.
  - 행 : 1개, 열 : 2개
- 사탕을 아래쪽과 교환한 경우 영향을 받는 행 또는 열은 총 3개이다.
  - 행 : 2개, 열 : 1개
- 각각의 행 또는 열에서 동일한 문자의 최대 길이를 판단하고, 최대값을 구한다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = "";
        char[][] candy = new char[N][N];

        for(int i=0; i<N; i++) {
            str = br.readLine();
            for(int j=0; j<N; j++) {
                candy[i][j] = str.charAt(j);
            }
        }

        System.out.println(maxSameCount(candy));
    }

    private static int maxSameCount(char[][] candy) {
        int N = candy.length;
        int count = 0;
        int max = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                // 가로
                if (j+1 < N) {
                    swap(candy, j, i, j+1, i);
                    count = verticalSameCount(candy, j);
                    max = Math.max(count, max);
                    count = verticalSameCount(candy, j+1);
                    max = Math.max(count, max);
                    count = horizontalSameCount(candy, i);
                    max = Math.max(count, max);
                    swap(candy, j, i, j+1, i);
                }

                // 세로
                if (i+1 < N) {
                    swap(candy, j, i, j, i+1);
                    count = horizontalSameCount(candy, i);
                    max = Math.max(count, max);
                    count = horizontalSameCount(candy, i+1);
                    max = Math.max(count, max);
                    count = verticalSameCount(candy, j);
                    max = Math.max(count, max);
                    swap(candy, j, i, j, i+1);
                }
            }
        }

        return max;
    }

    private static void swap(char[][] candy, int x1, int y1, int x2, int y2) {
        char tmp = candy[y1][x1];
        candy[y1][x1] = candy[y2][x2];
        candy[y2][x2] = tmp;
    }

    private static int verticalSameCount(char[][] candy, int x) {
        char ch = candy[0][x];
        int count = 1;
        int N = candy.length;
        int max = 0;
        for(int i=1; i<N; i++) {
            if (ch == candy[i][x]) {
                count++;
            }
            else {
                ch = candy[i][x];
                count = 1;
            }
            max = Math.max(max, count);
        }

        return max;
    }

    private static int horizontalSameCount(char[][] candy, int y) {
        char ch = candy[y][0];
        int count = 1;
        int N = candy.length;
        int max = 0;
        for(int i=1; i<N; i++) {
            if (ch == candy[y][i]) {
                count++;
            }
            else {
                ch = candy[y][i];
                count = 1;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
```
---
## 수 이어쓰기 1 (1748번)
https://www.acmicpc.net/problem/1748

### 풀이방법
- 123까지의 모든 수를 이어쓴다고 할 때, 먼저 1~99까지의 모든 수를 구한다.
- 123은 세자리 수 이므로 100부터 시작하기 때문에 123-100=23이 된다.
- 따라서 1~9까지의 자리수, 10~99까지의 자리수, 100~123까지의 자리수를 구해 모두 더해야 한다.
- 1~9는 자리수가 각각 1자리이며, 10~99는 자리수가 2자리, 100~123은 자리수가 3자리 이므로 합계를 구할 때 자리수를 곱해주어야 한다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int numberN = Integer.parseInt(N);

        long start = 0;
        long end = 0;
        long sum = 0;
        for(int i=0; i<N.length(); i++) {
            start = (long)Math.pow(10, i);
            end = (long)Math.pow(10, i+1)-1;

            if (end > numberN) {
                sum += ((numberN - start + 1) * (i+1));
            }
            else {
                sum += ((end - start + 1) * (i+1));
            }
        }

        System.out.println(sum);
    }
}
```
---
## N과 M (1) (15649번)
https://www.acmicpc.net/problem/15649

### 풀이방법
- `solve` 함수의 전달인자는 다음과 같다.
  1) 첫번째 : 데이터가 들어있는 배열
  2) 두번째 : 이미 데이터를 사용했는지 확인하는 배열 (중복이 발생하면 안되므로)
  3) 세번째 : 몇 개를 고를 것인지에 대한 변수
  4) 네번째 : 현재 뽑은 개수 및 데이터 저장 위치
- 현재 뽑은 개수와 몇 개를 고를 것인지의 개수가 동일할 경우 결과값을 저장한다.
- 그렇지 않으면 데이터 배열 중 방문하지 않은 데이터를 저장한다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] result = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        result = new int[M];
        for(int i=0; i<N; i++) {
            arr[i] = i+1;
        }
        solve(arr, visited, M, 0);

        System.out.println(sb);
    }

    private static void solve(int[] arr, boolean[] visited, int r, int c) {
        if (c == r) {
            for(int i=0; i<result.length; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        else {
            for(int i=0; i<arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    result[c] = arr[i];
                    solve(arr, visited, r, c+1);
                    visited[i] = false;
                }
            }
        }
    }
}
```
---
## N과 M (2) (15650번)
https://www.acmicpc.net/problem/15650

### 풀이방법
- `solve` 함수의 전달인자는 다음과 같다.
  1) 첫번째 : 데이터가 들어있는 배열
  2) 두번째 : 이미 데이터를 사용했는지 확인하는 배열 (중복이 발생하면 안되므로)
  3) 세번째 : 현재 데이터 배열에 접근한 인덱스가 몇인지 전달하여 그 이후의 데이터들로만 고르도록 하기 위한 변수
  4) 네번째 : 몇 개를 고를 것인지에 대한 변수
  5) 다섯번째 : 현재 뽑은 개수 및 데이터 저장 위치
- 현재 뽑은 개수와 몇 개를 고를 것인지의 개수가 동일할 경우 결과값을 저장한다.
- 그렇지 않으면 데이터 배열 중 방문하지 않은 데이터를 저장한다.


```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] result = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        result = new int[M];
        for(int i=0; i<N; i++) {
            arr[i] = i+1;
        }

        solve(arr, visited, 0, M, 0);
        System.out.println(sb);
    }

    private static void solve(int[] arr, boolean[] visited, int curIndex, int r, int c) {
        if (c == r) {
            for(int i : result) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        else {
            for(int i=curIndex; i<arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    result[c] = arr[i];
                    solve(arr, visited, i+1, r, c+1);
                    visited[i] = false;
                }
            }
        }
    }
}
```
---
## N과 M (3) (15651번)
https://www.acmicpc.net/problem/15651

### 풀이방법
- `solve` 함수의 전달인자는 다음과 같다.
  1) 첫번째 : 데이터가 들어있는 배열
  2) 두번째 : 몇 개를 고를 것인지에 대한 변수
  3) 세번째 : 현재 뽑은 개수 및 데이터 저장 위치
- 현재 뽑은 개수와 몇 개를 고를 것인지의 개수가 동일할 경우 결과값을 저장한다.
- 같은 수를 여러번 고를 수 있으므로 방문했는지 확인할 필요가 없다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] result = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        result = new int[M];

        for(int i=0; i<N; i++) {
            arr[i] = i+1;
        }

        solve(arr, M, 0);
        System.out.println(sb);
    }

    private static void solve(int[] arr, int r, int c) {
        if (c == r) {
            for(int i : result) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        else {
            for(int i=0; i<arr.length; i++) {
                result[c] = arr[i];
                solve(arr, r, c+1);
            }
        }
    }
}
```
---
## N과 M (4) (15652번)
https://www.acmicpc.net/problem/15652

### 풀이방법
- `solve` 함수의 전달인자는 다음과 같다.
  1) 첫번째 : 데이터가 들어있는 배열
  2) 두번째 : 현재 인덱스를 저장해 조합의 시작 위치를 지정하기 위한 변수
  3) 세번째 : 몇 개를 고를 것인지에 대한 변수
  4) 네번째 : 현재 뽑은 개수 및 데이터 저장 위치
- 현재 뽑은 개수와 몇 개를 고를 것인지의 개수가 동일할 경우 결과값을 저장한다.
- 같은 수를 여러번 고를 수 있으므로 방문했는지 확인할 필요가 없다.
- 예제 3번을 보면 2로 시작할 때 2보다 작은 값은 표현하지 않아야 하므로 현재 인덱스는 반복문의 변수여야 한다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] result = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        result = new int[M];
        for(int i=0; i<N; i++) {
            arr[i] = i+1;
        }

        solve(arr, 0, M,0);
        System.out.println(sb);
    }

    private static void solve(int[] arr, int curIndex, int r, int c) {
        if (c == r) {
            for(int i : result) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        else {
            for(int i=curIndex; i<arr.length; i++) {
                result[c] = arr[i];
                solve(arr, i, r, c+1);
            }
        }
    }
}
```
---
## N과 M (5) (15654번)
https://www.acmicpc.net/problem/15654

### 풀이방법
- `N과 M (1)` 문제와 비슷하지만 데이터가 주어진다는 점이 다르다.
- `solve` 함수의 전달인자는 다음과 같다.
  1) 첫번째 : 데이터가 들어있는 배열
  2) 두번째 : 이미 데이터를 사용했는지 확인하는 배열 (중복이 발생하면 안되므로)
  3) 세번째 : 몇 개를 고를 것인지에 대한 변수
  4) 네번째 : 현재 뽑은 개수 및 데이터 저장 위치
- 현재 뽑은 개수와 몇 개를 고를 것인지의 개수가 동일할 경우 결과값을 저장한다.
- 그렇지 않으면 데이터 배열 중 방문하지 않은 데이터를 저장한다.
- 단순히 정렬 후 `N과 M (1)` 문제와 동일하게 풀면 되는데, 나는 `힙 정렬`을 이용했으나 내장함수인 `Arrays.sort`와 별 차이가 없었다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] result = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        result = new int[M];

        int index = 0;
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }

        int[] sortResult = sort(arr);
        solve(sortResult, visited, M, 0);

        System.out.println(sb);
    }

    private static void solve(int[] arr, boolean[] visited, int r, int c) {
        if (c == r) {
            for(int i : result) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        else {
            for(int i=0; i<arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    result[c] = arr[i];
                    solve(arr, visited, r, c+1);
                    visited[i] = false;
                }
            }
        }
    }

    private static int[] sort(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++) {
            pq.add(arr[i]);
        }

        int[] result = new int[arr.length];
        int index = 0;
        while (!pq.isEmpty()) {
            result[index++] = pq.remove();
        }

        return result;
    }
}
```
---
## N과 M (6) (15655번)
https://www.acmicpc.net/problem/15655

### 풀이방법
- `N과 M (2)`와 비슷한 문제이나 데이터가 주어진다는 것이 다르다.
- `solve` 함수의 전달인자는 다음과 같다.
  1) 첫번째 : 데이터가 들어있는 배열
  3) 두번째 : 현재 데이터 배열에 접근한 인덱스가 몇인지 전달하여 그 이후의 데이터들로만 고르도록 하기 위한 변수
  4) 세번째 : 몇 개를 고를 것인지에 대한 변수
  5) 네번째 : 현재 뽑은 개수 및 데이터 저장 위치
- 현재 뽑은 개수와 몇 개를 고를 것인지의 개수가 동일할 경우 결과값을 저장한다.
- 그렇지 않으면 데이터 배열 중 다음 값을 저장한다.
- `예제 2`번을 보면 동일한 값이 허용되지 않으며 현재 선택된 값의 이전 값은 정답에서 제외되기 때문이다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] result = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        result = new int[M];

        int index = 0;
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        solve(arr, 0, M, 0);

        System.out.println(sb);
    }

    private static void solve(int[] arr, int curIndex, int r, int c) {
        if (c == r) {
            for(int i : result) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        else {
            for(int i=curIndex; i<arr.length; i++) {
                result[c] = arr[i];
                solve(arr, i+1, r, c+1);
            }
        }
    }
}
```
---
## N과 M (7) (15656번)
https://www.acmicpc.net/problem/15656

### 풀이방법
- `N과 M (3)`과 비슷하지만 데이터를 입력받는게 추가되었다.
- `solve` 함수의 전달인자는 다음과 같다.
  1) 첫번째 : 데이터가 들어있는 배열
  2) 두번째 : 몇 개를 고를 것인지에 대한 변수
  3) 세번째 : 현재 뽑은 개수 및 데이터 저장 위치
- 현재 뽑은 개수와 몇 개를 고를 것인지의 개수가 동일할 경우 결과값을 저장한다.
- 같은 수를 여러번 고를 수 있으므로 방문했는지 확인할 필요가 없다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] result = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        result = new int[M];

        int index = 0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        solve(arr, M, 0);

        System.out.println(sb);
    }

    private static void solve(int[] arr, int r, int c) {
        if (c == r) {
            for(int i : result) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        else {
            for(int i=0; i<arr.length; i++) {
                result[c] = arr[i];
                solve(arr, r, c+1);
            }
        }
    }
}
```
---
## N과 M (8) (15657번)
https://www.acmicpc.net/problem/15657

### 풀이방법
- `N과 M (4)`와 비슷하지만 데이터를 입력받는 부분이 추가되었다.
- `solve` 함수의 전달인자는 다음과 같다.
  1) 첫번째 : 데이터가 들어있는 배열
  2) 두번째 : 현재 인덱스를 저장해 조합의 시작 위치를 지정하기 위한 변수
  3) 세번째 : 몇 개를 고를 것인지에 대한 변수
  4) 네번째 : 현재 뽑은 개수 및 데이터 저장 위치
- 현재 뽑은 개수와 몇 개를 고를 것인지의 개수가 동일할 경우 결과값을 저장한다.
- 같은 수를 여러번 고를 수 있으므로 방문했는지 확인할 필요가 없다.
- 예제 2번을 보면 8로 시작할 때 8보다 작은 값은 표현하지 않아야 하므로 현재 인덱스는 반복문의 변수여야 한다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] result = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        solve(arr, 0, M, 0);

        System.out.println(sb);
    }

    private static void solve(int[] arr, int curIndex, int r, int c) {
        if (c == r) {
            for(int i : result) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        else {
            for(int i=curIndex; i<arr.length; i++) {
                result[c] = arr[i];
                solve(arr, i, r, c+1);
            }
        }
    }
}
```
---
## 다음 순열 (10972번)
https://www.acmicpc.net/problem/10972

### 풀이방법
- 주어진 입력 순열의 다음 순열을 구하는 문제이다.
- 모든 순열을 구하면서 입력받은 순열의 다음 순열을 구하게 되면 시간이 오래 걸리게 된다.
  - 최악의 경우: 역순으로 입력받은 경우
- 위와 같은 방법으로는 시간이 오래 걸리기 때문에 다른 방법을 찾아봐야 한다.
- `[1, 2, 3, 4, 5]`로 이루어진 순열을 생각해보면 `1XXXX`, `2XXXX`, `3XXXX`, `4XXXX`, `5XXXX` 순으로 순열이 이루어져야 한다.
  - `1XXXX`는 다시 `12XXX`, `13XXX`, `14XXX`, `15XXX` 로 이루어지고
  - `2XXXX`는 다시 `21XXX`, `23XXX`, `24XXX`, `15XXX` 로 이루어진다.
  - 위 `X`들은 오름차순이 되어야 한다. 
- 위의 내용을 토대로 `[3, 2, 5, 4, 1]`이 주어졌을 때 이 순열의 다음 순열은 `[3, 4, 1, 2, 5]`가 되어야 한다.
  - 그 이유는 `32XXX`를 생각했을 때 `XXX`가 모두 내림차순이므로 위 `[3, 2, 5, 4, 1]`은 `32XXX`로 시작하는 모든 수열에서 마지막이기 때문이다.
  - `32XXX`의 다음 순열은 `34XXX`가 되어야 하고, `34XXX`로 시작하는 순열 중 제일 첫번째인 `[3, 2, 5, 4, 1]`의 다음 순열은 `[3, 4, 1, 2, 5]`가 된다.
- 위 예시를 잘 보면 결국 `[3, 2, 5, 4, 1]`에서 처음으로 `32XXX`보다 큰 값이 나올 수 있는 값은 `34XXX` 이므로 `2`와 `4`를 서로 교환하면 `[3, 4, 5, 2, 1]`이 되고
`34XXX`로 시작하면서 제일 작은 수는 `[3, 4, 5, 2, 1]`에서 `5, 2, 1`을 역순으로 한 것이므로 뒤집어주면 된다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    int index = 0;

    while (st.hasMoreTokens()) {
      arr[index++] = Integer.parseInt(st.nextToken());
    }

    StringBuilder sb = new StringBuilder();
    if (next_permutation(arr)) {
      for(int i : arr) {
        sb.append(i).append(' ');
      }
      System.out.println(sb);
    }
    else {
      System.out.println(-1);
      return;
    }
  }

  private static boolean next_permutation(int[] arr) {
    int i = arr.length-1;
    // 뒤에서부터 탐색했을 때 처음으로 오름차순이 아닌 부분 검색
    // [3, 2, 5, 4, 1]에서 32XXX 부분이 됨
    while (i>0 && arr[i-1] > arr[i]) {
      i--;
    }
    
    // 순열의 마지막부터 첫번째까지 갔을 경우 모두 오름차순이므로 false 반환
    // 첫번째부터 순열의 마지막까지는 내림차순이 되므로
    if (i <= 0) {
      return false;
    }

    // 처음으로 오름차순이 아닌 부분보다 큰 값이 있을 경우 서로 교환
    // [3, 2, 5, 4, 1]에서 4가 2보다 크므로
    int j = arr.length-1;
    while (arr[j] < arr[i-1]) {
      j--;
    }
    swap(arr, i-1, j);
    
    // 오름차순이 아닌 부분 이후의 값들을 모두 역으로 교환
    reverse(arr, i);

    return true;
  }

  private static void swap(int[] arr, int idx1, int idx2) {
    int a1 = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = a1;
  }

  private static void reverse(int[] arr, int startIndex) {
    int endIndex = arr.length-1;

    while (startIndex <= endIndex) {
      swap(arr, startIndex++, endIndex--);
    }
  }
}
```
---
## 이전 순열 (10973번)
https://www.acmicpc.net/problem/10973

### 풀이방법
[다음 순열 (10973)](https://github.com/banjjak2/BOJ/tree/master/src/Silver_3#다음-순열-10972번) 과 비슷한 문제로, 
반복문의 부등호 방향만 바꿔주면 된다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int index = 0;
        
        while (st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }
        
        StringBuilder sb = new StringBuilder();
        if (nextPermutation(arr)) {
            for(int i : arr) {
                sb.append(i).append(' ');
            }
            System.out.println(sb);
        }
        else {
            System.out.println(-1);
        }
    }
    
    private static boolean nextPermutation(int[] arr) {
        int i = arr.length-1;
        while (i > 0 && arr[i-1] < arr[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }
        
        int j = arr.length-1;
        while (arr[i-1] < arr[j]) {
            j--;
        }
        swap(arr, i-1, j);
        
        reverse(arr, i);
        
        return true;
    }
    
    private static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
    
    private static void reverse(int[] arr, int startIndex) {
        int endIndex = arr.length-1;
        
        while (startIndex <= endIndex) {
            swap(arr, startIndex++, endIndex--);
        }
    }
}
```
---
## 모든 순열 (10974번)
https://www.acmicpc.net/source/36738364

### 풀이방법
- 1부터 N까지의 수로 이루어진 모든 순열을 사전순으로 출력하는 문제이다.
- 방문하지 않은 데이터를 이용해 순열을 만들어야 하므로 `visited` 배열을 추가해 구현하였다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] result = null;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        result = new int[N];
        boolean[] visited = new boolean[N];
        
        for(int i=0; i<N; i++) {
            arr[i] = i+1;
        }
        
        solve(arr, visited, N, 0);
        
        System.out.println(sb);
    }
    
    private static void solve(int[] arr, boolean[] visited, int r, int c) {
        if (c == r) {
            for(int i : result) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        else {
            for(int i=0; i<arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    result[c] = arr[i];
                    solve(arr, visited, r, c+1);
                    visited[i] = false;
                }
            }
        }
    }
}
```
---
## 1 (4375번)
https://www.acmicpc.net/problem/4375

### 이전풀이
- `BigInteger`를 이용해 풀었으나 성능이 좋지 않았다.
- [이전풀이](https://www.acmicpc.net/source/36865277)

### 문제설명
- 1로만 이루어진 n의 배수를 찾는다는 것은 1로만 이루어진 숫자 `예)111`를 `n`으로 나눴을 때 나누어 떨어지는가? 를 묻는 것이다.
- 예제 출력의 3은 `111`이 되고 6은 `111111`, ... 이 된다는 뜻이 된다.

### 풀이방법
- `Modular` 연산을 이용해 풀 수 있는 문제이다.
  1) `(A+B)%C는 ((A%C) + (B%C))%C와 같다`
  2) `(A×B)%C는 ((A%C) × (B%C))%C와 같다`
- 위 두가지 조건을 이용해 문제를 풀 수 있다.
- 첫 번째 조건을 보면 `(A+B)%C는 ((A%C) + (B%C))%C와 같다`고 하였으므로 결과는 아래와 같다. 
```text
1) A = 1%X
2) B = 11%X
3) C = 111%X
4) D = 1111%X
에서 
A는 (0+1)%X = 1
B는 (10+1)%X = (((A*10)%X) + (1%X))%X
C는 (110+1)%X = (((B*10)%X) + (1%X))%X
D는 (1110+1)%X = (((C*10)%X) + (1%X))%X
...
이 된다.
```
- 위의 설명에 따라 `1`, `11`, `111`, `1111`, ...을 순차적으로 구해주면 답이 나오게 된다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        StringBuilder sb = new StringBuilder();

        int n = 0;
        int remainder = 1;
        int count = 1;
        while ((str = br.readLine()) != null) {
            n = Integer.parseInt(str);
            if (n == 1) {
                System.out.println(1);
                continue;
            }
            
            count = 1;
            remainder = 1;

            while (remainder != 0) {
                remainder = (10 * remainder + 1) % n;
                count++;
            }

            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }
}
```
---

## 스타트와 링크 (14889번)
https://www.acmicpc.net/problem/14889

### 문제풀이
- 팀을 절반으로 나눈다고 하였으므로 선택된 인원과 선택되지 않은 인원을 각각 스타트팀과 링크팀으로 나누었다.
- 모든 조합을 이용하여 문제를 풀었다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        int[][] spec = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                spec[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[] check = new boolean[N];
        solve(spec, check, 0, N, 0, N/2);
        System.out.println(min);
    }

    private static void solve(int[][] spec, boolean[] check, int curIndex, int n, int c, int r) {
        if (c == r) {
            int startSpec = 0;
            int linkSpec = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if (check[i] && check[j]) startSpec += spec[i][j];
                    if (!check[i] && !check[j]) linkSpec += spec[i][j];
                }
            }

            min = Math.min(min, Math.abs(startSpec - linkSpec));
        }
        else {
            for(int i=curIndex; i<n; i++) {
                check[i] = true;
                solve(spec, check, i + 1, n, c + 1, r);
                check[i] = false;
            }
        }
    }
}
```
---
