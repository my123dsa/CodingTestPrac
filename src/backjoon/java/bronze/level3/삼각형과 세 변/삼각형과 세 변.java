import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st= new StringTokenizer(br.readLine());
            if(st==null){
                break;
            }
            int first= Integer.parseInt(st.nextToken());
            int second= Integer.parseInt(st.nextToken());
            int thrid= Integer.parseInt(st.nextToken());

            if(first==0 && second==0 && thrid ==0){
                break;
            }

            int[] arr = {first,second, thrid};
            Arrays.sort(arr);

            if(arr[2]>=arr[1]+arr[0]){
                System.out.println("Invalid");
            }
            else if(arr[0]==arr[1] && arr[1]==arr[2]){
                System.out.println("Equilateral");
            }
            else if(arr[0]==arr[1] ||arr[1] ==arr[2] ){
                System.out.println("Isosceles");
            }
            else{
                System.out.println("Scalene");
            }
        }

    }
}
