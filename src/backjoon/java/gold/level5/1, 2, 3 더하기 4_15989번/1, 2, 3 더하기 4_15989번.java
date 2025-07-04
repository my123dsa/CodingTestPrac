import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int[] coins = {1, 2, 3};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] nArr = new int[T];
        int maxN = 0;

        for(int i=0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n+1];
            dp[0]=1;

            for(int coin : coins){
                for(int k =coin; k<=n;k++){
                    dp[k] += dp[k-coin];
                }
            }

            sb.append(dp[n]).append('\n');
        }
        System.out.println(sb.toString().trim());
    }
}
