# 백준 문제풀이 (Gold 4)

---

## 오큰수 (17298번)
https://www.acmicpc.net/problem/17298

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[N];
        int[] result = new int[N];
        
        int index = 0;
        while(st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }
        
        stack.push(0);
        for(int i=1; i<N; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }
            
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(result[i]).append(' ');
        }
        
        System.out.println(sb);
    }
}
```
---
## 가장 긴 증가하는 부분 수열 4 (14002번)
https://www.acmicpc.net/problem/14002

### 풀이방법
- [가장 긴 증가하는 부분 수열](https://boj.kr/11053) 응용 문제
- 배열을 이용해 위치 저장 후 재귀호출로 순서대로 출력

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
        int[] seq = new int[N];
        int index = 0;
        while(st.hasMoreTokens()) {
            numbers[index] = Integer.parseInt(st.nextToken());
            dp[index] = 1;
            seq[index] = -1;
            index++;
        }

        int max = 1;
        int prevMax = max;
        for(int i=0; i<N; i++) {
            for(int j=0; j<i; j++) {
                if (numbers[j] < numbers[i]) {
                    max = Math.max(dp[i] + dp[j], max);
                    if (prevMax < max) {
                        seq[i] = j;
                    }
                    prevMax = max;
                }
            }

            dp[i] = max;
            max = 1;
            prevMax = 1;
        }

        int result = 0;
        for(int i=0; i<N; i++) {
            if (dp[i] > result) {
                result = dp[i];
                index = i;
            }
        }

        sb.append(result).append('\n');
        print(numbers, seq, index);
        sb.append('\n');
        System.out.println(sb);
    }

    static StringBuilder sb = new StringBuilder();
    private static void print(int[] numbers, int[] seq, int index) {
        if (index == -1) {
            return;
        }

        print(numbers, seq, seq[index]);
        sb.append(numbers[index]).append(' ');
    }
}
```
---

## 불! (4179번)
https://www.acmicpc.net/problem/4179

### 풀이방법
1. 지훈과 불의 거리 BFS를 이용해 문제를 해결한다.
2. 불의 거리를 BFS로 구한다.
3. 지훈의 거리를 BFS로 구한다.
    - 단, 거리를 구하다가 `X`, `Y`의 범위에서 벗어날 경우 해당 위치가 정답이 될 가능성이 있다.
    - 정답이 되기 위해서는 해당 위치에 불이 없어야하므로 범위에서 벗어날 때 불이 있는 자리인지 확인한다.

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
        int[][] map = new int[y][x];
        int[][] jDist = new int[y][x];
        int[][] fDist = new int[y][x];
        Queue<int[]> jihoon = new LinkedList<>();
        Queue<int[]> fire = new LinkedList<>();
        for (int i = 0; i < y; i++) {
            StringBuilder str = new StringBuilder(br.readLine());
            for (int j = 0; j < x; j++) {
                jDist[i][j] = -1;
                fDist[i][j] = -1;

                if (str.charAt(j) == '#') map[i][j] = 0;
                else if (str.charAt(j) == '.') map[i][j] = 1;
                else if (str.charAt(j) == 'J') {
                    jihoon.add(new int[]{i, j});
                    map[i][j] = 2;
                    jDist[i][j] = 1;
                } else if (str.charAt(j) == 'F') {
                    fire.add(new int[]{i, j});
                    map[i][j] = 2;
                    fDist[i][j] = 1;
                }
            }
        }

        int[] directX = {1, 0, -1, 0};
        int[] directY = {0, 1, 0, -1};
        int dx = 0;
        int dy = 0;
        int[] cur;
        while (!fire.isEmpty()) {
            cur = fire.poll();

            for (int i = 0; i < 4; i++) {
                dx = cur[1] + directX[i];
                dy = cur[0] + directY[i];

                if (dx < 0 || dx >= x || dy < 0 || dy >= y) continue;
                if (map[dy][dx] == 1 && fDist[dy][dx] == -1) {
                    fDist[dy][dx] = fDist[cur[0]][cur[1]] + 1;
                    fire.add(new int[]{dy, dx});
                }
            }
        }

        while (!jihoon.isEmpty()) {
            cur = jihoon.poll();

            for (int i = 0; i < 4; i++) {
                dx = cur[1] + directX[i];
                dy = cur[0] + directY[i];

                if ((dx < 0 || dx >= x || dy < 0 || dy >= y)) {
                    if ((fDist[cur[0]][cur[1]] > jDist[cur[0]][cur[1]]) || fDist[cur[0]][cur[1]] == -1) {
                        System.out.println(jDist[cur[0]][cur[1]]);
                        return;
                    }
                    continue;
                }
                if (map[dy][dx] == 1 && jDist[dy][dx] == -1) {
                    jDist[dy][dx] = jDist[cur[0]][cur[1]] + 1;
                    jihoon.add(new int[]{dy, dx});
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
```
---

## 벽 부수고 이동하기 (2206번)
https://www.acmicpc.net/problem/2206

### 풀이방법
- `벽을 부쉈을 때의 경로`와 `벽을 부수지 않았을 때의 경로`를 따로 갖고 있어야 함

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][][] distance = null;
    private static int[][] map = null;
    private static int[] directX = {1, 0, -1, 0};
    private static int[] directY = {0, 1, 0, -1};
    private static int n = 0;
    private static int m = 0;
    private static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 벽 부수지 않고 최단거리
        // 벽 부수고 최단거리
        distance = new int[n][m][2];
        map = new int[n][m];
        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int dx = 0;
        int dy = 0;
        int curX = 0;
        int curY = 0;
        int broken = 0;

        queue.add(new int[] { 0, 0, 0 });
        distance[0][0][0] = 1;
        distance[0][0][1] = 1;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            curX = pos[0];
            curY = pos[1];
            broken = pos[2];

            if (curX == m - 1 && curY == n - 1) {
                return distance[curY][curX][broken];
            }

            for (int i=0; i<4; i++) {
                dx = curX + directX[i];
                dy = curY + directY[i];

                if (dx < 0 || dx >= m || dy < 0 || dy >= n) continue;

                int curDist = distance[curY][curX][broken];
                if (map[dy][dx] == 0 && distance[dy][dx][broken] == 0) {
                    distance[dy][dx][broken] = curDist + 1;
                    queue.add(new int[] { dx, dy, broken });
                } else if (broken != 1 && map[dy][dx] == 1 && distance[dy][dx][broken] == 0) {
                    distance[dy][dx][1] = curDist + 1;
                    queue.add(new int[] { dx, dy, 1 });
                }
            }
        }

        return -1;
    }
}
```
---
