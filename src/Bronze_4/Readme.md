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
import java.util.*;
import java.io.*;

public class Main {
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

public class Main {
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
import java.util.*;
import java.io.*;

public class Main {
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
import java.util.*;
import java.io.*;

public class Main {
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
import java.util.*;
import java.io.*;

public class Main {
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
import java.util.*;
import java.io.*;

public class Main {
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
import java.util.*;
import java.io.*;

public class Main {
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
import java.util.*;
import java.io.*;

public class Main {
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
---
## 세수정렬 (2752번)
https://www.acmicpc.net/problem/2752

### 사전지식
- 배열 정렬 메소드 사용 방법

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[3];
        for(int i=0; i<3; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(arr);
        for(int i=0; i<3; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
```
---
## 주사위 세개 (2480번)
https://www.acmicpc.net/problem/2480

### 풀이방법
- AB, AC, BC만 확인하면 같은 눈이 무엇인지와 몇 개인지 알 수 있음
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.valueOf(st.nextToken());
        int B = Integer.valueOf(st.nextToken());
        int C = Integer.valueOf(st.nextToken());

        // AB, AC, BC 만 확인하면 됨
        int duplicateCount = 0;
        int duplicateNumber = 0;
        if (A == B) {
            duplicateCount++;
            duplicateNumber = A;
            if (B == C) {
                duplicateCount++;
            }
        }
        else if (A == C) {
            duplicateNumber = A;
            duplicateCount++;
        }
        else if (B == C) {
            duplicateNumber = B;
            duplicateCount++;
        }

        switch (duplicateCount) {
            // 중복이 없을 때
            case 0:
                int max = A;
                if (B > max) max = B;
                if (C > max) max = C;
                System.out.println(max * 100);
                break;

            // 두 개가 동일할 경우
            case 1:
                System.out.println(1000 + (duplicateNumber * 100));
                break;
            
            // 모두 다 동일한 경우
            case 2:
                System.out.println(10000 + (duplicateNumber * 1000));
                break;
        }
    }
}
```
---
## 체스판 조각 (3004번)
https://www.acmicpc.net/problem/3004

### 풀이방법 1
- 반복문을 이용한 풀이 (내가 푼 방법)
- 체스판을 그려보면 1번 자를때 체스판은 2개가 되고, 3번 자를때 체스판은 6개가 된다. 그리고 4, 5번 자를때는 9, 12가 되는데, 이대로 자르게되면 아래와 같은 규칙이 보인다. 
- `2, 2, 3, 3, 4, 4, 5, 5, 6, 6, ...` 순으로 체스판이 증가한다.
![체스판_조각_3004](./IMG/체스판_조각_3004.jpeg)

```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        int sum = 0;
        int add = 2;
        for(int i=1; i<=N; i++) {
            if (i%2 == 0 && i != 2) {
                add++;
            }

            sum += add;
        }

        System.out.println(sum);
    }
}
```
## 풀이방법 2
- 공식(?)을 이용한 풀이 (다른 사람의 풀이 방법)
- 그림 (풀이방법 1 이미지 참조)을 그려서 살펴보면, 아래와 같은 결론이 나오게 된다.
- 가로를 보면 `N/2+1` 만큼의 칸이 만들어짐을 알 수 있다.
- 세로를 보면 `N-가로+2` 만큼의 칸이 만들어짐을 알 수 있다.
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        int x = N/2 + 1;
        int y = N - x + 2;

        System.out.println(x * y);
    }
}
```
---
## 방학 숙제 (5532번)
https://www.acmicpc.net/problem/5532

### 풀이방법
- 주석으로 대체
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 방학
        int L = Integer.valueOf(br.readLine());
        // 국어 총 페이지 수
        int A = Integer.valueOf(br.readLine());
        // 수학 총 페이지 수
        int B = Integer.valueOf(br.readLine());
        // 하루에 국어 최대 페이지
        int C = Integer.valueOf(br.readLine());
        // 하루에 수학 최대 페이지
        int D = Integer.valueOf(br.readLine());

        int sum = 0;
        // C는 최대 페이지이므로 C보다 작을 수 있음
        // 총 페이지 수를 최대 페이지 수로 나눈 나머지가 있으면
        // 최대 페이지 미만의 페이지가 남아있는 것이므로 하루를 더 해야함
        if (A%C > 0) {
            sum = A/C+1;
        }
        else {
            sum = A/C;
        }

        if (B%D > 0) {
            // sum은 국어를 몇 일동안 푸는지에 대한 결과값이며,
            // B/D+1은 최대 페이지 미만이 남았으므로 하루를 더해줌
            if (sum < B/D+1) {
                // B/D+1 이 sum보다 더 크다면 국어를 푸는 날보다 수학을 푸는 날이 더 많으므로 빼주어야 함
                sum += (B/D+1 - sum);
            }
        }
        else {
            if (sum < B/D) {
                sum += (B/D - sum);
            }
        }

        System.out.println(L - sum);
    }
}
```
## 상근날드 (5543번)
https://www.acmicpc.net/problem/5543

### 풀이방법
- 햄버거와 음료를 변수로 나누어 입력받은 후 각 항목에 대한 최소값 판별

```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] food = new int[3];
        food[0] = Integer.valueOf(br.readLine());
        food[1] = Integer.valueOf(br.readLine());
        food[2] = Integer.valueOf(br.readLine());

        int[] juice = new int[2];
        juice[0] = Integer.valueOf(br.readLine());
        juice[1] = Integer.valueOf(br.readLine());

        int minFood = food[0];
        if (food[1] < minFood)
            minFood = food[1];
        if (food[2] < minFood)
            minFood = food[2];

        int minJuice = juice[0];
        if (juice[1] < minJuice)
            minJuice = juice[1];

        System.out.println(minFood+minJuice-50);
    }
}
```
---
## 타임 카드 (5575번)
https://www.acmicpc.net/problem/5575

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int H = 0, H1 = 0;
        int M = 0, M1 = 0;
        int S = 0, S1 = 0;
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.valueOf(st.nextToken());
            M = Integer.valueOf(st.nextToken());
            S = Integer.valueOf(st.nextToken());
            H1 = Integer.valueOf(st.nextToken());
            M1 = Integer.valueOf(st.nextToken());
            S1 = Integer.valueOf(st.nextToken());

