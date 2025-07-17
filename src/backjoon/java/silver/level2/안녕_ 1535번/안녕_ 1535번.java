import java.util.*;

import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer  st = new StringTokenizer(br.readLine());
        StringTokenizer  st2 = new StringTokenizer(br.readLine());

        //체력 0~100
        int[] dp = new int[101];

        for(int i=1;i<=N;i++){
            int stamina  = Integer.parseInt(st.nextToken());
            int happy = Integer.parseInt(st2.nextToken());
            for(int j=1;j<=100-stamina ;j++){
                // 체력이 n 이면 n+stamina 에 happy 더한거의 최대 넣음
                dp[j]= Math.max(dp[j],dp[j+stamina]+happy);
            }
        }
        System.out.println(dp[1]);
    }
}
