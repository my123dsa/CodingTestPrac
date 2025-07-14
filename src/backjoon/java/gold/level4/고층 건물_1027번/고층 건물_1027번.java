import java.util.*;
import java.io.*;

public class Main {
    static int[] tops;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        tops= new int[N+1];
        int result =0;

        for(int i=1;i<=N;i++){
            int building = Integer.parseInt(st.nextToken());
            tops[i]= building;
        }

        // 절대값 기준 기울기의 크기가 가장 작은 것보다 작은 것들이 count에 시킴
        // 기준점으로 왼쪽, 오른쪽 기울기를 구하고
        // 왼쪽은 기울기가 양수이니 작은경우를 +
        // 오른쪽은 기울기가 음수이니 큰경우를 +
        for(int i=1;i<=N;i++){
            int count =0;
            int stand =tops[i];
            //왼쪽
            double lc = 1_000_000_001;
            for(int j=i-1;j>=1;j--){
                int left = tops[j];
                double dc = (double)(stand-left)/(i-j);
                if(dc<lc){
                    // System.out.println(stand+" "+left);
                    count++;
                    lc = dc;
                }
            }
            //오른쪽
            double rc = -1_000_000_001;
            for(int j=i+1;j<=N;j++){
                int right = tops[j];
                double dc = (double)(stand-right)/(i-j);
                if(dc>rc){
                    // System.out.println(stand+" "+right);
                    count++;
                    rc=dc;
                }
            }
            result = Math.max(result,count);
            // System.out.println();
        }
        System.out.println(result);
    }
}
