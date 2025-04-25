import java.util.*;
class Solution {
    Map<String,List<String>> map;
    String[][] ts;
    int len;
    boolean find=false;
    public String[] solution(String[][] tickets) {
        len= tickets.length;
        map = new HashMap<>();
        ts= tickets;
        List<String> answer= new ArrayList<>();

        setMap();


        answer.add("ICN");

        dfs("ICN",0,answer);

        String[] a = answer.toArray(new String[answer.size()]);

        return a;
    }

    public void dfs(String now, int count, List<String> list){

        if(!find){
            if(count==len){
                System.out.println(list);
                find=true;
                return;
            }
            List<String> nowList = map.get(now);
            if( nowList ==null||nowList.size()==0)
                return;

            for(int i=0;i<nowList.size();i++){

                if(!find){
                    String next=nowList.get(i);
                    nowList.remove(i);
                    list.add(next);
                    dfs(next,count+1,list);
                    if(!find){
                        list.remove(list.size()-1);
                        nowList.add(i,next);
                    }
                }
                else{
                    return;
                }
            }
        }
    }

    public void setMap(){
        for(int i=0;i<ts.length;i++){
            String[] now = ts[i];
            if(!map.containsKey(now[0])){
                List<String> list= new ArrayList<>();
                list.add(now[1]);
                map.put(now[0],list);
            }
            else{
                List<String> list =map.get(now[0]);
                boolean b= false;
                for(int j=list.size()-1;j>=0;j--){
                    String before= list.get(j);

                    if(now[1].compareTo(before)>=0){
                        b=true;
                        list.add(j+1,now[1]);
                        break;
                    }
                }
                if(!b)
                    list.add(0,now[1]);

            }
        }
    }
}
