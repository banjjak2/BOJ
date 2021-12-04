# 백준 문제풀이 (Bronze 5)

---

## 16진수 (1550번)
https://www.acmicpc.net/problem/1550

### 사전지식
- 16진수를 10진수로 변경하는 방법
  ```text
  16진수 맨 뒷자리에서부터 시작해서 앞 자리까지 해당자리값*16^0, 해당자리값*16^1, 해당자리값*16^2, ... 순으로 구함
  
  ex) 16진수 0x1A => (A * 16^0) + (1 * 16^1) => (10 * 16^0) + (1 * 16^1) => 26
  ```

### 풀이방법
- 0부터 F까지 문자열로 선언 (0123456789ABCDEF)
- 입력받은 `hex` 값을 맨 뒤에서부터 하나씩 확인
- indexOf 메소드를 이용해 `0123456789ABCDEF`에서 몇 번째에 있는지 확인

```java
package Bronze_5;

import java.util.*;

public class 십육진수_1550 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String order = "0123456789ABCDEF";
        String hex = scanner.nextLine();

        int result = 0;
        char c = ' ';
        int index = 0;
        for(int i=hex.length() - 1; i>=0; i--){
            c = hex.charAt(i);
            index = order.indexOf(c);
            if (index >= 0){
                result += (index * Math.pow(16, hex.length() - 1 - i));
            }
        }

        System.out.println(result);
    }
}
```
---
## 엄청난 부자2 (1271번)
https://www.acmicpc.net/problem/1271

### 사전지식
 - java의 BigInteger 클래스
```text
BigInteger 클래스
 - 무한히 큰 정수를 받고 사칙연산 및 기본적인 java.Math 에서 사용하는 메소드들을 비슷하게 사용할 수 있음
 - 즉, BigInteger 내부의 add, mod, divide 등의 메소드를 통해 연산 가능 
```

###풀이방법 1
<b>BigInteger를 이용한 풀이</b>
 - BigInteger 클래스를 이용해 n과 m을 전달받고 BigInteger 클래스의 divide 메소드로 몫을 구하고 mod 메소드로 나머지를 구하는 방식으로 풀이
```java
package Bronze_5;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 엄청난_부자_2_1271 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        System.out.println(n.divide(m));
        System.out.println(n.mod(m));
    }
}
```
### 풀이방법 2
<b>배열을 이용한 풀이</b>
 - 구현예정

---
## 긴자리 계산 (2338번)
https://www.acmicpc.net/problem/2338

### 사전지식
- java의 BigInteger 클래스
```text
BigInteger 클래스
 - 무한히 큰 정수를 받고 사칙연산 및 기본적인 java.Math 에서 사용하는 메소드들을 비슷하게 사용할 수 있음
 - 즉, BigInteger 내부의 add, mod, divide 등의 메소드를 통해 연산 가능 
```

### 풀이방법
 - BigInteger 클래스의 add, substract, multiply 메소드를 이용해 구현
```java
package Bronze_5;

import java.io.*;
import java.math.BigInteger;

public class 긴자리_계산_2338 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger A = new BigInteger(br.readLine());
        BigInteger B = new BigInteger(br.readLine());

        System.out.println(A.add(B));
        System.out.println(A.subtract(B));
        System.out.println(A.multiply(B));
    }
}
```
---

## 검증수 (2475번)
https://www.acmicpc.net/problem/2475

### 사전지식
 - StringTokenizer 사용방법

### 풀이방법
 - StringTokenizer로 입력받은 문자열을 공백을 기준으로 자름
 - 반복문을 통해 아직 토큰이 남아있을 때까지 반복해서 숫자를 제곱하고 결과를 더해줌
```java
package Bronze_5;

import java.io.*;
import java.util.StringTokenizer;

public class 검증수_2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int result = 0;
        while(st.hasMoreTokens()){
            result += Math.pow(Integer.valueOf(st.nextToken()), 2);
        }

        System.out.println(result % 10);
    }
}
```
---
## A+B - 2 (2558번)
https://www.acmicpc.net/problem/2558

### 사전지식
 - StringTokenizer 사용법

### 풀이방법
 - StringTokenizer로 문자를 받아와 각각 Integer.valueOf 메소드로 형변환
 - 형변환 된 데이터를 더한 후 출력
```java
package Bronze_5;

import java.io.*;

public class A_plus_B_2_2558 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.valueOf(br.readLine());
        int B = Integer.valueOf(br.readLine());

        System.out.println(A+B);
    }
}

```
---
## 파티가 끝나고 난 뒤 (2845번)
https://www.acmicpc.net/problem/2845

