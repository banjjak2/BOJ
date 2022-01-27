# 백준 문제풀이 (Silver 4)

---

## 킹 (1063번)
https://www.acmicpc.net/problem/1063

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 인덱스를 이용해 A~H를 표현하기 위함
        char[] widthPos = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        String tmp = st.nextToken();
        // 현재 킹의 위치
        int[] kingPos = { tmp.charAt(0) - 'A' + 1, tmp.charAt(1) - '0' };
        tmp = st.nextToken();
        // 현재 돌의 위치
        int[] stonePos = { tmp.charAt(0) - 'A' + 1, tmp.charAt(1) - '0' };

        int N = Integer.parseInt(st.nextToken());

        String command = "";
        for(int i=0; i<N; i++) {
            command = br.readLine();

            calculatePos(command, kingPos, stonePos);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(widthPos[kingPos[0]]).append((char)(kingPos[1] + '0')).append("\n");
        sb.append(widthPos[stonePos[0]]).append((char)(stonePos[1] + '0'));

        System.out.println(sb);
    }

    private static void calculatePos(String command, int[] kingPos, int[] stonePos) {
        int widthMoveCount = 0;
        int heightMoveCount = 0;
        // R, L, B, T의 조합으로만 이루어져 있으므로
        for(int i=0; i<command.length(); i++) {
            switch (command.charAt(i)) {
                case 'R':
                    widthMoveCount = 1;
                    break;
                case 'L':
                    widthMoveCount = -1;
                    break;
                case 'B':
                    heightMoveCount = -1;
                    break;
                case 'T':
                    heightMoveCount = 1;
                    break;
            }
        }

        // 8x8 범위에서 벗어났는지 확인
        if (!checkArea(kingPos, widthMoveCount, heightMoveCount)) {
            return;
        }

        // 현재 킹의 위치에 이동횟수를 더한 위치값이 돌의 위치값이라면
        if (
                kingPos[0] + widthMoveCount == stonePos[0]
                && kingPos[1] + heightMoveCount == stonePos[1]
        )
        {
            // 돌의 위치가 8x8에서 벗어났는지 확인
            if (!checkArea(stonePos, widthMoveCount, heightMoveCount)) {
                return;
            }

            // 벗어나지 않았다면 둘 다 동일한 방향으로 밀기
            kingPos[0] += widthMoveCount;
            kingPos[1] += heightMoveCount;

            stonePos[0] += widthMoveCount;
            stonePos[1] += heightMoveCount;
        }
        // 현재 킹의 위치에 이동횟수를 더한 위치값이 돌의 위치와 같지 않다면 이동 가능하므로 더해줌
        else {
            kingPos[0] += widthMoveCount;
            kingPos[1] += heightMoveCount;
        }
    }

    // 8x8 배열에서 벗어났는지 확인
    private static boolean checkArea(int[] arr, int width, int height) {
        if (
            arr[0] + width > 8
            || arr[0] + width < 1
            || arr[1] + height > 8
            || arr[1] + height < 1
        )
        {
            return false;
        }

        return true;
    }
}
```
---
## 문자열 (1120번)
https://www.acmicpc.net/problem/1120

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {

    /**
     * 
     * A B C D E
     * A B C
     * 인 경우    
     * 
     * A B C D E
     * A B C ? ?
     * 
     * A B C D E
     * ? A B C ?
     * 
     * A B C D E
     * ? ? A B C
     * 
     * 로 비교
     * 
     */
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int lenA = A.length();
        int lenB = B.length();

        int min = 100;
        int compareCount = 0;
        int curIdxOfA = 0;
        for(int i=0; i<=lenB-lenA; i++) {
            curIdxOfA = 0;
            compareCount = 0;
            for(int j=i; j<lenB; j++) {
                if (curIdxOfA >= lenA) {
                    break;
                }
                else if (B.charAt(j) != A.charAt(curIdxOfA)) {
                    compareCount++;
                }

                curIdxOfA++;
            }

            min = Math.min(min, compareCount);
        }

        System.out.println(min);
    }
}
```
---
## 스택 (10828번)
https://www.acmicpc.net/problem/10828

