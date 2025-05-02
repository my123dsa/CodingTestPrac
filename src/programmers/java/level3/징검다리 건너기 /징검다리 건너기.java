import java.util.*;
class Solution {
    int[] STONES;
    int K;
    public int solution(int[] stones, int k) {
        int max=200000000;
        int min =0;
        int answer=0;
        STONES= stones;
        K=k;
        while(min<max){
            int middle =(max+min)/2;
            int result =check(middle);
            if(result<K){
                min = middle+1;
            }
            else{
                answer= middle;
                max= middle;
            }
        }
        return answer;
    }

    public int check(int middle){
        int size=0;
        int max=0;
        boolean result= false;
        for(int i=0;i<STONES.length;i++){
            int stone =STONES[i];
            if(stone>middle){
                size=0;

            }else {
                size++;
                max= Math.max(size,max);
            }
        }
        return max;
    }
}