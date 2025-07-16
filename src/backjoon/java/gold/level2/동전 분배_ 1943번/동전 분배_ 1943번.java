import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int k=0;k<3;k++){
            List<int[]> list = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            int total = 0;

            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int val = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());

                total+=val*cnt;

                list.add(new int[]{val,cnt});
            }

            boolean flag=false;

            //2로 나눠져야만 true 판단 로직 적용 아니면 무조건 false
            if(total%2 ==0) {
                //중간값 구하기
                int mid = total/2;
                int start =0;
                //중간값 기준으로 dp 생성
                boolean[] dp =new boolean[mid+1];
                //0원 시작이니 0 true
                dp[0]=true;

                for(int i=1;i<=list.size();i++){
                    int[] now = list.get(i-1);
                    int cnt = now[1];
                    int val =now[0];

                    //매 동전마다 끝에서부터 true인 것에 동전 개수만큼 반복
                    //끝에서부터하는 이유는 앞에서부터하면 중복이나 덮어 씌일 위험있음
                    for(int t = mid; t >= 0; t--){
                        if(dp[t]){
                            for(int c = 1; c <= cnt; c++){
                                if(t + c * val > mid)
                                    break;
                                dp[t + c * val] = true;
                            }
                        }
                    }
                }

                if(dp[mid]){
                    flag=true;
                }
            }

            sb.append(flag? 1:0).append('\n');
        }
        System.out.println(sb.toString().trim());
    }
}