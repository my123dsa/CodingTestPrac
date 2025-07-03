import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // / 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격
        // 위에서 먹은 것중
        //손님이 먹을 수 있는 초밥 가짓수의 최댓값

        StringTokenizer st = new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k =  Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] belt = new int[N+k];
        // 구할 것 : 연속 된 것에 종류 제일 많은데 대신 쿠폰에 있는거 미포함
        for(int i=0;i<N;i++){
            int kind = Integer.parseInt(br.readLine());
            belt[i]= kind;
        }

        for(int i=N;i<N+k;i++){
            belt[i]= belt[i-N];
        }

        // System.out.println(Arrays.toString(belt));
        int max =0;
        int count =0;
        int[] eats = new int[d+1];

        for(int i=0;i<k;i++){

            if(eats[belt[i]]==0){
                count++;
            }
            eats[belt[i]]++;
        }
        max = Math.max(count,max);
        if(eats[c]==0){
            max++;
        }

        for(int i=k;i<N+k;i++){

            if(eats[belt[i-k]]==1){
                count--;

            }
            eats[belt[i-k]]--;

            if(eats[belt[i]]==0){
                count++;
            }
            eats[belt[i]]++;

            int curr = (eats[c] > 0) ? count : count + 1;
            max = Math.max(max, curr);
        }

        System.out.println(max);
    }
}
