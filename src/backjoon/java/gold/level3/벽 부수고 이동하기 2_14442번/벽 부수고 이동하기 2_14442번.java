import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int N, M, K;
    static int[][] map;
    static boolean[][][] visited; // [행][열][부순 벽 개수]

    static class Node {
        int x, y, dist, broken;
        Node(int x, int y, int dist, int broken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broken = broken;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M][K+1];
        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0,1,0));
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(cur.x == N-1 && cur.y == M-1) return cur.dist;

            for(int d=0;d<4;d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;

                // 벽일 때
                if(map[nx][ny] == 1 && cur.broken < K && !visited[nx][ny][cur.broken+1]){
                    visited[nx][ny][cur.broken+1] = true;
                    q.add(new Node(nx, ny, cur.dist+1, cur.broken+1));
                }

                // 빈 칸일 때
                if(map[nx][ny] == 0 && !visited[nx][ny][cur.broken]){
                    visited[nx][ny][cur.broken] = true;
                    q.add(new Node(nx, ny, cur.dist+1, cur.broken));
                }
            }
        }

        return -1; // 도착 불가
    }
}
