package Bronze_2;

import java.io.*;

public class 하얀_칸_1100 {
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
