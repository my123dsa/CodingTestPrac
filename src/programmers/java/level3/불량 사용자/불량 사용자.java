import java.util.*;

class Solution {

    boolean[] visited;
    int max=0;
    Map<String,List<Integer>> map;
    Set<String> duplicate= new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        //아이디 당 최소 하나 이상의 '*' 문자 사용된 문자열
        // 경우의 수 가 답
        visited= new boolean[user_id.length];
        map = new HashMap<>();


        for(int k=0;k<banned_id.length;k++){
            String  ban = banned_id[k];
            List<Integer> list = new ArrayList<>();

            for(int i=0;i<user_id.length;i++){
                String user =user_id[i];
                boolean result =check(ban,user);
                if(result){
                    list.add(i);
                }
            }
            map.put(ban,list);
        }

//         for(int i=0;i<banned_id.length;i++){
//             System.out.println(map.get(banned_id[i]));
//         }

        dfs(0,0,banned_id,user_id);

        return max;
    }


    public void duplicate(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<visited.length;i++){
            if(visited[i]){
                sb.append(i);
            }
        }
        String now= sb.toString();
        if(!duplicate.contains(now)){
            duplicate.add(now);
            max++;
        }
    }

    public void dfs(int index,int count,String[] banned_id,String[] user_id){
        if(index==banned_id.length){
            duplicate();
            return;
        }

        String ban = banned_id[index];
        List<Integer> list= map.get(ban);

        for(int i=0;i<list.size();i++){
            int user = list.get(i);
            if(visited[user]){
                continue;
            }
            visited[user] =true;
            dfs(index+1,count+1,banned_id,user_id);
            visited[user] =false;
        }
    }

    public boolean check(String ban, String user){
        if(ban.length()!= user.length()){
            return false;
        }
        for(int i=0;i<ban.length();i++){
            char banChar =ban.charAt(i);
            if(ban.charAt(i)=='*'){
                continue;
            }
            char userChar = user.charAt(i);
            if(banChar!=userChar){
                return false;
            }
        }
        return true;
    }
}