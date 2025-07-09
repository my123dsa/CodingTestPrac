import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static List<List<int[]>> list= new ArrayList<>();
    static int[] level;
    static int max=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        level= new int[N+1];

        for(int i=0;i<=N;i++){
            level[i]=Integer.MAX_VALUE;
            list.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st= new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            int[] f = {end,count};
            int[] s = {start,count};
            list.get(start).add(f);
            list.get(end).add(s);
        }

        // Queue<int[]> queue = new ArrayDeque<>();
        PriorityQueue<int[]> queue= new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] start = {1,0};
        queue.add(start);
        level[1]=0;
        int result =Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0]==N){

                result = Math.min(result,now[1]);
                // break;
                continue;
            }

            for(int[] k : list.get(now[0])){

                int cow= k[1];

                int nc = cow+now[1];
                if(level[k[0]]>nc){
                    int[] next = {k[0],nc};
                    level[k[0]]= nc;
                    queue.add(next);
                }
            }
        }
        System.out.println(result);
    }
}
