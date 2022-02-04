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
## 테트로미노 (14500번)
https://www.acmicpc.net/problem/14500

### 풀이방법
- 테트로미노의 모든 경우의 수를 구함 (19가지 - 회전, 대칭 포함)

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0;
        int max = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                /*
                . . . .
                 */
                if (j+3 < M) {
                    sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3];
                    max = Math.max(max, sum);
                }
                /*
                .
                .
                .
                .
                 */
                if (i+3 < N) {
                    sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
                    max = Math.max(max, sum);
                }
                /*
                . .
                . .
                 */
                if (i+1 < N && j+1 < M) {
                    sum = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+1][j+1];
                    max = Math.max(max, sum);
                }
                /*
                .
                .
                . .
                 */
                if (i+2 < N && j+1 < M) {
                    sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j+1];
                    max = Math.max(max, sum);
                }
                /*
                . . .
                .
                 */
                if (j+2 < M && i+1 < N) {
                    sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j];
                    max = Math.max(max, sum);
                }
                /*
                . .
                  .
                  .
                 */
                if (j+1 < M && i+2 < N) {
                    sum = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1];
                    max = Math.max(max, sum);
                }
                /*
                    .
                . . .
                 */
                if (j+2 < M && i+1 < N) {
                    sum = map[i][j+2] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
                    max = Math.max(max, sum);
                }
                /*
                .
                . .
                  .
                 */
                if (j+1 < M && i+2 < N) {
                    sum = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1];
                    max = Math.max(max, sum);
                }
                /*
                  . .
                . .
                 */
                if (j+2 < M && i+1 < N) {
                    sum = map[i][j+1] + map[i][j+2] + map[i+1][j] + map[i+1][j+1];
                    max = Math.max(max, sum);
                }
                /*
                . . .
                  .
                 */
                if (j+2 < M && i+1 < N) {
                    sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1];
                    max = Math.max(max, sum);
                }
                /*
                  .
                . .
                  .
                 */
                if (j+1 < M && i+2 < N) {
                    sum = map[i][j+1] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1];
                    max = Math.max(max, sum);
                }
                /*
                  .
                . . .
                 */
                if (j+2 < M && i+1 < N) {
                    sum = map[i][j+1] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
                    max = Math.max(max, sum);
                }
                /*
                .
                . .
                .
                 */
                if (j+1 < M && i+2 < N) {
                    sum = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j];
                    max = Math.max(max, sum);
                }
                /*
                  .
                  .
                . .
                 */
                if (j+1 < M && i+2 < N) {
                    sum = map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i+2][j];
                    max = Math.max(max, sum);
                }
                /*
                .
                . . .
                 */
                if (j+2 < M && i+1 < N) {
                    sum = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
                    max = Math.max(max, sum);
                }
                /*
                . .
                .
                .
                 */
                if (j+1 < M && i+2 < N) {
                    sum = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+2][j];
                    max = Math.max(max, sum);
                }
                /*
                . . .
                    .
                 */
                if (j+2 < M && i+1 < N) {
                    sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+2];
                    max = Math.max(max, sum);
                }
                /*
                  .
                . .
                .
                 */
                if (j+1 < M && i+2 < N) {
                    sum = map[i][j+1] + map[i+1][j] + map[i+1][j+1] + map[i+2][j];
                    max = Math.max(max, sum);
                }
                /*
                . .
                  . .
                 */
                if (j+2 < M && i+1 < N) {
                    sum = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+1][j+2];
                    max = Math.max(max, sum);
                }
            }
        }

        System.out.println(max);
    }
}
```
---
## 암호 만들기 (1759번)
https://www.acmicpc.net/problem/1759

### 풀이방법
- 재귀를 이용해 문제를 해결할 수 있다.
- 문제 내용 중 암호를 이루는 알파벳이 증가하는 순서로 배열되었을 것이라고 하였으므로 입력받은 C개의 문자들을 정렬해주었다.
- 최소 한 개의 모음과 최소 두 개의 자음으로 구성되어 있다고 하였으므로 자음과 모음의 개수를 세고 조건에 맞을 경우 출력해주어야 한다.
- 자음과 모음을 판단하는 `checkVowel`함수를 만들고 모음일 경우 `true`, 자음일 경우 `false`를 반환하도록 하였다.
- 중복되지 않는 순열을 구하는 방법으로 정답을 구할 수 있다.
- `solve`함수의 매개변수는 아래와 같다.
  - arr : 입력받은 문자 C개를 정렬한 배열
  - vowelCount : 모음의 개수
  - consonantCount : 자음의 개수
  - curIndex : 중복을 뽑지 않으며 증가하는 순서대로 뽑기 위한 변수
  - r : 뽑을 개수
  - c : 현재 뽑은 개수 및 `result` 배열에 들어갈 위치 지정

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static char[] result = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        result = new char[L];
        int C = Integer.parseInt(st.nextToken());
        char[] arr = new char[C];
        st = new StringTokenizer(br.readLine());
        int index = 0;
        while (st.hasMoreTokens()) {
            arr[index++] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        solve(arr, 0, 0, 0, L, 0);
        System.out.println(sb);
    }

    private static void solve(char[] arr, int vowelCount, int consonantCount, int curIndex, int r, int c) {
        if (c == r) {
            if (vowelCount >= 1 && consonantCount >= 2) {
                sb.append(result).append('\n');
            }
            return;
        }
        else {
            for(int i=curIndex; i<arr.length; i++){
                result[c] = arr[i];
                if (checkVowel(arr[i])) {
                    solve(arr, vowelCount+1, consonantCount, i+1, r, c+1);
                }
                else {
                    solve(arr, vowelCount, consonantCount+1, i+1, r, c+1);
                }
            }
        }
    }

    private static boolean checkVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }

        return false;
    }
}
```
---
### 약수의 합 (17425번)
https://www.acmicpc.net/problem/17425

