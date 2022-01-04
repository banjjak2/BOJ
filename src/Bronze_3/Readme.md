# 백준 문제풀이 (Bronze 3)

---

## 플러그 (2010번)
https://www.acmicpc.net/problem/2010

### 풀이방법
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int P = 0;
        int sum = 0;
        for(int i=0; i<N - 1; i++) {
            P = Integer.parseInt(br.readLine());
            sum += (P - 1);
        }
        P = Integer.parseInt(br.readLine());
        sum += P;

        System.out.println(sum);
    }
}
```
---
## 지수연산 (2052번)
https://www.acmicpc.net/problem/2052

## 사전지식
- BigDecimal 사용법
- 지수표현은 BigDecimal의 `toPlainString()` 을 이용해 소수점을 모두 표현할 수 있다.

### 풀이방법
```java
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        BigDecimal result = new BigDecimal(2);
        result = result.pow(N);

        result = BigDecimal.valueOf(1).divide(result);
        System.out.println(result.toPlainString());
    }
}
```
---
## 초콜릿 자르기 (2163번)
https://www.acmicpc.net/problem/2163

### 풀이방법
- 초콜릿의 개수가 아닌 쪼갠 횟수를 반환해야 하므로 -1 해주어야 함

```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        System.out.println(N * M - 1);
    }
}
```
---
## 시그마 (2355번)
https://www.acmicpc.net/problem/2355

### 주의사항
- A, B의 대소관계가 명확하지 않음 (B가 A보다 작을수도 있음)
- 중간 계산 값들이 int보다 클 수도 있음

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long max = 0;
        long min = 0;

        max = (A<B)? B : A;
        min = (A<B)? A : B;

        System.out.println((((max - min) + 1) * (max + min))/2);
    }
}
```
---
## 별 찍기 4 (2441번)
https://www.acmicpc.net/problem/2441

### 풀이방법
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=N-i; j>0; j--) {
                sb.append("*");
            }
            sb.append("\n");
            for(int j=0; j<=i; j++) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
```
---
## 별 찍기 5 (2442번)
https://www.acmicpc.net/problem/2442

### 풀이방법
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=N-i-1; j>0; j--) {
                sb.append(" ");
            }
            for(int j=0; j<((i+1)*2)-1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
```
---
## 별 찍기 6 (2443번)
https://www.acmicpc.net/problem/2443