### 사전지식
- 스택 (Stack)

### 풀이방법
```java
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        stack.init(N);

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while(--N >= 0) {
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
//                    bw.write(stack.pop() + "\n");
                    sb.append(stack.pop()).append("\n");
                    break;

                case "size":
//                    bw.write(stack.size() + "\n");
                    sb.append(stack.size()).append("\n");
                    break;

                case "empty":
//                    bw.write(stack.empty() + "\n");
                    sb.append(stack.empty()).append("\n");
                    break;

                case "top":
//                    bw.write(stack.top() + "\n");
                    sb.append(stack.top()).append("\n");
                    break;
            }
        }

        System.out.println(sb.toString());
    }

    public static class Stack {
        int[] arr = null;
        int size = 0;
        public void init(int capacity) {
            arr = new int[capacity];
        }

        public int empty() {
            if (size == 0) {
                return 1;
            }

            return 0;
        }

        public int size() {
            return size;
        }

        public void push(int x) {
            arr[size++] = x;
        }

        public int pop() {
            if (empty() == 1) {
                return -1;
            }

            return arr[--size];
        }

        public int top() {
            if (empty() == 1) {
                return -1;
            }

            return arr[size-1];
        }
    }
}
```
---
## 괄호 (9012번)
https://www.acmicpc.net/problem/9012

### 참고
- 스택을 이용하지 않고도 풀 수 있음
- `(`와 `)`는 짝이 맞아야 함
- 문자열을 확인할 때 `(`를 만나면 +1, `)`을 만나면 -1 과정을 반복하다가
음수가 나오면 `(` 문자는 없는데 `)` 문자가 나온 것이므로 `NO`로 출력

