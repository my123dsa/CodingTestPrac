import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt()-1;
        // 1->6*1 = 6 ->7
        // 2->6*2 =12 ->19
        int count =1;
        int div = N/6;
        if(N%6!=0){
            div++;
        }
        int i=1;
        while(div>0){
            div-=i;
            i++;
            count++;
        }
        System.out.println(count);
    }
}
