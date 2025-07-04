import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb= new StringBuilder();
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr= new long[N];

        for(int i=0;i<N;i++){
            long val = Long.parseLong(st.nextToken());
            arr[i]= val;
        }

        // System.out.println(Arrays.toString(arr));
        int left=0;
        int right=N-1;
        long min =2_000_000_000;
        long[] answer = new long[2];

        while(right>left){
            long leftVal = arr[left];
            long before = 2_000_000_000;
            int count=0;
            while(right>left){
                long rightVal = arr[right];
                long result =Math.abs(rightVal+leftVal);

                if(min>result){
                    answer[0]=leftVal;
                    answer[1]= rightVal;
                    min = result;
                }

                if(before<result){
                    break;
                }

                before = result;
                right--;
            }
            right++;
            left++;

        }
        sb.append(answer[0]).append(' ').append(answer[1]);
        System.out.println(sb.toString());
    }
}