### 풀이방법
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        int T = Integer.parseInt(br.readLine());
        String str = null;
        char chr = ' ';
        StringBuilder sb = new StringBuilder();
        boolean fail = false;
        while(T-- > 0) {
            str = br.readLine();
            stack.clear();
            for(int i=0; i<str.length(); i++) {
                chr = str.charAt(i);

                if (chr == ')') {
                    if (stack.empty()) {
                        sb.append("NO").append('\n');
                        fail = true;
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
                else {
                    stack.push(chr);
                }
            }

            if (!fail && stack.empty()) {
                sb.append("YES").append('\n');
            }
            else if (!stack.empty()) {
                sb.append("NO").append('\n');
            }
            fail = false;
        }

        System.out.println(sb.toString());
    }
}
```
---
## 큐 (10845번)
https://www.acmicpc.net/problem/10845

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Queue queue = new Queue();
        StringBuilder sb = new StringBuilder();

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    sb.append(queue.pop()).append('\n');
                    break;

                case "size":
                    sb.append(queue.size()).append('\n');
                    break;

                case "empty":
                    sb.append(queue.empty()).append('\n');
                    break;

                case "front":
                    sb.append(queue.front()).append('\n');
                    break;

                case "back":
                    sb.append(queue.back()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }

    public static class Queue {
        List<Integer> list = new LinkedList<>();

        public int empty() {
            if (list.size() == 0) {
                return 1;
            }

            return 0;
        }

        public void push(int x) {
            list.add(x);
        }

        public int pop() {
            if (empty() == 1) {
                return -1;
            }

            int popData = list.get(0);
            list.remove(0);
            return popData;
        }

        public int size() {
            return list.size();
        }

        public int front() {
            if (empty() == 1) {
                return -1;
            }

            return list.get(0);
        }

        public int back() {
            if (empty() == 1) {
                return -1;
            }

            return list.get(list.size() - 1);
        }
    }
}
```
---
## 덱 (10866번)
https://www.acmicpc.net/problem/10866

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Deque deque = new Deque();
        StringBuilder sb = new StringBuilder();

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()) {
                case "push_front":
                    deque.push_front(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    deque.push_back(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    sb.append(deque.pop_front()).append('\n');
                    break;

                case "pop_back":
                    sb.append(deque.pop_back()).append('\n');
                    break;

                case "size":
                    sb.append(deque.size()).append('\n');
                    break;

                case "empty":
                    sb.append(deque.empty()).append('\n');
                    break;

                case "front":
                    sb.append(deque.front()).append('\n');
                    break;

                case "back":
                    sb.append(deque.back()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }

    public static class Deque {
        LinkedList<Integer> list = new LinkedList<>();

        public int empty() {
            if (list.size() == 0) {
                return 1;
            }

            return 0;
        }

        public void push_front(int x) {
            list.addFirst(x);
        }

        public void push_back(int x) {
            list.addLast(x);
        }

        public int pop_front() {
            if (empty() == 1) {
                return -1;
            }

            return list.removeFirst();
        }

        public int pop_back() {
            if (empty() == 1) {
                return -1;
            }

            return list.removeLast();
        }

        public int size() {
            return list.size();
        }

        public int front() {
            if (empty() == 1) {
                return -1;
            }

            return list.peekFirst();
        }

        public int back() {
            if (empty() == 1) {
                return -1;
            }

            return list.peekLast();
        }
    }
}
```
---
## 접미사 배열 (11656번)
https://www.acmicpc.net/problem/11656

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        List<String> list = new ArrayList<>();

        int len = sb.length();
        list.add(sb.toString());
        for(int i=0; i<len - 1; i++) {
            list.add(sb.deleteCharAt(0).toString());
        }

        Collections.sort(list);
        sb.delete(0, sb.length());
        for(String s : list) {
            sb.append(s).append('\n');
        }

        System.out.println(sb);
    }
}
```
---
## 소수 찾기 (1978번)
https://www.acmicpc.net/problem/1978

### 풀이방법 (1)
- 루트를 이용한 풀이

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = 0;
        int count = 0;
        while(st.hasMoreTokens()) {
            num = Integer.parseInt(st.nextToken());
            if (isPrime(num)) {
                count++;
            }
        }

        System.out.println(count);
    }
    
    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        
        for(int i=2; i*i<=num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
```

### 풀이방법 (2)
- 에라토스테네스의 체 이용한 풀이
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] checkedPrime = erathosthenes(1000);
        int num = 0;

        int count = 0;
        while(st.hasMoreTokens()) {
            num = Integer.parseInt(st.nextToken());
            if (!checkedPrime[num]) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean[] erathosthenes(int maxNum) {
        int[] prime = new int[maxNum];
        boolean[] checkedPrime = new boolean[maxNum + 1];
        checkedPrime[0] = true; // 0
        checkedPrime[1] = true; // 1 은 소수가 아니므로

        for(int i=0; i<maxNum; i++) {
            prime[i] = (i+1);
        }

        for(int i=2; i<=maxNum; i++) {
            if (!checkedPrime[i]) {
                for(int j=i*i; j<=maxNum; j+=i) {
                    checkedPrime[j] = true;
                }
            }
        }

        return checkedPrime;
    }
}
```
---
## 팩토리얼 0의 개수 (1676번)
https://www.acmicpc.net/problem/1676

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // 뒤 숫자가 0이 나오려면 2*5 형태가 있어야 함
        // 5의 개수는 2의 개수보다 작음 (2는 N까지의 모든 짝수이고 5는 5의 배수일 뿐이니까)
        // 25, 50, 75, 100는 5가 1번 더 들어감 (25 = 5 * 5, 50 = 5 * 5 * 2, ...)
        // 따라서, 5의 거듭제곱만큼 계속 나누면 됨
        int sum = 0;
        for(int i=5; i<=N; i*=5) {
            sum += (N / i);
        }

        System.out.println(sum);
    }
}
```
---
## -2진수 (2089번)
https://www.acmicpc.net/problem/2089

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        StringBuilder sb = new StringBuilder();
        long remainder = 0; // 나머지
        long quotient = 0; // 몫
        while(N != 0) {
            quotient = N / -2;
            remainder = N % -2;
            // 나머지가 음수이면 몫을 하나 증가 또는 감소
            // 나머지를 양수로 맞추기 위함
            if (remainder < 0) {
                if (quotient < 0) {
                    quotient--;
                }
                else {
                    quotient++;
                }

                // "어떤 수 = 몫 * 나누는 수 + 나머지" 이므로
                // "나머지 = 어떤 수 - 몫 * 나누는 수" 가 됨
                remainder = N - (quotient * -2);
            }

            N = quotient;
            sb.append(remainder);
        }

        if (sb.length() == 0) {
            System.out.println(0);
        }
        else {
            System.out.println(sb.reverse());
        }
    }
}
```
---
## 돌 게임 2 (9656번)
https://www.acmicpc.net/problem/9656

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        System.out.println((N%2)==0? "SK" : "CY");
    }
}
```
---
## 회전하는 큐 (1021번)
https://www.acmicpc.net/problem/1021

### 풀이방법
- `Queue`를 이용하면 중간에 데이터가 무엇이 있는지, 마지막 데이터가 무엇인지 알 수 없으므로 `LinkedList`를 이용하여 회전하는 큐를 구현
- 첫번째 위치에서 찾고자하는 위치를 반환하는 `leftCount`, `rightCount` 함수 구현
- 왼쪽/오른쪽으로 이동하는 함수 구현
- 더 가까운 쪽에서 이동하도록 구현

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            queue.add(i);
        }

        LinkedList<Integer> removeData = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            removeData.add(Integer.parseInt(st.nextToken()));
        }

        int lCount = 0;
        int rCount = 0;
        int step2 = 0;
        int step3 = 0;
        while(!removeData.isEmpty()) {
            lCount = leftCount(queue, removeData.peekFirst());
            rCount = rightCount(queue, removeData.peekFirst());
            removeData.poll();
            if (lCount < rCount) {
                while(lCount-- > 0) {
                    step2++;
                    left(queue);
                }
                queue.poll();
            }
            else {
                while(rCount-- > 0) {
                    step3++;
                    right(queue);
                }
                queue.poll();
            }
        }

        System.out.println(step2 + step3);
    }

    private static void left(LinkedList<Integer> queue) {
        queue.addLast(queue.removeFirst());
    }

    private static void right(LinkedList<Integer> queue) {
        queue.addFirst(queue.removeLast());
    }

    private static int leftCount(LinkedList<Integer> queue, int target) {
        for(int i=0; i<queue.size(); i++) {
            if (queue.get(i) == target) {
                return i;
            }
        }
        return -1;
    }

    private static int rightCount(LinkedList<Integer> queue, int target) {
        for(int i=queue.size()-1; i>=0; i--) {
            if (queue.get(i) == target) {
                return queue.size() - i;
            }
        }
        return -1;
    }
}
```
---

## 제로 (10773번)
https://www.acmicpc.net/problem/10773

### 풀이방법
- 스택을 이용해 입력값이 `0`인 경우 `pop`을 하고 `0`이 아니라면 해당 값을 `push`한다.
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static class Stack {
        int pos = 0;
        int countOfData = 0;
        int[] array = null;

        public Stack(int size) {
            array = new int[size];
        }

        public int pop() {
            countOfData--;
            int rData = array[--pos];
            array[pos] = 0;
            return rData;
        }

        public void push(int c) {
            array[pos++] = c;
            countOfData++;
        }

        public boolean isEmpty() {
            return (countOfData == 0);
        }

        public int size() {
            return countOfData;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack stack = new Stack(K);
        int value = 0;
        int sum = 0;

        while (K-- > 0) {
            value = Integer.parseInt(br.readLine());
            if (value == 0 && !stack.isEmpty()) sum -= stack.pop();
            else {
                sum += value;
                stack.push(value);
            }
        }

        System.out.println(sum);
    }
}
```
---
