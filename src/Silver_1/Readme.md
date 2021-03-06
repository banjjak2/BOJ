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
## RGB거리 (1149번)
https://www.acmicpc.net/problem/1149

### 풀이방법
- 점화식
1. DP[i][c] = i번째 집을 c로 칠할 때 1 ~ i번째 집 까지의 최소 비용<br>
<br>
2. `DP[i][빨] = DP[i-1][녹] + Arr[빨]`<br>
   -> i번째 집을 빨간색으로 칠할 때 i-1번째 집이 녹색일 경우의 수 중 최소값<br>
   `DP[i][빨] = DP[i-1][파] + Arr[빨]`<br>
   -> i번째 집을 빨간색으로 칠할 때 i-1번째 집이 파란색일 경우의 수 중 최소값<br>
   <br>
3. `DP[i][녹] = DP[i-1][빨] + Arr[녹]`
   -> i번째 집을 녹색으로 칠할 때 i-1번째 집이 빨간색일 경우의 수 중 최소값<br>
   `DP[i][녹] = DP[i-1][파] + Arr[녹]`
   -> i번째 집을 녹색으로 칠할 때 i-1번째 집이 파란색일 경우의 수 중 최소값<br>
    <br>
4. `DP[i][파] = DP[i-1][빨] + Arr[파]`<br>
   -> i번째 집을 파란색으로 칠할 때 i-1번째 집이 빨간색일 경우의 수 중 최소값<br>
   `DP[i][파] = DP[i-1][녹] + Arr[파]`<br>
   -> i번째 집을 파란색으로 칠할 때 i-1번째 집이 녹색일 경우의 수 중 최소값<br>
   
```text
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][3+1];
        int[][] arr = new int[N+1][3+1];
        StringTokenizer st = null;

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 점화식
        // 1. DP[i][c] = i번째 집을 c로 칠할 때 1 ~ i번째 집 까지의 최소 비용

        // 2. DP[i][빨] = DP[i-1][녹] + Arr[빨]
        //    -> i번째 집을 빨간색으로 칠할 때 i-1번째 집이 녹색일 경우의 수 중 최소값
        // 2-1. DP[i][빨] = DP[i-1][파] + Arr[빨]
        //    -> i번째 집을 빨간색으로 칠할 때 i-1번째 집이 파란색일 경우의 수 중 최소값

        // 3. DP[i][녹] = DP[i-1][빨] + Arr[녹]
        //    -> i번째 집을 녹색으로 칠할 때 i-1번째 집이 빨간색일 경우의 수 중 최소값
        // 3-1. DP[i][녹] = DP[i-1][파] + Arr[녹]
        //    -> i번째 집을 녹색으로 칠할 때 i-1번째 집이 파란색일 경우의 수 중 최소값

        // 4. DP[i][파] = DP[i-1][빨] + Arr[파]
        //    -> i번째 집을 파란색으로 칠할 때 i-1번째 집이 빨간색일 경우의 수 중 최소값
        // 4-1. DP[i][파] = DP[i-1][녹] + Arr[파]
        //    -> i번째 집을 파란색으로 칠할 때 i-1번째 집이 녹색일 경우의 수 중 최소값

        for(int i=1; i<=N; i++) {
            dp[i][1] = Math.min(dp[i-1][2], dp[i-1][3]) + arr[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][3]) + arr[i][2];
            dp[i][3] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][3];
        }

        System.out.println(Math.min(Math.min(dp[N][1], dp[N][2]), dp[N][3]));
    }
}
```
---
## 동물원 (1309번)
https://www.acmicpc.net/problem/1309

