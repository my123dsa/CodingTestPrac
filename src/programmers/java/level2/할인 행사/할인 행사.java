import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer=0;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<10;i++){
            String item=discount[i];
            map.put(item,map.getOrDefault(item,0)+1);
            // if(map.containsKey(item)){
            //     map.put(item,map.get(item)+1);
            //     continue;
            // }
            // map.put(item,1);
        }
        int index=10;
        while(true){
            int wants=0;
            for(int i=0;i<want.length;i++){
                String key=want[i];
                if(map.get(key)!=null && map.get(key)>=number[i]){
                    wants++;
                }
            }
            if(wants==want.length){
                answer++;
            }
            if(index+1>discount.length)
                break;
            String removeItem= discount[index-10];
            String addItem= discount[index];
            map.put(removeItem,map.get(removeItem)-1);
            if(map.containsKey(addItem)){
                map.put(addItem,map.get(addItem)+1);
            }
            else{
                map.put(addItem,1);
            }
            index++;
        }


        return answer;
    }
}