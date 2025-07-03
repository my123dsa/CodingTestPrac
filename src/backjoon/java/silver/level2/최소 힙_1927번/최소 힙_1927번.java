import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    // static int[] array=new int[100];
    static int[] array=new int[100_001];
    static int point =0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(num ==0){
                if(point==0){
                    sb.append(0).append('\n');
                }else{
                    pop();
                }
            }
            else{
                add(num);
            }
            // System.out.println(Arrays.toString(array));
        }
        System.out.println(sb.toString().trim());
    }

    static void add(int num){

        int index= ++point;
        array[index]=num;

        while(index>1){
            int tempt = index/2;
            if(array[tempt]<=num){
                return;
            }

            array[index]=array[tempt];
            array[tempt] = num;
            index=tempt;
        }

    }

    static void pop(){

        int num = array[1];
        sb.append(num).append('\n');

        int big= array[point];
        array[point--]=0;
        array[1]= big;

        int index= 1;
        while (index * 2 <= point) {
            int left = index * 2;
            int right = index * 2 + 1;
            int minChild = left;

            // 오른쪽 자식이 있고, 오른쪽 자식이 더 작으면
            if (right <= point && array[right] < array[left]) {
                minChild = right;
            }

            if (array[minChild] >= big) {
                break;
            }

            array[index] = array[minChild];
            index = minChild;
        }
        array[index] =big;
    }
}
