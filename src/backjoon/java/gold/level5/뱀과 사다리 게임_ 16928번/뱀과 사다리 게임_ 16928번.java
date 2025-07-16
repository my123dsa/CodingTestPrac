import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int[] array = new int[101];
    // 뱀일 때와 사다리 일때 2개로 나누는게 좋은데, 3차원 배열은거에 익숙해질려고 일케했음
    static int[][] route = new int[101][2];
    static int[] dices = {1,2,3,4,5,6};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        //route[x][0] 은 사다리
        for(int i=1;i<=N;i++){
            st  = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            route[x][0]= y;
        }
        //route[x][1]은 뱀
        for(int i=1;i<=M;i++){
            st  = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            route[u][1]= v;
        }

        Arrays.fill(array,Integer.MAX_VALUE);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        array[1]=0;

        while(!queue.isEmpty()){
            int now =queue.poll();
            int before = array[now];
            //1~6돌리고
            for(int dice:dices){
                int nx =now+dice;
                int after= before+1;
                if(nx<1 || nx>100 || array[nx]<=after){
                    continue;
                }
                array[nx]=after;
                //여기부터는 route될 수있는 것만 처리 아니면 그냥 이전에 다이스로 옮겨진 길 추가
                if(route[nx][0]!=0){
                    nx=route[nx][0];
                }else if(route[nx][1]!=0){
                    nx=route[nx][1];
                }
                else{
                    queue.add(nx);
                    continue;
                }
                // 이동 후에도 이동 거리 작을 시에만 추가
                if(array[nx]>after){
                    array[nx]=after;
                    queue.add(nx);
                }
            }
        }
        System.out.println(array[100]);
    }
}
