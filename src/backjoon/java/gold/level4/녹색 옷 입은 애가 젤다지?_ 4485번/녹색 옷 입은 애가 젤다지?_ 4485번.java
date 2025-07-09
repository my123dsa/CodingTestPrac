import java.io.*;
import java.util.*;

public class Main {
    static int[] dx ={0,0,1,-1};
    static int[] dy= {1,-1,0,0};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pnum=1;

        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;

            int[][] array = new int[N][N];
            int[][] da = new int[N][N];
            int result =Integer.MAX_VALUE;

            for(int i=0;i<N;i++){
                String[] strArray = br.readLine().split(" ");
                for(int j=0;j<N;j++){
                    array[i][j]= Integer.parseInt(strArray[j]);
                    da[i][j]=Integer.MAX_VALUE;
                }
                // System.out.println(Arrays.toString(array[i]));
            }

            PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[2]-b[2]);
            int[] start = {0,0,array[0][0]};
            da[0][0]=5;
            queue.add(start);

            while(!queue.isEmpty()){
                int[] now = queue.poll();
                if(now[0]== N-1 && now[1]==N-1){
                    result = Math.min(result,now[2]);
                    continue;
                }

                for(int p=0;p<4;p++){
                    int nx = now[0] + dx[p];
                    int ny = now[1] + dy[p];
                    if(nx<0 || ny<0 || nx>=N || ny>=N){
                        continue;
                    }

                    if(da[nx][ny] > now[2]+array[nx][ny]){
                        da[nx][ny]=now[2]+array[nx][ny];
                        // System.out.println(nx+" "+ny+" "+da[nx][ny]);
                        int[] add = {nx,ny,da[nx][ny]};
                        queue.add(add);
                    }
                }

            }

            sb.append("Problem ").append(pnum++).append(": ")
                    .append(result).append('\n');
        }
        System.out.println(sb.toString().trim());
    }
}
