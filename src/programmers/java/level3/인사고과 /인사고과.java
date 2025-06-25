import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int[] answer =new int[]{scores[0][0],scores[0][1]};
        int answerSum=answer[0]+answer[1];

        Arrays.sort(scores,(a,b)->{
            if(a[0]!=b[0])
                return b[0]-a[0];
            return a[1]-b[1];
        });

        int max=0;

        List<Integer> list = new ArrayList<>();

        for(int[] score : scores){
            if(score[0]>answer[0] && score[1]>answer[1]){
                return -1;
            }

            if(score[1]>=max){
                max=Math.max(score[1], max);
                list.add(score[0]+score[1]);
            }
        }
        Collections.sort(list,(a,b)->b-a);

        int rank=1;
        int pre=-1;

        for(int i=0;i<list.size();i++){
            int now = list.get(i);
            if(now==answerSum){
                return rank;
            }

            rank ++;
            if(now !=pre){
                pre=now;
            }
        }
        return -1;
    }
}