### 풀이방법
- 점화식
   - n-1번째 줄에 사자가 있을 경우와 없을 경우를 구분
     - 사자가 없을 경우 : `DP[N-1][0]`
     - 사자가 왼쪽에 있을 경우 : `DP[N-1][1]`
     - 사자가 오른쪽에 있을 경우 : `DP[N-1][2]`
   - 그림을 그려 점화식 도출
   - N번째 줄에 사자가 없을 경우의 수
      - N-1번째 줄에는 사자가 없거나 왼쪽 또는 오른쪽에 있어야 함
      - `DP[N][0] = DP[N-1][0] + DP[N-1][1] + DP[N-1][2]`
   - N번째 줄에 사자가 왼쪽에 있을 경우의 수
      - N-1번째 줄에는 사자가 없거나 오른쪽에 있어야 함
      - `DP[N][1] = DP[N-1][0] + DP[N-1][2]`
   - N번째 줄에 사자가 오른쪽에 있을 경우의 수
      - N-1번째 줄에는 사자가 없거나 왼쪽에 있어야 함
      - `DP[N][2] = DP[N-1][0] + DP[n-1][1]`

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int MOD_VALUE = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // dp[1][0] => 1번째 줄에 배치하지 않을 경우
        // dp[1][1] => 1번째 줄의 왼쪽에 배치할 경우
        // dp[1][2] => 1번째 줄의 오른쪽에 배치할 경우
        int[][] dp = new int[N+1][3];
        // 1번째 줄
        dp[1][0] = 1; // "사자를 한 마리도 배치하지 않는 경우도 하나의 경우의 수" 조건
        dp[1][1] = 1; // 왼쪽에 배치할 경우
        dp[1][2] = 1; // 오른쪽에 배치할 경우

        for(int i=2; i<=N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD_VALUE;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD_VALUE;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD_VALUE;
        }

        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % MOD_VALUE);
    }
}
```
---
## 오르막 수 (11057번)
https://www.acmicpc.net/problem/11057

### 풀이방법
- 길이가 1일 때 끝 자리가 0 ~ 9인 경우는 모두 1개
    - `0 1 2 3 4 5 6 7 8 9`
- 점화식
    - `D[i][j] = i번째 수가 j일 때 오르막 수가 될 수 있는 개수`
- 예를 들어서,
  ```text
  i=2, j=0 인 경우 [2번째 자리 수가 0인 경우]
  D[2][0] = D[1][0], 2번째 자리가 0이면 1번째 자리는 0만 올 수 있음
  
  i=2 j=1 인 경우 [2번째 자리 수가 1인 경우]
  D[2][1] = D[1][0] + D[1][1], 2번째 자리가 1이면 1번째 자리는 0과 1이 올 수 있음
  
  ...
  
  i=2 j=9 인 경우 [2번째 자리 수가 9인 경우]
  D[2][9] = D[1][0] + D[1][1] + D[1][2] + ... + D[1][9]
  
  i=3, j=0 인 경우 [3번째 자리 수가 0인 경우]
  D[3][0] = D[2][0], 3번째 자리가 0이면 2번째 자리가 0일 때의 경우의 수
  
  ...
  ```
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int MOD_VALUE = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10];
        // 길이가 1일 때 끝 자리가 0 ~ 9인 경우는 모두 1
        // 0 1 2 3 4 5 6 7 8 9
        for(int j=0; j<=9; j++) {
            dp[1][j] = 1;
        }

        // 점화식
        // D[i][j] = i번째 수가 j일 때 오르막 수가 될 수 있는 개수
        // D[i][j] = D[i-1][j] + D[i-1][j-1] + D[i-1][j-2] + ... + D[i-1][0]
        // 단, [0 <= j <= 9, 1 <= i <= 1000]
        for(int i=2; i<=N; i++) {
            for(int j=0; j<=9; j++) {
                for(int k=0; k<=j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][k]) % MOD_VALUE;
                }
            }
        }

        // 맨 마지막 숫자가 0~9 중 어떤 것이 나올지 모르므로 N길이에서 0~9까지 모든 경우의 수를 더해줌
        int result = 0;
        for(int i=0; i<=9; i++) {
            result += dp[N][i];
        }

        System.out.println(result % MOD_VALUE);
    }
}
```
---
### 스티커 (9465번)
https://www.acmicpc.net/problem/9465