            H1 -= H;
            M1 -= M;
            S1 -= S;

            if (S1 < 0) {
                M1--;
                S1 = 60 + S1;
            }

            if (M1 < 0) {
                H1--;
                M1 = 60 + M1;
            }

            sb.append(H1).append(" ").append(M1).append(" ").append(S1).append("\n");
        }

        System.out.println(sb.toString());
    }
}
```
---
## 시험 점수 (5596번)
https://www.acmicpc.net/problem/5596

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int max = -1;
        int tmp = 0;
        for(int i=0; i<2; i++) {
            st = new StringTokenizer(br.readLine());
            tmp += Integer.valueOf(st.nextToken());
            tmp += Integer.valueOf(st.nextToken());
            tmp += Integer.valueOf(st.nextToken());
            tmp += Integer.valueOf(st.nextToken());

            if (max < tmp) {
                max = tmp;
            }
            tmp = 0;
        }

        System.out.println(max);
    }
}
```
---
## 17배 (5893번)
https://www.acmicpc.net/problem/5893

### 걸림돌
- 주어지는 N이 1000자리인 것을 간과했다. `2^1000`은 long으로도 해결 불가능한 큰 수이다.
- 처음에는 int형으로 제출했으나 틀려서 long으로 변경 후 제출해도 동일하게 틀렸었다.
### 사전지식
- BigInteger 클래스를 통한 2진수 및 10진수 변환 방법
### 풀이방법
- BigInteger 클래스를 통해 2진수를 10진수로 변환 후 17을 곱하고 다시 2진수로 바꾸어 주었다.
```java
import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger b = new BigInteger(br.readLine(), 2);
        b = b.multiply(new BigInteger("17"));

        System.out.println(b.toString(2));
    }
}
```
---
## 평균 점수 (10039번)
https://www.acmicpc.net/problem/10039

### 풀이방법
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int tmp = 0;
        for(int i=0; i<5; i++) {
            tmp = Integer.parseInt(br.readLine());
            if (tmp < 40) {
                tmp = 40;
            }
            sum += tmp;
        }

