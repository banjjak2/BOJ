# 백준 문제풀이 (Bronze 4)

---

## TV 크기 (1297번)
https://www.acmicpc.net/problem/1297

### 사전지식
- 피타고라스 정리

### 풀이방법
- `a^2 + b^2 = c^2` 공식 적용
- a : 높이 비율, b : 넓이 비율, c : 대각선 비율
- `9^2 + 16^2 = c^2 -> 337`
- 결국, `c^2 = 337, c = 루트 337, sqrt(337)`이 된다.
- 대각선 비율이 `루트 337, sqrt(337)`이 나왔으므로 `대각선 길이`를 `비율`로 나누면 비율 1당 길이가 나오게 된다.
- 비율 1당 길이에 높이 비율 및 넓이 비율을 곱해서 표현하면 된다.
```java
package Bronze_4;

import java.util.*;
import java.io.*;

public class TV크기_1297 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double D = Double.valueOf(st.nextToken());
        double H = Double.valueOf(st.nextToken());
        double W = Double.valueOf(st.nextToken());

        // A^2 + B^2 = C^2
        double distancePerRatio = D / Math.sqrt(H * H + W * W);

        System.out.println((int)(Math.floor(distancePerRatio * H)) + " " + (int)(Math.floor(distancePerRatio * W)));
    }
}
```
---
## A/B (1008번)
https://www.acmicpc.net/problem/1008

### 풀이방법
- double로 데이터를 입력받고 나누기
```java
package Bronze_5;

import java.util.*;
import java.io.*;

public class A_divide_B_1008 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double A = Double.valueOf(st.nextToken());
        double B = Double.valueOf(st.nextToken());

        System.out.println(A/B);
    }
}
```
---
## 손익분기점 (1712번)
https://www.acmicpc.net/problem/1712

### 풀이방법
- 가변비용이 노트북 가격보다 크거나 같다면 수익이 나올 수 없기 때문에 절대로 손익분기점이 나올 수 없음 `(B >= C)`
- 노트북 가격에서 가변비용을 빼면 순수익이 나오게 되며 고정비용을 순수익으로 나누면 손익분기점이 나올 수 있는 최소 개수가 나오게 됨
```java
package Bronze_4;

import java.util.*;
import java.io.*;

public class 손익분기점_1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 고정비용
        long A = Long.valueOf(st.nextToken());
        // 가변비용
        long B = Long.valueOf(st.nextToken());
        // 노트북 가격
        long C = Long.valueOf(st.nextToken());

        // B >= C -> 손익분기점 X
        // A / (C - B) -> 최초 손익분기점

        if (B >= C) {
            System.out.println(-1);
        }
        else {
            System.out.println(A / (C - B) + 1);
        }
    }
}
```
---
## 사파리월드 (2420번)
https://www.acmicpc.net/problem/2420

### 풀이방법
```java
package Bronze_4;

import java.util.*;
import java.io.*;

public class 사파리월드_2420 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.valueOf(st.nextToken());
        long M = Long.valueOf(st.nextToken());

        System.out.println(Math.abs(N - M));
    }
}
```
---
## AFC 윔블던 (4299번)
https://www.acmicpc.net/problem/4299

### 주의사항
- 제대로 된 입력의 경우 합이 무조건 차보다 커야 함
- 그러나, 합이 차보다 무조건 크게 **입력**될 것이라는 보장이 없음. 즉, 잘못된 데이터가 들어왔을 때에도 처리해주어야 함 <br>`ex) 합 2 차 4`

### 풀이방법
- 합이 3이고 차가 1일 때, 수식은 다음과 같다.
- `a + b = 3`, `a - b = 1` 일 때, `a + b = 3`을 `a = 3 - b`로 바꾸고 `a - b = 1`을 `a = 1 + b`로 바꾼다.
- `a = 3 - b`에 `a = 1 + b`를 대입하면 `1 + b = 3 - b`가 되고, 정리하면 `2b = 2`에서 `b = 1`이 된다.
- `b`를 구했으면 위 수식 아무곳이나 `b`를 대입해 `a`를 구하면 된다.
- 만약, `2b = 3`과 같이 정수로 떨어지지 않을 경우 a, b를 구할 수 없으므로 -1을 반환한다. `ex) 합 123, 차 90`
```java
package Bronze_4;

import java.util.*;
import java.io.*;

public class AFC_윔블던_4299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = Integer.valueOf(st.nextToken());
        int sub = Integer.valueOf(st.nextToken());


        double b = (sum - sub) / 2.0;
        // 소수점이 있으면 -1
        if ((b % 1 > 0) || (sum < sub)) {
            System.out.println(-1);
            return;
        }

        int a = sum - (int)b;
        if (a > b) {
            System.out.println(a + " " + (int)b);
        }
        else{
            System.out.println((int)b + " " + a);
        }
    }
}
```
---
## 이칙연산 (15726번)
https://www.acmicpc.net/problem/15726

### 풀이방법
- 1 2 3 입력 시 1이 출력되어야 함
- `1 * 2 / 3` => `2/3` => 0
- `1 / 2 * 3` => `3/2` => 1.XXX (소수점 버리기) => 1
```java
package Bronze_4;

import java.util.*;
import java.io.*;

public class 이칙연산_15726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double A = Double.valueOf(st.nextToken());
        double B = Double.valueOf(st.nextToken());
        double C = Double.valueOf(st.nextToken());

        int result = (int)(((A * B / C) > (A / B * C))? (A * B / C) : (A / B * C));
        System.out.println(result);
    }
}
```
---
## 오븐 시계 (2525번)
https://www.acmicpc.net/problem/2525

### 풀이방법
```java
package Bronze_4;

import java.util.*;
import java.io.*;

public class 오븐_시계_2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.valueOf(st.nextToken());
        int B = Integer.valueOf(st.nextToken());
        int C = Integer.valueOf(br.readLine());

        // 분(B)에 걸리는 시간(C) 더하기
        B += C;
        // 더해진 분(B)을 60으로 나누어 시간에 더함
        A += (B / 60);
        // B의 잔여 분
        B %= 60;
        A %= 24;

        System.out.println(A + " " + B);
    }
}
```
---
## 인공지능 시계 (2530번)
https://www.acmicpc.net/problem/2530

### 풀이방법
```java
package Bronze_4;

import java.util.*;
import java.io.*;

public class 인공지능_시계_2530 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.valueOf(st.nextToken()); // 시
        int B = Integer.valueOf(st.nextToken()); // 분
        int C = Integer.valueOf(st.nextToken()); // 초
        int D = Integer.valueOf(br.readLine()); // 걸리는 시간 (초)

        // 초 더하기
        C += D;
        // 분 구하기
        B += (C/60);
        C %= 60;

        A += (B/60);
        B %= 60;

        A %= 24;

        System.out.println(A + " " + B + " " + C);
    }
}
```