### 풀이방법
- [동물원 (1309)](https://boj.kr/1309) 과 비슷한 문제
- 점화식
    - `DP[i][0] = max(DP[i-1][0], DP[i-1][1], DP[i-1][2])`
        - i번째 줄에서 아무 스티커도 선택하지 않은 경우 이전 결과값들 중 최대값을 가져옴
    - `DP[i][1] = max(DP[i-1][0], DP[i-1][2]) + arr[i][1]`
        - i번째 줄에서 아래쪽을 선택한 경우 이전 결과값들 중 최대값을 반환한 후 현재 선택한 값을 더해줌
    - `DP[i][2] = max(DP[i-1][0], DP[i-1][1]) + arr[i][2]`
        - i번째 줄에서 위쪽을 선택한 경우 이전 결과값들 중 최대값을 반환한 후 현재 선택한 값을 더해줌
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int n = 0;
        int[][] dp = null;
        int[][] arr = null;
        StringBuilder sb = new StringBuilder();
        int max = 0;

        while(T-- > 0) {
            n = Integer.parseInt(br.readLine());
            dp = new int[n + 1][3];
            arr = new int[n + 1][2];

            for(int i=0; i<2; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=n; j++) {
                    arr[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=1; i<=n; i++) {
                dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][2]) + arr[i][0];
                dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + arr[i][1];
            }

            max = Math.max(Math.max(dp[n][0], dp[n][1]), dp[n][2]);
            sb.append(max).append('\n');
        }

        System.out.println(sb);
    }
}
```
---
## 포도주 시식 (2156번)
https://www.acmicpc.net/problem/2156

### 풀이방법
- 점화식
    ```text
    1. arr[i]를 마시지 않은 경우
       -> dp[i] = dp[i-1]
    2. arr[i-1]을 마시고 arr[i]를 마신 경우
       -> dp[i] = dp[i-3] + arr[i-1] + arr[i]
       arr[i-2]를 마시면 3잔이 연속 되므로 arr[i-2]를 마시기 이전인 dp[i-3]을 취함
    3. arr[i-2]를 마시고 arr[i]를 마신 경우
       -> dp[i] = dp[i-2] + arr[i]
    ```

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int[] arr = new int[n+1];
        
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        if (n == 1) {
            System.out.println(arr[1]);
            return;
        } else if (n == 2) {
            System.out.println(arr[1] + arr[2]);
            return;
        }

        // 점화식
        // 1. arr[i]를 마시지 않은 경우
        //     -> dp[i] = dp[i-1]
        // 2. arr[i-1]을 마시고 arr[i]를 마신 경우
        //     -> dp[i] = dp[i-3] + arr[i-1] + arr[i]
        //     arr[i-2]를 마시면 3잔이 연속 되므로 arr[i-2]를 마시기 이전인 dp[i-3]을 취함
        // 3. arr[i-2]를 마시고 arr[i]를 마신 경우
        //     -> dp[i] = dp[i-2] + arr[i]
        
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        for(int i=3; i<=n; i++) {
            dp[i] = Math.max(Math.max(dp[i-1], dp[i-3]+arr[i-1]+arr[i]), dp[i-2]+arr[i]);
        }
        
        System.out.println(dp[n]);
    }
}
```
---
## 정수 삼각형 (1932번)
https://www.acmicpc.net/problem/1932

