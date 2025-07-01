import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());

        for(int i=0;i<P;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int classNum = Integer.parseInt(st.nextToken());
            int[] line = new int[20];
            int index=line.length-1;
            int total =0;
            line[index--] = Integer.parseInt(st.nextToken());

            for(int x=1;x<20;x++){
                int heigth =Integer.parseInt(st.nextToken());
                int count=0;

                for(int k=index+1;k<line.length;k++){
                    if(heigth<line[k]){
                        break;
                    }
                    count++;
                }

                for (int k=index;k<index+count;k++){
                    line[k]=line[k+1];
                    if(k==index+count-1){
                        line[k+1]= heigth;
                    }
                }

                if(count==0){
                    line[index]= heigth;
                }
                total+= x-count;
                index--;
            }
            // System.out.println(Arrays.toString(line));
            System.out.println(classNum+" "+total);
        }
    }
}
