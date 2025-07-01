import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean result =false;
        int N = Integer.parseInt(br.readLine());

        while(true){
            result= !result;
            if(N==3 || N==1){
                break;
            }
            N-=1;
        }

        System.out.println(result? "SK": "CY");
    }
}
