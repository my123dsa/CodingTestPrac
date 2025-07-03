import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] tops;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());
        StringTokenizer  st= new StringTokenizer(br.readLine());
        tops= new int[N+1];
        for(int i=1;i<N+1;i++){
            int top= Integer.parseInt(st.nextToken());
            tops[i] = top;
        }

        int[] arr= new int[N];
        int index= N;
        Stack<int[]> stack = new Stack<>();
        int[] start = {tops[index],index};
        stack.add(start);

        while(index>1){
            int target =tops[--index];

            while( !stack.isEmpty()&& stack.peek()[0]<target){
                int[] b= stack.pop();
                arr[b[1]-1] = index;
            }
            int[] next= {target,index};
            stack.add(next);
        }

        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]).append(' ');
        }

        // System.out.println(Arrays.toString(arr));
        System.out.println(sb.toString().trim());


    }
}