### 풀이방법
- 점화식
```text
dp[i][j] = 이제까지 선택된 수의 합이 최대
i : 세로, j : 가로

1. arr[i][j]를 선택하기 위해서는 i-1줄의 j번째와 j-1번째를 선택해야 함
   -> "아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다." 조건
2. dp[i][j]는 dp[i-1][j] 번째를 선택했을 때의 합과 dp[i-1][j-1]번째를 선택했을 때의 합을 비교하고
   그 중 최대값과 arr[i][j]를 더하면 arr[i][j]를 선택하기 까지의 최대값이 나옴
```

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 점화식
        // dp[i][j] = 이제까지 선택된 수의 합이 최대
        // i : 세로, j : 가로
        
        // 1. arr[i][j]를 선택하기 위해서는 i-1줄의 j번째와 j-1번째를 선택해야 함
        //   -> "아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다." 조건
        // 2. dp[i][j]는 dp[i-1][j] 번째를 선택했을 때의 합과 dp[i-1][j-1]번째를 선택했을 때의 합을 비교하고
        //    그 중 최대값과 arr[i][j]를 더하면 arr[i][j]를 선택하기 까지의 최대값이 나옴
        
        int result = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + arr[i][j];
                result = Math.max(dp[i][j], result);
            }
        }
        
        System.out.println(result);
    }
}
```
---
## 타일 채우기 (2133번)
https://www.acmicpc.net/problem/2133

### 풀이방법
![풀이](https://i.imgur.com/JrxpmSq.jpeg)
- 위와 같은 방법을 손으로 풀다보면 알 수 있다.

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

        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[2] = 3;

        for(int i=4; i<=N; i+=2) {
            dp[i] = dp[i-2] * 3;
            for(int j=i-4; j>=0; j-=2) {
                dp[i] += dp[j] * 2;
            }
        }

        System.out.println(dp[N]);
    }
}
```
---
## 카잉 달력 (6064번)
https://www.acmicpc.net/problem/6064

### 주의사항
- X+1 < M 이 아니라 X < M 인 것에 주의
- Y+1 < M 이 아니라 Y < N 인 것에 주의
- `<x:y>`에서 y값을 N값으로 나눴을 때 나머지가 0일 경우 예외 처리

### 풀이방법
- `M`이 `6`이고, `N`이 `4`일 때 숫자 1부터 계산해보면
```text
`1`일 때 `<1:1>`
`2`일 때 `<2:2>`
`3`일 때 `<3:3>`
`4`일 때 `<4:4>`
`5`일 때 `<5:1>`
`6`일 때 `<6:2>`
`7`일 때 `<1:3>`
`8`일 때 `<2:4>`
`9`일 때 `<3:1>`
`10`일 때 `<4:2>`
`11`일 때 `<5:3>`
`12`일 때 `<6:4>` - x, y가 M, N과 같으므로 끝
```
- M, N, x, y를 각각 6, 4, 4, 2로 설정했을 때, `10`이 정답이 됨
- 즉, x값이 4인 경우의 수들을 살펴보면 `4`, `10`일 때 `<4:4>, <4:2>` 이 된다.
- y값은 년도값을 `N`으로 나눴을 때의 나머지 값이 됨을 알 수 있다.
- 즉, `4(년도값)%4(N값) == 0`과 `10(년도값)%4(N값) == 2`이 되므로 
`<4:2>`와 같기 위해서는 `10`번째 해가 된다.
- 단, `<x:y>`에서 y값을 N값으로 나눴을 때 나머지가 0일 경우 예외 처리를 해주어야 한다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int M, N, x, y;
        boolean find = false;
        StringBuilder sb = new StringBuilder();

        // X < M 이면 X' = X + 1
        // Y < M 이면 Y' = Y + 1

        // X+1 < M 이 아니라 X < M 인 것에 주의
        // Y+1 < M 이 아니라 Y < N 인 것에 주의
        // <x:y>에서 y값을 N값으로 나눴을 때 나머지가 0일 경우 예외 처리

        while (T-- > 0) {
            find = false;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            for(int i=x; i<(M*N); i+=M) {
                if (i%N == y) {
                    sb.append(i).append('\n');
                    find = true;
                    break;
                }
                else if (i%N == 0) {
                    if (y == N) {
                        sb.append(i).append('\n');
                        find = true;
                        break;
                    }
                }
            }

            if (!find) {
                sb.append(-1).append('\n');
            }
        }

        System.out.println(sb);
    }
}
```
---

## 그림 (1926번)
https://www.acmicpc.net/problem/1926

### 풀이방법
1. `Queue`를 이용해 방문하지 않았으면서 해당 위치의 값이 1인 좌표를 추가한다.
2. 현재 위치가 방문하지 않았고 1이라면 넓이를 1 증가시킨 후 `Queue`에 넣는다.
3. `poll`로 `Queue`에 있는 값을 가져와 상하좌우 비교한다.

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] paper = new int[y][x];
        boolean[][] visited = new boolean[y][x];

        int[] directX = {1, 0, -1, 0};
        int[] directY = {0, 1, 0, -1};

        for(int i=0; i<y; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<x; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int dx = 0;
        int dy = 0;
        int curX = 0;
        int curY = 0;
        int countOfPicture = 0;
        int maxAreaOfPicture = 0;
        int areaOfPicture = 0;
        for(int i=0; i<y; i++) {
            for(int j=0; j<x; j++) {
                if (visited[i][j] || paper[i][j] == 0) continue;
                queue.add(new int[]{i, j});
                visited[i][j] = true;
                countOfPicture++;

                while (!queue.isEmpty()) {
                    areaOfPicture++;
                    int[] pos = queue.poll();
                    curX = pos[1]; curY = pos[0];

                    for(int k=0; k<4; k++) {
                        dx = curX + directX[k];
                        dy = curY + directY[k];

                        if (dx < 0 || dx >= x || dy < 0 || dy >= y) continue;
                        if (visited[dy][dx] || paper[dy][dx] != 1) continue;

                        queue.add(new int[]{dy, dx});
                        visited[dy][dx] = true;
                    }
                }

                maxAreaOfPicture = Math.max(maxAreaOfPicture, areaOfPicture);
                areaOfPicture = 0;
            }
        }

        System.out.println(countOfPicture);
        System.out.println(maxAreaOfPicture);
    }
}
```
---