### 사전지식
 - StringTokenizer 사용법
 - 반복문

### 주의사항
 - 예제를 보면 뉴스 기사에 실려있는 참가자의 수에서 실제 참가자의 수를 빼야함을 알 수 있음

### 풀이방법
 - StringTokenizer로 문자열을 잘라서 변수에 저장
 - `1m^2`에 있는 사람(`L`)과 파티가 열린 곳의 넓이 `P`가 주어졌으므로 `L*P`는 전체 참가자 수
 - 반복문을 통해 신문 기사에 실려있는 참가자의 수와 실제 참가한 수를 빼서 출력
```java
package Bronze_5;

import java.io.*;
import java.util.*;

public class 파티가_끝나고_난_뒤_2845 {
    private static final int NEWS_COUNT = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int L = Integer.valueOf(st.nextToken());
        int P = Integer.valueOf(st.nextToken());
        int peopleCount = L * P;

        str = br.readLine();
        st = new StringTokenizer(str);
        for(int i=0; i<NEWS_COUNT; i++){
            System.out.print(Integer.valueOf(st.nextToken()) - peopleCount + " ");
        }
    }
}
```
---
## 저작권 (2914번)
https://www.acmicpc.net/problem/2914

### 주의사항
 - 항상 올린다고 하였으므로 예제 1번에서 `38 24`일 때 평균값 24는 `평균값>23 또는 평균값<=24`가 되어야 함
 - 따라서 `앨범에 수록된 곡의 개수`와 `평균값-1`을 곱한 후 +1을 해주어야 적어도 몇 곡이 저작권에 걸리는지 알 수 있음.

### 풀이방법
 - `앨범에 수록된 곡의 개수`와 `평균값`을 곱한 후 +1
```java
package Bronze_5;

import java.io.*;
import java.util.*;

public class 저작권_2914 {
    // 항상 올려서 정수로 계산함
    // 예제 1번에서 38 24 일 때,
    // 평균값이 24가 되려면 평균값>23 또는 평균값<=24가 되어야 함
    // 따라서 23일때 38을 곱한 후 +1을 해주어야 위 범위에 들어가게 됨

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int A = Integer.valueOf(st.nextToken());
        int I = Integer.valueOf(st.nextToken());

        System.out.println(A*(I - 1)+1);
    }
}
```
## 킹, 퀸, 룩, 비숍, 나이트, 폰 (3003번)
https://www.acmicpc.net/problem/3003

### 풀이방법
 - 각 피스의 개수를 배열로 잡고 입력값에서 뺌
```java
package Bronze_5;

import java.util.*;
import java.io.*;

public class 킹_퀸_룩_비숍_나이트_폰_3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int[] chess = {1, 1, 2, 2, 2, 8};

        for(int i=0; i<6; i++) {
            System.out.print(chess[i] - Integer.valueOf(st.nextToken()) + " ");
        }
    }
}
```
## R2 (3046번)
https://www.acmicpc.net/problem/3046

### 풀이방법
 - S = (R1 + R2) / 2
   R2 = S * 2 - R1
   
```java
package Bronze_5;

import java.util.*;
import java.io.*;

public class R2_3046 {
    // S = (R1 + R2) / 2
    // R2 = S * 2 - R1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int R1 = Integer.valueOf(st.nextToken());
        int S = Integer.valueOf(st.nextToken());

        System.out.println(S * 2 - R1);
    }
}
```
## 웰컴 (5337번)
https://www.acmicpc.net/problem/5337

### 풀이방법
 - 역슬래쉬 (\) 표현 시 \\로 대체해주어야 함
```java
package Bronze_5;

public class 웰컴_5337 {
    public static void main(String[] args) {
        System.out.println(".  .   .");
        System.out.println("|  | _ | _. _ ._ _  _");
        System.out.println("|/\\|(/.|(_.(_)[ | )(/.");
    }
}
```
---
## 마이크로소프트 로고 (5338번)
https://www.acmicpc.net/problem/5338

### 풀이방법
```java
package Bronze_5;

public class 마이크로소프트_로고_5338 {
  public static void main(String[] args) {
    System.out.println("       _.-;;-._\n" +
            "'-..-'|   ||   |\n" +
            "'-..-'|_.-;;-._|\n" +
            "'-..-'|   ||   |\n" +
            "'-..-'|_.-''-._|");
  }
}
```
---
## 콜센터 (5339번)
https://www.acmicpc.net/problem/5339

