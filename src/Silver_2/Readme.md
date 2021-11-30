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
