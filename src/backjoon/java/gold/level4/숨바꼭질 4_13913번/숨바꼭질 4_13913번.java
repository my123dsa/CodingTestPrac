import java.util.*;
import java.io.*;

public class Main {
    static int N,K;
    static boolean flag;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        boolean[] visited= new boolean[100001];

        int[] dist = new int[100001];
        int[] parent = new int[100001];

        Arrays.fill(dist,-1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);

        dist[N] = 0;
        parent[N] = -1;


        // // -1, +1, *2
        while(!q.isEmpty()){
            int sp = q.poll();
            if(sp ==K){
                break;
            }

            int n1 = sp-1;
            int n2 = sp+1;
            int n3 = sp*2;
            if(n1>=0 && dist[n1]==-1){
                dist[n1]= dist[sp]+1;
                parent[n1]= sp;
                q.add(n1);
            }
            if(n2<=100000 && dist[n2]==-1){
                dist[n2]= dist[sp]+1;
                parent[n2]= sp;
                q.add(n2);
            }
            if(n3<=100000 && dist[n3]==-1){
                dist[n3]= dist[sp]+1;
                parent[n3]= sp;
                q.add(n3);
            }
        }
        sb.append(dist[K]).append('\n');

        int[] result= new int[dist[K]+1];

        int index = K;
        int i=result.length-1;
        while(index != -1){
            result[i--]= index;
            index = parent[index];
        }
        for(int j=0;j<result.length;j++){
            sb.append(result[j]).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
    static class Item{
        int n;
        int count;
        List<Integer> history;
        Item(int n,int count,List<Integer> history){
            this.n= n;
            this.count = count;
            this.history= history;
        }
    }
}