### 풀이방법
```java
package Bronze_5;

public class 콜센터_5339 {
    public static void main(String[] args) {
        System.out.println("     /~\\\n" +
                "    ( oo|\n" +
                "    _\\=/_\n" +
                "   /  _  \\\n" +
                "  //|/.\\|\\\\\n" +
                " ||  \\ /  ||\n" +
                "============\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |");
    }
}
```
---
## 카드 게임 (5522번)
https://www.acmicpc.net/problem/5522

### 풀이방법
```java
package Bronze_5;

import java.io.*;

public class 카드_게임_5522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sum = 0;

        for(int i=0; i<5; i++){
            sum += Long.valueOf(br.readLine());
        }
        System.out.println(sum);
    }
}
```
---
## 심부름 가는 길 (5554번)
https://www.acmicpc.net/problem/5554

### 풀이방법
 - 모든 초를 더한 후 `분(x)`는 `초/60`, `초(y)`는 `초%60`
```java
package Bronze_5;

import java.io.*;

public class 심부름_가는_길_5554 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalSeconds = 0;
        for(int i=0; i<4; i++){
            totalSeconds += Integer.valueOf(br.readLine());
        }
        System.out.println(totalSeconds/60 + "\n" + totalSeconds%60);
    }
}
```
---
## Next in line (6749번)
https://www.acmicpc.net/problem/6749

### 풀이방법
```java
package Bronze_5;

import java.io.*;

public class Next_in_line_6749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int youngest = Integer.valueOf(br.readLine());
        int middle = Integer.valueOf(br.readLine());

        System.out.println(middle + (middle-youngest));
    }
}
```
---
## Plane (8370번)
https://www.acmicpc.net/problem/8370

### 풀이방법
```java
package Bronze_5;

import java.io.*;
import java.util.*;

public class Plane {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int businessSeats = Integer.valueOf(st.nextToken()) * Integer.valueOf(st.nextToken());
        int economicSeats = Integer.valueOf(st.nextToken()) * Integer.valueOf(st.nextToken());

        System.out.println(businessSeats + economicSeats);
    }
}
```
---
## 스타워즈 로고(9653번)
https://www.acmicpc.net/problem/9653

### 풀이방법
```java
package Bronze_5;

public class 스타워즈_로고_9653 {
    public static void main(String[] args) {
        System.out.println("    8888888888  888    88888\n" +
                "   88     88   88 88   88  88\n" +
                "    8888  88  88   88  88888\n" +
                "       88 88 888888888 88   88\n" +
                "88888888  88 88     88 88    888888\n" +
                "\n" +
                "88  88  88   888    88888    888888\n" +
                "88  88  88  88 88   88  88  88\n" +
                "88 8888 88 88   88  88888    8888\n" +
                " 888  888 888888888 88  88      88\n" +
                "  88  88  88     88 88   88888888");
    }
}
```
---
## 나부 함대 데이터 (9654번)
https://www.acmicpc.net/problem/9654

### 풀이방법
```java
package Bronze_5;

public class 나부_함대_데이터_9654 {
    public static void main(String[] args) {
        System.out.println("SHIP NAME      CLASS          DEPLOYMENT IN SERVICE\n" +
                "N2 Bomber      Heavy Fighter  Limited    21        \n" +
                "J-Type 327     Light Combat   Unlimited  1         \n" +
                "NX Cruiser     Medium Fighter Limited    18        \n" +
                "N1 Starfighter Medium Fighter Unlimited  25        \n" +
                "Royal Cruiser  Light Combat   Limited    4         ");
    }
}
```
---
## NFC West vs North (10170번)
https://www.acmicpc.net/problem/10170

### 풀이방법
```java
package Bronze_5;

public class NFC_West_vs_North_10170 {
    public static void main(String[] args) {
        System.out.println("NFC West       W   L  T\n" +
                "-----------------------\n" +
                "Seattle        13  3  0\n" +
                "San Francisco  12  4  0\n" +
                "Arizona        10  6  0\n" +
                "St. Louis      7   9  0\n" +
                "\n" +
                "NFC North      W   L  T\n" +
                "-----------------------\n" +
                "Green Bay      8   7  1\n" +
                "Chicago        8   8  0\n" +
                "Detroit        7   9  0\n" +
                "Minnesota      5  10  1");
    }
}
```
---
## 오늘 날짜 (10699번)
https://www.acmicpc.net/problem/10699

### 풀이방법
 - 푸는 날짜를 기준으로 작성해야 함
