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
## 리모컨 (1107번)
https://www.acmicpc.net/problem/1107

### 풀이방법
- +, -로 이동하는 것이 제일 빠를 경우로 채널값에서 100을 뺌
- 고장난 버튼들은 `true`로 설정
- 값이 `500,000`까지지만 고장난 번호가 `0, 2, 3, 4, 6, 7, 8, 9`일 경우 `511,111`에서 움직이는 것이 더 최소이므로 최대 `1,000,000`까지 설정
- `0~1,000,000`까지 돌면서 각 자리수가 고장난 버튼에 포함되는지 확인하고 포함될 경우 다음 숫자로 넘어감
- 포함되지 않을 경우 설정한 채널 번호에서 현재 돌고있는 채널값을 빼고 현재 돌고있는 채널의 길이를 더해주어야 정답이 됨 (예제 참고)

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int targetChannel = Integer.parseInt(br.readLine());
        int brokenButtonCount = Integer.parseInt(br.readLine());
        boolean[] brokenButtons = new boolean[10];
        int min = Math.abs(targetChannel - 100);

        if (brokenButtonCount > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            if (targetChannel == 100) {
                System.out.println(0);
                return;
            }

            int index = 0;
            while (st.hasMoreTokens()) {
                index = Integer.parseInt(st.nextToken());
                brokenButtons[index] = true;
            }
        }

        int i = 0;
        for(i=0; i<1_000_000; i++) {
            if (isBrokenButtonPressed(i, brokenButtons)) {
                continue;
            }

            min = Math.min(min, Math.abs(targetChannel - i) + intLen(i));
        }

        System.out.println(min);
    }

    private static boolean isBrokenButtonPressed(int num, boolean[] brokenButtons) {
        for(int i=0; i<intLen(num); i++) {
            if (brokenButtons[getIntPosition(num, i)]) {
                return true;
            }
        }
        return false;
    }

    private static int getIntPosition(int num, int position) {
        int r = 0;
        while (position-- >= 0) {
            r = num % 10;
            while (true) {
                if (r < 10) {
                    break;
                }

                r = r % 10;
            }
            num /= 10;
        }

        return r;
    }

    private static int intLen(int num) {
        if (num < 10) {
            return 1;
        }

        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }

        return count;
    }
}
```
---