## 미로 탐색 (2178번)
https://www.acmicpc.net/problem/2178

### 풀이방법
- BFS(너비우선탐색)를 이용한 문제풀이
- 무조건 (1,1)에서 (N,M)까지라고 하였으므로 어디서부터 시작해야하는지 찾을 필요 없음
- 시작점에서의 거리를 계산함
    - 현재값에서 상하좌우를 확인하고, 현재 거리값에 +1한 값을 상하좌우의 방문하지않았으며 0이 아닌 곳에 입력
- `distance`배열에서 좌표의 값이 -1인 경우 방문하지 않은 곳

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] distance = new int[N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = str.charAt(j) - '0';
                distance[i][j] = -1;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int[] directX = {1, 0, -1, 0};
        int[] directY = {0, 1, 0, -1};
        int curX = 0;
        int curY = 0;
        int dx = 0;
        int dy = 0;
        queue.add(new int[] { 0, 0 });
        distance[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            curX = cur[0]; curY = cur[1];
            for(int i=0; i<4; i++) {
                dx = curX + directX[i];
                dy = curY + directY[i];

                if (dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
                if (map[dy][dx] != 0 && distance[dy][dx] == -1) {
                    distance[dy][dx] = distance[curY][curX]+1;
                    queue.add(new int[] { dx, dy });
                }
            }
        }

        System.out.println(distance[N-1][M-1]);
    }
}
```
---

## 숨바꼭질 (1697번)
https://www.acmicpc.net/problem/1697

### 풀이방법
- BFS, DP로 풀 수 있는 문제이다. 
- 거리 배열을 넉넉하게 `200,000`으로 설정했다.
    - 문제는 `100,000`까지지만 `100,000`보다 크게 갔다가 돌아올 수 있으므로
- `+1`, `-1`, `*2`를 하면서 해당 위치에 값을 입력해주었다. 그렇게되면 현재 위치에서 해당 위치까지 몇 번 움직여야되는지에 대한 답이 나오기 때문이다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dist = new int[100_000 * 2];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        dist[N] = 0;

        int cur = 0;
        int origin = 0;
        while (dist[K] == -1) {
            origin = queue.poll();

            cur = origin - 1;
            if (cur >= 0 && cur < 100_000*2 && dist[cur] == -1) {
                dist[cur] = dist[origin]+1;
                queue.add(cur);
            }
            cur = origin + 1;
            if (cur >= 0 && cur < 100_000*2 && dist[cur] == -1) {
                dist[cur] = dist[origin]+1;
                queue.add(cur);
            }
            cur = origin * 2;
            if (cur >= 0 && cur < 100_000*2 && dist[cur] == -1) {
                dist[cur] = dist[origin]+1;
                queue.add(cur);
            }
        }

        System.out.println(dist[K]);
    }
}
```
---