### 헤맸던 점
- [약수의 합 2](https://www.acmicpc.net/problem/17427) 와 똑같은 문제로 판단하고 풀었는데 시간초과가 발생했다.
- 처음에는 `에라토스테네스의 체`처럼 미리 계산하는 방식으로 구현해야겠다 생각은 했지만 구현부분에서 어지러웠던 점이 있었는데 
멘탈을 부여잡고 다시 처음부터 생각해보니 너무 어렵게 생각했던 부분이 있었다.

### 풀이방법
- 단순하게 생각하면 쉬운 문제였다.
- `1~N`까지 약수들의 합을 배열에 미리 계산한 후 매 케이스마다 해당 인덱스의 값을 반환하면 된다.
- 처음에 `1~20`까지 약수들을 모두 써본 후 어떤 규칙이 있는지 확인해보았다.
  - `1은 모든 약수`에 들어있고, `2는 2의 배수`에, `3은 3의 배수`에 들어있었음을 알 수 있었다.
- 위의 방식을 이용하여 미리 `1,000,000`개의 배열을 선언해준 후에 각 배수의 인덱스에 값을 더해주는 방식으로 구현하였다.
- 문제에서는 `1~N`까지 약수의 합을 말했으므로 각 배수를 모두 구했을 때마다 이전값과 더해주는 방식을 취하였다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int MAX_VALUE = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] saved = new long[MAX_VALUE+1];

        for(int i=1; i<=MAX_VALUE; i++) {
            for(int j=i; j<=MAX_VALUE; j+=i) {
                saved[j] += i;
            }
            saved[i] += saved[i-1];
        }


        int T = Integer.parseInt(br.readLine());
        int N = 0;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            sb.append(saved[N]).append('\n');
        }

        System.out.println(sb);
    }
}
```
---

## 토마토 (7576번)
https://www.acmicpc.net/problem/7576

### 풀이방법
1. 숫자를 입력받을 때 익은 토마토의 좌표를 `Queue`에 넣는다.
2. `Queue`에서 하나씩 빼면서 상하좌우에 현재값 +1 한다.
3. 방문하지 않은 곳은 -1로 설정한다.
4. +1할때마다 최대값을 구한다.

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

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] dist = new int[N][M];
        int zeroCount = 0;

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = -1;
                if (map[i][j] == 1) queue.add(new int[]{i, j});
                if (map[i][j] == 0) zeroCount++;
            }
        }

        int[] xPos = {1, 0, -1, 0};
        int[] yPos = {0, 1, 0, -1};
        int dx = 0; int dy = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i=0; i<4; i++) {
                dx = cur[1] + xPos[i];
                dy = cur[0] + yPos[i];
                if (dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
                if (map[dy][dx] == 0 && dist[dy][dx] == -1) {
                    dist[dy][dx] = dist[cur[0]][cur[1]]+1;
                    max = Math.max(dist[dy][dx], max);
                    zeroCount--;
                    queue.add(new int[] { dy, dx });
                }
            }
        }

        if (zeroCount != 0) System.out.println(-1);
        else if(max == 0) System.out.println(0);
        else System.out.println(max+1);
    }
}
```
---

