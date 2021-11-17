# 백준 문제풀이 (Gold 4)

---

## 오큰수 (17298번)
https://www.acmicpc.net/problem/17298

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[N];
        int[] result = new int[N];
        
        int index = 0;
        while(st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }
        
        stack.push(0);
        for(int i=1; i<N; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }
            
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(result[i]).append(' ');
        }
        
        System.out.println(sb);
    }
}
```
---