### 풀이방법
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(" ".repeat(i)).append("*".repeat((N*2)-(i*2)-1)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
```
---
## 별 찍기 7 (2444번)
https://www.acmicpc.net/problem/2444

### 풀이방법
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            sb.append(" ".repeat(N-i-1)).append("*".repeat((i+1)*2-1)).append("\n");
        }
        
        for(int i=0; i<N-1; i++) {
            sb.append(" ".repeat(i+1)).append("*".repeat(((N-1)*2)-(i*2)-1)).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}
```
---
## Number Game (1975번)
https://www.acmicpc.net/problem/1975

### 풀이방법
- N을 초과한 진법은 항상 N을 반환하므로 2~N까지의 진법만 계산한다.
- 2진법부터 계산하며 첫번째 나눈 나머지값이 0이 아니면 바로 반복문을 빠져나오고 0이라면 계속 나머지를 구한다.

```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int sum = 0;
        int N = 0;
        int tmp = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
            tmp = N;
            for(int j=2; j<=N; j++) {
                while(tmp != 0) {
                    if (tmp%j == 0) {
                        tmp /= j;
                        sum++;
                    }
                    else {
                        break;
                    }
                }

                tmp = N;
            }
            sb.append(sum).append("\n");
            sum = 0;
        }

        System.out.println(sb.toString());
    }
}
```
---
## 오각형, 오각형, 오각형... (1964번)
https://www.acmicpc.net/problem/1964

### 풀이방법
- 각 단계마다 변의 점 개수가 하나씩 증가한다.
- 한 변의 점 개수를 제곱하면 아래 그림의 빨간 네모칸 안의 점 개수가 구해진다.
  ![오각형](./IMG/오각형_1964.jpeg)
- 빨간 네모칸 아래 점 개수는 1~n까지의 합이 된다.
- 따라서 등차수열의 합을 이용해 점 개수를 구할 수 있다.

```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long N = Long.parseLong(br.readLine());

    long sum = (long)Math.pow(N + 1, 2);
    // 등차수열의 합
    sum += (N * (N+1))/2;

    sum %= 45678;
    System.out.println(sum);
  }
}
```
---
## 문어 숫자 (1864번)
https://www.acmicpc.net/problem/1864

### 풀이방법
```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = "";
    int num = 0;
    StringBuilder sb = new StringBuilder();
    while(!(str = br.readLine()).equals("#")) {
      for(int i=0; i<str.length(); i++) {
        num += (whatNumber(str.charAt(i)) * Math.pow(8, str.length() - 1 - i));
      }

      sb.append(num).append("\n");
      num = 0;
    }

    System.out.println(sb.toString());
  }

  private static int whatNumber(char c) {
    switch(c) {
      case '-': return 0;
      case '\\': return 1;
      case '(': return 2;
      case '@': return 3;
      case '?': return 4;
      case '>': return 5;
      case '&': return 6;
      case '%': return 7;
      default: return -1;
    }
  }
}
```
---
## 생상점 (1703번)
https://www.acmicpc.net/problem/1703

### 풀이방법
- 예제 `3 3 0 2 1 2 3` 의 경우
    - 나무의 나이는 3이다. 즉, 3번 가지를 칠 수 있다.
    - 첫번째 레벨에는 3개의 가지가 뻗어나가며 0개의 가지를 친다. (1 * 3 - 0)
    - 두번째 레벨에는 첫번째 레벨에서 뻗어나간 가지들이 2개씩 뻗어나가며 1개의 가지를 친다. (3 * 2 - 1)
    - 세번째 레벨에는 두번째 레벨에서 뻗어나간 가지들이 2개씩 뻗어나가며 3개의 가지를 친다. (5 * 2 - 3)

```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String str = "";
        int sum = 1;
        int a = 0;
        StringBuilder sb = new StringBuilder();
        while(!(str = br.readLine()).equals("0")) {
            st = new StringTokenizer(str);

            a = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) {
                sum *= Integer.parseInt(st.nextToken());
                sum -= Integer.parseInt(st.nextToken());
            }

            sb.append(sum).append("\n");
            sum = 1;
        }

        System.out.println(sb.toString());
    }
}
```
---
## 꼬리를 무는 숫자 나열 (1598번)
https://www.acmicpc.net/problem/1598

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    int sum = 0;
    sum += Math.abs(calculateX(A) - calculateX(B));
    sum += Math.abs(calculateY(A) - calculateY(B));

    System.out.println(sum);
  }

  private static int calculateX(int num) {
    int sum = 0;

    // 가로 구하기
    sum += (num/4);
    if (num%4 == 0) {
      sum--;
    }

    return sum;
  }

  private static int calculateY(int num) {
    int sum = 0;

    // 세로 구하기
    sum += (num%4);
    if (num%4 == 0) {
      sum += 3;
    }
    else {
      sum--;
    }

    return sum;
  }
}
```
---
## 공 (1547번)
https://www.acmicpc.net/problem/1547

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.valueOf(br.readLine());
        
        boolean[] cups = {true, false, false};
        StringTokenizer st = null;
        
        int X = 0;
        int Y = 0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            
            X = Integer.parseInt(st.nextToken()) - 1;
            Y = Integer.parseInt(st.nextToken()) - 1;
            
            if (X == Y) {
                continue;
            }
            
            swap(cups, X, Y);
        }
        
        if (cups[0])
            System.out.println("1");
        else if (cups[1])
            System.out.println("2");
        else if (cups[2])
            System.out.println("3");
    }
    
    private static void swap(boolean[] cups, int X, int Y) {
        boolean tmp = cups[X];
        cups[X] = cups[Y];
        cups[Y] = tmp;
    }
}
```
---
## 집 주소 (1284번)
https://www.acmicpc.net/problem/1284

