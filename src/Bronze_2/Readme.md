# 백준 문제풀이 (Bronze 2)

---
## 저항 (1076번)
https://www.acmicpc.net/problem/1076

### 풀이방법
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 10^값 => 곱
        int first = getResistanceValue(br.readLine());
        int second = getResistanceValue(br.readLine());
        int third = getResistanceValue(br.readLine());
        
        System.out.println((long)(first*10 + second) * (long)Math.pow(10, third));
    }
    
    private static int getResistanceValue(String color) {
        switch (color) {
            case "black":
                return 0;
                
            case "brown":
                return 1;
                
            case "red":
                return 2;
                
            case "orange":
                return 3;
                
            case "yellow":
                return 4;
                
            case "green":
                return 5;
                
            case "blue":
                return 6;
                
            case "violet":
                return 7;
                
            case "grey":
                return 8;
                
            default:
                return 9;
        }
    }
}
```
---
## 하얀 칸 (1100번)
https://www.acmicpc.net/problem/1100

### 풀이방법
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        boolean isWhiteCell = true;
        int whiteCount = 0;
        for(int i=0; i<8; i++) {
            sb.append(br.readLine());

            for(int j=0; j<8; j++) {
                if (isWhiteCell) {
                    if (sb.charAt(j) == 'F') {
                        whiteCount++;
                    }
                }

                isWhiteCell = !isWhiteCell;
            }

            isWhiteCell = !isWhiteCell;
            sb.delete(0, sb.length());
        }

        System.out.println(whiteCount);
    }
}
```
---
## 운동 (1173번)
https://www.acmicpc.net/problem/1173

### 풀이방법
1. 현재 맥박이 M보다 커지기 전까지 T 값 더하기
2. 현재 맥박에서 T값이 들어갈 때까지 R값 빼기
3. 뺀 값이 m보다 작으면 현재 맥박은 다시 m으로 변경
4. 1 ~ 3 반복
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        if (m + T > M) {
            System.out.println(-1);
            return;
        }

        int curPulse = m;
        int restTime = 0;
        int exerciseTime = 0;
        while(exerciseTime < N) {
            if (curPulse < m) {
                curPulse = m;
            }

            if (curPulse + T <= M) {
                curPulse += T;
                exerciseTime++;
                continue;
            }

            while(true) {
                if (Math.abs(curPulse - M) < T) {
                    restTime++;
                    curPulse -= R;
                }
                else {
                    break;
                }
            }
        }

        System.out.println(N + restTime);
    }
}
```
## 카드1 (2161번)
https://www.acmicpc.net/problem/2161

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            queue.add(i+1);
        }

        StringBuilder sb = new StringBuilder();
        while(queue.size() != 1) {
            sb.append(queue.remove()).append(" ");
            queue.add(queue.remove());
        }

        sb.append(queue.remove());
        System.out.println(sb.toString());
    }
}
```