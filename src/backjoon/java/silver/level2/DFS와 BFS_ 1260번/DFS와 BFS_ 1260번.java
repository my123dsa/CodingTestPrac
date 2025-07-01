import java.util.*;
import java.io.*;


public class Main {
    static List<List<Integer>> list;
    static int N,M,V;
    static boolean[] visisted;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visisted = new boolean[N+1];
        list = new ArrayList<>();
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            change(first,second);
            change(second,first);
        }
        visisted[V]=true;
        dfs(V);
        sb.append("\n");

        visisted = new boolean[N+1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(V);
        visisted[V]=true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            sb.append(now+" ");

            List<Integer> bfsList =   list.get(now);
            for(int i=0;i<bfsList.size();i++){
                int num= bfsList.get(i);
                if(!visisted[num]){
                    visisted[num]=true;
                    queue.add(num);
                }

            }
        }

        System.out.println(sb.toString());
    }

    static void change(int first,int second){
        List<Integer> temptList =list.get(first);
        for(int i=temptList.size()-1;i>=0;i--){
            if(temptList.get(i)<=second){
                temptList.add(i+1,second);
                return;
            }
        }
        temptList.add(0,second);
    }

    static void dfs(int v){
        sb.append(v+" ");
        List<Integer> route = list.get(v);

        for(int i=0;i<route.size();i++){
            int num =route.get(i);
            if(!visisted[num]){
                visisted[num]= true;
                dfs(num);
            }
        }
    }
}
