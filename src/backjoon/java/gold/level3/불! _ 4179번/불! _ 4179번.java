import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb =  new StringBuilder();
    static int R,C;
    static char[][] miro;
    static int[][] array;
    static int[][] arrayF;
    static int[] dx= {0,0,1,-1};
    static int[] dy= {1,-1,0,0};
    static int jx,jy;
    static int result =0;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        miro = new char[R][C];
        array= new int[R][C];
        arrayF= new int[R][C];
        Queue<int[]> qeueuFire = new ArrayDeque<>();
        for(int i=0;i<R;i++){
            String str = br.readLine();

            for(int j=0;j<C;j++){
                char ch = str.charAt(j);
                boolean f=false;
                if(ch=='J'){
                    jx= i;
                    jy =j;
                }
                if(ch=='F'){
                    f=true;
                    // map.get(i).add(j);
                }
                miro[i][j]= ch;
                array[i][j]= Integer.MAX_VALUE;
                if(f){
                    arrayF[i][j]=0;
                    int[] ff= {i,j,0};
                    qeueuFire.add(ff);
                    continue;
                }

                arrayF[i][j]=Integer.MAX_VALUE;
            }
        }

        Queue<int[]> queue= new ArrayDeque<>();
        int[] start = {jx,jy,0};
        queue.add(start);
        array[jx][jy]=0;
        int answer=0;
        int level =0;
        boolean flag=false;
        while(!queue.isEmpty()&& !flag){
            int[] now= queue.poll();

            if(level!= now[2]){
                while(!qeueuFire.isEmpty()){
                    int[] nowfire =qeueuFire.poll();
                    if(nowfire[2]!=level){
                        qeueuFire.add(nowfire);
                        break;
                    }
                    for(int i=0;i<4;i++){
                        int nx = nowfire[0]+ dx[i];
                        int ny = nowfire[1]+ dy[i];

                        if(nx<0 || ny<0 || nx==R || ny==C){
                            continue;
                        }

                        if(miro[nx][ny]!='#' && arrayF[nx][ny]>level+1){
                            int[] next = {nx,ny,nowfire[2]+1};
                            arrayF[nx][ny]=level+1;
                            miro[nx][ny]='F';
                            qeueuFire.add(next);
                        }

                    }

                }
                level=now[2];
            }

            if(miro[now[0]][now[1]]=='F'){
                continue;
            }

            for(int i=0;i<4;i++){
                int nx = now[0]+ dx[i];
                int ny = now[1]+ dy[i];

                if(nx<0 || ny<0 || nx==R || ny==C){
                    answer=now[2]+1;
                    flag= true;
                    break;
                }

                if(miro[nx][ny]=='.'&& array[nx][ny]>level+1){
                    int[] next = {nx,ny,now[2]+1};
                    array[nx][ny]=level+1;
                    queue.add(next);
                }

            }
        }
        System.out.println(flag?answer:"IMPOSSIBLE");

    }
}
