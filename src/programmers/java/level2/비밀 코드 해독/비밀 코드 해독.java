import java.util.*;
class Solution {
    int N;
    int[][] Q;
    int[] ANS;
    List<Integer> list;
    int result=0;
    public int solution(int n, int[][] q, int[] ans) {
        N=n;
        Q=q;
        ANS=ans;
        list= new ArrayList<>();
        combine(1,0);

        return result;
    }

    public void combine(int index,int size){
        if(size==5){
            if(check())
                result++;
            return;
        }

        for(int i=index;i<=N;i++){
            list.add(i);
            combine(i+1,size+1);
            list.remove(list.size()-1);
        }
    }

    public boolean check(){
        for(int i=0;i<Q.length;i++){
            int count=0;
            for(int j=0;j<5;j++){
                for(int k :list){
                    if(k==Q[i][j]){
                        count++;
                    }
                }
            }
            if(count!=ANS[i])
                return false;
        }
        return true;
    }
}