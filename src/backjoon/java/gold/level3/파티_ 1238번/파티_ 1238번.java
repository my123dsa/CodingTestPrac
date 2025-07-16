import java.util.*;
import java.io.*;
public class Main {
    static int[][] map;
    static int[][] map2;
    static int N,M,X;
    static int[] goTime;
    static int[] backTime;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        map2 = new int[N+1][N+1];
        goTime=new int[N+1];
        backTime=new int[N+1];
        Arrays.fill(goTime,10_000_000);
        Arrays.fill(backTime,10_000_000);

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int sp = Integer.parseInt(st.nextToken());
            int ep = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            //X로 가는 길
            map[sp][ep]= t;

            //X에서 갈 수있는 길
            map2[ep][sp] =t;
        }

        // X에서 전부 나가는데 최소인 값
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(X);
        goTime[X]= 0;
        //정방향일 떄 가는 최소 시간
        while(!queue.isEmpty()){
            int now = queue.poll();
            int[] route= map[now];

            for(int next=1;next<=N;next++){
                int val = route[next];
                if(val==0){
                    continue;
                }
                if(goTime[next]>goTime[now]+val){
                    goTime[next]=goTime[now]+val;
                    queue.add(next);
                }
            }
        }
        queue = new ArrayDeque<>();
        queue.add(X);
        backTime[X]= 0;
        //역방향일 떄 갈 수 있는 최소 시간
        while(!queue.isEmpty()){
            int now = queue.poll();
            int[] route= map2[now];

            for(int next=1;next<=N;next++){
                int val = route[next];
                if(val==0){
                    continue;
                }
                if(backTime[next]>backTime[now]+val){
                    backTime[next]=backTime[now]+val;
                    queue.add(next);
                }
            }
        }

        int result =0;
        //이 정방향+ 역방향 최소 구함
        for(int i=1;i<=N;i++){
            result =Math.max(goTime[i]+backTime[i],result);
        }
        System.out.println(result);
    }
}
