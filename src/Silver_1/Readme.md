# 백준 문제풀이 (Silver 1)

---
## 물병 (1052번)
### 재풀이 예정
- 성능 최적화 필요

https://www.acmicpc.net/problem/1052

### 풀이방법
```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int oneCountFromBinary = 0;
        int tmp = N;
        do {
            oneCountFromBinary = getOneCountFromBinary(N++);
            if (oneCountFromBinary <= K) {
                break;
            }
        }while(oneCountFromBinary > K);

        System.out.println(N - tmp - 1);
    }
    
    // 1의 개수가 현재 물이있는 통의 개수가 됨
    // 13 -> 1101 -> 3개의 물통
    // 따라서 2진수로 변환할 때 1의 총 개수를 구함
    private static int getOneCountFromBinary(int num) {
        int oneCount = 0;
        while(num != 0) {
            if (num % 2 == 1) {
                oneCount++;
            }
            num /= 2;
        }

        return oneCount;
    }
}
```
---
## 골드바흐의 추측 (6588번)
https://www.acmicpc.net/problem/6588

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    // 10^18 이하에서는 추측이 참이 됨 (위키참조)
    // n은 100만까지 이므로 10^18 이하여서 소수의 합으로 나타낼 수 없는 경우는 없음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        boolean[] checkedPrime = null;

        StringBuilder sb = new StringBuilder();
        checkedPrime = erathosthenes(1000000);
        while(true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            for(int i=3; i<n; i++) {
                if (!checkedPrime[i]) {
                    // n = 소수 + 소수
                    // 두 소수 중 하나가 소수면 다른 하나도 소수여야 함
                    // 가장 처음 해가 발견된 것이 정답이 됨
                    if (!checkedPrime[n - i]) {
                        sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append('\n');
                        break;
                    }
                }
            }
        }

        System.out.println(sb);
    }

    public static boolean[] erathosthenes(int maxNum) {
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
## 카드 구매하기 (11052번)
https://www.acmicpc.net/problem/11052

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] P = new int[N + 1];
        int[] dp = new int[N + 1];
        for(int i=1; i<=N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 중복이 허용되니까 1
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=i; j++) {
                // 새로운 누적값과 이전 누적값 비교
                /* N = 4,
                    1) 1   1   1   1
                    2) 1   1   2
                    3) 1   3
                    4) 4
                    비교해야 함
                 */
                dp[i] = Math.max(dp[i], dp[i-j] + P[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
```
---
## 카드 구매하기 2 (16194번)
https://www.acmicpc.net/problem/16194

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] P = new int[N + 1];
        int[] dp = new int[N + 1];
        for(int i=1; i<=N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        // 중복이 허용되니까 1
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j] + P[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
```
---
## 쉬운 계단 수 (10844번)


### 풀이방법
- 점화식 : `dp[N] = d[N-1][L-1] + d[N-1][L+1]`<br>
N : 길이<br>
L : 마지막 수<br>
L - 1 : 1, 2, 3일 때<br>
L + 1 : 3, 2, 1일 때<br>
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int MOD_VALUE = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][10];
        // 길이가 1일 때
        for(int i=1; i<=9; i++) {
            dp[1][i] = 1;
        }

        for(int i=2; i<=N; i++) {
            for(int j=0; j<=9; j++) {
                dp[i][j] = 0;
                if (j-1 >= 0) {
                    dp[i][j] += dp[i-1][j-1];
                }
                if (j+1 <= 9) {
                    dp[i][j] += dp[i-1][j+1];
                }
                dp[i][j] %= MOD_VALUE;
            }
        }

        long result = 0;
        for(int i=0; i<=9; i++) {
            result += dp[N][i];
        }

        System.out.println(result%MOD_VALUE);
    }
}
```
---