## 적록색약 (10026번)
https://www.acmicpc.net/problem/10026

### 뻘짓
- 단순히 생각하면 되는데 어렵게 생각했다.
- 적록색약인 경우 R인지 G인지 확인하고 상하좌우의 값이 R 또는 G인 경우에만 더해주는 방식으로 구현해보려했는데 잘 되지 않았다.

### 풀이방법
1. `BFS`를 이용해 적록색약이 아닐 때의 개수를 센다.
2. `R`을 `G`로 바꾸게 되면 적록색약인 사람이 보는 것과 동일하다.
3. `R`을 `G`로 바꾼 후 다시 `BFS`를 이용해 적록색약일 때의 개수를 센다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j=0; j<N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int rgbCount = 0;
        int rrbCount = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[i][j]) {
                    char c = map[i][j];
                    bfs(c, j, i, N);
                    rgbCount++;
                }
            }
        }

        changeMap(N);
        visited = new boolean[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[i][j]) {
                    char c = map[i][j];
                    bfs(c, j, i, N);
                    rrbCount++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(rgbCount).append(' ').append(rrbCount);
        System.out.println(sb);
    }

    public static void changeMap(int N) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == 'R') map[i][j] = 'G';
            }
        }
    }

    public static void bfs(char c, int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
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

                if (dx < 0 || dx >= n || dy < 0 || dy >= n) continue;
                if (visited[dy][dx] || map[dy][dx] != c) continue;
                visited[dy][dx] = true;
                queue.add(new int[] { dx, dy });
            }
        }
    }
}
```
---

## 토마토 (7569번)
https://www.acmicpc.net/problem/7569

### 풀이방법
1. 숫자를 입력받을 때 익은 토마토의 좌표를 `Queue`에 넣는다.
2. `Queue`에서 하나씩 빼면서 위,아래,상,하,좌,우에 현재값 +1 한다.
3. 방문하지 않은 곳은 -1로 설정한다.
4. +1할때마다 최대값을 구한다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<int[]> queue = new LinkedList<>();
    static int[][][] map;
    static int[][][] dist;
    static int zeroCount;
    static int max = 0;
    static int M = 0;
    static int N = 0;
    static int H = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];
        dist = new int[H][N][M];
        zeroCount = 0;

        for(int i=0; i<H; i++) {
            for (int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k=0; k<M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 0) {
                        dist[i][j][k] = -1;
                        zeroCount++;
                    }
                    if (map[i][j][k] == 1) {
                        dist[i][j][k] = 0;
                        queue.add(new int[] { k, j, i });
                    }
                }
            }
        }

        if (zeroCount == 0) {
            System.out.println(0);
            return;
        }

        bfs();
        if (zeroCount != 0) System.out.println(-1);
        else System.out.println(max);
    }

    private static void bfs() {
        int[] cur;
        int[] xPos = {1, 0, -1, 0, 0, 0};
        int[] yPos = {0, 1, 0, -1, 0, 0};
        int[] zPos = {0, 0, 0, 0, -1, 1};
        int dx = 0; int dy = 0; int dz = 0;
        while (!queue.isEmpty()) {
            cur = queue.poll();

            for(int i=0; i<6; i++) {
                dx = cur[0] + xPos[i];
                dy = cur[1] + yPos[i];
                dz = cur[2] + zPos[i];

                if (dx < 0 || dx >= M || dy < 0 || dy >= N || dz < 0 || dz >= H) continue;
                if (dist[dz][dy][dx] != -1) continue;
                dist[dz][dy][dx] = dist[cur[2]][cur[1]][cur[0]] + 1;
                queue.add(new int[] { dx, dy, dz });
                max = Math.max(max, dist[dz][dy][dx]);
                zeroCount--;
            }
        }
    }
}
```
---
