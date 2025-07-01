import java.util.*;
import java.io.*;

public class Main {
    static int x; static int y;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        int[][] route = new int[n][m];

        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int point = Integer.parseInt(st.nextToken());
                if(point==2){
                    x=i;y=j;
                }
                map[i][j]= point;
                route[i][j]=999999;

            }
        }


        Queue<int[]> queue = new ArrayDeque<>();
        int[] p= {x,y,0};
        queue.add(p);
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            // System.out.println(Arrays.toString(now));

            route[now[0]][now[1]] = now[2];

            for(int i=0;i<4;i++){
                int nx= now[0]+dx[i];
                int ny= now[1]+ dy[i];
                if(nx<0 || ny<0 || nx>=n ||ny>=m || map[nx][ny]!=1 ){
                    continue;
                }

                if(route[nx][ny]<=now[2]+1){
                    // System.out.println(route[nx][ny]+" "+(now[2]+1)+"dltkd");
                    continue;
                }
                route[nx][ny]=now[2]+1;
                int[] next = {nx,ny,now[2]+1};
                queue.add(next);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int put=route[i][j];
                if(route[i][j]==999999){
                    if(map[i][j]==1){
                        put= -1;
                    }
                    else{
                        put= 0;
                    }
                }
                sb.append(put).append(' ');
            }
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
