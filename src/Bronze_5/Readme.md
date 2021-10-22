# 백준 문제풀이 (Bronze 5)

---

## 16진수 (1550번)

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
