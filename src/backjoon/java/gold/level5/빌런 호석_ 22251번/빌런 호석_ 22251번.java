import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb =  new StringBuilder();
    static int[] bit={
            Integer.parseInt("1110111",2), //0
            Integer.parseInt("0010010",2), //1
            Integer.parseInt("1011101",2), //2
            Integer.parseInt("1011011",2), //3
            Integer.parseInt("0111010",2), //4
            Integer.parseInt("1101011",2), //5
            Integer.parseInt("1101111",2), //6
            Integer.parseInt("1010010",2), //7
            Integer.parseInt("1111111",2), //8
            Integer.parseInt("1111011",2) //9
    };
    static int N, K, P, X;
    static int[] arr;
    static int tt=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken()); // 최대 값
        K= Integer.parseInt(st.nextToken()); //자리수
        P= Integer.parseInt(st.nextToken()); //변환 가능 개수
        X= Integer.parseInt(st.nextToken()); //현재 층
        // for(int i=0;i<bit.length;i++){
        // System.out.println(bit[i]);
        // }
        arr= new int[K];
        init();
        dfs(0,P,0);
        // System.out.println(Arrays.toString(arr));
        System.out.println(tt);
    }

    static void dfs(int level,int count,int now){
        if(level==K && count>=0){
            if(now >= 1 &&now<=N && now!=X ){
                tt++;
            }
            return;
        }

        if(count<0){
            return;
        }

        int n =arr[K-1-level];

        for(int i=0;i<bit.length;i++){
            int diffBits = bit[n] ^ bit[i];
            int change   = Integer.bitCount(diffBits);
            int num = i;
            for(int j=0;j<level;j++){
                num*=10;
            }
            dfs(level+1,count-change,now+num);
        }
    }

    static void init(){
        int tempt =X;
        int idx= K-1;
        while(tempt>0){
            arr[idx]=tempt%10;
            tempt/=10;
            idx--;
        }
    }
}
