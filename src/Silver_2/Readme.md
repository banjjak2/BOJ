# 백준 문제풀이 (Silver 2)

---
## 소수 구하기 (1929번)
https://www.acmicpc.net/problem/1929

### 사전지식
- 에라토스테네스의 체
- 소수의 배수를 지우고 지워지지 않은 수들은 모두 소수가 됨

### 풀이방법
- erathosthenes에서 i*2를 한 이유는 M, N의 값이 백만이기 때문
  - 백만 * 백만 = int 범위를 벗어남
- 배수를 지우면 되는 것이기 때문에 *2해도 무방

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] checkedPrime = erathosthenes(N);

        StringBuilder sb = new StringBuilder();
        for(int i=M; i<=N; i++) {
            if (!checkedPrime[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }

    public static boolean[] erathosthenes(int maxNum) {
        // 지워졌다면 true
        boolean[] checkedPrime = new boolean[maxNum + 1];
        checkedPrime[0] = true;
        checkedPrime[1] = true;

        for(int i=2; i<=maxNum; i++) {
            if (!checkedPrime[i]) {
                for(int j=i*2; j<=maxNum; j+=i) {
                    checkedPrime[j] = true;
                }
            }
        }

        return checkedPrime;
    }
}
```
---
## 조합 0의 개수 (2004번)
https://www.acmicpc.net/problem/2004

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        
        long two = 0;
        long five = 0;
        // nCm = n!/(m! * (n-m)!)
        
        // n의 2, 5의 개수
        for(long i=2; i<=n; i*=2) {
            two += (n/i);
        }
        for(long i=5; i<=n; i*=5) {
            five += (n/i);
        }
        
        // m의 2, 5의 개수
        for(long i=2; i<=n; i*=2) {
            two -= (m/i);
        }
        for(long i=5; i<=n; i*=5) {
            five -= (m/i);
        }
        
        // m-n의 2, 5의 개수
        for(long i=2; i<=(n-m); i*=2) {
            two -= ((n-m)/i);
        }
        for(long i=5; i<=(n-m); i*=5) {
            five -= ((n-m)/i);
        }
        
        System.out.println(Math.min(two, five));
    }
}
```
---
## 골드바흐 파티션 (17103번)
https://www.acmicpc.net/problem/17103

### 사전지식
- 에라토스테네스의 체

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = 0;

        boolean[] checkedPrime = eratosthenes(1000000);
        int sumOfGoldbachCount = 0;
        int restPrime = 0;
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());

            for(int i=2; i<checkedPrime.length; i++) {
                if (!checkedPrime[i]) {
                    restPrime = N - i;
                    // i를 제외한 또다른 소수 restPrime이 i보다 크면 역으로 돌게 되므로 break
                    // 10의 경우
                    // i 3, restPrime 7
                    // i 5, restPrime 5
                    // i 7, restPrime 3 => 이런 경우는 "두 소수의 순서만 다른 것은 같은 파티션이다." 조건에 맞지 않으므로 종료
                    if (restPrime < i) {
                        break;
                    }
                    else if (!checkedPrime[restPrime]) {
                        sumOfGoldbachCount++;
                    }
                }
            }

            sb.append(sumOfGoldbachCount).append('\n');
            sumOfGoldbachCount = 0;
        }

        System.out.println(sb);
    }

    public static boolean[] eratosthenes(int maxNum) {
        // true는 소수가 아닌 것들
        boolean[] checkedPrime = new boolean[maxNum + 1];
        checkedPrime[0] = true; // 0
        checkedPrime[1] = true; // 1 은 소수가 아님

        for(int i=2; i<=maxNum; i++) {
            if (!checkedPrime[i]) {
                for(int j=i*2; j<=maxNum; j+=i) {
                    checkedPrime[j] = true;
                }
            }
        }

        return checkedPrime;
    }
}
```
---
## 1, 2, 3 더하기 5 (15990번)
https://www.acmicpc.net/problem/15990

### 풀이방법
- n이 3, 4, 5, 6, 7, ...일 때의 수식을 써보면
n번째에 어떤 수식들이 있는지 유추 가능함

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int MOD_VALUE = 1_000_000_009;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int n = 0;
        long[][] dp = new long[100000 + 1][4];
        // n이 1일 때 수식의 끝자리가 1, 2, 3의 개수
        dp[1][1] = 1; dp[1][2] = 0; dp[1][3] = 0;
        // n이 2일 때 수식의 끝자리가 1, 2, 3의 개수
        dp[2][1] = 0; dp[2][2] = 1; dp[2][3] = 0;
        // n이 3일 때 수식의 끝자리가 1, 2, 3의 개수
        dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;
        for(int i=4; i<=100_000; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3])%MOD_VALUE;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3])%MOD_VALUE;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2])%MOD_VALUE;
        }

        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            n = Integer.parseInt(br.readLine());
            sb.append((dp[n][1] + dp[n][2] + dp[n][3])%MOD_VALUE).append('\n');
        }

        System.out.println(sb);
    }
}
```
---
## 가장 긴 증가하는 부분 수열 (11053번)
https://www.acmicpc.net/problem/11053

