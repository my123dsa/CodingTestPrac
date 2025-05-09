import java.util.*;
class Solution {

    public int solution(int[] arr) {
        // 5 10
        // 1 2
        // 2 6 8 14
        // 1 3 4 7 = 2*1*3*4*7
        // 앞은 인수 , 뒤는 index
        Map<Integer,List<Integer>> map= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            for(int j=1;j<=num/2;j++){
                if(num%j==0){
                    if(map.containsKey(j)){
                        map.get(j).add(i);
                    }
                    else{
                        List<Integer> list= new ArrayList<>();
                        list.add(i);
                        map.put(j,list);
                    }
                }
            }
        }
        int calu= 1;
        Iterator<Map.Entry<Integer,List<Integer>>> iterator= map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,List<Integer>> entry = iterator.next();
            List<Integer> indexList = entry.getValue();
            if(indexList.size()<2){
                continue;
            }
            int key =entry.getKey();
            calu*=key;
            // System.out.println(calu);
            for(int i=0;i<indexList.size();i++){
                arr[i] = arr[i]/key ;

            }
        }
        for(int i=0;i<arr.length;i++){
            calu*= arr[i];
            System.out.println(calu);
        }
        int answer = 0;
        return calu;
    }
}