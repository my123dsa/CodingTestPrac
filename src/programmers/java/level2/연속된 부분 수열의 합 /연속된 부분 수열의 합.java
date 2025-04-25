class Solution {
    public int[] solution(int[] sequence, int k) {

        int[] answer= new int[2];

        int goal = 0;
        int start = 0;
        int end = sequence.length-1;

        for(int i=sequence.length-1;i>=0;i--){
            goal+=sequence[i];
            if(goal>k){
                goal-=sequence[end--];
            }
            if(goal==k){
                start=i;
                if(goal==k){
                    answer[0]=start;
                    answer[1]=end;
                    // System.out.println(start+" "+end);
                }
                while(start>=1){
                    goal-=sequence[end--];
                    goal+=sequence[--start];
                    if(goal==k){
                        answer[0]=start;
                        answer[1]=end;
                    }
                }
                break;
            }
        }
        return answer;
    }
}