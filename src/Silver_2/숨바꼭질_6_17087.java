package Silver_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class 숨바꼭질_6_17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 동생들 위치
        int[] arr = new int[N + 1];
        int index = 0;
        while(st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }
        // 수빈이 위치도 배열에 저장
        arr[N] = S;

        // 힙정렬
        int[] sortedArray = heapSort(arr);
        int minDistance = 0;
        // 수빈이의 인덱스 확인
        int sIndex = binarySearch(sortedArray, 0, sortedArray.length, S);
        // 수빈이와 가장 가까운 값이 정답이 됨
        if (sIndex == 0) {
            minDistance = sortedArray[1] - sortedArray[0];
        }
        else {
            minDistance = sortedArray[sIndex] - sortedArray[sIndex - 1];
        }

        System.out.println(minDistance);
    }

    // 힙 정렬
    public static int[] heapSort(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++) {
            pq.add(arr[i]);
        }

        int[] sortedArray = new int[arr.length];
        int index = 0;
        while(!pq.isEmpty()) {
            sortedArray[index++] = pq.remove();
        }

        return sortedArray;
    }

    // 이진 탐색
    public static int binarySearch(int[] arr, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        else if (arr[mid] > target) {
            return binarySearch(arr, start, mid - 1, target);
        }
        else {
            return binarySearch(arr, mid + 1, end, target);
        }
    }
}
