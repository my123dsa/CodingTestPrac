import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb =  new StringBuilder();
    static int[] array;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        array = new int[N];
        int[] counts = new int[100_001];
        for(int i=0;i<N;i++){
            int a = Integer.parseInt(st.nextToken());
            array[i]=a;

        }
        // 같은 원소가 K개 이하로 들어 있는 최장 연속 부분 수열의 길이
        // System.out.println(Arrays.toString(array));
        int idx=0;
        int start =0;
        int max=0;
        while(idx<N && start<=idx ){
            int next = array[idx];
            counts[next]++;
            int len=0;
            while(start<=idx && counts[next]>K ){
                int sn= array[start];
                counts[sn]--;
                start++;
            }
            idx++;
            len = idx-start;
            max= Math.max(len,max);

        }

        System.out.println(max);
    }
}
