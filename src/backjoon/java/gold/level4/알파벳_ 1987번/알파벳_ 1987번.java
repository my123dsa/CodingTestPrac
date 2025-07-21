import java.util.*;
import java.io.*;

public class Main {
    static int R,C;
    static char[][] array;
    static boolean[] visited;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static int max =1;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        array= new char[R][C];
        visited= new boolean[26];

        for(int i=0;i<R;i++){
            String str = br.readLine();
            for(int j=0;j<C;j++){
                char alpa = str.charAt(j);
                array[i][j]= alpa;
            }
        }

        //처음 시자점 visited 후 시작
        char start = array[0][0];
        int idx = start-'A';
        visited[idx]=true;
        char[] ch = new char[R*C];
        ch[0]= start;

        dfs(0,0,ch,1);
        System.out.println(max);
    }

    static void dfs(int x,int y,char[] ch,int index){

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || ny<0 || nx>=R || ny>=C){
                continue;
            }

            char alpa = array[nx][ny];
            int idx = alpa-'A';

            if(visited[idx]){
                continue;
            }
            ch[index]= alpa;
            max= Math.max(index+1,max);
            visited[idx]= true;
            dfs(nx,ny,ch,index+1);

            visited[idx]= false;

        }
    }
}

// 풀리긴 했는데 골4 치고는 너무 쉬웠음
// 실행시간 보니 900ms 로 굉장히 느렸지만 일반적인 형태로는 더 줄일 수가 없었음
// 찾아보니 비트 마스크로 풀면 10배 정도 차이가 나는데
// 솔직히 코테에서 비트 마스크 생각? 못할 듯 함