### 사전지식
- 다이나믹 프로그래밍

### 시행착오
1. 수열은 특정 규칙에 따라 수가 나열된 것을 의미하는 줄 알았으나, [위키](https://ko.wikipedia.org/wiki/%EC%88%98%EC%97%B4) 에 따르면 규칙이 없이 수들이 나열된 것도 수열이라고 한다.
2. 처음 문제를 접했을 때 단순히 현재값이 이전값보다 클 경우 길이를 하나씩 증가시켜주면 될 줄 알았다.<br>
  위 방법대로 풀었을 경우 `10 30 20 25` 의 경우에 `10 30`으로 2가 나오게 된다. 그러나 정답은 `10 20 25`로 3이 되어야 한다.


### 풀이방법
- 현재값(i)이 제시된 수열중에서 가장 큰 값이라고 가정하고 문제를 푼다.
- 현재값 위치보다 작은 곳에 위치한 값(j)들을 비교해서 현재값보다 작다면 부분 수열이 가능하다는 것이 된다.
- 위와 같은 방법을 반복하면 `numbers[i]`가 가장 큰 부분 수열의 길이를 알 수 있다. <br>
10 | 20 | 10 | 30 | 20 | 50<br>
1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4<br>
10이 가장 큰 부분 수열의 길이는 1 (10)<br>
20이 가장 큰 부분 수열의 길이는 2 (10, 20)<br>
10이 가장 큰 부분 수열의 길이는 1 (10)<br>
30이 가장 큰 부분 수열의 길이는 3 (10, 20, 30) - 20은 (10, 20)을 포함하므로<br>
20이 가장 큰 부분 수열의 길이는 2 (10, 20)<br>
50이 가장 큰 부분 수열의 길이는 4 (10, 20, 30, 50)

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

        int[] numbers = new int[N];
        int[] dp = new int[N];
        int index = 0;
        while(st.hasMoreTokens()) {
            numbers[index] = Integer.parseInt(st.nextToken());
            dp[index] = 1;
            index++;
        }

        int max = 1;
        for(int i=0; i<N; i++) {
            for(int j=0; j<i; j++) {
                if (numbers[j] < numbers[i]) {
                    max = Math.max(dp[i] + dp[j], max);
                }
            }
            dp[i] = max;
            max = 1;
        }

        int result = 0;
        for(int i=0; i<N; i++) {
            if (dp[i] > result) {
                result = dp[i];
            }
        }

        System.out.println(result);
    }
}
```
---
## 연속합 (1912번)
https://www.acmicpc.net/problem/1912

### 풀이방법
- 점화식 정의
  1. 선택된 숫자가 마지막으로 선택된 숫자인 경우<br>
  `dp[i] = dp[i-1] + arr[i]`
  2. 새롭게 연속합이 시작될 경우<br>
  `dp[i] = arr[i]`

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 점화식
        // 1. 선택된 숫자가 마지막으로 선택된 숫자인 경우
        //    dp[i] = dp[i-1] + arr[i]
        // 2. 새롭게 연속합이 시작될 경우
        //    dp[i] = A[i]
        // 최대합을 구해야 하므로 1, 2를 비교해서 큰 값을 저장

        int[] dp = new int[n+1];
        int[] numbers = new int[n+1];
        int index = 1;
        while (st.hasMoreTokens()) {
            numbers[index++] = Integer.parseInt(st.nextToken());
        }

        int max = (-1) * Integer.MAX_VALUE;
        for(int i=1; i<=n; i++) {
            dp[i] = Math.max(dp[i-1] + numbers[i], numbers[i]);
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
```
---
## 1, 2, 3 더하기 3 (15988번)
https://www.acmicpc.net/problem/15988

