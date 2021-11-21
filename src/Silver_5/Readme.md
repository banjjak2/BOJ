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
