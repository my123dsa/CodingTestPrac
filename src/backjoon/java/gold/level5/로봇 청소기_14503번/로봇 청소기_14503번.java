import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int r, c, d;
    static int[][] map;
    static boolean[][] visited;

    // 0: 북, 1: 동, 2: 남, 3: 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cleaned = simulate();
        System.out.println(cleaned);
    }

    static int simulate() {
        int count = 0;

        while (true) {
            // 1. 현재 칸 청소
            if (!visited[r][c]) {
                visited[r][c] = true;
                count++;
            }

            boolean moved = false;

            // 2. 왼쪽부터 4방향 탐색
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 왼쪽 회전
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0 && !visited[nx][ny]) {
                        // 청소 가능한 칸 있으면 전진
                        r = nx;
                        c = ny;
                        moved = true;
                        break;
                    }
                }
            }

            if (moved) continue; // 새 칸으로 이동했으면 다시 1번부터

            // 3. 네 방향 다 못 갔으면 뒤로 이동
            int back = (d + 2) % 4;
            int bx = r + dx[back];
            int by = c + dy[back];

            if (bx < 0 || by < 0 || bx >= N || by >= M || map[bx][by] == 1) {
                // 뒤가 벽이면 종료
                return count;
            } else {
                // 후진
                r = bx;
                c = by;
            }
        }
    }
}