### 사전지식
- 다이나믹 프로그래밍

### 풀이방법
```text
n = 1,
 => 1
 
n = 2,
 => 1 + 1
    2

n = 3,
 => 1 + 1 + 1
    2 + 1
    1 + 2
    3
    
n = 4,
 => 1 + 1 + 1 + 1
    3 + 1
    1 + 2 + 1
    2 + 1 + 1
    1 + 1 + 2
    2 + 2
    1 + 3
...
```
`n`이 `4`일 때의 `1 + 1 + 1 + 1` 은 `n`이 `3`일 때의 `1 + 1 + 1`을 포함하고 있음<br>
`n`이 `4`일 때의 `3 + 1`은 `n`이 `3`일 때의 `3`을 포함하고 있음<br>
`n`이 `4`일 때의 `1 + 2 + 1`은 `n`이 `3`일 때의 `1 + 2`를 포함하고 있음<br>
`n`이 `4`일 때의 `2 + 1 + 1`은 `n`이 `3`일 때의 `2 + 1`을 포함하고 있음<br>
`n`이 `4`일 때의 `1 + 1 + 2`은 `n`이 `2`일 때의 `1 + 1`을 포함하고 있음<br>
`n`이 `4`일 때의 `2 + 2`은 `n`이 `2`일 때의 `2`를 포함하고 있음<br>
`n`이 `4`일 때의 `1 + 3`은 `n`이 `1`일 때의 `1`를 포함하고 있음<br>

즉, <br>
`n`이 `4`일 때 수식의 끝 자리가 `1`이면 n이 `3`일 때 나오는 수식을 모두 포함<br>
`n`이 `4`일 때 수식의 끝 자리가 `2`이면 n이 `2`일 때 나오는 수식을 모두 포함<br>
`n`이 `4`일 때 수식의 끝 자리가 `3`이면 n이 `1`일 때 나오는 수식을 모두 포함<br>

위 공식에 따라 1, 2, 3을 제외한 n의 값이 4, 5, 6, 7, ... 일 때를 검증해보면 답을 구할 수 있음
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int MAX_VALUE = 1_000_000;
    private static final int MOD_VALUE = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[MAX_VALUE + 1];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;

        for(int i=4; i<=MAX_VALUE; i++) {
            dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % MOD_VALUE;
        }

        int n = 0;
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }

        System.out.println(sb);
    }
}
```
---
## 가장 큰 증가 부분 수열 (11055번)
https://www.acmicpc.net/board/view/67313

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N+1];
    int[] dp = new int[N+1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=1; i<=N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      dp[i] = arr[i];
    }

    int max = arr[1];
    for(int i=2; i<=N; i++) {
      for(int j=1; j<i; j++) {
        if (arr[i] > arr[j]) {
          if (dp[i] < dp[j] + arr[i]) {
            dp[i] = dp[j] + arr[i];
            max = Math.max(dp[i], max);
          }
        }
      }
    }

    System.out.println(max);
  }
}
```
---
## 가장 긴 감소하는 부분 수 (11722번)
https://www.acmicpc.net/problem/11722

