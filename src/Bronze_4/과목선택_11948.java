package Bronze_4;

import java.io.*;

public class 과목선택_11948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] four = new int[4];
        int[] two = new int[2];

        for(int i=0; i<4; i++) {
            four[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<2; i++) {
            two[i] = Integer.parseInt(br.readLine());
        }

        insertionSort(four);
        insertionSort(two);

        System.out.println(four[3] + four[2] + four[1] + two[1]);
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        int tmp = 0;
        int index = 0;
        for(int i=0; i<n-1; i++) {
            index = i;

            for(int j=i+1; j<n; j++) {
                if (arr[index] > arr[j]){
                    index = j;
                }
            }

            tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }
    }
}
