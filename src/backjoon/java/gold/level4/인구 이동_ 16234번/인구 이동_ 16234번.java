import java.util.*;
import java.io.*;

public class Main {
    static int N,L,R;
    static int[][] countrys;
    static int[] dx={0,-1,1,0};
    static int[] dy={1,0,0,-1};
    static boolean[][] visited;
    static List<int[]> list;
    static boolean flag =true;
    static int total =0;
    static int repeat=0;
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        L =Integer.parseInt(st.nextToken());
        R =Integer.parseInt(st.nextToken());
        countrys= new int[N][N];
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                countrys[i][j] =Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            //반복시 flag와 방문한 배열 초기화
            visited = new boolean[N][N];
            flag=false;

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    //매번 리스트, total 초기화-> 어짜피 openDoor에서 dfs로 갈 수 있는 곳
                    // 전부 리스트에 넣어서 update로 다 계산하기 때문에 매번 초기화
                    // total을 따로 쓴 이유는 리스트 돌면서 다시 합 구하기 않기 위해
                    list = new ArrayList<>();
                    total=0;
                    openDoor(i,j);
                    update();
                }
            }

            if(!flag) break;

            repeat++;
        }

        System.out.println(repeat);
    }

    static void update(){
        //리스트 크기가 자신 제외 즉 2개 이상일 경우 에만 flag true 후 countrys 업데이트
        if(list.size()<=1) return;

        flag=true;

        int num = total/list.size();

        for(int[] point: list){
            countrys[point[0]][point[1]]= num;
        }
    }

    static void openDoor(int x,int y){

        if(visited[x][y]) return;

        // 미방문이면 total에 더해주고 리스트에 추가
        visited[x][y]= true;
        int now = countrys[x][y];
        list.add(new int[]{x,y});
        total+=now;

        //4방향 탐색
        for(int i=0;i<4;i++){
            int nx =x+dx[i];
            int ny =y+dy[i];

            if(nx<0 || ny<0 || nx==N || ny==N || visited[nx][ny]){
                continue;
            }

            int next= countrys[nx][ny];

            int cal = Math.abs(now-next);
            // 차이가 L<= <=R
            if(L>cal || cal>R){
                continue;
            }

            openDoor(nx,ny);
        }
    }
}
