import java.util.*;
class Solution {
    public int[] solution(String msg) {
        // 1, 1~2 , 2, 2~3, 3~4,
        // int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        char c = 'A';
        int index=1;
        while(c<='Z'){
            map.put(c+"",index);
            c+=1;
            index++;
        }
        int add= 27;
        for(int i=0;i<msg.length();i++){
            String s= msg.substring(i,i+1);
            int j=i+1;
            while(j<msg.length()){
                s+= msg.charAt(j);
                if(!map.containsKey(s)){
                    break;
                }
                j++;
            }
            String wc= s.substring(0,j-i);
            list.add(map.get(wc));
            map.put(s,add++);
            i+=(j-i-1);
        }
        // System.out.println(list);
        int[] answer= new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]= list.get(i);
        }
        return answer;
    }
}