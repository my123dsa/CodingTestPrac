import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        //1. 큐로도 가능한다
        //2. 배열 이 빠르긴해~
        int len = routes.length;

        //연습 겸 퀵 소트 하자
        quickSort(routes,0,len-1);
        // for(int i=0;i<len;i++){
        //     System.out.println(Arrays.toString(routes[i]));
        // }

        int camera = -300001;
        for (int[] route : routes) {
            if (route[0] > camera) {
                answer++;
                camera = route[1];
            }
        }
        return answer;
    }

    public void quickSort(int[][] array,int start,int end){
        if(start<end){
            int pivot = partition(array,start,end);

            quickSort(array,start,pivot-1);
            quickSort(array,pivot+1,end);
        }
    }

    public int partition(int[][] array, int start, int end) {
        int[] pivot = array[start];
        int i = start + 1;
        int j = end;

        while (i <= j) {
            while (i <= end && array[i][1] <= pivot[1]) {
                i++;
            }
            while (j >= start + 1 && array[j][1] > pivot[1]) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
            }
        }

        // pivot을 제자리로 옮김
        swap(array, start, j);
        return j; // 피벗 최종 위치 반환
    }

    private void swap(int[][] array, int i, int j) {
        int[] temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}