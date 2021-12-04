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
