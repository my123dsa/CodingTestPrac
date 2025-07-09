import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 곡 수
        int S = Integer.parseInt(st.nextToken());  // 시작 볼륨
        int M = Integer.parseInt(st.nextToken());  // 최대 볼륨

        int[] V = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;

        for (int i = 0; i < N; i++) {
            for (int vol = 0; vol <= M; vol++) {
                if (dp[i][vol]) {
                    if (vol + V[i] <= M) dp[i + 1][vol + V[i]] = true;
                    if (vol - V[i] >= 0) dp[i + 1][vol - V[i]] = true;
                }
            }
        }

        int result = -1;
        for (int vol = M; vol >= 0; vol--) {
            if (dp[N][vol]) {
                result = vol;
                break;
            }
        }

        System.out.println(result);
    }
}
