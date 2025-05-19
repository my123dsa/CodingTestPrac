import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {

        //무작위 경기
        // > 일때만 1점
        // A가 고정일 때, B의 최고점 줘라
        Arrays.sort(A);
        Arrays.sort(B);
        int len= A.length;
        int index=0;
        int count =0;
        for(int i=0;i<len;i++){
            int a = A[index];
            int b = B[i];
            if(b>a){
                count++;
                index++;
            }
        }
        // 1,3,5,7
        // 2,2,6,8


        return count;
    }
}