### 풀이방법
- 점화식
  ```text
  dp[i] = arr[i]로 끝나면서 가장 긴 감소하는 부분 수열
  arr[1] ~ arr[i-1]까지 비교하면서 감소하는 구간을 찾음
  인덱스      :  1  2  3  4  5  6
  수열 arr   : 10 30 10 20 20 10
  감소횟수(dp) : 1  1  2  2  2  3
  
  arr[i]가 30(인덱스 2)일 때 arr[1] ~ arr[i-1]중 감소하는 구간은 없음
  arr[i]가 10(인덱스 3)일 때 arr[1] ~ arr[i-1]중 감소하는 구간은 (30, 10)
  arr[i]가 20(인덱스 4)일 때 arr[1] ~ arr[i-1]중 감소하는 구간은 (30, 20)
  arr[i]가 10(인덱스 6)일 때 arr[1] ~ arr[i-1]중 감소하는 구간은 (30, 20, 10)
  
  따라서, arr[i]는 arr[1] ~ arr[i-1]까지 몇 번 감소했는지 알아내야 함
  ```

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
        
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        
        int max = 1;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=i; j++) {
                // 감소하는 구간을 찾아야 하므로
                if (arr[i] < arr[j]) {
                    // dp[j] + 1이 dp[i]보다 크면 앞쪽에서 최대값을 아직 뽑지 않았다는 것이 됨
                    // 예를들어, arr[i]가 예제 수열의 맨 마지막(10) 일 때 앞쪽 감소횟수를 하나씩 더해보면서 최대값을 찾음
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        max = Math.max(dp[i], max);
                    }
                }
            }
        }
        
        System.out.println(max);
    }
}
```
---
## N과 M (9) (15663번)
https://www.acmicpc.net/problem/15663

### 풀이방법
- 중복된 숫자가 주어질 수 있지만 중복된 순열은 출력하면 안된다는 조건이 있으므로 `LinkedHashSet`을 이용하였다.
- 일반적인 `HashSet`은 순서가 보장되지 않으나 `LinkedHashSet`은 입력된 순서에 따라 순서가 보장된다.
- 먼저 입력받은 숫자들을 정렬한 후 `solve` 함수에 전달해주었다.
- `solve` 함수의 전달인자는 다음과 같다.
  1) 첫번째 : 데이터가 들어있는 배열
  2) 두번째 : 나 자신을 제외해야 하므로 방문했는지 확인하는 변수
  3) 세번째 : 몇 개를 고를 것인지에 대한 변수
  4) 네번째 : 현재 뽑은 개수 및 데이터 저장 위치

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.LinkedHashSet;
import java.util.Arrays;
import java.util.Set;

public class Main {
    private static Set<String> set = new LinkedHashSet<>();
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
        st = new StringTokenizer(br.readLine());
        int index = 0;
        while (st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        solve(arr, visited, M, 0);

        sb.delete(0, sb.length());
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            sb.append(iter.next()).append('\n');
        }

        System.out.println(sb);
    }

    private static void solve(int[] arr, boolean[] visited, int r, int c) {
        if (c == r) {
            for(int i : result) {
                sb.append(i).append(' ');
            }
            set.add(sb.toString());
            sb.delete(0, sb.length());
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
## N과 M (10) (15664번)
https://www.acmicpc.net/problem/15664

### 풀이방법
- 중복된 숫자가 주어질 수 있지만 중복된 순열은 출력하면 안된다는 조건이 있으므로 `LinkedHashSet`을 이용하였다.
- 일반적인 `HashSet`은 순서가 보장되지 않으나 `LinkedHashSet`은 입력된 순서에 따라 순서가 보장된다.
- 먼저 입력받은 숫자들을 정렬한 후 `solve` 함수에 전달해주었다.
- `solve` 함수의 전달인자는 다음과 같다.
  1) 첫번째 : 데이터가 들어있는 배열
  2) 두번째 : 현재 데이터 배열에 접근한 인덱스가 몇인지 전달하여 그 이후의 데이터들로만 고르도록 하기 위한 변수
  3) 세번째 : 몇 개를 고를 것인지에 대한 변수
  4) 네번째 : 현재 뽑은 개수 및 데이터 저장 위치

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] result = null;
    private static LinkedHashSet<String> ls = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        int index = 0;
        while (st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        solve(arr, 0, M, 0);

        Iterator<String> iter = ls.iterator();
        while (iter.hasNext()) {
            sb.append(iter.next()).append('\n');
        }

        System.out.println(sb);
    }

    private static void solve(int[] arr, int curIndex, int r, int c) {
        if (r == c) {
            for(int i : result) {
                sb.append(i).append(' ');
            }
            ls.add(sb.toString());
            sb.delete(0, sb.length());
        }
        else {
            for (int i=curIndex; i<arr.length; i++) {
                result[c] = arr[i];
                solve(arr, i+1, r, c+1);
            }
        }
    }
}
```
---
## N과 M (11) (15665번)
https://www.acmicpc.net/problem/15665