        System.out.println(sum / 5);
    }
}
```
---
## 삼각형 외우기 (10101번)
https://www.acmicpc.net/problem/10101

### 걸림돌
- 조건 중 `세 각의 크기가 모두 60이면, Equilateral` 조건을 세 각의 합이 60이면으로 잘못 이해해서 틀렸었다.

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        if (A == 60 && B == 60 && C == 60) {
            bw.write("Equilateral");
        }
        else if (A+B+C != 180) {
            bw.write("Error");
        }
        else if (A == B || A == C || B == C) {
            bw.write("Isosceles");
        }
        else {
            bw.write("Scalene");
        }

        bw.flush();
    }
}
```
---
## 과자 (10156번)
https://www.acmicpc.net/problem/10156

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.println((K * N - M < 0)? 0 : (K * N - M));
    }
}
```
---
## 전자레인지 (10162번)
https://www.acmicpc.net/problem/10162

### 풀이방법
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        if (T%10 > 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(T/(5*60) + " " + T%(5*60)/60 + " " + T%(5*60)%60/10);
    }
}
```
---
## 쿠폰 (10179번)
https://www.acmicpc.net/problem/10179

## 걸림돌
- 문제를 자세히 읽지 않아 출력 시 맨 앞에 $를 붙여야 하는것을 간과했다.

## 사진지식
- Java를 이용한 소수점 표현 방법
- `String.format` 메소드를 이용한 방법 `String.format("%.2f", a)`
- 결과값에 `10^자리수` 만큼 곱한 후 round 메소드를 이용해 반올림하고 다시 `10^자리수` 만큼 나누기
- 단, round 메소드를 이용했을 때 12.00이 정답이라면 12.0 으로 출력되므로 String.format 이용

### 풀이방법
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        double dollar = 0;
        for(int i=0; i<N; i++) {
            dollar = Double.parseDouble(br.readLine());
            sb.append(String.format("$" + "%.2f", dollar*0.8)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
```
---
## 수도요금 (10707번)
https://www.acmicpc.net/problem/10707

### 풀이방법
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        int X = P * A;
        int Y = B;

        if (P > C) {
            Y += (P - C)*D;
        }

        System.out.println((X>Y)? Y : X);
    }
}
```
---
## 특별한 날 (10768번)
https://www.acmicpc.net/problem/10768

### 풀이방법
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());

        if (month == 2 && day == 18) {
            System.out.println("Special");
            return;
        }

        if (month < 2) {
            System.out.println("Before");
        }
        else {
            if (month == 2 && day < 18) {
                System.out.println("Before");
            }
            else {
                System.out.println("After");
            }
        }
    }
}
```
---
## 10부제 (10797번)
### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int day = Integer.parseInt(br.readLine());

        int count = 0;
        int tmp = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<5; i++) {
            tmp = Integer.parseInt(st.nextToken());
            if (tmp == day) {
                count++;
            }
        }

        System.out.println(count);
    }
}
```
---
## 한글 (11282번)
https://www.acmicpc.net/problem/11282

### 풀이방법
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println((char)(N + '가' - 1));
    }
}
```
---
## 파일 옮기기 (11943번)
https://www.acmicpc.net/problem/11943

### 풀이방법
- A와 D를 더한 값과 B와 C를 더한 값을 비교
- A를 2번째 바구니로 옮길 경우 D를 1번째 바구니로 옮기고 B를 2번째 바구니로 옮길 경우 C를 1번째 바구니로 옮겨야 하므로 `A+D >= B+C`를 비교해서 더 적은쪽을 출력
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        if (A + D >= B + C) {
            System.out.println(B + C);
        }
        else {
            System.out.println(A + D);
        }
    }
}
```
---
## 과목선택 (11948번)
https://www.acmicpc.net/problem/11948

