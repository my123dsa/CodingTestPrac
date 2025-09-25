import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] pos;
    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            pos = new int[n+2][2];
            visited = new boolean[n+2];
            flag = false;

            for (int i=0; i<n+2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                pos[i][0] = Integer.parseInt(st.nextToken());
                pos[i][1] = Integer.parseInt(st.nextToken());
            }

            dfs(0); // 집에서 시작
            sb.append(flag ? "happy" : "sad").append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int cur) {
        if (flag) return;  // 이미 happy면 탐색 중단

        if (cur == n+1) {  // 락페스티벌 도착
            flag = true;
            return;
        }

        for (int i=0; i<n+2; i++) {
            if (!visited[i] && dist(pos[cur], pos[i]) <= 1000) {
                visited[i] = true;
                dfs(i);
            }
        }
    }

    static int dist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