## 하노이 탑 이동 순서 (11729번)
https://www.acmicpc.net/problem/11729

### 풀이방법
- 재귀로 풀어야 하는 문제로, N번째 원판을 3번째 기둥에 넣기 위해서는 N-1번째 원판을 2번째 기둥에 넣어야하고 2번째 기둥에 있는 원판을 1개만 남겨두고 다시 1번째 기둥에 옮긴 후  1개만 남은 원판을 3번째 기둥에 넣는다.
- 위 과정을 계속 반복하면 된다.
- 재귀 문제는 `수학적 귀납법`이 제일 중요한데 문제를 직접 디버깅하려고 하면 점점 산으로 가기 때문에 나름대로 공식을 세우고 구현을 해야한다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sb.append(pow(2, n) - 1).append('\n');
        hanoi(1, 2, 3, n);
        System.out.println(sb);
    }

    private static int pow(int a, int b) {
        int n = 0;
        int result = 1;
        while (n++ != b) {
            result *= a;
        }

        return result;
    }


    private static void hanoi(int from, int mid, int to, int n) {
        if (n == 1) {
            sb.append(from).append(' ').append(to).append('\n');
            return;
        }

        hanoi(from, to, mid, n-1);
        sb.append(from).append(' ').append(to).append('\n');
        hanoi(mid, from, to, n-1);
    }
}
```
---

## Z (1074번)
https://www.acmicpc.net/problem/1074

### 풀이방법
1. r, c가 몇 사분면 위에 있는지 확인
2. 해당 사분면의 시작번호 파악
    - 8x8 에서는 4x4가 하나의 사분면이므로
    
    ```text
    1사분면 : 0~15     2사분면 : 16~31
    3사분면 : 32~47    4사분면 : 48~63
    ```
    - 해당사분면의 시작 번호 : 2^n-1 + 2^n-1 * (해당사분면 - 1)
    
3. r, c값을 현재 사분면을 기준으로 뺌
    - ex) 2^2 x 2^2 일 때 (3,2)면 4사분면이고 해당 면에서는 (3,2)가 (1, 0)이 됨
    - 즉, r, c를 2^n-1로 나눈 나머지를 구하면 됨

4. 1~3과정을 재귀로 반복해서 2x2 배열이 될 때까지 나누고 시작값에 x+2y하면 정답이 됨


```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = (int)Math.pow(2, Integer.parseInt(st.nextToken()));
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        recursive(0, x, y, n);
    }

    private static void recursive(int startValue, int x, int y, int nn) {
        if (nn == 2) {
            System.out.println(startValue + (x + 2*y));
            return;
        }

        int quadrant = getQuadrant(x, y, nn);
        int tmpStartValue = startValue + (nn>>1) * (nn>>1) * (quadrant - 1);
        recursive(tmpStartValue, x % (nn>>1), y % (nn>>1), nn>>1);
    }

    private static int getQuadrant(int x, int y, int nn) {
        if (x < nn>>1 && y < nn>>1) {
            return 1;
        } else if (x >= nn>>1 && y < nn>>1) {
            return 2;
        } else if (x < nn>>1 && y >= nn>>1) {
            return 3;
        } else {
            return 4;
        }
    }
}
```
---

## 쿼드트리 (1992번)
https://www.acmicpc.net/problem/1992

### 풀이방법
- 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래로 나눠서 계산한다.

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] matrix = null;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        String data = "";

        for (int i=0; i<n; i++) {
            data = br.readLine();
            for (int j=0; j<n; j++) {
                matrix[i][j] = data.charAt(j) - '0';
            }
        }

        recursive(0, 0, n);
        System.out.println(sb);
    }

    static private void recursive(int x, int y, int n) {
        if (checkMatrix(x, y, n)) {
            sb.append(matrix[y][x]);
            return;
        }

        sb.append('(');
        int size = n >> 1;
        recursive(x, y, size); //왼쪽 위
        recursive(x + size, y, size); // 오른쪽 위
        recursive(x, y + size, size); // 왼쪽 아래
        recursive(x + size, y + size, size); // 오른쪽 아래
        sb.append(')');
    }

    static private boolean checkMatrix(int x, int y, int n) {
        int tmpData = matrix[y][x];
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (tmpData != matrix[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
```
---

