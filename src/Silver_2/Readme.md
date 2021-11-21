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