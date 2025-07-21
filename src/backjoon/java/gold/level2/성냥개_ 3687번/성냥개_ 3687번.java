import java.util.*;
import java.io.*;

public class Main {
    static int[][] should= {{2,1},{3,7},{4,4},{5,2},{6,0},{7,8}};
    static int N;
    static int num = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            num= Integer.parseInt(br.readLine());
            // max
            String maxStr = max(num);
            //min
            String minStr = min(num);

            System.out.println(minStr+" "+maxStr);
        }
    }

    static String min(int num){
        int tempt =num;
        StringBuilder sb1= new StringBuilder();
        int size=0;
        //하나 숫자 최대 성냥개비 개수는 7개이므로 숫자의 자리수를 구함
        if(tempt%7==0){
            size= tempt/7;
        }
        else{
            size=tempt/7+1;
        }

        long[] dp= new long[num+1];
        //최소값을 찾는게 목표이므로 모두 max로 채운뒤 0만 0으로 초기화
        Arrays.fill(dp,Long.MAX_VALUE);
        dp[0]=0;
        for(int i=size-1;i>=0;i--){
            for(int k=dp.length-1;k>=0;k--){
                //max일 경우엔 pass
                if(dp[k]==Long.MAX_VALUE){
                    continue;
                }
                for(int j=0;j<should.length;j++){
                    int cnt =should[j][0];
                    int val =should[j][1];

                    //만약 최고자리수일경우일때 값이 0이면 다음 가장 작은 수인 6으로 초기화
                    if(i== size-1 && val==0){
                        val = 6;
                    }

                    //성냥개비 개수 보다 작을 경우에 계속 dp 업데이트
                    if(k+cnt<=num){
                        dp[k+cnt]=Math.min(dp[k]+ val * (long)Math.pow(10,i),dp[k+cnt]);
                    }
                }
            }
        }
        sb1.append(dp[num]);

        return sb1.toString();
    }

    static String max(int num){
        int tempt =num;
        StringBuilder sb1= new StringBuilder();
        boolean flag = false;

        //2로 나눠지면 1*몫 아니면  7을 하나 붙이고 1*몫을 진행
        if(tempt%2!=0){
            flag=true;
        }
        int repeat = tempt/2;
        if(flag){
            sb1.append(7);
        }
        for(int i=0;i<repeat;i++){
            if(flag && i==0){
                continue;
            }
            sb1.append(1);
        }
        return sb1.toString();
    }
}

//처음에 dfs로 충분히 될거같았는데 시간초과나서.. dp로 바꿈..