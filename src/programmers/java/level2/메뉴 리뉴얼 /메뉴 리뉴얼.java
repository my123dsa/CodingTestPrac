import java.util.*;
class Solution {
    Map<String,Integer> menuMap;
    int max=0;

    //                                 단품메뉴들의 갯수가 담긴 배열 course
    public String[] solution(String[] orders, int[] course) {

        List<String> list= new ArrayList<>();
        //기본 정보 각 단품메뉴는 A ~ Z의 알파벳 대문자
        //코스는 제작할 단품 메뉴 개수

        //조건1 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 합니다
        //조건2 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함

        //후처리 사전 순으로 오름차순
        menuMap = new HashMap<>();
        for(int k=0;k<course.length;k++){
            max=0;
            menuMap = new HashMap<>();
            int volnum=0;
            int size= course[k];
            for(int i=0;i<orders.length;i++){
                // System.out.println(orders[i]);
                char[] orderArray = orders[i].toCharArray();
                Arrays.sort(orderArray);
                boolean[] visited = new boolean[orderArray.length];
                combine(visited,orderArray,size,"",0);
            }
            // System.out.println(max);
            // System.out.println(menuMap);
            Iterator<Map.Entry<String,Integer>> iterator= menuMap.entrySet().iterator();
            if(max<2){
                continue;
            }
            while(iterator.hasNext()){
                Map.Entry<String,Integer> entry= iterator.next();
                if(entry.getValue()==max){
                    list.add(entry.getKey());
                }
            }
            // System.out.println(list);
        }
        Collections.sort(list);
        // list.sort();
        // System.out.println(list);
        String[] answer = new String[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
    public void combine(boolean[] visited,char[] orderArray,int size,String now,int index){
        if(index>orderArray.length){
            return;
        }
        if(now.length()==size){
            // System.out.println(now);
            menuMap.put(now,menuMap.getOrDefault(now,0)+1);
            max= Math.max(max,menuMap.get(now));
            return;
        }
        for(int i=index;i<orderArray.length;i++){
            if(!visited[i]){
                String newString = now+orderArray[i];
                visited[i]=true;
                combine(visited,orderArray,size,newString,i+1);
                visited[i]=false;
            }
        }
    }
}