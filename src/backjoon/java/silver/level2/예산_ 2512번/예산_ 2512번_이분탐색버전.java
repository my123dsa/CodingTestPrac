import java.util.*;
import java.io.*;

public class Main {
    static int[] bugets;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 국가 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine()); //total 예산
        bugets = new int[N];

        for(int i=0;i<N;i++){
            int buget = Integer.parseInt(st.nextToken());
            bugets[i]= buget;
        }
        Arrays.sort(bugets);
        int left =0;
        int right = bugets[bugets.length-1];
        int answer = 0;
        while(right>=left){
            int min=(left+right)/2;
            int sum=0;
            for(int i=0;i<N;i++){
                sum += (int)Math.min(bugets[i], min);
            }

            if(sum>M){
                right= min-1;

            }
            else if(sum<=M){
                answer=min;
                left = min+1;
            }
        }

        System.out.println(answer);

    }
}