### 풀이방법
- 중복되는 숫자가 주어질 수 있지만 중복되는 수열은 한 번 출력되어야 한다.
- 주어진 수에서 중복된 수를 제거하고 테스트해보면 출력과 동일한 결과가 나오는 것을 확인할 수 있다.
  - `예제 2번`을 `1 7 9` 세 수를 이용해 출력해보면 알 수 있음
- `TreeSet`을 이용하여 입력된 수들의 중복을 제거하고 다시 배열에 넣어준다.
- 중복이 제거된 수를 이용해 문제를 해결한다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] result = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        TreeSet<Integer> ts = new TreeSet<>();
        while (st.hasMoreTokens()) {
            ts.add(Integer.parseInt(st.nextToken()));
        }

        int index = 0;
        int[] arr = new int[ts.size()];
        Iterator<Integer> iter = ts.iterator();
        while (iter.hasNext()) {
            arr[index++] = iter.next();
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
## N과 M (12) (15666번)
https://www.acmicpc.net/problem/15666

### 풀이방법
- 중복되는 숫자가 주어질 수 있지만 중복되는 수열은 한 번 출력되어야 한다.
- 주어진 수에서 중복된 수를 제거하고 테스트해보면 출력과 동일한 결과가 나오는 것을 확인할 수 있다.
  - `예제 2번`을 `1 7 9` 세 수를 이용해 출력해보면 알 수 있음 
  - 단, 비내림차순이어야 하므로 선택한 값보다 작은 값은 선택할 수 없음 (`curIndex`변수를 이용해 선택)
- `TreeSet`을 이용하여 입력된 수들의 중복을 제거하고 다시 배열에 넣어준다.
- 중복이 제거된 수를 이용해 문제를 해결한다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Iterator;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int[] result = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        result = new int[M];
        TreeSet<Integer> ts = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            ts.add(Integer.parseInt(st.nextToken()));
        }

        int index = 0;
        int[] arr = new int[ts.size()];
        Iterator<Integer> iter = ts.iterator();
        while (iter.hasNext()) {
            arr[index++] = iter.next();
        }

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
## 차이를 최대로 (10819번)
https://www.acmicpc.net/problem/10819

