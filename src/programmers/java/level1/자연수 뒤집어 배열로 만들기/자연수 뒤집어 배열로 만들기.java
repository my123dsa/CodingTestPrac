import java.util.*;
class Solution {
    public int[] solution(long n) {
        long tempt =n;
        // long answer=0;
        List<Integer> answer= new ArrayList<>();
        while(tempt>0){
            int before=(int)(tempt%10);
            answer.add((Integer)before);
            tempt/=10;
        }
        int[] real = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            real[i] = answer.get(i);
        }
        return real;
    }
}