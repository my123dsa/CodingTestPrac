import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int[][][] dp;
    static int N,M;
    static int[] dx={0,0,1};
    static int[] dy={1,-1,0};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{

        init();
        dpinit();

        for(int i=2;i<=N;i++){
            dp[i][1][0] = dp[i-1][1][0] + map[i][1];
            for(int j=2; j<=M; j++){
                dp[i][j][0] = map[i][j] + Math.max(dp[i][j-1][0], dp[i-1][j][0]);
            }
            dp[i][M][1] = dp[i-1][M][1] + map[i][M];

            for(int j=M-1; j>=1; j--){
                dp[i][j][1] = map[i][j]+ Math.max(dp[i][j+1][1],dp[i-1][j][1]);
            }
            for(int j=1;j<=M;j++){
                dp[i][j][0]= Math.max(dp[i][j][0],dp[i][j][1]);
                dp[i][j][1]= dp[i][j][0];
            }
        }

        System.out.println(dp[N][M][0]);
    }

    static void dpinit(){
        for(int i=1;i<=M;i++){
            dp[1][i][0]=dp[1][i-1][0]+map[1][i];
            dp[1][i][1]=dp[1][i-1][1]+map[1][i];
        }
    }

    static void init() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];

        dp=new int[N+2][M+2][2];
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
            }
        }
    }
}