### 풀이방법
- 입력받은 배열을 이용해 모든 순열을 구함과 동시에 최대값을 구해주면 된다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int max = 0;
    private static int[] result = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        result = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve(arr, visited, N, 0);

        System.out.println(max);
    }

    private static void solve(int[] arr, boolean[] visited, int r, int c) {
        if (c == r) {
            int sum = 0;
            for(int i=0; i<arr.length-1; i++) {
                sum += Math.abs(result[i] - result[i+1]);
            }
            max = Math.max(max, sum);
            return;
        }
        else {
            for (int i=0; i<arr.length; i++) {
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
## 외판원 순회 2 (10971번)
https://www.acmicpc.net/problem/6603

### 이전풀이
- 처음에는 모든 순열을 구해서 `ArrayList`에 저장하고 그 순열을 이용해 최소값을 구하도록 구혔했었다. 
그러다보니 속도에서 700ms 이상의 퍼포먼스가 나왔고 아래와 같은 방법으로 수정한 결과 300ms대 퍼포먼스가 나왔다. 
  그러나 다른 사람들의 풀이를 보면 `DP`를 이용한 풀이가 속도면에서 우월했다.
- `DP` 또는 코드를 개선해 개선할 필요가 있다.

### 풀이방법
- 순열을 구할 때마다 최소값을 계산하는 방식으로 구현하였다.
- 원래의 도시로 다시 돌아와야 하므로 `1, 2, 3, 4`로 순회할 경우 `1, 2, 3, 4, 1`로 수정한 후 계산했다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] result = null;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        result = new int[N+1];
        StringTokenizer st = null;

        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        for(int i=0; i<N; i++) {
            arr[i] = i+1;
        }

        int[][] W = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(arr, W, visited, N, 0);

        System.out.println(min);
    }

    private static void calculate(int[][] W, int[] tmp) {
        boolean canMove = true;
        int sum = 0;

        for(int j=0; j<tmp.length-1; j++) {
            if (W[tmp[j]][tmp[j+1]] == 0) {
                canMove = false;
            }

            sum += W[tmp[j]][tmp[j+1]];
        }

        if (canMove) {
            min = Math.min(min, sum);
        }
    }

    private static void solve(int[] arr, int[][] W, boolean[] visited, int r, int c) {
        if (c == r) {
            result[arr.length] = result[0];
            calculate(W, result);
        }
        else {
            for(int i=0; i<arr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    result[c] = arr[i];
                    solve(arr, W, visited, r, c+1);
                    visited[i] = false;
                }
            }
        }
    }
}
```
---
## 로또 (6603번)
https://www.acmicpc.net/problem/6603

### 풀이방법
- 주어지는 로또 번호들은 `오름차순`으로 주어지며 사전 순으로 출력해야 하므로 주어진 번호 중 6개를 이용해 조합하면 된다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] result = new int[6];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = 0;

        while(true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            if (N == 0) {
                break;
            }

            int[] arr = new int[N];
            for(int i=0; i<arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            solve(arr, 0, 0);
            sb.append('\n');
        }


        System.out.println(sb);
    }

    private static void solve(int[] arr, int curIndex, int c) {
        if (c == 6) {
            for(int i : result) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        else {
            for(int i=curIndex; i<arr.length; i++) {
                result[c] = arr[i];
                solve(arr, i+1, c+1);
            }
        }
    }
}
```
---
## 약수의 합 2 (17427번)
https://www.acmicpc.net/problem/17427

### 시행착오
- **첫번째 시도** : 처음 문제를 봤을 때 시간 제한이 0.5초인걸 보고 하나씩 약수를 구한 후 더하면 시간초과가 발생할 것 같았다.
  - 대략 1억번 반복할 때 1초라고 얘기를 들은적이 있는데 `1,000,000 * 1,000,000`이면 `1조`라는 큰 값이 나온다.
  - 시간복잡도 : O(N^2)
- **두번째 시도** : 소인수분해를 통해서도 약수의 합을 구할 수 있어서 구현했지만 `10,000`을 넣어도 시간이 오래걸렸다.
  - 아마 소인수분해를 할 때 계속해서 나누기 때문에 오래걸린 것으로 판단했다. 
  - 시간복잡도 : O(N^2)
