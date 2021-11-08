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
