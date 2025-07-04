import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb= new StringBuilder();
    static int[] xy = new int[100_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        xy[N]= -2;
        xy[K]=-1;
        for(int i=0;i<xy.length;i++){
            xy[i]= 1000000;
        }
        int[] start = {N,0};
        int answer=-1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            // System.out.println(Arrays.toString(now));
            if(now[0]==K){
                answer=now[1];
                // System.out.println("여기");
                break;
            }
            for(int i=0;i<3;i++){
                int np= check(now[0],i);
                if(np<0 || np>100_000){
                    continue;
                }

                if(xy[np]>now[1]+1){
                    xy[np]= now[1]+1;
                    int[] next= {np,xy[np]};
                    queue.add(next);
                }
            }
        }
        System.out.println(answer);

    }
    static int check(int point,int step){
        if(step==0){
            return point+1;
        }
        if(step==1){
            return point-1;
        }
        return point*2;
    }
}