### 풀이방법
- 삽입정렬을 구현하여 풀이
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] four = new int[4];
        int[] two = new int[2];
        
        for(int i=0; i<4; i++) {
            four[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i=0; i<2; i++) {
            two[i] = Integer.parseInt(br.readLine());
        }
        
        insertionSort(four);
        insertionSort(two);
        
        System.out.println(four[3] + four[2] + four[1] + two[1]);
    }
    
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        int tmp = 0;
        int index = 0;
        for(int i=0; i<n-1; i++) {
            index = i;
            
            for(int j=i+1; j<n; j++) {
                if (arr[index] > arr[j]){
                    index = j;
                }
            }
            
            tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }
    }
}
```
---
## 팀 나누기 (13866번)
https://www.acmicpc.net/problem/13866

### 실수
- 입력의 조건을 제대로 확인하지 않아 필요없는 정렬을 구현해서 제출했었다.
- 조건은 `0 ≤ A ≤ B ≤ C ≤ D ≤ 10^4`인데, A, B, C, D가 오름차순으로 들어온다는 것을 알 수 있다.
### 풀이방법
- 가장 큰 값과 가장 작은 값을 더한 결과와 중간 두 개를 더한 결과를 비교
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] skill = new int[4];
        
        for(int i=0; i<4; i++) {
            skill[i] = Integer.parseInt(st.nextToken());
        }
                
        System.out.println(Math.abs((skill[3] + skill[0]) - (skill[1] + skill[2])));
    }
}
```
---
## 정육각형과 삼각형 (14264번)
https://www.acmicpc.net/problem/14264

### 사전지식
- 피타고라스 정리 `a^2 + b^2 = c^2`
- 삼각형 넓이 구하기 `(w * h) / 2`

### 풀이방법
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double L = Double.parseDouble(br.readLine());
        double a = L/2;
        double b = Math.sqrt(L*L - (a * a));

        System.out.println((2*a*b)/2);
    }
}
```
---
## 전자레인지 (14470번)
https://www.acmicpc.net/problem/14470

### 풀이방법
- 주석참고

```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        int time = 0;
        // 얼어있을 때
        if (A < 0) {
            // 현재 온도 * 얼어있는 고기를 1도 데우는데 걸리는 시간
            // 현재 온도 ~ 0도까지이기 때문
            time += Math.abs(A) * C;
            // 해동 시간
            time += D;
            // 해동이 완료된 상태이므로 현재 온도는 0으로
            A = 0;
        }

        // 얼어있지 않을 때 목표 온도까지 걸리는 시간
        time += (B - Math.abs(A)) * E;

        System.out.println(time);
    }
}
```
---
## 감정이입 (14623번)
https://www.acmicpc.net/problem/14623

### 풀이방법
- 최대 가능한 결과값이 `2^30 * 2^30` 이므로 BigInteger를 이용
```java
import java.math.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger B1 = new BigInteger(br.readLine(), 2);
        BigInteger B2 = new BigInteger(br.readLine(), 2);
        
        B1 = B1.multiply(B2);
        System.out.println(B1.toString(2));
    }
}
```
---
## 사분면 고르기 (14681번)
https://www.acmicpc.net/problem/14681

### 풀이방법
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        
        if (x > 0) {
            if (y > 0) {
                System.out.println(1);
            }
            else {
                System.out.println(4);
            }
        }
        else {
            if (y > 0) {
                System.out.println(2);
            }
            else {
                System.out.println(3);
            }
        }
    }
}
```
---
## 폰 노이만과 파리 (14924번)
https://www.acmicpc.net/problem/14924

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        System.out.println(D/(S*2)*T);
    }
}
```
---
## FA (14935번)
https://www.acmicpc.net/problem/14935

### 걸림돌
- 왜인지 모르겠는데 0은 FA가 아닐거라고 생각하고 풀었었다.
- 어차피 0도 수니까 FA가 되어야한다.

### 풀이방법
- 어떻게 입력받아도 최종 결과는 항상 한자리수이므로 결과값은 항상 FA가 된다.
```java
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        System.out.println("FA");
    }
}
```
---
## 연세대학교 (15680번)
https://www.acmicpc.net/problem/15680

### 풀이방법
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        if (Integer.parseInt(br.readLine()) == 0) {
            System.out.println("YONSEI");
        }
        else {
            System.out.println("Leading the Way to the Future");
        }
    }
}
```
---
## 타일 채우기 4 (15700번)
https://www.acmicpc.net/problem/15700

