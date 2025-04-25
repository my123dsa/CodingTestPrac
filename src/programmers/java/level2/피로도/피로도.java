class Solution {
    int[][] DUNGEONS;
    int K;
    int n;
    int max=0;
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        n = dungeons.length;
        int temptK= k;
        K=k;
        DUNGEONS=dungeons;
        boolean[] visited = new boolean[n];

        dfs(k,-1,0,visited,0);

        return max;
    }

    public void dfs(int temptK,int position,int count,boolean[] visited,int level){
        if(level==n){
            // System.out.println(count);
            max = Math.max(max,count);
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                // System.out.println(temptK);
                boolean b = true;
                if(temptK >= DUNGEONS[i][0]){
                    temptK-=DUNGEONS[i][1];
                    count++;
                    b= false;
                    dfs(temptK,i,count,visited,level+1);
                    temptK+=DUNGEONS[i][1];
                    count--;
                    visited[i]=false;
                }
                else{
                    dfs(temptK,i,count,visited,level+1);
                    visited[i]=false;
                }
            }
        }
    }
}