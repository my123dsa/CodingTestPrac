import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int count=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            int now = tangerine[i];
            if(!map.containsKey(now)){
                map.put(now,1);
            }
            else{
                map.put(now,map.get(now)+1);
            }
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());

        keySet.sort((a,b)-> map.get(b)-map.get(a));
        for(int i=0;i<keySet.size();i++){
            k-=map.get(keySet.get(i));
            count++;
            if(k<=0){
                return count;
            }
        }
        return count;
    }

}