- **마지막 시도** : 우선 1~10까지의 약수를 모두 구해보고 어떤 규칙이 있지 않을까 생각했다. 왜냐하면 분명 시간내에 풀기 위해서는 O(N)의 시간복잡도는 가져야한다고 판단했기 때문이다.
  - 그래서 규칙을 찾아본 결과 `N`을 `1~N`까지 나눈 값이 `1~N` 까지의 약수들을 모두 포함하고 있었다.
  ```text
  1~10까지의 약수들 중
  1의 개수 : 10개
  2의 개수 : 5개
  3의 개수 : 3개
  4의 개수 : 2개
  5의 개수 : 2개
  6의 개수 : 1개
  7의 개수 : 1개
  8의 개수 : 1개
  9의 개수 : 1개
  10의 개수 : 1개
  를 가지게 됨을 알 수 있었다.
  ```

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;

        for(int i=1; i<=N; i++) {
            answer += i * (N/i);
        }

        System.out.println(answer);
    }
}
```
---

## 부등호 (2529번)
https://www.acmicpc.net/problem/2529

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] result = null;
    private static long max = 0;
    private static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] op = new char[K];
        for(int i=0; i<K; i++) {
            op[i] = st.nextToken().charAt(0);
        }

        result = new int[K+1];
        boolean[] visited = new boolean[10];
        solve(op, result, visited, K+1, 0);

        StringBuilder sb = new StringBuilder();
        if (len(max) != K+1) {
            sb.append(0).append(max);
            System.out.println(sb);
        }
        else {
            System.out.println(max);
        }

        if (len(min) != K+1) {
            sb.append(0).append(min);
            System.out.println(sb);
        }
        else {
            System.out.println(min);
        }
    }

    private static int len(long value) {
        int count = 0;
        while (value != 0) {
            value /= 10;
            count++;
        }

        return count;
    }

    private static int count = 0;
    private static void solve(char[] op, int[] result, boolean[] visited, int r, int c) {
        if (c == r) {
            long answer = 0;
            for(int i=0; i<result.length; i++) {
                answer *= 10;
                answer += result[i];
            }

            min = Math.min(min, answer);
            max = Math.max(max, answer);
        }
        else {
            for(int i=0; i<=9; i++) {
                if (!visited[i]) {
                    count = c;
                    result[c] = i;

                    if (count >= 1) {
                        if (op[c-1] == '<') {
                            if (result[c-1] > result[c]) {
                                continue;
                            }
                        }
                        else if (op[c-1] == '>') {
                            if (result[c-1] < result[c]) {
                                continue;
                            }
                        }
                    }

                    visited[i] = true;
                    solve(op, result, visited, r, c+1);
                    visited[i] = false;
                    count = c;
                }
            }
        }
    }
}
```
---

## 유기농 배추 (1012번)
https://www.acmicpc.net/problem/1012

### 풀이방법
- 전형적인 `BFS`문제로, 배추가 있으면서 방문하지 않은 곳인지 확인한다.
- 해당 위치부터 상,하,좌,우 위치에 있는 값을 확인해 방문했다는 표시를 남긴다.
- 이렇게 되면 이미 방문한 곳은 제외하므로 `BFS`가 끝나면 벌레의 개수를 1증가시킨다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int bugCount = 0;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                map[Y][X] = 1;
            }

            for(int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(j, i, M, N);
                        bugCount++;
                    }
                }
            }
            sb.append(bugCount).append('\n');
            bugCount = 0;
        }

        System.out.println(sb);
    }

    public static void bfs(int x, int y, int m, int n) {
        queue.add(new int[] { x, y });
        visited[y][x] = true;
        int[] cur;
        int[] xPos = {1, 0, -1, 0};
        int[] yPos = {0, 1, 0, -1};
        int dx = 0; int dy = 0;
        while (!queue.isEmpty()) {
            cur = queue.poll();

            for (int i=0; i<4; i++) {
                dx = cur[0] + xPos[i];
                dy = cur[1] + yPos[i];

                if (dx < 0 || dx >= m || dy < 0 || dy >= n) continue;
                if (visited[dy][dx] || map[dy][dx] != 1) continue;
                visited[dy][dx] = true;
                queue.add(new int[] { dx, dy });
            }
        }
    }
}
```
---

## 나이트의 이동 (7562번)
https://www.acmicpc.net/problem/7562

### 풀이방법
- 전형적인 BFS 문제이다.
- X, Y가 움직일 수 있는 모든 경우의 수 8가지를 이용해 문제를 해결한다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int I = 0;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            I = Integer.parseInt(br.readLine());

            int[] curPos = new int[2];
            st = new StringTokenizer(br.readLine());
            curPos[0] = Integer.parseInt(st.nextToken());
            curPos[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] targetPos = new int[2];
            targetPos[0] = Integer.parseInt(st.nextToken());
            targetPos[1] = Integer.parseInt(st.nextToken());

            int[][] dist = new int[I+1][I+1];
            initDist(dist);

            if (curPos[0] == targetPos[0] && curPos[1] == targetPos[1]) {
                sb.append(0).append('\n');
            } else {
                bfs(dist, curPos, targetPos, I);
                sb.append(dist[targetPos[1]][targetPos[0]]).append('\n');
            }
        }

        System.out.println(sb);
    }

    private static void initDist(int[][] dist) {
        for(int i=0; i<dist.length; i++) {
            for (int j=0; j<dist.length; j++) {
                dist[i][j] = -1;
            }
        }
    }

    private static void bfs(int[][] dist, int[] curPos, int[] targetPos, int I) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(curPos);
        dist[curPos[1]][curPos[0]] = 0;

        int[] cur;
        int[] xPos = {-1, -1, 1, 1, -2, -2, 2, 2};
        int[] yPos = {2, -2, 2, -2, 1, -1, 1, -1};
        int dx = 0; int dy = 0;
        while (!queue.isEmpty()) {
            cur = queue.poll();

            for(int i=0; i<8; i++) {
                dx = cur[0] + xPos[i];
                dy = cur[1] + yPos[i];

                if (dx < 0 || dx >= I || dy < 0 || dy >= I) continue;
                if (dist[dy][dx] != -1) continue;
                dist[dy][dx] = dist[cur[1]][cur[0]] + 1;

                if (dx == targetPos[0] && dy == targetPos[1]) return;
                queue.add(new int[] { dx, dy });
            }
        }
    }
}
```
---