### 풀이방법
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = "";
        int sum = 0;
        char chr = ' ';
        while(!(N = br.readLine()).equals("0")) {
            sum = 0;
            for(int i=0; i<N.length(); i++) {
                chr = N.charAt(i);
                if (chr == '0') {
                    sum += 4;
                }
                else if (chr == '1') {
                    sum += 2;
                }
                else {
                    sum += 3;
                }
            }
            // 각 숫자 사이의 여백 1cm
            sum += N.length() - 1;
            // 경계
            sum += 2;

            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
    }
}
```
---
## 핸드폰 요금 (1267번)
https://www.acmicpc.net/problem/1267

### 걸림돌
- 0초 일때도 돈을 지불해야한다. 0초는 당연히 포함되지 않을 것으로 판단했는데 판단 미스였다.
- 민식이와 영식이의 시간을 잘못 입력해놓고 삽질하고 있었다..

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    private static final int MINSIK_TIME = 60;
    private static final int MINSIK_PAY = 15;

    private static final int YOUNGSIK_TIME = 30;
    private static final int YOUNGSIK_PAY = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int minsik = 0;
        int youngsik = 0;
        int time = 0;
        while(st.hasMoreTokens()) {
            time = Integer.parseInt(st.nextToken());
            minsik += (time / MINSIK_TIME + 1) * MINSIK_PAY;
            youngsik += (time / YOUNGSIK_TIME + 1) * YOUNGSIK_PAY;
        }

        if (minsik == youngsik) {
            System.out.println("Y M " + minsik);
        }
        else if (minsik > youngsik) {
            System.out.println("Y " + youngsik);
        }
        else {
            System.out.println("M " + minsik);
        }
    }
}
```
---
## 부호 (1247번)
https://www.acmicpc.net/problem/1247

### 풀이방법
```java
import java.io.*;
import java.math.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = 0;
    BigInteger sum = null;
    char[] sign = new char[3];

    for(int i=0; i<3; i++) {
      sum = new BigInteger("0");
      N = Integer.parseInt(br.readLine());

      for(int j=0; j<N; j++) {
        sum = sum.add(new BigInteger(br.readLine()));
      }

      if (sum.compareTo(BigInteger.valueOf(0)) == 0) {
        sign[i] = '0';
      }
      else if (sum.compareTo(BigInteger.valueOf(0)) > 0) {
        sign[i] = '+';
      }
      else {
        sign[i] = '-';
      }
    }

    for(int i=0; i<sign.length; i++) {
      System.out.println(sign[i]);
    }
  }
}
```
---
## 8진수 2진수 (1212번)
https://www.acmicpc.net/problem/1212

### 걸림돌
- 처음에는 그냥 int로 풀었다가 수의 길이가 333,334 임을 보고 BigInteger를 이용해 풀었는데 그래도 정답이 아니었다.
- 두번째로 StringBuilder의 insert를 이용해 풀었었다. 계속 시간초과 오류가 뜨길래 아무리봐도 문제가 될만한 부분은 보이지 않았는데,
  혹시나 하고 기존에 사용하던 insert대신에 append를 이용해 풀었더니 풀렸다.

### 사전지식
- 8진수를 2진수로 변환하는 방법 (참고 : https://www.lgsl.kr/cur/HODA2008040043)

### 풀이방법
```java
import java.io.*;
import java.math.*;

// 참고자료 : https://www.lgsl.kr/cur/HODA2008040043
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(octalToBinary(br.readLine()));
    }

    private static String octalToBinary(String octal) {
        StringBuilder convSb = new StringBuilder();
        String tmp = "";
        for (int i = 0; i < octal.length(); i++) {
            tmp = convBinary(octal.charAt(i));
            convSb.append(tmp);
        }

        while (convSb.length() != 0 && convSb.charAt(0) != '1') {
            convSb.deleteCharAt(0);
        }

        if (convSb.length() == 0) {
            return "0";
        }

        return convSb.toString();
    }

    private static String convBinary(char c) {
        int value = c - '0';
        char[] bin = new char[3];

        for(int i=0; i<3; i++) {
            bin[2 - i] = (char)(value%2 + '0');
            value/=2;
        }

        return new String(bin);
    }
}
```
---
## 직사각형에서 탈출 (1085번)
https://www.acmicpc.net/problem/1085

### 풀이방법
```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int min = x;
        if (x < w - x) {
            min = x;
        }
        else {
            min = w - x;
        }

        if (y < h - y) {
            if (min > y) {
                min = y;
            }
        }
        else {
            if (min > h - y) {
                min = h - y;
            }
        }

        System.out.println(min);
    }
}
```
---
## 분산처리 (1009번)
## 재풀이 예정
https://www.acmicpc.net/problem/1009

### 걸림돌
- 제곱한 수의 마지막 자리 숫자가 1이면 몇 번을 제곱해도 정답의 마지막 자리 값이 1이 되고, 2일 경우 2, 4, 8, 6, 2, ..., 3일 경우 3, 9, 7, 1, 3, ... 과 같이
  반복되는 것을 확인해서 a의 마지막 자리에 b의 마지막자리만큼 제곱한 결과에서 마지막 자리가 정답이 될 것이라고 생각했다.
  <br>ex) 17^3 (4913) => 7^3 (343) => 3
  <br>ex) 15^12 (129746337890625) => 5^2 (25) => 5
