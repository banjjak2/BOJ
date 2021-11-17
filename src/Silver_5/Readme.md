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
