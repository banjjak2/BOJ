# 백준 문제풀이 (Silver 1)

---
## 물병 (1052번)
### 재풀이 예정
- 성능 최적화 필요

https://www.acmicpc.net/problem/1052

### 풀이방법
```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int oneCountFromBinary = 0;
        int tmp = N;
        do {
            oneCountFromBinary = getOneCountFromBinary(N++);
            if (oneCountFromBinary <= K) {
                break;
            }
        }while(oneCountFromBinary > K);

        System.out.println(N - tmp - 1);
    }
    
    // 1의 개수가 현재 물이있는 통의 개수가 됨
    // 13 -> 1101 -> 3개의 물통
    // 따라서 2진수로 변환할 때 1의 총 개수를 구함
    private static int getOneCountFromBinary(int num) {
        int oneCount = 0;
        while(num != 0) {
            if (num % 2 == 1) {
                oneCount++;
            }
            num /= 2;
        }

        return oneCount;
    }
}
```
---