## 종이의 개수 (1780번)
https://www.acmicpc.net/problem/1780

### 풀이방법
- 재귀문제
- 전달받은 n의 크기만큼 반복해서 전체가 같은 숫자인지 판별한다.
  - 같은 숫자가 아니라면 9개씩 자른다고 했으므로 검사할 n의 개수는 n/3씩 줄어든다.
    - 최악의 경우 n이 1이 될때까지 반복한다.
    ```text
    0 1 0
    0 0 1
    1 0 0
    ```
    - 위의 경우 하나의 종이에 동일한 숫자가 없으므로 한칸씩 종이를 자르게 되고, 그렇게 되면 종이에 채워진 수가 1개이므로 해당하는 값을 더해준다.

- 행렬에서 다음 검사할 x, y를 결정한다.
  - 9개로 자르고 3^n이므로 아래와 같이 결정할 수 있다.
  ```text
  x = x + (n/3) * (0, 1, 2)
  y = y + (n/3) * (0, 1, 2)
  0, 1, 2는 내 위치, 다음위치, 다다음위치를 가리킴
  ```

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N = 0;
    static int[][] matrix = null;
    static int countOfPositive = 0;
    static int countOfNegative = 0;
    static int countOfZero = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        StringTokenizer st = null;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, 0, N);

        StringBuilder sb = new StringBuilder();
        sb.append(countOfNegative).append('\n');
        sb.append(countOfZero).append('\n');
        sb.append(countOfPositive).append('\n');
        System.out.println(sb);
    }

    private static void recursive(int x, int y, int n) {
        if (checkMatrix(x, y, n)) {
            if (matrix[y][x] == 1) countOfPositive++;
            else if (matrix[y][x] == 0) countOfZero++;
            else if (matrix[y][x] == -1) countOfNegative++;
            return;
        }

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                recursive(x + (n/3) * j, y + (n/3) * i, n/3);
            }
        }
    }

    private static boolean checkMatrix(int x, int y, int n) {
        int tmpData = matrix[y][x];
        for(int i=y; i<n + y; i++) {
            for (int j=x; j<n + x; j++) {
                if (tmpData != matrix[i][j]) return false;
            }
        }

        return true;
    }
}
```
---
