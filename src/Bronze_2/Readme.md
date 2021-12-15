# 백준 문제풀이 (Bronze 2)

---
## 저항 (1076번)
https://www.acmicpc.net/problem/1076

### 풀이방법
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 10^값 => 곱
        int first = getResistanceValue(br.readLine());
        int second = getResistanceValue(br.readLine());
        int third = getResistanceValue(br.readLine());
        
        System.out.println((long)(first*10 + second) * (long)Math.pow(10, third));
    }
    
    private static int getResistanceValue(String color) {
        switch (color) {
            case "black":
                return 0;
                
            case "brown":
                return 1;
                
            case "red":
                return 2;
                
            case "orange":
                return 3;
                
            case "yellow":
                return 4;
                
            case "green":
                return 5;
                
            case "blue":
                return 6;
                
            case "violet":
                return 7;
                
            case "grey":
                return 8;
                
            default:
                return 9;
        }
    }
}
```
---
## 하얀 칸 (1100번)
https://www.acmicpc.net/problem/1100

### 풀이방법
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        boolean isWhiteCell = true;
        int whiteCount = 0;
        for(int i=0; i<8; i++) {
            sb.append(br.readLine());

            for(int j=0; j<8; j++) {
                if (isWhiteCell) {
                    if (sb.charAt(j) == 'F') {
                        whiteCount++;
                    }
                }

                isWhiteCell = !isWhiteCell;
            }

            isWhiteCell = !isWhiteCell;
            sb.delete(0, sb.length());
        }

        System.out.println(whiteCount);
    }
}
```
---
## 운동 (1173번)
https://www.acmicpc.net/problem/1173

### 풀이방법
1. 현재 맥박이 M보다 커지기 전까지 T 값 더하기
2. 현재 맥박에서 T값이 들어갈 때까지 R값 빼기
3. 뺀 값이 m보다 작으면 현재 맥박은 다시 m으로 변경
4. 1 ~ 3 반복
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        if (m + T > M) {
            System.out.println(-1);
            return;
        }

        int curPulse = m;
        int restTime = 0;
        int exerciseTime = 0;
        while(exerciseTime < N) {
            if (curPulse < m) {
                curPulse = m;
            }

            if (curPulse + T <= M) {
                curPulse += T;
                exerciseTime++;
                continue;
            }

            while(true) {
                if (Math.abs(curPulse - M) < T) {
                    restTime++;
                    curPulse -= R;
                }
                else {
                    break;
                }
            }
        }

        System.out.println(N + restTime);
    }
}
```
## 카드1 (2161번)
https://www.acmicpc.net/problem/2161

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            queue.add(i+1);
        }

        StringBuilder sb = new StringBuilder();
        while(queue.size() != 1) {
            sb.append(queue.remove()).append(" ");
            queue.add(queue.remove());
        }

        sb.append(queue.remove());
        System.out.println(sb.toString());
    }
}
```
---
## 알파벳 개수 (10808번)
https://www.acmicpc.net/problem/10808

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S = br.readLine().toCharArray();
        int[] alphabet = new int[26];

        for(int i=0; i<S.length; i++) {
            alphabet[S[i] - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<alphabet.length; i++) {
            sb.append(alphabet[i]).append(' ');
        }
        System.out.println(sb);
    }
}
```
---
## 문자열 분석 (10820번)
https://www.acmicpc.net/problem/10820

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[4];
        String S = "";
        char chr = ' ';
        StringBuilder sb = new StringBuilder();
        while((S = br.readLine()) != null) {
            for(int i=0; i<S.length(); i++) {
                chr = S.charAt(i);
                if (chr >= 'a' && chr <= 'z') {
                    count[0]++;
                }
                else if (chr >= 'A' && chr <= 'Z') {
                    count[1]++;
                }
                else if (chr >= '0' && chr <= '9') {
                    count[2]++;
                }
                else {
                    count[3]++;
                }
            }

            for(int i=0; i<count.length; i++) {
                sb.append(count[i]).append(' ');
            }
            sb.append('\n');

            count[0] = 0; count[1] = 0; count[2] = 0; count[3] = 0;
        }

        System.out.println(sb);
    }
}
```
---
## 단어 길이 재기 (2743번)
https://www.acmicpc.net/problem/2743

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(br.readLine().length());
        
    }
}
```
---
## 2진수 8진수 (1373번)
https://www.acmicpc.net/problem/1373

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder bin = new StringBuilder(br.readLine());
        if (bin.length() % 3 == 1) {
            bin.insert(0, "00");
        }
        else if (bin.length() % 3 == 2) {
            bin.insert(0, "0");
        }

        StringBuilder sb = new StringBuilder();
        int[] eight = {4, 2, 1};
        int sum = 0;
        for(int i=0; i<bin.length(); i++) {
            if (i % 3 == 0 && i != 0) {
                sb.append(sum);
                sum = 0;
            }

            if (bin.charAt(i) == '1') {
                sum += eight[i % 3];
            }
        }

        sb.append(sum);
        System.out.println(sb);
    }
}
```
---
## 이름 궁합 (15312번)
https://www.acmicpc.net/problem/15312

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] alphabetCount = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        int[] arrayOfAB = new int[A.length() * 2];
        for(int i=0; i<A.length(); i++) {
            arrayOfAB[i * 2] = alphabetCount[A.charAt(i) - 'A'];
            arrayOfAB[(i * 2) + 1] = alphabetCount[B.charAt(i) - 'A'];
        }

        int[] result = solution(arrayOfAB);
        System.out.println(String.valueOf(result[0]) + String.valueOf(result[1]));
    }

    public static int[] solution(int[] arr) {
        int[] result = new int[arr.length - 1];

        for(int i=0; i<arr.length - 1; i++) {
            result[i] = (arr[i] + arr[i + 1]) % 10;
        }
        if (result.length == 2) {
            return result;
        }

        return solution(result);
    }
}
```
## 일곱 난쟁이 (2309번)
https://www.acmicpc.net/problem/2309

### 풀이방법
- 9명 키의 총 합 중에 2명을 뺀 키가 100이 될 경우 일곱 난쟁이가 됨

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] arr = new int[9];
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<9; i++) {
            for(int j=i+1; j<9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    for(int k=0; k<9; k++) {
                        if (k == i || k == j) {
                            continue;
                        }
                        
                        sb.append(arr[k]).append('\n');
                    }
                    
                    System.out.println(sb);
                    return;
                }
            }
        }
    }
}
```
---
