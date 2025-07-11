import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb =  new StringBuilder();
    static int[][] array;
    static int N,M;
    static int[] route;
    static Map<Integer,Set<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        array = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            String[] str = br.readLine().split(" ");
            for(int j=1;j<=N;j++){
                int info = Integer.parseInt(str[j-1]);
                if(info ==1){
                    array[i][j]=1;
                    array[j][i]=1;
                }
            }
            map.put(i,new HashSet<>());
        }

        StringTokenizer st= new StringTokenizer(br.readLine());
        route = new int[M];
        for(int i=1;i<=N;i++){
            Set<Integer> iset= map.get(i);
            iset.add(i);
            dfs(i,iset);
        }

        for(int i=0;i<M;i++){
            route[i]=Integer.parseInt(st.nextToken());
        }

        // int start= route[0];

        for(int i=1;i<M;i++){
            int target = route[i];
            int start= route[i-1];
            if(!map.get(start).contains(target)){
                // System.out.println(start+" "+ target);
                System.out.println("NO");
                return;
            }
        }
        // for(int i=1;i<=N;i++){
        // System.out.println(map.get(i));
        // }
        System.out.println("YES");
    }

    static void dfs(int next,Set<Integer> set){

        int[] canGo =array[next];

        for(int i=1;i<=N;i++){
            if(canGo[i]==1 && !set.contains(i)){
                set.add(i);
                dfs(i,set);
            }
        }
    }
}