```java
package Bronze_5;

public class 오늘_날짜_10699 {
    public static void main(String[] args) {
        System.out.println("2021-10-24");
    }
}
```
---
## 큰 수 A+B (10757번)
https://www.acmicpc.net/problem/10757

### 사전지식
 - BigInteger 클래스 이해<br>
  (BigInteger는 문자열을 생성자로 받을 수 있으며 내부적으로 문자열끼리 연산이 가능하도록 구현되어 있음)

### 풀이방법
```java
package Bronze_5;

import java.io.*;
import java.math.*;
import java.util.*;

public class 큰_수_A_plus_B_10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());

        System.out.println(A.add(B));
    }
}
```
---
## ??! (10926번)
https://www.acmicpc.net/problem/10926

### 걸림돌
 - 문제를 잘못읽어 joonas 일때만 ??!를 붙여 출력하는 줄 알았다.

### 느낀점
 - 아무리 쉬운 문제라도 제대로 읽고 이해한 후 풀이하자.

### 풀이방법
```java
package Bronze_5;

import java.io.*;

public class 준하_10926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        System.out.println(name + "??!");
    }
}
```
---
## 한글 2 (11283번)
https://www.acmicpc.net/problem/11283

### 사전지식
 - 한글 한글자를 int형으로 변환하는 방법
```text
(int)'가'.charAt(0)
```

### 걸림돌
 - 한글을 숫자로 변환하는데 별 짓을 다해봤다. 2진수로 변환, 유니코드 to int 등등 해봐도 안돼서 단순히 한글을 int 형식으로 변환하니 int형식으로 잘 나왔다.

### 느낀점
 - 너무 복잡하게 생각하지 말아야겠다.

