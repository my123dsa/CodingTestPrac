import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb= new StringBuilder();
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i]=num;
        }

        int left = 0,sum=0,minLen = Integer.MAX_VALUE;

        for(int right=0;right<N;right++){
            sum+= arr[right];

            while(sum>=S){
                minLen =  Math.min(minLen,right-left+1);
                sum-=arr[left++];
            }
        }

        System.out.println(minLen==Integer.MAX_VALUE? 0:minLen);

    }
}
