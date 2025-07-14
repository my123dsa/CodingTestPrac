import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] array;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0}; //우,좌,상,하
    //감시카메라의 종류에 따라 dx,dy를 적용
    static int[][][] patten={
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 1}, {2, 3}},
            {{0,2},{1,2},{1,3},{0,3}},
            {{0,1,2},{0,1,3},{0,2,3},{1,2,3}},
            {{0,1,2,3}}
    };

    static List<int[]> cameras= new ArrayList<>();
    static int result =Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N][M];

        for(int i=0;i<N;i++){

            st= new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){

                int info = Integer.parseInt(st.nextToken());
                array[i][j]= info;

                if(info==6) block++;
                else if(info !=0) {
                    cameras.add(new int[]{i,j,info});
                }
            }
        }

        dfs(0,array);

        System.out.println(result);
    }

    static void dfs(int depth, int[][] board){
        if (depth == cameras.size()) {
            result = Math.min(result, countZero(board));
            return;
        }

        //카메라 index++ 해가며 뽑기
        int[] cam = cameras.get(depth);
        int type = cam[2];

        for (int[] dirs : patten[type]) {
            //배열 복사
            int[][] copied = copyBoard(board);

            for (int d : dirs) {
                //패턴에 따라 값처리
                watch(copied, cam[0], cam[1], d);
            }
            dfs(depth + 1, copied);
        }
    }

    static int countZero(int[][]board){
        int count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }

    static void watch(int[][] board, int x, int y, int d) {
        int nx = x + dx[d];
        int ny = y + dy[d];
        while (inRange(nx, ny) && board[nx][ny] != 6) {
            if (board[nx][ny] == 0) {
                board[nx][ny] = -1; // 감시 처리
            }
            nx += dx[d];
            ny += dy[d];
        }
    }

    static boolean inRange(int nx,int ny){
        return !(nx<0 || ny<0 || nx>=N || ny>=M);
    }

    static int[][] copyBoard(int[][] original) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {고
                copy[i][j]=original[i][j];
            }
        }
        return copy;
    }
}

//시뮬이 처음이라 카메라가 1,2,3,4,5 인경우에 해당하는 메소드 5개 만들었다가
//gpt 도움을 좀 받 3차원 배열 알려줘서 그걸로 사용함