### 풀이방법
 - 한글을 int형식으로 강제형변환 시켜주었고, `가`의 유니코드 값`(0xAC00)`을 빼주었다.
 - 단순히 유니코드 값이 아닌 `가`를 빼주어도 정상적으로 작동한다.
 - 한글 유니코드 (https://unicode.org/charts/PDF/UAC00.pdf) - 2페이지
```java
package Bronze_5;

import java.io.*;

public class 한글_2_11283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println((int)str.charAt(0) - 0xAC00 + 1);
//        System.out.println((int)str.charAt(0) - '가' + 1);
    }
}
```
---
## 꼬마 정민 (11382번)
https://www.acmicpc.net/problem/11382

### 사전지식
 - 자료형의 범위

### 주의사항
 - 입력값이 `10^12`이므로 int 범위를 벗어남

### 풀이방법
```java
package Bronze_5;

import java.util.*;
import java.io.*;

public class 꼬마_정민_11382 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        System.out.println(Integer.valueOf(st.nextToken()) + 
                Integer.valueOf(st.nextToken()) + 
                Integer.valueOf(st.nextToken()));
    }
}
```
---
## 고려대학교 (11942번)
https://www.acmicpc.net/problem/11942

### 풀이방법
```java
package Bronze_5;

public class 고려대학교_11942 {
    public static void main(String[] args) {
        System.out.println("고려대학교");
    }
}
```
---
## 큰 수 곱셈 (13277번)
https://www.acmicpc.net/problem/13277

### 사전지식
 - BigInteger 클래스 이해<br>
   (BigInteger는 문자열을 생성자로 받을 수 있으며 내부적으로 문자열끼리 연산이 가능하도록 구현되어 있음)
   
### 풀이방법
 - BigInteger 클래스의 곱셈 기능인 multiply 이용
```java
package Bronze_5;

import java.util.*;
import java.io.*;
import java.math.*;

public class 큰_수_곱셈_13277 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());
        System.out.println(A.multiply(B));
    }
}
```
---
## 와이버스 부릉부릉 (14645번)
https://www.acmicpc.net/problem/14645

### 주의사항
 - 문제의 입력에는 뭔가 계산하고 출력할 것처럼 되어있지만 출력을 확인해보면 종착역 도착 시 `버스 운전수의 이름`을 출력해야 함
 - 계산 문제가 아닌 단순 입/출력 문제

### 풀이방법
 - 입력은 받아야하므로 N만큼 입력받기만 하도록 처리
```java
package Bronze_5;

import java.util.*;
import java.io.*;

public class 와이버스_부릉부릉_14645 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.valueOf(st.nextToken());

        for(int i=0; i<N; i++){
            str = br.readLine();
        }

        System.out.println("비와이");
    }
}
```
---
## 나는 행복합니다 (14652번)
https://www.acmicpc.net/problem/14652

### 풀이방법
 - `자리번호/M`의 값이 n이 되고, `자리번호%M`의 값이 m이 된다.

```java
package Bronze_5;

import java.util.*;
import java.io.*;

public class 나는_행복합니다_14652 {
    public static void main(String[] args) throws IOException {
        // n => 자리번호/M
        // m => 자리번호%M
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        int K = Integer.valueOf(st.nextToken());

        int n = (K/M);
        int m = (K%M);

        System.out.println(n + " " + m);
    }
}
```
---
## 조별과제를 하려는데 조장이 사라졌다 (16727번)
https://www.acmicpc.net/problem/16727

### 풀이방법
 - 최대한 빨리 찾는다고 하였으므로 성우는 1분에 무조건 5의 거리를 이동한다고 가정한다.
 - 즉, 최소 t분 만에 찾아야하므로 집까지의 거리를 5로 나누고 나머지가 있을 경우 1분을 더해준다.
```java
package Bronze_5;

import java.io.*;

public class 조별과제를_하려는데_조장이_사라졌다_15727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.valueOf(br.readLine());

        int result = L/5;

        System.out.println(L%5>0? result+1 : result);
    }
}
```
---
## 나는 누구인가 (15733번)
https://www.acmicpc.net/problem/15733

### 풀이방법
```java
package Bronze_5;

public class 나는_누구인가_15733 {
    public static void main(String[] args) {
        System.out.println("I'm Sexy");
    }
}
```
---
## A+B - 9 (15740번)
https://www.acmicpc.net/problem/15740

### 풀이방법
```java
package Bronze_5;

import java.util.*;
import java.io.*;
import java.math.*;

public class A_plus_B_9_15740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());

        System.out.println(A.add(B));
    }
}
```
---
## 수학은 체육과목 입니다 (15894번)
https://www.acmicpc.net/problem/15894

### 주의사항
 - 범위는 `1 ≤ n ≤ 10^9`이므로 int로 계산 불가능

### 풀이방법
 - 네모의 왼쪽과 오른쪽 실선의 개수 = 맨 아랫부분의 정사각형 개수 * 2
 - 맨 아랫부분 실선의 개수 = 맨 아랫부분의 정사각형 개수
 - 맨 윗부분 실선의 개수 = 1
 - 각 층마다 반절씩 잘린 부분의 개수 = 맨 아랫부분 정사각형 개수 - 1
 - 따라서, `(n * 2) + n + 1 + n - 1`이므로 `(n * 2) + (2 * n)` 으로 계산 가능
```java
package Bronze_5;

import java.io.*;

public class 수학은_체육과목_입니다_15894 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.valueOf(br.readLine());

        // 네모의 왼쪽과 오른쪽 실선의 개수 : 맨 아랫부분의 정사각형 개수 * 2
        // 맨 아랫부분 실선의 개수 : 맨 아랫부분의 정사각형 개수
        // 맨 윗부분 실선의 개수 : 1
        // 각 층마다 반절씩 잘린 부분의 개수 : 맨 아랫부분 정사각형 개수 - 1
        // (n * 2) + n + 1 + n - 1
        // (n * 2) + 2n

        System.out.println((n * 2) + 2 * n);
    }
}
```
---
## 새로운 시작 (15962번)
https://www.acmicpc.net/problem/15962

### 풀이방법
```java
package Bronze_5;

public class 새로운_시작_15962 {
    public static void main(String[] args) {
        System.out.println("파이팅!!");
    }
}
```
---
## 이상한 기호 (15964)
https://www.acmicpc.net/problem/15964

### 주의사항
 - 범위가 `1 ≤ A, B ≤ 100,000` 이므로 int형으로 계산 불가능한 부분이 있음

### 풀이방법
```java
package Bronze_5;

import java.util.*;
import java.io.*;

public class 이상한_기호_15964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.valueOf(st.nextToken());
        long B = Long.valueOf(st.nextToken());

        System.out.println((A+B)*(A-B));
    }
}
```
---
## 오늘의 날짜는? (16170번)
https://www.acmicpc.net/problem/16170

### 주의사항
 - 한국은 UTC+9 의 시간을 가지고 있으므로 현재 시간에서 -9를 한 후의 년월일을 입력해야 함

### 풀이방법
```java
package Bronze_5;

public class 오늘의_날짜는_16170 {
    public static void main(String[] args) {
        System.out.println("2021\n10\n26");
    }
}
```
---
## 홍익대학교 (16394번)
https://www.acmicpc.net/problem/16394

### 풀이방법
```java
package Bronze_5;

import java.util.Scanner;

public class 홍익대학교_16394 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(sc.nextInt() - 1946);
    }
}
```
---
## 제리와 톰 (16430번)
https://www.acmicpc.net/problem/16430

### 주의사항
 - 결과값을 기약분수로 표현한 후 출력해야함

### 풀이방법
 - A는 B보다 무조건 작아야 한다고 가정 (치즈를 B이상 훔쳐갈 수 없으므로)
 - 톰이 가지고 있는 치즈의 무게를 `P`와 `Q`로 구함
 - `Q`로 `P`를 나누었을 때 나머지가 0이라면 기약분수가 아니므로 나눈 결과값을 출력
```java
package Bronze_5;

import java.util.*;
import java.io.*;

public class 제리와_톰_16430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.valueOf(st.nextToken());
        int B = Integer.valueOf(st.nextToken());

        int P = B - A;
        int Q = B;

        if (Q%P == 0){
            Q /= P;
            P /= P;
        }

        System.out.println(P + " " + Q);
    }
}
```
---
## 달달함이 넘쳐흘러 (17256번)
https://www.acmicpc.net/problem/17256

## 풀이방법
```java
package Bronze_5;

import java.util.*;
import java.io.*;

public class 달달함이_흘러넘쳐_17256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ax, ay, az;
        ax = Integer.valueOf(st.nextToken());
        ay = Integer.valueOf(st.nextToken());
        az = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int cx, cy, cz;
        cx = Integer.valueOf(st.nextToken());
        cy = Integer.valueOf(st.nextToken());
        cz = Integer.valueOf(st.nextToken());

        int bx, by, bz;
        bx = cx - az;
        by = cy / ay;
        bz = cz - ax;

        System.out.println(bx + " " + by + " " + bz);
    }
}
```
---
## 엔드게임 스포일러 (17295번)
https://www.acmicpc.net/problem/17295

### 풀이방법
```java
package Bronze_5;

import java.io.*;

public class 엔드게임_스포일러_17295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println("Avengers: Endgame");
    }
}
```
---
## 스타후르츠 (17496번)
https://www.acmicpc.net/problem/17496

### 풀이방법
- 날짜가 1일부터 시작하므로 N - 1을 해줌
- 여름일수를 T로 나누면 여름일수동안 몇 번을 수확할 수 있는지 알 수 있음
- 여름일수를 T로 나눈 값에 C를 곱하면 스타후르츠의 개수를 알 수 있음
- 스타후르츠의 개수에 가격을 곱하면 총 금액을 알 수 있음
```java
package Bronze_5;

import java.util.*;
import java.io.*;

public class 스타후르츠_17496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken()) - 1;
        int T = Integer.valueOf(st.nextToken());
        int C = Integer.valueOf(st.nextToken());
        int P = Integer.valueOf(st.nextToken());

        // 여름일수를 T로 나누면 여름일수동안 몇 번을 수확할 수 있는지 알 수 있음
        // 여름일수를 T로 나눈 값에 C를 곱하면 스타후르츠의 개수를 알 수 있음
        // 스타후르츠의 개수에 가격을 곱하면 총 금액을 알 수 있음
        System.out.println((N/T)*C*P);
    }
}
```
---
## 1998년생인 내가 태국에서는 2541년생?! (18108번)
https://www.acmicpc.net/problem/18108

### 풀이방법
- 2541년에서 1998을 뺀 수가 불기에서 서기로 바꿔주는 수가 됨
```java
package Bronze_5;

import java.io.*;

public class 태국에서는_2541년생_18108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int y = Integer.valueOf(br.readLine());

        System.out.println(y - (2541-1998));
    }
}
```
---
## 세금 (20492번)
https://www.acmicpc.net/problem/20492

### 풀이방법
```java
package Bronze_5;

import java.io.*;

public class 세금_20492 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        int one = N - (int)(N * 0.22);
        int two = (int)(N - (N - N*0.80) * 0.22);

        System.out.println(one + " " + two);
    }
}
```
---
## 큰 수 (BIG) (14928번)
https://www.acmicpc.net/problem/14928

### 풀이방법
```java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // 수학에서 나눗셈을 구하듯이 구현
        int result = 0;
        for(int i=0; i<str.length(); i++) {
            result = (result * 10 + str.charAt(i) - '0') % 20000303;
        }

        System.out.println(result);
    }
}
```
---
