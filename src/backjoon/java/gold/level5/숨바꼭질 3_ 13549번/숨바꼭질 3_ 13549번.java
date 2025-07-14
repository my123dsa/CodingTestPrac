import java.util.*;
import java.io.*;

public class Main {
    static int N,K;
    static int[] visited;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        queue = new ArrayDeque<>();

        // 방문사전 최대값으로 초기화
        visited = new int[100_001];
        for(int i=0;i<visited.length;i++){
            visited[i]= Integer.MAX_VALUE;
        }

        // 시작 지점 add
        int[] start=  {N,0};
        visited[N]= 0;
        queue.add(start);

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            // now[0]== K 일 경우 visited[K] 읜 값을 가져와야함
            if(now[0] == K){
                System.out.println(visited[now[0]]);
                break;
            }
            // 순서는 텔레포트가 0초이므로 가장 우선적으로 메소드 호출
            teleport(now);
            move(now,1);
            move(now,-1);
        }
    }

    static void move(int[] now,int num){
        int time = now[1]+1;
        int nx = now[0]+num;
        if(nx<0 || nx> 100000 || visited[nx]<=time){
            return;
        }
        visited[nx]=time;
        int[] next = {nx,time};
        queue.add(next);
    }

    static void teleport(int[] now){
        int nx = now[0]*2;
        if(nx<0 || nx> 100000 || visited[nx]<now[1]){
            return;
        }
        visited[nx]=now[1];
        int[] next = {nx,now[1]};
        queue.add(next);
    }
}

//해당 문제는 그냥 큐와 add 순서를 조정하면 풀 수 있지만
//권장하는 방법은 Deque를 사용하여 텔레포트일 경우 앞에 추가하는 것이 좋음
//우선순위 큐의 경우 범위가 10만이라 시간 초과가 나는 듯 함