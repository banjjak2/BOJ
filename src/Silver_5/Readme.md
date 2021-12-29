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
