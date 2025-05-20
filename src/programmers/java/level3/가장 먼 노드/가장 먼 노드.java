import java.util.*;

class Solution {
    int max=0;
    int[] visited;
    int len=0;
    Map<Integer,Set<Integer>> map = new HashMap<>();

    public int solution(int n, int[][] edge) {

        len =n;

        visited= new int[n+1];

        for(int i=1;i<=n;i++){
            map.put(i,new HashSet<>());
            visited[i]= 20001;
        }

        for(int i=0;i<edge.length;i++){
            int[] e= edge[i];
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{1,0});
        visited[1]=0;
        int count =0;

        while(!queue.isEmpty()){
            int[] now =queue.poll();
            Iterator<Integer> it=  map.get(now[0]).iterator();
            while(it.hasNext()){
                int num= it.next();
                if(visited[num]>now[1]+1){
                    visited[num]=now[1]+1;
                    max= Math.max(now[1]+1,max);
                    int[] next = new int[2];
                    next[0] = num;
                    next[1] = now[1]+1;
                    queue.add(next);
                }
            }
        }


        // System.out.println(Arrays.toString(visited));
        for(int i=0;i<visited.length;i++){
            if(visited[i]==max){
                count++;
            }
        }
        return count;
    }
}
