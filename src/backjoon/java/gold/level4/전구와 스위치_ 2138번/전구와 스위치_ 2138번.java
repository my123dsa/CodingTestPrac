import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String st = br.readLine();
        String st2 = br.readLine();

        // 0번쨰를 키거나 끈거 처리하기 위해 배열 2개 작성
        boolean[] cur = new boolean[N];
        boolean[] cur2 = new boolean[N];
        boolean[] target = new boolean[N];

        for(int i=0;i<N;i++){
            if(st.charAt(i)=='1'){
                cur[i]= true;
                cur2[i]= true;
            }
            if(st2.charAt(i)=='1'){
                target[i] = true;
            }
        }

        int count =0;

        //0번쨰 on 하고 진행
        cur2[0]=!cur2[0];
        cur2[1]=!cur2[1];
        int count2=1;

        for(int i=0;i<N-1;i++){
            //자기가 target이랑 다를 경우  자신 앞에 있는거 키거나 끔
            if(cur[i] != target[i]){
                count++;
                cur[i] =!cur[i];
                cur[i+1] = !cur[i+1];
                if(i!= N-2){
                    cur[i+2] = !cur[i+2];
                }
            }
            if(cur2[i] != target[i]){
                count2++;
                cur2[i] =!cur2[i];
                cur2[i+1] = !cur2[i+1];
                if(i!=N-2){
                    cur2[i+2] = !cur2[i+2];
                }
            }
        }

        // 끝이 타겟과 동일시 해당 count
        System.out.println(cur[N-1]==target[N-1] ? count :(cur2[N-1] == target[N-1] ? count2: -1));
    }
}
