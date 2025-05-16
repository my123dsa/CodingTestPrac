import java.util.*;

class Solution {
    int[][] array;
    int N;
    int count=0;
    Map<Integer,Integer> map;
    public int solution(int n, int[][] computers) {
        array= new int[n][n];
        N= n;
        map = new HashMap<>();

        for(int i=0;i<computers.length;i++){
            int[] computer = computers[i];
            for(int j=0;j<computer.length;j++){
                if(computer[j]==1){
                    array[i][j]=1;
                    array[j][i]=1;
                }
            }
        }
        // 1,2,3,4,5

        for(int i=0;i<N;i++){
            if(!map.containsKey(i)){
                // System.out.println(i);
                // System.out.println(map);
                map.put(i,1);
                dfs(i,0);
                count++;
            }
        }
        return count;
    }
    void dfs(int start, int level){

        for(int i=0;i<array.length;i++){
            if(i!=start && array[start][i]==1 && !map.containsKey(i)){
                map.put(i,1);
                dfs(i,level+1);
            }
        }
    }
}