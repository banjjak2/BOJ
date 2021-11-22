# 백준 문제풀이 (Silver 2)

---
## 소수 구하기 (1929번)
https://www.acmicpc.net/problem/1929

### 사전지식
- 에라토스테네스의 체
- 소수의 배수를 지우고 지워지지 않은 수들은 모두 소수가 됨

### 풀이방법
- erathosthenes에서 i*2를 한 이유는 M, N의 값이 백만이기 때문
  - 백만 * 백만 = int 범위를 벗어남
- 배수를 지우면 되는 것이기 때문에 *2해도 무방

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] checkedPrime = erathosthenes(N);

        StringBuilder sb = new StringBuilder();
        for(int i=M; i<=N; i++) {
            if (!checkedPrime[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }

    public static boolean[] erathosthenes(int maxNum) {
        // 지워졌다면 true
        boolean[] checkedPrime = new boolean[maxNum + 1];
        checkedPrime[0] = true;
        checkedPrime[1] = true;

        for(int i=2; i<=maxNum; i++) {
            if (!checkedPrime[i]) {
                for(int j=i*2; j<=maxNum; j+=i) {
                    checkedPrime[j] = true;
                }
            }
        }

        return checkedPrime;
    }
}
```
---
## 조합 0의 개수 (2004번)
https://www.acmicpc.net/problem/2004

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
        
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        
        long two = 0;
        long five = 0;
        // nCm = n!/(m! * (n-m)!)
        
        // n의 2, 5의 개수
        for(long i=2; i<=n; i*=2) {
            two += (n/i);
        }
        for(long i=5; i<=n; i*=5) {
            five += (n/i);
        }
        
        // m의 2, 5의 개수
        for(long i=2; i<=n; i*=2) {
            two -= (m/i);
        }
        for(long i=5; i<=n; i*=5) {
            five -= (m/i);
        }
        
        // m-n의 2, 5의 개수
        for(long i=2; i<=(n-m); i*=2) {
            two -= ((n-m)/i);
        }
        for(long i=5; i<=(n-m); i*=5) {
            five -= ((n-m)/i);
        }
        
        System.out.println(Math.min(two, five));
    }
}
```
---
## 골드바흐 파티션 (17103번)
https://www.acmicpc.net/problem/17103

### 사전지식
- 에라토스테네스의 체

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = 0;

        boolean[] checkedPrime = eratosthenes(1000000);
        int sumOfGoldbachCount = 0;
        int restPrime = 0;
        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());

            for(int i=2; i<checkedPrime.length; i++) {
                if (!checkedPrime[i]) {
                    restPrime = N - i;
                    // i를 제외한 또다른 소수 restPrime이 i보다 크면 역으로 돌게 되므로 break
                    // 10의 경우
                    // i 3, restPrime 7
                    // i 5, restPrime 5
                    // i 7, restPrime 3 => 이런 경우는 "두 소수의 순서만 다른 것은 같은 파티션이다." 조건에 맞지 않으므로 종료
                    if (restPrime < i) {
                        break;
                    }
                    else if (!checkedPrime[restPrime]) {
                        sumOfGoldbachCount++;
                    }
                }
            }

            sb.append(sumOfGoldbachCount).append('\n');
            sumOfGoldbachCount = 0;
        }

        System.out.println(sb);
    }

    public static boolean[] eratosthenes(int maxNum) {
        // true는 소수가 아닌 것들
        boolean[] checkedPrime = new boolean[maxNum + 1];
        checkedPrime[0] = true; // 0
        checkedPrime[1] = true; // 1 은 소수가 아님

        for(int i=2; i<=maxNum; i++) {
            if (!checkedPrime[i]) {
                for(int j=i*2; j<=maxNum; j+=i) {
                    checkedPrime[j] = true;
                }
            }
        }

        return checkedPrime;
    }
}
```
---
