# 백준 문제풀이 (Gold 5)

---

## 합분해 (2225번)
https://www.acmicpc.net/problem/2225

### 풀이방법
[참고](https://imgur.com/a/j7EVxjZ)

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int MOD_VALUE = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[K+1][N+1];
        // D[1][0 ~ N]까지 1로 설정
        // https://imgur.com/a/j7EVxjZ
        for(int i=0; i<=N; i++) {
            dp[1][i] = 1;
        }

        for(int k=2; k<=K; k++) {
            for(int n=0; n<=N; n++) {
                for(int l=0; l<=n; l++) {
                    dp[k][n] += dp[k-1][n-l];
                }
                dp[k][n] %= MOD_VALUE;
            }
        }

        System.out.println(dp[K][N]);
    }
}
```
---
## 연속합 2 (13398번)
https://www.acmicpc.net/problem/13398

### 풀이방법
- `D[i] = i-1번째 수를 마지막으로 하는 최대 연속합 + i+1번째 수로 시작하는 연속 최대합` 과
  `D[i] = i번째 수를 마지막으로 하는 최대 연속합` 을 비교해야 함
- 숫자를 제거하지 않았을 때와 숫자를 제거했을 때의 연속 최대합들을 구해야 함
- 숫자를 제거하지 않았을 때는 첫번째부터 마지막까지 비교하며 연속 최대합을 구함
- 숫자를 제거했을 경우 제거 대상의 앞쪽의 연속 최대합과 뒤쪽의 연속 최대합을 구해야 함
  - ex) 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 에서 -35를 제거하고 계산한다고 했을 때, 
    10, -4, 3, 1, 5, 6에서 연속 최대합을 구하고 12, 21, -1에서 연속 최대합을 구해야 함

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

        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp1[i] = arr[i];
            dp2[i] = arr[i];
        }

        for(int i=2; i<=n; i++) {
            dp1[i] = Math.max(arr[i], dp1[i-1] + arr[i]);
        }

        for(int i=n-1; i>=1; i--) {
            dp2[i] = Math.max(arr[i], dp2[i+1] + arr[i]);
        }

        int max = dp1[1];
        for(int i=1; i<=n; i++) {
            max = Math.max(dp1[i], max);
        }
        for(int i=1; i<=n-1; i++) {
            max = Math.max(max, dp1[i-1] + dp2[i+1]);
        }

        System.out.println(max);
    }
}
```
---
