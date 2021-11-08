# 백준 문제풀이 (Silver 4)

---

## 킹 (1063번)
https://www.acmicpc.net/problem/1063

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 인덱스를 이용해 A~H를 표현하기 위함
        char[] widthPos = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        String tmp = st.nextToken();
        // 현재 킹의 위치
        int[] kingPos = { tmp.charAt(0) - 'A' + 1, tmp.charAt(1) - '0' };
        tmp = st.nextToken();
        // 현재 돌의 위치
        int[] stonePos = { tmp.charAt(0) - 'A' + 1, tmp.charAt(1) - '0' };

        int N = Integer.parseInt(st.nextToken());

        String command = "";
        for(int i=0; i<N; i++) {
            command = br.readLine();

            calculatePos(command, kingPos, stonePos);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(widthPos[kingPos[0]]).append((char)(kingPos[1] + '0')).append("\n");
        sb.append(widthPos[stonePos[0]]).append((char)(stonePos[1] + '0'));

        System.out.println(sb);
    }

    private static void calculatePos(String command, int[] kingPos, int[] stonePos) {
        int widthMoveCount = 0;
        int heightMoveCount = 0;
        // R, L, B, T의 조합으로만 이루어져 있으므로
        for(int i=0; i<command.length(); i++) {
            switch (command.charAt(i)) {
                case 'R':
                    widthMoveCount = 1;
                    break;
                case 'L':
                    widthMoveCount = -1;
                    break;
                case 'B':
                    heightMoveCount = -1;
                    break;
                case 'T':
                    heightMoveCount = 1;
                    break;
            }
        }

        // 8x8 범위에서 벗어났는지 확인
        if (!checkArea(kingPos, widthMoveCount, heightMoveCount)) {
            return;
        }

        // 현재 킹의 위치에 이동횟수를 더한 위치값이 돌의 위치값이라면
        if (
                kingPos[0] + widthMoveCount == stonePos[0]
                && kingPos[1] + heightMoveCount == stonePos[1]
        )
        {
            // 돌의 위치가 8x8에서 벗어났는지 확인
            if (!checkArea(stonePos, widthMoveCount, heightMoveCount)) {
                return;
            }

            // 벗어나지 않았다면 둘 다 동일한 방향으로 밀기
            kingPos[0] += widthMoveCount;
            kingPos[1] += heightMoveCount;

            stonePos[0] += widthMoveCount;
            stonePos[1] += heightMoveCount;
        }
        // 현재 킹의 위치에 이동횟수를 더한 위치값이 돌의 위치와 같지 않다면 이동 가능하므로 더해줌
        else {
            kingPos[0] += widthMoveCount;
            kingPos[1] += heightMoveCount;
        }
    }

    // 8x8 배열에서 벗어났는지 확인
    private static boolean checkArea(int[] arr, int width, int height) {
        if (
            arr[0] + width > 8
            || arr[0] + width < 1
            || arr[1] + height > 8
            || arr[1] + height < 1
        )
        {
            return false;
        }

        return true;
    }
}
```