### 풀이방법
- `10억^2` 은 long의 범위안에 들어감
- 2x1, 1x2 모두 크기가 2가 되므로 N*M 전체 크기에서 2만큼 나누면 됨
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        System.out.println(N*M/2);
    }
}
```
---
## 공백 없는 A+B (15873번)
https://www.acmicpc.net/problem/15873

### 풀이방법
- 숫자가 3자리, 4자리인 경우만 따로 처리
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int len = s.length();

        int sum = 0;
        for(int i=0; i<s.length(); i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }

        if (len == 3) {
            sum -= 1;
            sum += 10;
        }
        else if (len == 4) {
            sum -= 2;
            sum += 20;
        }

        System.out.println(sum);
    }
}
```
---
## 수찬은 마린보이야!! (15921번)
https://www.acmicpc.net/problem/15921

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            System.out.println("divide by zero");
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        double average = 0; // 평균
        double chance = 0; // 확률
        int input = 0;
        for(int i=0; i<N; i++) {
            input = Integer.parseInt(st.nextToken());
            average += input;
            chance += (input * (1/(double)N));
        }

        if (chance == 0) {
            System.out.println("divide by zero");
            return;
        }

        average /= N;

        System.out.println(String.format("%.2f", average/chance));
    }
}
```
---
## CASIO (15963번)
https://www.acmicpc.net/problem/15963

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        if (st.nextToken().equals(st.nextToken())) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}
```
---
## 나이 계산하기 (16199번)
https://www.acmicpc.net/problem/16199

### 풀이방법
- 입력의 조건 중 `입력으로 주어지는 생년월일은 기준 날짜와 같거나 그 이전이다.` 의 조건을 볼 수 있는데 이 뜻은 기준날짜가 생년월일보다 작을 수 없다는 뜻이므로 월, 일로만 계산했다.
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int inputYear = Integer.parseInt(st.nextToken());
        int inputMonth = Integer.parseInt(st.nextToken());
        int inputDay = Integer.parseInt(st.nextToken());
        
        // 기준 날짜가 생년월일보다 작을 수 없음 
        // (입력으로 주어지는 생년월일은 기준 날짜와 같거나 그 이전이다.)
        // 만 나이
        int age = inputYear - year;
        if (inputMonth < month) {
            age--;
        }
        else if (inputMonth == month) {
            if (inputDay < day) {
                age--;
            }
        }
        System.out.println(age);
        
        // 세는 나이
        age = inputYear - year;
        System.out.println(age + 1);
        
        // 연 나이
        age = inputYear - year;
        System.out.println(age);
    }
}
```
---
## 카드 뽑기 (16204번)
https://www.acmicpc.net/problem/16204

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 카드의 총 개수
        int N = Integer.parseInt(st.nextToken());
        // 앞면에 O가 적혀있는 개수
        int M = Integer.parseInt(st.nextToken());
        // 뒷면에 적힌 O의 개수
        int K = Integer.parseInt(st.nextToken());

        int sum = 0;
        sum += (M < K)? M : K;
        sum += ((N-K) < (N-M))? N-K : N-M;

        System.out.println(sum);
    }
}
```
---
## 베시와 데이지 (16431번)
https://www.acmicpc.net/problem/16431

### 사전지식
https://banjjak1.tistory.com/9?category=978276
- 멘하탄 거리
- 유클리드 거리

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int B1 = Integer.parseInt(st.nextToken());
        int B2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int D1 = Integer.parseInt(st.nextToken());
        int D2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int J1 = Integer.parseInt(st.nextToken());
        int J2 = Integer.parseInt(st.nextToken());

        double bessie = (int)Math.sqrt(Math.pow(B2 - J2, 2) + Math.pow(B1 - J1, 2));
        int daisy = Math.abs(D2 - J2) + Math.abs(D1 - J1);

        if (bessie < daisy) {
            System.out.println("bessie");
        }
        else if (bessie > daisy) {
            System.out.println("daisy");
        }
        else {
            System.out.println("tie");
        }
    }
}
```
---
## 운동장 한 바퀴 (16486번)
https://www.acmicpc.net/problem/16486

### 사전지식
- 원둘레 구하기 `(2 * 파이 * 반지름)`

### 풀이방법
```java
import java.io.*;

public class Main {
    private static final double PI = 3.141592;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Double d1 = Double.parseDouble(br.readLine());
        Double d2 = Double.parseDouble(br.readLine());

