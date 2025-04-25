import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String,List<int[]>> playsMap = new HashMap<>();
        Map<String,Integer> maxTime= new HashMap<>();
        for(int i=0;i<plays.length;i++){
            String key= genres[i];
            int time = plays[i];

            if(!playsMap.containsKey(key)){
                List<int[]> temptList = new ArrayList<>();
                temptList.add(new int[]{time,i});
                playsMap.put(key,temptList);
                maxTime.put(key,time);
                continue;
            }

            List<int[]> temptList = playsMap.get(key);
            boolean isAdd=false;

            for(int j=0;j<temptList.size();j++){
                if(temptList.get(j)[0]<time){
                    temptList.add(j,new int[]{time,i});
                    isAdd=true;
                    break;
                }
                else if(temptList.get(j)[0]==time){
                    temptList.add(j+1,new int[]{time,i});
                    isAdd=true;
                    break;
                }
            }
            maxTime.put(key,maxTime.get(key)+time);
            if(!isAdd){
                temptList.add(new int[]{time,i});
            }

        }

        List<String> sortedGenres = new ArrayList<>(maxTime.keySet());
        sortedGenres.sort((a,b)->maxTime.get(b)-maxTime.get(a));

        List<Integer> ans= new ArrayList<>();

        for(int j=0;j<sortedGenres.size();j++){
            String key=sortedGenres.get(j);
            List<int[]> now =playsMap.get(key);
            if(now.size()==1){
                ans.add(now.get(0)[1]);
            }
            else{
                for(int i=0;i<2;i++){
                    ans.add(now.get(i)[1]);
                }
            }
        }
        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i]=ans.get(i);
        }
        return answer;
    }
}