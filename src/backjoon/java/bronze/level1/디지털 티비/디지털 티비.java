import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());

        int kbs1=0;
        int kbs2=0;

        for(int i=0;i<N;i++){
            String channel = br.readLine();
            if("KBS1".equals(channel)){
                kbs1=i;
            }
            if("KBS2".equals(channel)){
                kbs2=i;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(kbs2<kbs1){
            kbs2++;
        }
        for(int i=0;i<kbs1;i++){
            sb.append(1);
        }
        for(int i=0;i<kbs1;i++){
            sb.append(4);
        }
        for(int i=0;i<kbs2;i++){
            sb.append(1);
        }
        for(int i = 0; i <kbs2-1; i++) {
            sb.append(4);
        }
        // k번째에 있으면  (k-1)*2 번을 눌러야 맨위로감
        //
        System.out.println(sb.toString());
    }
}