## 계란으로 계란치기 (16987번)
https://www.acmicpc.net/problem/16987

### 풀이방법

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n = 0;
    static int[] s = null;
    static int[] w = null;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        n = Integer.parseInt(br.readLine());
        s = new int[n];
        w = new int[n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, 0);
        System.out.println(max);
    }

    private static void solve(int eggNumber, int brokenEggCount) {
        if (eggNumber == n) {
            max = Math.max(max, brokenEggCount);
            return;
        }

        // 현재 계란의 내구도가 0이하이거나
        // 깨진 계란의 개수가 n - 1개인 경우 (계란이 하나 남은 경우)
        if (s[eggNumber] <= 0 || brokenEggCount == n - 1) {
            solve(eggNumber + 1, brokenEggCount);
            return;
        }

        for (int i=0; i<n; i++) {
            if (i == eggNumber || s[i] <= 0) {
                continue;
            }

            if ((s[eggNumber] -= w[i]) <= 0) {
                brokenEggCount++;
            }
            if ((s[i] -= w[eggNumber]) <= 0) {
                brokenEggCount++;
            }
            solve(eggNumber + 1, brokenEggCount);

            if (s[eggNumber] <= 0) {
                brokenEggCount--;
            }
            s[eggNumber] += w[i];

            if (s[i] <= 0) {
                brokenEggCount--;
            }
            s[i] += w[eggNumber];
        }
    }
}
```
---

## 안전 영역 (2468번)
https://www.acmicpc.net/problem/2468

### 풀이방법
- 1~100까지 물의 높이가 될 수 있지만 입력값의 최대값을 최대 가능한 물의 높이로 생각한다.
- 0부터 최대값까지 반복하면서 map의 (0, 0)부터 bfs로 탐색한다.

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n = 0;
    static int[][] map = null;
    static boolean[][] visited = null;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int maxNumber = 0;
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                maxNumber = Math.max(maxNumber, tmp);
                map[i][j] = tmp;
            }
        }

        for (int water=0; water<maxNumber; water++) {
            int count = 0;
            visited = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!visited[j][k] && map[j][k] > water) {
                        bfs(k, j, water);
                        count++;
                    }
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    static Queue<int[]> queue = new LinkedList<>();
    static int[] directX = {1, 0, -1, 0};
    static int[] directY = {0, 1, 0, -1};
    private static void bfs(int x, int y, int maxNumber) {
        queue.add(new int[] { x, y });
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int curX = pos[0];
            int curY = pos[1];

            for (int i=0; i<4; i++) {
                int dx = curX + directX[i];
                int dy = curY + directY[i];

                if (dx < 0 || dx >= n || dy < 0 || dy >= n || visited[dy][dx]) continue;

                if (map[dy][dx] > maxNumber) {
                    queue.add(new int[]{dx, dy});
                    visited[dy][dx] = true;
                }
            }
        }
    }
}
```
---