        System.out.println(d1 * 2 + 2 * PI * d2);
    }
}
```
---
## 수학은 체육과목 입니다 2 (17362번)
https://www.acmicpc.net/problem/17362

### 풀이방법
- 값들을 직접 입력해보면 특정 규칙을 발견할 수 있다.
  ![수학은_체육과목_입니다_2_17362_1](./IMG/수학은_체육과목입니다_2_17362_1.jpeg)
- 엄지손가락 주기로 모든 값을 나눈 나머지를 구하면 아래와 같다.
  ![수학은_체육과목_입니다_2_17362_2](./IMG/수학은_체육과목_입니다_2_17362_2.jpeg)

```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()) % 8;
        switch (n) {
            case 1:
                System.out.println(1);
                break;

            case 2:
            case 0:
                System.out.println(2);
                break;

            case 3:
            case 7:
                System.out.println(3);
                break;

            case 4:
            case 6:
                System.out.println(4);
                break;

            case 5:
                System.out.println(5);
                break;
        }
    }
}
```
---
## 와글와글 숭고한 (17388번)
https://www.acmicpc.net/problem/17388

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        sb.append("Soongsil");
        int min = S;
        if (min > K) {
            sb.delete(0, sb.length());
            sb.append("Korea");
            min = K;
        }
        if (min > H) {
            sb.delete(0, sb.length());
            sb.append("Hanyang");
            min = H;
        }
        
        if (S + K + H >= 100) {
            System.out.println("OK");
        }
        else {
            System.out.println(sb.toString());
        }
    }
}
```
## 헛간 청약 (19698번)
https://www.acmicpc.net/problem/19698

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] cow = new int[4];
        for(int i=0; i<4; i++) {
            cow[i] = Integer.parseInt(st.nextToken());
        }

        int totalCow = (int)(cow[1]/cow[3]) * (int)(cow[2]/cow[3]);
        if (totalCow > cow[0]) {
            System.out.println(cow[0]);
        }
        else {
            System.out.println(totalCow);
        }
    }
}
```
---
## 뉴비의 기준은 뭘까? (19944번)
https://www.acmicpc.net/problem/19944

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        if (M <= 2) {
            System.out.println("NEWBIE!");
        }
        else if (M > 2 && M <= N) {
            System.out.println("OLDBIE!");
        }
        else {
            System.out.println("TLE!");
        }
    }
}
```
---
## Darius님 한타 안 함? (20499번)
https://www.acmicpc.net/problem/20499

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "/");
        
        int K = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        
        if (K + A < D || D == 0) {
            System.out.println("hasu");
        }
        else {
            System.out.println("gosu");
        }
    }
}
```
## 분산처리 (1009번)
## 재풀이 예정
https://www.acmicpc.net/problem/1009

### 걸림돌
- 제곱한 수의 마지막 자리 숫자가 1이면 몇 번을 제곱해도 정답의 마지막 자리 값이 1이 되고, 2일 경우 2, 4, 8, 6, 2, ..., 3일 경우 3, 9, 7, 1, 3, ... 과 같이
반복되는 것을 확인해서 a의 마지막 자리에 b의 마지막자리만큼 제곱한 결과에서 마지막 자리가 정답이 될 것이라고 생각했다.
  <br>ex) 17^3 (4913) => 7^3 (343) => 3
  <br>ex) 15^12 (129746337890625) => 5^2 (25) => 5
- BigInteger 클래스를 이용해 계산하려고 했으나 값이 워낙 커지기 때문에 시간초과가 발생했다.
- 결국 a에 1부터 b까지 계속 곱한 후 10으로 나머지 연산을 수행하여 풀었다.
- 그러나 시간복잡도가 n^2 이라서 그런지 시간이 1320ms 나 걸렸고 다른 문제 푸신 분들은 300ms 내로 풀었다.

### 풀이방법
```java
import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int a = 0;
        int b = 0;
        int result = 1;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            for(int j=1; j<=b; j++) {
                result = (result * a) % 10;
            }

            if (result == 0) {
                sb.append(10).append("\n");
            }
            else {
                sb.append(result).append("\n");
            }
            result = 1;
        }

        System.out.println(sb.toString());
    }
}
```
---
## 직사각형에서 탈출 (1085번)
https://www.acmicpc.net/problem/1085

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int min = x;
        if (x < w - x) {
            min = x;
        }
        else {
            min = w - x;
        }

        if (y < h - y) {
            if (min > y) {
                min = y;
            }
        }
        else {
            if (min > h - y) {
                min = h - y;
            }
        }

        System.out.println(min);
    }
}
```
---
