import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb= new StringBuilder();
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T= Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int k = Integer.parseInt(br.readLine());
            dp = new int[k+1];
            if(k==1){
                sb.append(1).append('\n');
            }
            else if(k==2){
                sb.append(2).append('\n');
            }
            else{
                dp[1]=1;
                dp[2]=2;
                dp[3]=4;
                int count = dp(k);
                sb.append(count).append('\n');
            }

        }
        System.out.println(sb.toString().trim());
    }

    static int dp(int k){
        if(k<=0){
            return 0;
        }
        if(k<=3){
            return dp[k];
        }
        dp[k] =  dp(k-1) + dp(k-2)+ dp(k-3);
        return dp[k];
    }
}
