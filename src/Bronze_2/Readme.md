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
