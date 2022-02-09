# 백준 문제풀이 (Silver 5)

---

## 요세푸스 (1158번)
https://www.acmicpc.net/problem/1158

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<N; i++) {
            queue.add(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        while(N-- > 0) {
            for(int i=0; i<K - 1; i++) {
                queue.offer(queue.poll());
            }

            sb.append(queue.poll());
            if (N != 0) {
                sb.append(", ");
            }
        }
        sb.append('>');

        System.out.println(sb);
    }
}
```
---
## 최대공약수와 최소공배수 (2609번)
https://www.acmicpc.net/problem/2609

### 사전지식
- 유클리드 호제법
- gcd = 최대공약수
- lcm = 최소공배수
- gcd(a, b) = gcd(b, r), 단, r은 a%b
- lcm = (a*b) / gcd(a, b)

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = gcd(a, b);
        int lcm = lcm(gcd, a*b);

        System.out.println(String.format("%d\n%d", gcd, lcm));
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        else {
            return gcd(b, a%b);
        }
    }

    public static int lcm(int gcd, int ab) {
        return ab / gcd;
    }
}
```
---
## 최소공배수 (1934번)
https://www.acmicpc.net/problem/1934

### 풀이방법
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
        int a, b;

        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(lcm(gcd(a, b), a*b)).append('\n');
        }

        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        else {
            return gcd(b, a%b);
        }
    }

    public static int lcm(int gcd, int ab) {
        return ab / gcd;
    }
}
```
---
## 다리 놓기 (1010번)
https://www.acmicpc.net/problem/1010

### 사전지식
- 동적계획법 (다이나믹 프로그래밍, DP)

### 풀이방법
- 1~30까지의 모든 경우의 수를 조합
- memoization을 이용해 풀이

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        int eastCount = 0;
        int westCount = 0;

        for(int r=1; r<=30; r++) {
            for(int n=r; n<=30; n++) {
                dp[n][r] = combination(n, r);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            westCount = Integer.parseInt(st.nextToken());
            eastCount = Integer.parseInt(st.nextToken());
            sb.append(dp[eastCount][westCount]).append('\n');
        }

        System.out.println(sb);
    }

    public static int combination(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        }

        return combination(n-1, r-1) + combination(n-1, r);
    }
}
```
---
## 거스름돈 (14916번)
https://www.acmicpc.net/problem/14916

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());

        int countOfFive = 0;
        int countOfTwo = 0;

        while(money != 0) {
            if (money % 5 == 0) {
                countOfFive = money / 5;
                break;
            }
            else if (money < 2) {
                System.out.println(-1);
                return;
            }
            else {
                money -= 2;
                countOfTwo++;
            }
        }

        System.out.println(countOfFive + countOfTwo);
    }
}
```
---
## 파스칼 삼각형 (15489번)
https://www.acmicpc.net/problem/15489

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] dp = new int[R+W][R+W];
        for(int i=1; i<=R+W-1; i++) {
            dp[i][1] = 1; // 줄의 첫번째 데이터는 1이 되어야 함
            for(int j=1; j<=i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
            dp[i][i] = 1; // 줄의 마지막 데이터는 1이 되어야 함
        }

        int sum = 0;
        int sumCount = C;
        for(int i=R; i<=R+W-1; i++) {
            for(int j=C; j<=sumCount; j++) {
                sum += dp[i][j];
            }
            sumCount++;
        }

        System.out.println(sum);
    }
}
```
---
## 날짜 계산 (1476번)
https://www.acmicpc.net/problem/1476

### 풀이방법
- E, S, M의 값이 범위에서 벗어나면 1로 초기화해서 정답이 나올 때까지 반복함
- 나머지를 이용해서도 구할 수 있다고 함

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] esm = new int[3];
        int[] tmpesm = new int[3];
        for(int i=0; i<3; i++) {
            esm[i] = Integer.parseInt(st.nextToken());
            tmpesm[i] = 1;
        }
        
        int years = 1;
        while(true) {
            if (tmpesm[0] == esm[0] && tmpesm[1] == esm[1] && tmpesm[2] == esm[2]) {
                break;
            }
            
            if (++tmpesm[0] > 15) {
                tmpesm[0] = 1;
            }
            if (++tmpesm[1] > 28) {
                tmpesm[1] = 1;
            }
            if (++tmpesm[2] > 19) {
                tmpesm[2] = 1;
            }
            years++;
        }
        
        System.out.println(years);
    }
}
```
---
## 약수 (1037번)
https://www.acmicpc.net/problem/1037

### 풀이방법
- 문제 내용에서 어떤 수 N의 진짜 약수가 모두 주어진다 하였으므로 정렬 후 맨 처음과 마지막을 곱하면 N을 구할 수 있다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        System.out.println(arr[0] * arr[N-1]);
    }
}
```
---

## 방 번호 (1475번)
https://www.acmicpc.net/problem/1475

### 풀이방법
- 0~9 배열을 1로 초기화
- 입력값을 하나씩 가져와 숫자로 변환 후 숫자에 해당하는 배열에 1뺌
    - 6, 9인 경우 6 또는 9의 개수를 1뺌
    - 배열의 숫자가 0인 경우 한세트가 더 필요하므로 0~9까지 각각 1씩 더한 후 해당 숫자를 1뺌
    
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String roomNumber = st.nextToken();

        int setCount = 1;
        int[] numberCount = new int[10];
        for(int i=0; i<=9; i++) {
            numberCount[i] = 1;
        }

        int number = 0;
        for(int i=0; i<roomNumber.length(); i++) {
            number = roomNumber.charAt(i) - '0';
            if (numberCount[number] == 0) {
                if (number == 6 && numberCount[9] != 0) number = 9;
                else if (number == 9 && numberCount[6] != 0) number = 6;
                else {
                    for (int j = 0; j <= 9; j++) numberCount[j] += 1;
                    setCount++;
                }
            }
            numberCount[number] -= 1;
        }

        System.out.println(setCount);
    }
}
```
---

## 재귀함수가 뭔가요? (17478번)
https://www.acmicpc.net/problem/17478

### 헤맸던 부분
1. '-' 문자가 아니라 '_' 문자였다.
2. 긴 문장에서도 각 줄마다 '____'를 넣어줘야하는데 그 부분을 놓쳤다.

- 위 둘 다 문제를 제대로 읽지않아 발생한 문제...

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    /*

    마지막에서만 "재귀함수는 자기 자신을 호출하는 함수라네" 문자열 출력

     */

    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append('\n');
        recursive(n, 0);

        System.out.println(sb);
    }

    private static void recursive(int n, int under) {
        if (n == 0) {
            repeat(under);
            sb.append("\"재귀함수가 뭔가요?\"").append('\n');
            repeat(under);
            sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append('\n');
            repeat(under);
            sb.append("라고 답변하였지.").append('\n');
            return;
        }

        repeat(under);
        sb.append("\"재귀함수가 뭔가요?\"").append('\n');
        repeat(under);
        sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
        repeat(under);
        sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
        repeat(under);
        sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
        recursive(n-1, under + 1);
        repeat(under);
        sb.append("라고 답변하였지.").append('\n');
    }

    private static void repeat(int under) {
        for(int i=0; i<under; i++) {
            sb.append("____");
        }
    }
}
```
---
