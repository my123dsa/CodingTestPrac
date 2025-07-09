import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 1_000_000_009;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 1) {
                sb.append(1).append('\n');
                continue;
            }
            if (n == 2) {
                sb.append(2).append('\n');
                continue;
            }
            if (n == 3) {
                sb.append(4).append('\n');
                continue;
            }

            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int val = 4; val <= n; val++) {
                dp[val] = (int)(((long)dp[val - 1] + dp[val - 2] + dp[val - 3]) % MOD);
            }

            sb.append(dp[n]).append('\n');
        }

        System.out.println(sb.toString().trim());
    }
}
