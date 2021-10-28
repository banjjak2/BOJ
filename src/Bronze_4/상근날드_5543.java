package Bronze_4;

import java.io.*;

public class 상근날드_5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] food = new int[3];
        food[0] = Integer.valueOf(br.readLine());
        food[1] = Integer.valueOf(br.readLine());
        food[2] = Integer.valueOf(br.readLine());

        int[] juice = new int[2];
        juice[0] = Integer.valueOf(br.readLine());
        juice[1] = Integer.valueOf(br.readLine());

        int minFood = food[0];
        if (food[1] < minFood)
            minFood = food[1];
        if (food[2] < minFood)
            minFood = food[2];

        int minJuice = juice[0];
        if (juice[1] < minJuice)
            minJuice = juice[1];

        System.out.println(minFood+minJuice-50);
    }
}
