import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[][] map;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static int[][] level;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=  new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map =new int[N][M];
        level= new int[N][M];
        Queue<int[]> oneList = new ArrayDeque<>();
        //1이 이동 불가
        //+1 해줘야함<- 시작 포함
        //벽 한개 뿌셔도됨
        //
        //int[] 0= n, 1=m, 2= count, 3= 뚫었는지?

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                char ch = str.charAt(j);
                if(ch=='1'){
                    int[] t= {i,j};
                    oneList.add(t);
                }
                map[i][j]= (int)(ch-'0');
                level[i][j]=10000000;
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        int[] first = {0,0,1,0};
        queue.add(first);
        level[0][0]=1;

        while(!queue.isEmpty()){
            int[] sp = queue.poll();
            if(sp[0]== N-1 && sp[1]==N-1){

                break;
            }

            for(int i=0;i<4;i++){
                int nx= sp[0]+dx[i];
                int ny= sp[1]+dy[i];
                if(nx<0 ||ny<0 || nx>=N || ny>= M){
                    continue;
                }

                if(map[nx][ny]==0 && level[nx][ny]>sp[2]+1){
                    level[nx][ny] = sp[2]+1;
                    int[] next= {nx,ny,sp[2]+1,0};
                    queue.add(next);
                }

                if(map[nx][ny]==1 && level[nx][ny]>sp[2]+1){
                    level[nx][ny] = sp[2]+1;
                }
            }
        }


        queue = new ArrayDeque<>();
        while(!oneList.isEmpty()){
            int[] now =oneList.poll();
            // System.out.println(Arrays.toString(now));
            if(level[now[0]][now[1]] !=10000000){
                int[] next = {now[0],now[1],level[now[0]][now[1]],0};
                queue.add(next);
            }

        }
        // System.out.println(queue);

        while(!queue.isEmpty()){
            int[] sp = queue.poll();
            if(sp[0]== N-1 && sp[1]==N-1){

            }

            for(int i=0;i<4;i++){
                int nx= sp[0]+dx[i];
                int ny= sp[1]+dy[i];
                if(nx<0 ||ny<0 || nx>=N || ny>= M){
                    continue;
                }

                if(map[nx][ny]==0 && level[nx][ny]>sp[2]+1){

                    level[nx][ny] = sp[2]+1;
                    int[] next= {nx,ny,sp[2]+1,0};
                    queue.add(next);
                }
            }
        }

        // if(level[nx][ny]!=-1){

        // for(int i=0;i<N;i++){
        // System.out.println(Arrays.toString(level[i]));
        // }

        System.out.println(level[N-1][M-1]== 10000000 ? -1:level[N-1][M-1]);
    }
}
