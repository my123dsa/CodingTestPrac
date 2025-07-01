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



        int max=bugets[bugets.length-1];

        int total =0;
        for(int i=0;i<bugets.length;i++){
            total+=bugets[i];
        }


        int find=0;
        // System.out.println(total+"토탈");
        //마즘
        int index=bugets.length-1;
        boolean flag =false;
        while(index>=0){
            int count =0;
            int next= bugets[index];
            for(int i=index;i<bugets.length;i++){
                count+=bugets[i]-next;
            }
            // System.out.println(count);
            if(total-count<=M){
                flag=true;
                if(index==bugets.length-1){
                    find=next;
                    break;
                }
                find= next + (M-total+count)/(bugets.length-index-1);
                break;
            }
            index--;
        }
        max=Math.min(max,find);
        if(!flag){
            max= M/N;
        }
        System.out.println(max);

    }
}
