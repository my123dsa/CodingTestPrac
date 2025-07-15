import java.util.*;
import java.io.*;

public class Main {
    static int N,K,N2;
    static int[] array;
    static boolean[] robots;
    static int count =0;

    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        N2= N*2;
        st= new StringTokenizer(br.readLine());
        array = new int[N*2];
        for(int i=0;i<N*2;i++){
            array[i] =  Integer.parseInt(st.nextToken());
        }
        //로봇의 존재 여부 배열
        robots = new boolean[N];
        int result=0;
        // 벨트 0인 개수가 K보다 작을 경우 계속
        while(count<K){
            //벨트와 그에 따른 로봇이동
            beltMove();

            //로봇이 자력으로 갈 수 있는지? 이동 + 0번 인덱스에 로봇올리는 것 까지
            robotMove();
            result++;
        }

        System.out.println(result);
    }

    static void beltMove(){
        //N2-1-> 1까지 차례로 이전꺼로 업데이트 하고
        //인덱스가 0인 벨트는 사전에 저장한 end로 초기화, robot의 경우 0번 인덱스는 한 칸씩 밀려 false로 업데이트
        int end = array[N2-1];

        for(int i=N2-1 ;i>=1;i--){
            array[i]= array[i-1];
            if(i<N){
                robots[i]= robots[i-1];
            }
        }

        array[0] = end;
        robots[0]= false;
        //조건에 N번째(N-1인덱스)는 즉시 로봇 없어진다고했으니
        robots[N-1]= false;
    }

    static void robotMove(){

        for(int i=N-1;i>=1;i--){
            //N-1-> 1까지 차례로 이동할 수있으면 이동
            if(array[i]>0 && !robots[i] && robots[i-1]){
                robots[i]= robots[i-1];
                robots[i-1]= false;
                array[i]--;
                if(array[i]==0){
                    count++;
                }
            }
        }
        //0번째 로봇 추가 가능하면 추가
        if(array[0]>0 && !robots[0]){
            robots[0] = true;
            array[0]--;
            if(array[0]==0){
                count++;
            }
        }

    }
}
