import java.util.*;

class Solution {
    char[] arr = {'A','E','I','O','U'};
    List<String> list = new ArrayList<>();
    public int solution(String word) {

        int answer =0;
        dfs("",0);
        int size= list.size();
        for(int i=0;i<size;i++){
            String check= list.get(i);
            if(check.equals(word)){
                answer= i;
                break;
            }
        }
        return answer;
    }
    public void dfs(String str,int length){
        list.add(str);
        if(length==5){
            return;
        }
        for(int i=0;i<5;i++){
            dfs(str+arr[i],length+1);
        }
    }
}