- BigInteger 클래스를 이용해 계산하려고 했으나 값이 워낙 커지기 때문에 시간초과가 발생했다.
- 결국 a에 1부터 b까지 계속 곱한 후 10으로 나머지 연산을 수행하여 풀었다.
- 그러나 시간복잡도가 n^2 이라서 그런지 시간이 1320ms 나 걸렸고 다른 문제 푸신 분들은 300ms 내로 풀었다.

### 풀이방법
```java
import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int a = 0;
        int b = 0;
        int result = 1;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            for(int j=1; j<=b; j++) {
                result = (result * a) % 10;
            }

            if (result == 0) {
                sb.append(10).append("\n");
            }
            else {
                sb.append(result).append("\n");
            }
            result = 1;
        }

        System.out.println(sb.toString());
    }
}
```
---
## 점수계산 (2506번)
https://www.acmicpc.net/problem/2506

### 풀이방법
```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int result = 0;
        int sum = 0;
        
        while(st.hasMoreTokens()) {
            if (st.nextToken().equals("0")) {
                sum = 0;
            }
            else {
                sum++;
            }
            
            result += sum;
        }

        System.out.println(result);
    }
}
```
---
## 네 수 (10824번)
https://www.acmicpc.net/problem/10824

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
        
        StringBuilder sb = new StringBuilder();
        sb.append(st.nextToken()).append(st.nextToken());
        long AB = Long.parseLong(sb.toString());
        
        sb.delete(0, sb.length());
        sb.append(st.nextToken()).append(st.nextToken());
        long CD = Long.parseLong(sb.toString());
        System.out.println(AB + CD);
    }
}
```
---
## 영수증 (5565번)
https://www.acmicpc.net/problem/5565

### 풀이방법
- 첫번째 줄에는 10권의 총 가격이 주어진다고 하였으므로 두번째 줄부터 마지막 줄 까지의 합을 첫번째 값에서 빼주면 정답을 유추할 수 있다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalSum = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i=0; i<9; i++) {
            sum += Integer.parseInt(br.readLine());
        }

        System.out.println(totalSum - sum);
    }
}
```
---
## 지능형 기차 (2455번)
https://www.acmicpc.net/problem/2455

### 풀이방법
- 현재 기차의 인원을 계산하여 최대값과 비교한다.

```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int getOffCount = 0;
        int getOnCount = 0;
        int max = 0;
        int cur = 0;
        for(int i=0; i<4; i++) {
            st = new StringTokenizer(br.readLine());
            getOffCount = Integer.parseInt(st.nextToken());
            getOnCount = Integer.parseInt(st.nextToken());
            cur = cur - getOffCount + getOnCount;
            max = Math.max(max, cur);
        }
        
        System.out.println(max);
    }
}
```
---
## 상근이의 친구들 (5717번)
https://www.acmicpc.net/problem/5717

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int A = 0;
        int B = 0;

        while(true) {
            st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            if (A == 0 && B == 0)
                break;

            sb.append(A+B).append('\n');
        }

        System.out.println(sb);
    }
}
```
---
