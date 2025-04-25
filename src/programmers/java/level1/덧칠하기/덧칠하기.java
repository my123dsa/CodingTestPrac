import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String,Integer> map= new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            String[] now = clothes[i];
            if(map.containsKey(now[1])){
                map.put(now[1],map.get(now[1])+1);
            }
            else{
                map.put(now[1],1);
            }
        }
        int answer = 1;
        Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,Integer> entry = it.next();
            // System.out.println(entry.getValue());
            answer*=(entry.getValue()+1);
        }
        answer-=1;

        return answer;
    }
}